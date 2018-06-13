import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class ThreadedDayTimeServer {

	//create port
	public final static int SERVICE_PORT=13;
	
	public static void main(String[] args) {
		
		//declare server and client socket
		ServerSocket socServerSocket =null;
		Socket socClient =null;
		
		try {
			//create server socket giving port
			socServerSocket = new ServerSocket(SERVICE_PORT);
			
			while(true) {
				
				//accept client request
				socClient=socServerSocket.accept();
				
				//create object of bellow class witch implent runnable;
				//and send socClient to creat communication stream
				RequestProcessorThread thread = new RequestProcessorThread(socClient);
				
				System.out.println("Thread created and handed over the connection"+"Thr ["+thread.toString()+"] soc ["+socClient.toString()+"]");
				
				// can do this because thread object from runnable implemented class
				Thread t = new Thread(thread);
				// start run method in the below class
				t.start();
				
				
			}
		}
		catch(Exception e) {}
	}
}

class RequestProcessorThread implements Runnable{
	
	private Socket socClient;
	public RequestProcessorThread(Socket soc) {
		
		//get client
		socClient=soc;
	}
	
	public void run() {
		
		System.out.println(this.toString()+" : Thread started. processing client "+socClient);
		
		try {
			
			Date today = new Date();
			
			//creating communication stream
			PrintWriter out;
			
			out= new PrintWriter(socClient.getOutputStream(),true);
			out.println(today);//write date time to the server
			//wait till client sends some data back to the server
			
			//creating geting data stream
			InputStream is = socClient.getInputStream();
			BufferedReader br =  new BufferedReader(new InputStreamReader(is));
			
			//receive data
			String receivedData =br.readLine();
			System.out.println("Received from client :"+receivedData);
			socClient.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println(this.toString()+" : Thread exiting...");
	}
	
}

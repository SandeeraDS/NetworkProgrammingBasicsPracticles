import java.net.*;
import java.io.*;

public class TcpClient {

	public static void main(String[] args) {
		
		try {
			
			//creating the socket
			Socket socClient = new Socket("localhost", 5001);
			
			//get data from server
			InputStream is = socClient.getInputStream();	
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			
			//read data
			String receivedData = br.readLine();
			
			//print data
			System.out.println("Received Data: " + receivedData);
			} 
		
		catch (IOException e) {
			e.printStackTrace();
			}
	}
}

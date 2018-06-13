import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;
import java.rmi.server.SocketSecurityException;
import java.security.spec.DSAGenParameterSpec;
import java.util.Date;

public class DayTimeClient {

	public final static int SERVER_PORT=13;
	
	public static void main(String[] args) {
		
		System.out.println("warm up...");
		connectServer(10,1);
		
		System.out.println("perf measure...");
		connectServer(100,100);
	}
	public static void connectServer(int iIterations,int iRequestsPerIte) {
	
		for(int i=0;i<iIterations;i++) {
			Date dStart=new Date();
		
		
		for(int j=0;j<iRequestsPerIte;j++) {
			
			try {
			Socket socClient = new Socket("localhost",SERVER_PORT);
			InputStream is = socClient.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			String time=br.readLine();
			
			
			PrintWriter out = new PrintWriter(socClient.getOutputStream(),true);
			out.println("Bye...");
			socClient.close();
			}
			catch(Exception e) {}
			
		}
		
		Date dEnd= new Date();
		long diffInMill = dEnd.getTime()-dStart.getTime();
		System.out.print(diffInMill +", ");
		
		}
		
	}
	
}

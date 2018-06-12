import java.net.*;
import java.io.*;

public class TcpServer {

	public static void main(String[] args) {
		
		try {
			//create server socket
			ServerSocket server = new ServerSocket(5001);
			//waiting for request
			Socket client = server.accept();
			
			//create io stream to communicate with client
			DataOutputStream os = new DataOutputStream(client.getOutputStream());
			
			//write to client
			os.writeBytes("Hello Sockets\n");
			client.close();
			
		} catch (IOException e) {
			e.printStackTrace();
			}
	}
}

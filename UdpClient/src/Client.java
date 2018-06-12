import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Client {

	public final static int UDP_PORT = 50001;
	
	public static void main(String[] args) throws Exception {
		
		System.out.println("Server Time >>>>");
		
		//create a DatagramSocket object
		DatagramSocket clientSocket = new DatagramSocket();
		InetAddress ip = InetAddress.getByName("localhost");
		
		//create buffers to store datagram data in DatagramPacket Objecct
		byte[] buffReceiveData = new byte[100]; //for incoming data
		byte[] buffSendData = new byte[100]; //for outgoing data
		
		//*****
		//checking whether data send from client. not in the labsheet. by sandeera
		buffSendData = "sandeera".toString().getBytes();
		//*****
		
		//create the outgoing Datagram with ip and port
		DatagramPacket packetOut = new DatagramPacket(buffSendData, buffSendData.length, ip,
		UDP_PORT);
		
		//create the incoming DatagramPacket object to wrap receiving data
		DatagramPacket packetIn = new DatagramPacket(buffReceiveData, buffReceiveData.length);
		
		clientSocket.send(packetOut); //send data
		
		clientSocket.receive(packetIn); //receive data from the server
		
		String time = new String(packetIn.getData());
		
		System.out.println(time);
		
		clientSocket.close(); //close the client socket
	}
}

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Date;

public class UdpServer {
	
	public final static int UDP_PORT = 50001;
	
	public static void main(String[] args) throws Exception {
	//create a DatagramSocket and bind it to the PORT
	DatagramSocket serverSocket = new DatagramSocket(UDP_PORT);
	
	while (true) {
		System.out.println("Server is up....");
		
		//create buffers to store datagram data in DatagramPacket Objecct
		byte[] buffReceiveData = new byte[100]; //for incoming data
		byte[] buffSendData = new byte[100]; //for outgoing data
		
		//Datagram object to wrap incoming data
		DatagramPacket packetIn = new DatagramPacket(buffReceiveData,
		buffReceiveData.length);
		
		//Receive the incoming data packet to DatagramPacket Object
		serverSocket.receive(packetIn);
       
		//*****
		//checking whether data come from client. not in the labsheet. by sandeera
		String name = new String(packetIn.getData());
		System.out.println(name);
		//*****
		
		
		//Get the source ip from the incoming packet
		InetAddress ip = packetIn.getAddress();
		
		//Get the source port from the incoming packet
		int port = packetIn.getPort();
		
		buffSendData = new Date().toString().getBytes();//get Date in bytes
		
		//create the outgoing Datagram with source ip and port
		DatagramPacket packetOut = new DatagramPacket(buffSendData, buffSendData.length,
		ip, port);
		serverSocket.send(packetOut);
		packetIn = null; //reset incoming DatagramPacket Object
		System.out.println("Done !! ");
	}
	}
}

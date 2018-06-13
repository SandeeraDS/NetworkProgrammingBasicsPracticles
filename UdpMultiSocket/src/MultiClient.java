import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class MultiClient {
	public final static int MCAST_PORT=5001;
	public final static String MCAST_GROUP_IP="224.0.0.1";
	
	public static void main(String[] args) {
		
		try {
			
			//create port and blind it to the listeninig port
			MulticastSocket clientSocket = new MulticastSocket(MCAST_PORT);
			
			//join(subcribed to) the multicast group
			clientSocket.joinGroup(InetAddress.getByName(MCAST_GROUP_IP));
			
			//buffer for storing data 
			byte[] bufferData =new byte[1024];
			
			//create datagram object for wrapping in coming packet(datagram);
			DatagramPacket packetIn = new DatagramPacket(bufferData, bufferData.length);
			 
			//recieve data
			clientSocket.receive(packetIn);
			
			//display the recieve data
			String strReceived  = new String(packetIn.getData());
			
			System.out.println("Client recieve :"+strReceived);
			
			//leave (unsubcribed from ) the multicast group
			clientSocket.leaveGroup(InetAddress.getByName(MCAST_GROUP_IP));
			
			//close the datagramsocket
			clientSocket.close();
			
		}
		catch(Exception e) {}
	}

}

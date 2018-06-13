import java.net.*;
import java.util.Date;

public class MultiServer {

	public final static int MCAST_PORT=5001;
	public final static String MCAST_GROUP_IP="224.0.0.1";
	
	 public static void main(String[] args) {
		 
		 try {
		
		 //create the socket but we dont bind it.
			 //beacase we are only going to send data
		 DatagramSocket serverSocket = new DatagramSocket();
		 
		 //we dont have to join the multicast group
		 //becaouse we are only sending data and not recieving

		 //buffer for storing datagram data
		 byte[] buffData = new byte[1024];
		
		 DatagramPacket packetout = new DatagramPacket(buffData,buffData.length,InetAddress.getByName(MCAST_GROUP_IP),MCAST_PORT);
		 
		 //5.send the packet in 1 second interval with modified data
		 while(true) {
			 
			 packetout.setData(new Date().toString().getBytes());
			 System.out.println("sending"+new String(packetout.getData()));
			 serverSocket.send(packetout);
			 try {
				Thread.sleep(1000);
			} catch (Exception e) {
				// TODO: handle exception
			}
			 
		 }
		 
		 }
		 
		 //creat datagram to send
		
		 
		 
		 catch(Exception e) {}
		
	 }
}

import java.net.*;

public class UdpGetLocalHost {
	
	public static void main(String[] args) {
		
		try {
			
			InetAddress address = InetAddress.getLocalHost();
			
			System.out.println("HostAddress :"+address.getHostAddress());
			System.out.println("HostName    :"+address.getHostName());
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}

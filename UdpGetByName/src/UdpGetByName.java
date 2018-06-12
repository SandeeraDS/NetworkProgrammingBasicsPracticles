import java.net.InetAddress;

public class UdpGetByName {

	public static void main(String[] args) {
			
			try {
				
				InetAddress address = InetAddress.getByName("www.google.com");
				
				System.out.println("HostAddress :"+address.getHostAddress());
				System.out.println("HostName    :"+address.getHostName());
				
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

}

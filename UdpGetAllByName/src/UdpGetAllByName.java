import java.net.InetAddress;

public class UdpGetAllByName {

	public static void main(String[] args) {
		
		try {
			
			InetAddress[] address = InetAddress.getAllByName("www.google.com");
			
			for(int i=0;i<address.length;i++) {
				System.out.println(address[i]);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}

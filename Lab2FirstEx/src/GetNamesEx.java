
import java.net.InetAddress;
import java.net.UnknownHostException;


public class GetNamesEx  {
	
	public static void main(String[] args) {
		
		try {
			
			InetAddress addrGoog = InetAddress.getByName("www.google.com");
			InetAddress addrIpAsName = InetAddress.getByName("208.80.154.224");
			InetAddress addrByIp = InetAddress.getByAddress(new byte[]{98, (byte) 139, (byte) 183, 24});
			InetAddress addrLocal = InetAddress.getLocalHost();
			InetAddress addrLocalByIp = InetAddress.getByName("127.0.0.1");
			
			System.out.println("Google :" + addrGoog.getHostName() + " - " + addrGoog.getHostAddress());
			
			System.out.println("208.80.154.224 byName :" + addrIpAsName.getHostName() + " - " +
			addrIpAsName.getHostAddress());
			
			System.out.println("98.139.183.24 byIP :" + addrByIp.getHostName() + " - " +
			addrByIp.getHostAddress());
			
			System.out.println("Localhost byName :" + addrLocal.getHostName() + " - " +
			addrLocal.getHostAddress());
			
			System.out.println("Localhost byIP :" + addrLocalByIp.getHostName() + " - " +
			addrLocalByIp.getHostAddress());
		} 
		
		catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}
}
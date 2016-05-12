package hqh.socket;

//: WhoAmI.java
//Finds out your network address when you're
//connected to the Internet.
import java.net.*;

public class WhoAmI {
	public static void main(String[] args) throws Exception {
		if (args.length != 1) {
			System.err.println("Usage: WhoAmI MachineName");
			System.exit(1);
		}
//		InetAddress a = InetAddress.getByName(args[0]);
		InetAddress a = InetAddress.getByName(null);
//		InetAddress a = InetAddress.getByName("127.0.0.1");
//		InetAddress a = InetAddress.getByName("localhost");
		System.out.println(a);
	}
}
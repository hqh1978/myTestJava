package hqh.socket.sigle.thinkInJava;

//: JabberClient.java
//Very simple client that just sends
//lines to the server and reads lines

//that the server sends.
import java.net.*;
import java.util.Calendar;
import java.io.*;

public class JabberClient {

	public static void main(String[] args) throws IOException {
		Calendar c = Calendar.getInstance();
		// Passing null to getByName() produces the
		// special "Local Loopback" IP address, for
		// testing on one machine w/o a network:
		InetAddress addr = InetAddress.getByName(null);
		// Alternatively, you can use
		// the address or name:
		// InetAddress addr =
		// InetAddress.getByName("127.0.0.1");
		// InetAddress addr =
		// InetAddress.getByName("localhost");
		System.out.println("addr = " + addr);
		//不同于server端，此处为Socket 不是 serverSocket，此处需要服务端的Ip，和端口号
		Socket socket = new Socket(addr, JabberServer.PORT);
		// Guard everything in a try-finally to make
		// sure that the socket is closed:
		try {
			System.out.println("socket = " + socket);
			/*The client also creates an InputStream to hear what
			the server is saying (which, in this case, is just the words echoed back).
			*/
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			//System.out.println("Client In="+in);
			// Output is automatically flushed by PrintWriter: "true" 参数
			PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())),
					true);
			//System.out.println("Client Out="+out);
			for (int i = 0; i < 10; i++) {
				//给out中注入数据到socket,server 端在通过同一个socket 从 in中读出来。 
				//**** 这里往out中写入，不用write方法，用println方法，应为用write 写入的默认的为block bufferd， println 默认为line bufferd
				//Step  1 ----begin
				out.println("howdy " + i);
				//Step  1 ----end
//				String str = in.readLine();
//				System.out.println(str);
			}
			out.println("END");
			String temp=in.readLine();
			System.out.println("get message from server :"+temp);
		}catch(Exception e){
			e.printStackTrace();
		}
		finally {
			System.out.println("Client closing...");
			socket.close();
		}
	}
}
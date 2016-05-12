package hqh.socket.multiThread;

//: JabberClient.java
//Very simple client that just sends
//lines to the server and reads lines

//that the server sends.
import java.net.*;
import java.util.Calendar;
import java.io.*;
/**
 * �ֶ�����server ÿ�β���һ���ͻ���
 * @author hqh
 *
 */
public class JabberClient {

	public static void main(String[] args) throws IOException {
		InetAddress addr = InetAddress.getByName(null);
		System.out.println("addr = " + addr);
		Socket socket = new Socket(addr, MultiJabberServer.PORT);
		try {
			System.out.println("socket = " + socket);
			//BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())),
					true);
			for (int i = 0; i < 10; i++) {
				out.println("howdy " + i);
			}
			out.println("END");			
		}catch(Exception e){
			e.printStackTrace();
		}
		finally {
			System.out.println("Client closing...");
			socket.close();
		}
	}
}
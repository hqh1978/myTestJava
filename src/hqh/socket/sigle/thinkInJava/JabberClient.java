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
		//��ͬ��server�ˣ��˴�ΪSocket ���� serverSocket���˴���Ҫ����˵�Ip���Ͷ˿ں�
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
			// Output is automatically flushed by PrintWriter: "true" ����
			PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())),
					true);
			//System.out.println("Client Out="+out);
			for (int i = 0; i < 10; i++) {
				//��out��ע�����ݵ�socket,server ����ͨ��ͬһ��socket �� in�ж������� 
				//**** ������out��д�룬����write��������println������ӦΪ��write д���Ĭ�ϵ�Ϊblock bufferd�� println Ĭ��Ϊline bufferd
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
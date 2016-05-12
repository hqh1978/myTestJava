package hqh.socket.sigle.thinkInJava;

//: JabberServer.java
//Very simple server that just
//echoes whatever the client sends.
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Date;
import java.util.Calendar;

public class JabberServer {
	// Choose a port outside of the range 1-1024:
	public static final int PORT = 8080;

	public static void main(String[] args) throws IOException {
		//此处为serverSocket,不需要Ip，只需要端口号
		ServerSocket s = new ServerSocket(PORT);
		System.out.println("Started: " + s);
		Calendar c = Calendar.getInstance();
		try {
			// Blocks until a connection occurs:
			Socket socket = s.accept();
			try {
				System.out.println("Connection accepted: " + socket);
				BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				//System.out.println("Server In="+in);
				// Output is automatically flushed  "true" 参数
				// by PrintWriter:
				PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())),
						true);
				//System.out.println("Server out="+out);
				while (true) {
					//step2------ begin
					String str = in.readLine();
					//step2------ end
					if (str.equals("END"))
						break;
					System.out.println("Echoing: " + str);
					//out.println(str);
				}
				//server 端写入数据到out，从client 端通过in读到
				out.write("this is the message from server");		
				out.flush(); //必须要flush一下，block buffered
				// Always close the two sockets...
			} finally {
				System.out.println("Server closing...");
				socket.close();
			}
		} finally {
			s.close();
		}
	}
}

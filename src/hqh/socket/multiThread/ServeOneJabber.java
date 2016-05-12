package hqh.socket.multiThread;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class ServeOneJabber extends Thread {
	private Socket socket;
	private BufferedReader in;
	private PrintWriter out;

	public ServeOneJabber(Socket s) throws IOException {
		this.socket = s;
		in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		// Enable auto-flush:
		out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
		// If any of the above calls throw an exception, the caller is
		// responsible for closing the socket. Otherwise the thread
		// will close it.
		start(); // calls run
	}

	public void run() {
		try {
			while (true) {
				String str = in.readLine();
				if(str.equals("END")){
					break;
				}
				System.out.println(str);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
}

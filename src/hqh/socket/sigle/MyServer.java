package hqh.socket.sigle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer {
	private ServerSocket server; 
	private Socket socket; 
	private BufferedReader in; 
	private PrintWriter out; 
	public MyServer(){
		try {
			server=new ServerSocket(10000);
			while(true){
				socket=server.accept();
				in= new BufferedReader(new InputStreamReader(socket.getInputStream()));
				out=new PrintWriter(socket.getOutputStream());
				String line=in.readLine();
				out.println("server received "+line);
				out.close();
				in.close();
				socket.close();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String args[]){
		new MyServer();
	}
}

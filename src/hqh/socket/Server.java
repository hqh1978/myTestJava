package hqh.socket;

import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	ServerSocket server;
	Socket client;
	
	public void listenSocket(){
		try {
			server=new ServerSocket(4321);
		} catch (IOException e) {
			System.out.println("Could not listen on port 4321");
			e.printStackTrace();
			System.exit(-1);
		}
		try {
			client = server.accept();
		} catch (IOException e) {
			System.out.println("Accept failed: 4321");
			e.printStackTrace();
			System.exit(-1);
		}
		BufferedReader in = null;
		PrintWriter out=null;
		try {
			in = new BufferedReader(new InputStreamReader(client.getInputStream()));
			out = new PrintWriter(client.getOutputStream(), true);
		} catch (IOException e) {
			System.out.println("Read failed");
			e.printStackTrace();
		    System.exit(-1);
		}
		
		String line="";
		while(true){
			try {
				line=in.readLine();
				out.println(line);
			} catch (IOException e) {
				System.out.println("Read failed");
				e.printStackTrace();
		        System.exit(-1);
			}
		}
	}
	public void actionPerformed(ActionEvent event) {
		   Object source = event.getSource();
//		   if(source == button){
//		       textArea.setText(line);
//		   }
	}
	
}

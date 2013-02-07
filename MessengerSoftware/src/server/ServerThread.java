package server;
import java.net.*;
import java.io.*;

public class ServerThread extends Thread {
	private Socket socket = null;
	
	public ServerThread(Socket socket) {
		super("ServerThread");
		this.socket = socket;
		System.out.println("Server Thread Created on port: "+socket.getPort());
	}
	
	public void run() {
		try{
			PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String inputLine, outputLine;
			outputLine = "hello";
			//outputLine = user.getMessage();
			outputLine = "Succesfully connected to server";
			out.println(outputLine);
			
				
			while ((inputLine = in.readLine()) != null){
				//outputLine = user.getMessage();
				System.out.println("Client said to me: "+inputLine);
				out.println(outputLine);
				if (outputLine.equalsIgnoreCase("/quit")){
					break;
				}
			}
			System.out.println("Good stuff!");
			out.close();
			in.close();
			socket.close();
		} catch (IOException e){
			e.printStackTrace();
		}
	}
}

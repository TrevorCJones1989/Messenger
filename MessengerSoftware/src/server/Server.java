package server;

import java.io.*;
import java.net.*;


public class Server {
	ServerSocket serverSocket;
	PrintWriter outToClient;
	Socket clientSocket;
	
	//Parameters: int port number for server to listen on
	//Function: Start the server
	public void runServer(int port) {
		serverSocket = null;
		boolean listening = true;
		System.out.println("Run server started");
		try{
			serverSocket = new ServerSocket(4444);
			System.out.println("Created server socket");
		} catch (IOException e){
			System.err.println("Could not listen on port: 4444");
			System.exit(-1);
		}
		
		while(listening){
			try {
				new ServerThread(serverSocket.accept()).start();
			} catch (IOException e) {
				System.out.println("Failed to start serverSocket");
				e.printStackTrace();
			}
		}
	}
		
}

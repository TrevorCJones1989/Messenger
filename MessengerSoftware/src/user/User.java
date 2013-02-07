package user;

import java.net.*;
import java.io.*;

public class User {
	Profile profile;
	Socket clientSocket;
	PrintWriter outToServer;
	BufferedReader inFromUser, inFromServer;
	public boolean connectToServer(){
		try{
			clientSocket = new Socket("localhost", 4444);
			outToServer = new PrintWriter(clientSocket.getOutputStream());
			inFromUser = new BufferedReader( new InputStreamReader(System.in));
			inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			return true;
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	public void communicate() throws IOException{
		String serverMessage; 
		String clientMessage= "";
		while(!clientMessage.equalsIgnoreCase("/quit")){
			if ((serverMessage = inFromServer.readLine()) != null){
				System.out.println("Server says: "+serverMessage);
				
			}
				clientMessage = inFromUser.readLine();
			if (clientMessage != null){
				System.out.println("Client: "+ clientMessage);
				outToServer.println(clientMessage);
			}
		}
	}
}

package server;
import java.io.IOException;

import user.User;


public class EntryPoint {
	
	public static void main(String args[]){
		if (args[0].equalsIgnoreCase("server")){
			Server server = new Server();
			server.runServer(4444);
		}
		else{
			User user = new User();
			user.connectToServer();
			try {
				user.communicate();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}

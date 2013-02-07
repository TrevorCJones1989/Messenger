package server;

public class Connection {
	String username;
	boolean connected;
	
	public Connection(String username){
		this.username = username;
		connected = true;
	}
	
	public boolean getConnected(){
		return connected;
	}
	public String getUsername(){
		return username;
	}
	public void disconnect(){
		connected = false;
	}
}

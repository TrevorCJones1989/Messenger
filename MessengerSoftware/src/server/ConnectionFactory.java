package server;


public class ConnectionFactory {

	
	public void createConnection(String username){
		Connection connection = new Connection(username);
	}
}

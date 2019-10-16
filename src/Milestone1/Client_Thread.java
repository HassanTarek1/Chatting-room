package Milestone1;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Client_Thread extends Thread{
	Socket connectionSocket;
	int ID;
	String clientSentence;
	String capitalizedSentence;
	DataOutputStream outToClient;
	BufferedReader inFromClient;

	//lazm n3ml constructor 3shan ya5od socket bta3 client da 
		public Client_Thread(Socket ClientSocket,int ID)
		{
			connectionSocket = ClientSocket;
			ID = this.ID;
		}
	
	
	public void run(){
		try {
			inFromClient = new BufferedReader(new
					InputStreamReader(connectionSocket.getInputStream()));
		} catch (IOException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		} 

	
	try {
		outToClient = new DataOutputStream(connectionSocket.getOutputStream());
	} catch (IOException e2) {
		// TODO Auto-generated catch block
		e2.printStackTrace();
	} 

	while(true){
		try {
			clientSentence = inFromClient.readLine();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
		try {
		capitalizedSentence = clientSentence.toUpperCase() + '\n';
		}catch(NullPointerException e) {
			clientSentence="";
			capitalizedSentence="";
		}
		
		try {
			outToClient.writeBytes(capitalizedSentence);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		if(clientSentence.equalsIgnoreCase("Close Socket"))
		{
			try {
				connectionSocket.close();
				System.out.println("Connection Socket is closed @Server");
				break;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			}
		}
		
	}
}

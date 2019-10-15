package Milestone1;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientThread  extends Thread{
	private Socket connectionSocket;
	private int id;
	
	public ClientThread(Socket connectionSocket,int id) {
		this.connectionSocket=connectionSocket;	
		this.id=id;
	}

	public Socket getConnectionSocket() {
		return connectionSocket;
	}
	

	
	public void run() {
		try {
			System.out.println("Client : "+this.id+"  is connected");
			String clientSentence; 
			String capitalizedSentence; 
			while(true) { 
			
				BufferedReader inFromClient = 
						new BufferedReader(new
								InputStreamReader(connectionSocket.getInputStream())); 

				DataOutputStream  outToClient = 
						new DataOutputStream(connectionSocket.getOutputStream()); 

				while(true){
					if(inFromClient.ready()) {
						clientSentence = inFromClient.readLine(); 

						capitalizedSentence = clientSentence.toUpperCase() + '\n';

						outToClient.writeBytes(capitalizedSentence); 

						if(clientSentence.equalsIgnoreCase("Close Socket"))
						{
							System.out.println("Connection Socket between the server and client number "+this.getId()+" is closed");
							System.out.println("===============================================");
							System.out.println("Server is Still Running......");
							break;
						}
					}
				}
			} 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

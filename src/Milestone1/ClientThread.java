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
	
	public ClientThread(Socket connectionSocket) {
		this.connectionSocket=connectionSocket;		
	}

	public Socket getConnectionSocket() {
		return connectionSocket;
	}

	public void run() {
		try {
			System.out.println("Client : "+this.getId()+"  is connected");
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
							System.out.println("Connection Socket between the server and client is closed");
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

package Milestone2;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) throws Exception {
		ServerSocket welcomeSocket=new ServerSocket(5000);
		Socket connectionSocket=welcomeSocket.accept();
		BufferedReader inFromClient=new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
		String clientSentence=inFromClient.readLine();
		String returnSentence;
		boolean available=false;
		if(clientSentence.equals("CONNECT")) {
			available=true;
			DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());;
			outToClient.writeBytes("connected"+"\n");
		}
		
		
		while(available) {
			if(inFromClient.ready()) {
				clientSentence=inFromClient.readLine();
				if(clientSentence!=null) {
					System.out.println("From Client : "+clientSentence);
					if(connectionSocket!=null) {
					BufferedReader inServer=new BufferedReader(new InputStreamReader(System.in));
					DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());;
					returnSentence=inServer.readLine()+"\n";
					outToClient.writeBytes(returnSentence);
					}
				}
			}
		}
	}

}

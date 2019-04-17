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
		DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());
		if(clientSentence.equals("CONNECT")) {
			available=true;
			outToClient.writeBytes("connected"+"\n");
		}
		
		
		while(true) {
			if(available) {
				if(inFromClient.ready()) {
					clientSentence=inFromClient.readLine();
					if(clientSentence!=null) {
						System.out.println("From Client : "+clientSentence);
						if(connectionSocket!=null) {
							BufferedReader inServer=new BufferedReader(new InputStreamReader(System.in));
							outToClient = new DataOutputStream(connectionSocket.getOutputStream());;
							returnSentence=inServer.readLine()+"\n";
							outToClient.writeBytes(returnSentence);
						}
					}
				}
			}
			else {
				if(inFromClient.ready()) {
					clientSentence=inFromClient.readLine();
					if(clientSentence.equals("CONNECT")) {
						outToClient.writeBytes("connected"+"\n");
						available=true;
					}
				}	
			}
		}
	}

}

package Milestone2;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) throws Exception {
		ServerSocket welcomeSocket=new ServerSocket(5000);
		String clientSentence = "";
		String capitalisedSentence;
		Socket connectionSocket=welcomeSocket.accept();

		while(true) {
			BufferedReader inFromClient=new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
			DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());
			clientSentence=inFromClient.readLine();
			if(!clientSentence.toLowerCase().equals("close socket")) {
				capitalisedSentence=clientSentence.toUpperCase();
				outToClient.writeBytes(capitalisedSentence+"\n");
			}
			else {
				connectionSocket=welcomeSocket.accept();
			}
		}
	}
}

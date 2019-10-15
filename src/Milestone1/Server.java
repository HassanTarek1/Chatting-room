package Milestone1;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {

	public static void main(String[] args) throws Exception {
		ServerSocket welcomeSocket=new ServerSocket(5000);
		String clientSentence = "";
		String capitalisedSentence;
		ArrayList<ClientThread> arr = new ArrayList<ClientThread>();
		System.out.println("Waiting for connection");
		int id=1;
		while(true) {
			Socket connectionSocket=welcomeSocket.accept();
			ClientThread client = new ClientThread(connectionSocket,id);
			client.start();
			id++;
			arr.add(client);
		}
		
	}
}

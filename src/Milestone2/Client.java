package Milestone2;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

		// TODO Auto-generated constructor stub
	public static void main(String[] args) throws UnknownHostException, IOException {
		InetAddress address=InetAddress.getLocalHost();
		Socket clientSocket = new Socket("192.168.1.5", 5000);
		String sentence="";
		String modifiedSentence;
		System.out.println("enter a string");
		BufferedReader inFromUser=new BufferedReader(new InputStreamReader(System.in));
		
		while(true){
			if(inFromUser.ready()) {
				sentence=inFromUser.readLine();
				DataOutputStream outToServer=new DataOutputStream(clientSocket.getOutputStream());
				if(sentence!=null)
					outToServer.writeBytes(sentence+"\n");
			}
			BufferedReader inFromServer =new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			if(inFromServer.ready()) {
				modifiedSentence=inFromServer.readLine();
				if(modifiedSentence!=null)
					System.out.println("From Server : "+modifiedSentence);
			}
		}
		
	}

}

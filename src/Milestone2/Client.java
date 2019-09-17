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
		Socket clientSocket = new Socket("localhost", 5000);
		String sentence="";
		String modifiedSentence = null;
		System.out.println("enter a string");
		while(true){
			BufferedReader inFromServer =new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			BufferedReader inFromUser=new BufferedReader(new InputStreamReader(System.in));
			sentence=inFromUser.readLine();
			DataOutputStream outToServer=new DataOutputStream(clientSocket.getOutputStream());
			if(sentence!=null) {
				outToServer.writeBytes(sentence+"\n");
			String tmpSentence=sentence.toLowerCase();
			if(tmpSentence.equals("close socket"))
				break;
			}
			modifiedSentence=inFromServer.readLine();
			System.out.println("From Server : "+modifiedSentence);
	}
	clientSocket.close();
}

}

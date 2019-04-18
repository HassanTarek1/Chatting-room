package Milestone1;
import java.io.*;
import java.net.*;

public class TCPClient {

	public TCPClient() {
		
	}
	public static void main(String[] args) throws UnknownHostException, IOException {
		InetAddress address=InetAddress.getLocalHost();
		Socket clientSocket = new Socket(address, 1596);
		String sentence="";
		String modifiedSentence;
		System.out.println("enter a string");
		BufferedReader inFromUser=new BufferedReader(new InputStreamReader(System.in));
		
			sentence=inFromUser.readLine();
			DataOutputStream outToServer=new DataOutputStream(clientSocket.getOutputStream());
			outToServer.writeBytes(sentence+"\n");
			BufferedReader inFromServer =new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			modifiedSentence=inFromServer.readLine();
			System.out.println("From Server : "+modifiedSentence);
		clientSocket.close();
	}

}

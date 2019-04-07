package chatting;
import java.io.*;
import java.net.*;

public class TCPClient {

	public TCPClient() {
		
	}
	public static void main(String[] args) throws UnknownHostException, IOException {
		InetAddress address=InetAddress.getLocalHost();
		String sentence;
		String modifiedSentence;
		BufferedReader inFromUser=new BufferedReader(new InputStreamReader(System.in));
		Socket clientSocket = new Socket(address, 5830);
		DataOutputStream outToServer=new DataOutputStream(clientSocket.getOutputStream());
		BufferedReader inFromServer =new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		sentence=inFromUser.readLine();
		outToServer.writeUTF(sentence+"\n");
		modifiedSentence=inFromServer.readLine();
		System.out.println("From Server : "+modifiedSentence);
		clientSocket.close();
	}

}

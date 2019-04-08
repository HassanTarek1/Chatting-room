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
		System.out.println("enter a string");
		BufferedReader inFromUser=new BufferedReader(new InputStreamReader(System.in));
		sentence=inFromUser.readLine();
		Socket clientSocket = new Socket("127.0.0.1", 5071);
		PrintWriter outToServer=new PrintWriter(clientSocket.getOutputStream(),true);
		outToServer.write(sentence+"\n");
		BufferedReader inFromServer =new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		System.out.println(sentence);
		modifiedSentence=inFromServer.readLine();
		System.out.println("From Server : "+modifiedSentence);
		clientSocket.close();
	}

}

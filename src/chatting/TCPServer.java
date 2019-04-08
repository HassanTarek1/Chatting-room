package chatting;
import java.io.*;
import java.net.*;

public class TCPServer {

	public static void main(String[] args) throws Exception {
		String clientSentence;
		String capitalizedSentence;
		ServerSocket welcomeSocket=new ServerSocket(5071);
		Socket connectionSocket=welcomeSocket.accept();
		BufferedReader inFromClient=new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
		clientSentence=inFromClient.readLine();
		PrintWriter outToClient;
		outToClient=new PrintWriter(connectionSocket.getOutputStream(),true);
		capitalizedSentence=clientSentence.toUpperCase();
		outToClient.write(capitalizedSentence);
		System.out.println("ended");
		welcomeSocket.close();
	}

}

package chatting;
import java.io.*;
import java.net.*;

public class TCPServer {

	public static void main(String[] args) throws Exception {
		String clientSentence;
		String capitalizedSentence;
		ServerSocket welcomeSocket=new ServerSocket(585);
		while(true) {
			Socket connectionSocket=welcomeSocket.accept();
			BufferedReader inFromClient=new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
			DataOutputStream outToClient=new DataOutputStream(connectionSocket.getOutputStream());
			clientSentence=inFromClient.readLine();
			capitalizedSentence=clientSentence.toUpperCase();
			outToClient.writeBytes(capitalizedSentence);
		}
	}

}

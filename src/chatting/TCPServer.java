package chatting;
import java.io.*;
import java.net.*;

public class TCPServer {

	public static void main(String[] args) throws Exception {
		String clientSentence;
		String capitalizedSentence;
		ServerSocket welcomeSocket=new ServerSocket(5830);
		while(true) {
			Socket connectionSocket=welcomeSocket.accept();
			BufferedReader inFromClient=new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
			PrintWriter outToClient=new PrintWriter(connectionSocket.getOutputStream());
			clientSentence=inFromClient.readLine();
			capitalizedSentence=clientSentence.toUpperCase();
			outToClient.write(capitalizedSentence);
		}
	}

}

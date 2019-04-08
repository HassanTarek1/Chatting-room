package Milestone1;
import java.io.*;
import java.net.*;

import com.sun.jmx.mbeanserver.ModifiableClassLoaderRepository;

public class TCPServer {

	public static void main(String[] args) throws Exception {
		String clientSentence;
		String capitalizedSentence;
		ServerSocket welcomeSocket=new ServerSocket(5000);
		Socket connectionSocket=welcomeSocket.accept();
		BufferedReader inFromClient=new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
		//System.out.println("connected");
		while(true) {
			
			clientSentence=inFromClient.readLine();
			if(clientSentence.equals("end"))
				break;
			DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());;
			capitalizedSentence=clientSentence.toUpperCase()+"\n";
			//System.out.println(capitalizedSentence);
			outToClient.writeBytes(capitalizedSentence);
		}
		welcomeSocket.close();
	}

}

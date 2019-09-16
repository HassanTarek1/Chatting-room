package Milestone1;
import java.io.*;
import java.net.*;

import com.sun.jmx.mbeanserver.ModifiableClassLoaderRepository;

public class TCPServer {

	public static void main(String[] args) throws Exception {
		String clientSentence;
		String capitalizedSentence;
		ServerSocket welcomeSocket=new ServerSocket(1596);
		Socket connectionSocket=welcomeSocket.accept();
		BufferedReader inFromClient=new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
		//System.out.println("connected");
		while(true) {
			if(inFromClient.ready()) {
				clientSentence=inFromClient.readLine();
				if(clientSentence!=null) {
					DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());;
					capitalizedSentence=clientSentence.toUpperCase()+"\n";
					outToClient.writeBytes("Connection Denied"+"\n");
				}
			}
		}
	}

}

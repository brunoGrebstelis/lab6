package test.lab6;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) throws Exception {
		System.out.println("Server is activated!");
		new Server();

	}
	
	public Server() throws Exception {
		ServerSocket serverSocket = new ServerSocket(4671);
		Socket socket = serverSocket.accept();
		System.out.println("Server: Connected");
		
		ObjectOutputStream outStream = new ObjectOutputStream(socket.getOutputStream());
		ObjectInputStream inStream = new ObjectInputStream(socket.getInputStream());
		
		Objects msgRes;
		do {
			msgRes = (Objects)inStream.readObject();
			System.out.println("Server: "+msgRes.message);
			
			if(msgRes.message.equals("help")) {
				Objects msg = new Objects("you enered help");
				outStream.writeObject(msg);
			}
			if(msgRes.message.equals("exit")) {
				Objects msg = new Objects("you enered exit");
				outStream.writeObject(msg);
			}
			
		}while(!msgRes.message.equals("exit"));
		System.out.println("Server: Disconnected");
		serverSocket.close();
	}

}

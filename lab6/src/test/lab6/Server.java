package test.lab6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) throws Exception {
		System.out.println("Server is activated!");
		ServerScoketThread socket = new ServerScoketThread("socket");
		socket.start();
		ServerKeyboardThread keyboard = new ServerKeyboardThread("keyboard");
		keyboard.start();

	}
	
//	public Server() throws Exception {
//		ServerSocket serverSocket = new ServerSocket(4671);
//		Socket socket = serverSocket.accept();
//		System.out.println("Server: Connected");
//		
//		ObjectOutputStream outStream = new ObjectOutputStream(socket.getOutputStream());
//		ObjectInputStream inStream = new ObjectInputStream(socket.getInputStream());
//		InputStreamReader in = new InputStreamReader(System.in);
//		BufferedReader reader = null;
//		
//		Objects msgRes;
//		do {
//			if(in.ready()) {
//				reader = new BufferedReader(in);
//				System.out.println(reader.readLine());
//			}
//			
//			msgRes = (Objects)inStream.readObject();
//			System.out.println("Server: "+msgRes.message);
//			
//			if(msgRes.message.equals("help")) {
//				Objects msg = new Objects("you enered help");
//				outStream.writeObject(msg);
//			}
//			if(msgRes.message.equals("exit")) {
//				Objects msg = new Objects("you enered exit");
//				outStream.writeObject(msg);
//			}
//			
//		}while(!msgRes.message.equals("exit"));
//		System.out.println("Server: Disconnected");
//		serverSocket.close();
//	}

}

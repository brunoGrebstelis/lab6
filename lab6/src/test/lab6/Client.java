package test.lab6;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	
	private String commands;

	public static void main(String[] args) throws Exception {
		System.out.println("Client is activated!");
		Commands add = new Commands();
		add.add();
		new Client();

	}
	
	public Client() throws Exception {
		Commands com = new Commands();
		Socket socket = new Socket("127.0.0.1",4671);
		
		ObjectOutputStream outStream = new ObjectOutputStream(socket.getOutputStream());
		ObjectInputStream inStream = new ObjectInputStream(socket.getInputStream());
		
		do {
			do {
				System.out.println("Client: Enter command!");
				commands = com.inputRead();
				if(commands!=null) {
					Objects msg = new Objects(commands);
					System.out.println(msg);
					outStream.writeObject(msg);
				}else {
					commands = "-";
					System.out.println("Client: Such command does not exsist");
				}
			}while(commands.equals("-"));
			
			Objects resMsg = (Objects)inStream.readObject();
			System.out.println("Client: "+resMsg.message);
		
		
		
		}while(!commands.equals("exit"));
		outStream.close();
		socket.close();
		System.out.println("Its all over");
		
	}

}

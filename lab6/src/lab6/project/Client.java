package lab6.project;


import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

import obj.Objects;



public class Client  {
	
	private Socket socket = new Socket("127.0.0.1",4671);
	private ObjectOutputStream outStream = new ObjectOutputStream(socket.getOutputStream());
	private ObjectInputStream inStream = new ObjectInputStream(socket.getInputStream());
	private String commands;
	private User com = new User();
	private ExecuteMethod met = new ExecuteMethod(outStream, inStream);
	private ArrayList<String> historyList = new ArrayList<String>();

	public static void main(String[] args) throws Exception {
		System.out.println("Client is activated!");
		new Client();
	}
	
	public Client() throws Exception{
			
		do {
			do {
				System.out.println("_____________________________________________");
				System.out.println("Client: Enter command!");
				commands = com.inputRead();	
			}while(commands==null);
			
			historyList.add(commands);
			if(historyList.size()>6) {historyList.remove(0);}
			System.out.println("Form server: ");
			switch(commands) {
			
			case "help":
				met.help();
			    break;
			
			  case "show":
				met.show();
			    break;
			    
			  case "info":
				met.info();
			    break;
			    
			  case "insert":
				met.insert(null);
				break;
				
			  case "update":
				met.remove(commands); 
				met.insert(null); 
				break;
				
			  case "remove":
				met.remove(commands);
				break;
				
			  case "clear":
				met.clear();
				break;
				
			  case "execut_script":
				met.script();
				break;
					
			  case "remove_greater":
				met.remove_greater();   
				break;
				
			  case "history":
				System.out.println("History:");
				historyList.forEach(i -> System.out.println(i));
				break;
				
			  case "replace_if_greater":
				met.replace_if_greater();    
				break;
			
			  case "remove_all_by_birthday":
				met.remove_all_by_birthday();    
				break;
				
			  case "print_ascending":
				met.print_ascending();    
				break;
				
			  case "print":
				met.print_ascending();    
				break;
				
			  case "print_field_descending_birthday":
				met.print_field_descending_birthday();    
				break;
			
			  case "printb":
				met.print_field_descending_birthday();    
				break;
			
			  case "exit":
				outStream.writeObject(new Objects(commands));
				break;
				
			}
			
			
		}while(!commands.equals("exit"));
		outStream.close();
		socket.close();
		System.out.println("Client is disconected");
		
	}
	
	
}

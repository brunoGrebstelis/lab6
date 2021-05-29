package test.lab6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class ExampleWithHTTP {

	public static void main(String[] args) throws UnknownHostException, IOException {
		String httpServer = "g11.lv";
		int serverPort = 80;
		int timeOut = 10000;
		String httpRequest = "GET /motorsport/  HTTP/1.1";
		String hostHeader = "Host: " + httpServer;

		Socket socket = new Socket(httpServer, serverPort);
		socket.setSoTimeout(timeOut);
		PrintWriter toServer = new PrintWriter(socket.getOutputStream());
		toServer.println(httpRequest);
		toServer.println(hostHeader);
		toServer.println();
		toServer.flush();

		BufferedReader fromServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		String str;
		while ((str = fromServer.readLine()) != null) {
			System.out.println(str);
		}

	}

}

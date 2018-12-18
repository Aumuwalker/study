package SocketDemo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.net.Socket;
import java.util.concurrent.TimeUnit;

public class SocketClientDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Socket client = null;
		try {
			while(true){
				PrintWriter out = new PrintWriter(socket.getOutputStream());
				Scanner scanner = new Scanner(System.in);
				String message = scanner.nextLine();
				out.println(message);
				out.flush();
				Reader reader = new InputStreamReader(socket.getInputStream());
				BufferedReader in = new BufferedReader(reader);
				String serverMessage = in.readLine();
				System.out.println("服务器传来的消息为:"+serverMessage);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}

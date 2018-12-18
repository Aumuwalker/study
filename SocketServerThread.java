package SocketDemo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.net.Socket;
import java.util.Scanner;

public class SocketServerThread implements Runnable{
	
	private Socket socket;
	
	public SocketServerThread(Socket socket){
		this.socket = socket;
	}
	
	@Override
	public void run(){
		System.out.println("����ͻ���ҵ���߳�������");
		try {
			while(true){
				Reader reader = new InputStreamReader(socket.getInputStream());
				BufferedReader in = new BufferedReader(reader);
				String serverMessage = in.readLine();
				System.out.println("�ͻ���������ϢΪ:"+serverMessage);
				PrintWriter out = new PrintWriter(socket.getOutputStream());
				Scanner scanner = new Scanner(System.in);
				String message = scanner.nextLine();
				if(message.equals("exit")){
					break;
				}
				out.println(message);
				out.flush();
			}
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			try {
				if(socket != null){
					socket.close();
				}
			} catch (IOException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}

}

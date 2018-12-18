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
		System.out.println("处理客户端业务线程已启动");
		try {
			while(true){
				Reader reader = new InputStreamReader(socket.getInputStream());
				BufferedReader in = new BufferedReader(reader);
				String serverMessage = in.readLine();
				System.out.println("客户传来的消息为:"+serverMessage);
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

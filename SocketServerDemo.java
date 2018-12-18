package SocketDemo;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServerDemo {

	public static void main(String[] args){
		ServerSocket serverSocket = null;
		try{
			serverSocket = new ServerSocket(7070);
		}catch(IOException e){
			e.printStackTrace();
		}
		if(serverSocket == null){
			return;
		}
		System.out.println("服务器打开完成");
		while(true){
			try{
				System.out.println("服务器等待客户端连接");
				Socket socket = serverSocket.accept();
				SocketServerThread thread = new SocketServerThread(socket);
				new Thread(thread).start();
				System.out.println("服务器处理客户端完成");
			}catch(IOException e){
				e.printStackTrace();
			}
		}
	}
}

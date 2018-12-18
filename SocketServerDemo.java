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
		System.out.println("�����������");
		while(true){
			try{
				System.out.println("�������ȴ��ͻ�������");
				Socket socket = serverSocket.accept();
				SocketServerThread thread = new SocketServerThread(socket);
				new Thread(thread).start();
				System.out.println("����������ͻ������");
			}catch(IOException e){
				e.printStackTrace();
			}
		}
	}
}

package kr.or.ddit.basic.tcp;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream.GetField;
import java.net.ServerSocket;
import java.net.Socket;

// 클아이언트가 보낸 파일을 받아서 'd:/d_other/data'폴더에
// 보낸 파일과 같은 이름으로 저장한다.

public class TcpFileServer {
	public static void main(String[] args) throws IOException {
		ServerSocket server = new ServerSocket(7777);
		System.out.println("서버가 접속을 기다립니다.");
		
		Socket socket = server.accept();
		
		InputStream is = socket.getInputStream();
		DataInputStream dis = new DataInputStream(is);
		BufferedInputStream bis = new BufferedInputStream(is);
		String filename="";
		
	
		File file = new File("d:/d_other/data/코알라.jpg");
		FileOutputStream out = new FileOutputStream(file);
		BufferedOutputStream bos = new BufferedOutputStream(out);
		int f;
//		while ((f=dis.read()) != -1) {
		while ((f=bis.read()) != -1) {
			bos.write(f);
		}
		out.close();
//		dis.close();
		bis.close();
		bos.close();
		socket.close();
		server.close();
		
	}
}

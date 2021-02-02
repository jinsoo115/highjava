package kr.or.ddit.basic.tcp;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;


// 서버에 접속되면 'd:/d_other/코알라.jpg' 파일을 서버로 전송한다.

public class TcpFileClient {
	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket socket = new Socket("localhost", 7777);
		System.out.println("서버에 연결되었습니다.");
		System.out.println();
		
		File file = new File("d:/d_other/코알라.jpg");
		FileInputStream fis = new FileInputStream(file);
		BufferedInputStream bis = new BufferedInputStream(fis);
		
		String filename = file.getName();
		
		OutputStream out = socket.getOutputStream();
		DataOutputStream dos = new DataOutputStream(out);
		BufferedOutputStream bos = new BufferedOutputStream(out);
		
		int f;
//		while((f=fis.read())!=-1){
		while((f=bis.read())!=-1){
			//dos.write(f);
			bos.write(f);
		}
		fis.close();
		out.close();
//		dos.close();
		bos.close();
		bis.close();
		socket.close();
	}
}

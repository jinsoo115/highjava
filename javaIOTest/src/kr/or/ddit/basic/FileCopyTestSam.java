package kr.or.ddit.basic;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopyTestSam {
	public static void main(String[] args) {
		File file = new File("d:/d_other/코알라.jpg");
		if(!file.exists()){
			System.out.println(file.getPath() + " 파일이 없습니다.");
			System.out.println("복사 작업을 중지합니다.");
			return;
		}
		try {
			// 복사할 파일 스트림 객체 생성
			FileInputStream fin = new FileInputStream(file);
			BufferedInputStream bis = new BufferedInputStream(fin);
			
			// 복사될 파일 ㅅ ㅡ트림 객체 생성
			FileOutputStream fout = new FileOutputStream("d:/d_other/연습용/복사본-코알라.jpg");
			BufferedOutputStream bout = new BufferedOutputStream(fout);
			
			System.out.println("복사 시작...");
			
			int data; // 읽어온 데이터가 저장될 변수
			
			/*while((data = fin.read()) != -1){
				fout.write(data);
			}
			
			// 사용한 스트림 닫기
			fin.close();
			fout.close();*/
			
			
			// 버퍼 스트림 이용하기
			while((data= bis.read())!=-1){
				bout.write(data);
			}
			bout.flush();
			
			// 스트림 닫기
			bis.close();
			bout.close();
			
			
			System.out.println("복사 완료...");
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}

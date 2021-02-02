package kr.or.ddit.basic;

import java.awt.image.BufferedImageFilter;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.Buffer;


/*
 * 문제)
 * 		'd:/d_other' 폴더에 있는 '코알라.jpg'파일을
 * 		'd:/d_other/연습용' 폴더에 '복사본-코알라.jpg'파일로
 * 		복사하는 프로그램을 작성하시오.
 */
public class FileCopyTest {
	public static void main(String[] args) {
		try {
			FileInputStream input = new FileInputStream("d:/d_other/코알라.jpg");
			FileOutputStream output = new FileOutputStream("d:/d_other/연습용/복사본-코알라.jpg");
			
			int f;
			while ((f=input.read()) != -1) {
				output.write(f);
			}
			input.close();
			output.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		


		/*try {
			FileReader fr = new FileReader("d:/d_other/코알라.jpg");
			BufferedReader br = new BufferedReader(fr);
			
			FileWriter fw = new FileWriter("d:/d_other/연습용/복사본-코알라.jpg");
			BufferedWriter bw = new BufferedWriter(fw);
			
			String s = null;
			char[] buffer = new char[512];
			while((s= br.readLine())!= null){
				bw.write(s);
				bw.newLine();
			}
			bw.flush();
			br.close();
			bw.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}

}

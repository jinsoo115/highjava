package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/*
 * 문제) 사용자로부터 도, 시, 군, 구 중 한가지를 입력 받아 
 * 		DB의 Member테이블에서 회원의 주소에 입력한 값이 포함되는 데이터를
 * 		모두 출력하시오.
 * 		아이디, 이름, 우편번호, 주소1, 주소2
 */
public class jdbcTest04_sam {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("주소의 일부분을 입력하세요 : ");
		String s = sc.nextLine();
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "JINSU", "java");
			
			String sql = "select * from member where mem_add1 like '%"+ s + "%'"; 
//			String sql = "select * from member where mem_add1 LIKE '%' || ? ||'%'";
			
			stmt = conn.createStatement();
//			pstmt = conn.prepareStatement(sql);
			
//			pstmt.setObject(1, s);
			
			rs = stmt.executeQuery(sql);
//			rs = pstmt.executeQuery();
			
			System.out.println("쿼리문 처리 결과");
			while(rs.next()){
				System.out.print("MEM_ID" + rs.getObject("MEM_ID")+" ");
				System.out.print("MEM_NAME" + rs.getObject("MEM_NAME")+" ");
				System.out.print("MEM_ZIP" + rs.getObject("MEM_ZIP")+" ");
				System.out.print("MEM_ADD1" + rs.getObject("MEM_ADD1")+" ");
				System.out.println("MEM_ADD2" + rs.getObject("MEM_ADD2")+" ");
			}
			System.out.println("출력 끝...");
		} catch (SQLException e) {
			e.printStackTrace();
			// TODO: handle exception
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(rs!=null) try{rs.close();}catch(SQLException e){}
			if(stmt!=null) try{stmt.close();}catch(SQLException e){}
			if(conn!=null) try{conn.close();}catch(SQLException e){}
		}
	}
}


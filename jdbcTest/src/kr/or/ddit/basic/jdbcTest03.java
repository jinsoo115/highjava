package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

//문제2) lprod_id값을 2개 입력 받아 두 값 중 작은 값부터 큰값 사이의
//자료들을 출력하시오.
public class jdbcTest03 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("첫번째 값 입력 : ");
		String s1 = scan.nextLine();
		System.out.print("두번째 값 입력 : ");
		String s2 = scan.nextLine();
		/*if(Integer.parseInt(s1) > Integer.parseInt(s2)){
			String temp = s1;
			s1 = s2;
			s2 = temp;
		}*/
		int min = Math.min(Integer.parseInt(s1), Integer.parseInt(s2));
		int max = Math.max(Integer.parseInt(s1), Integer.parseInt(s2));
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "JINSU", "java");
			
//			String sql = "select * from lprod where lprod_id >= " + s1 +" and lprod_id <= "+ s2;
			String sql = "select * from lprod where lprod_id between ? and ?";
			stmt  = conn.createStatement();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setObject(1, min);
			pstmt.setObject(2, max);
			
			
//			rs = stmt.executeQuery(sql);
			rs = pstmt.executeQuery();
			
			
			System.out.println("쿼리 처리 결과");
			
			while(rs.next()){
				System.out.println("Lprod_id : " + rs.getInt("lprod_id"));
				System.out.println("Lprod_gu : " + rs.getString(2));
				System.out.println("Lprod_nm : " + rs.getString("LPROD_NM"));
				System.out.println("-------------------------------------");
			}
			System.out.println("출력 끝...");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			// 5. 자원 반납하기
			if(rs!=null) try{rs.close();}catch(SQLException e){}
			if(stmt!=null) try{stmt.close();}catch(SQLException e){}
			if(pstmt!=null) try{pstmt.close();}catch(SQLException e){}
			if(conn!=null) try{conn.close();}catch(SQLException e){}
		}
	}
}

package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

/*
 * LPROD테이블에 새로운 데이터를 추가하시오.
 * 
 * 조건) lprod_gu와 lprod_nm은 직접 입력 받아서 처리하고,
 * 		lprod_id는 현재의 lprod_id중 제일 큰 값보다 1 증가된 값으로 한다.
 * 		그리고, 입력받은 lprod_gu가 이미 등록되어 있으면
 * 		다시 입력 받아서 처리한다.  
 */
public class jdbcTest06 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "JINSU", "java");
			String gu ="";
			while(true){
				boolean bl = true;
				System.out.print("lprod_gu : ");
				gu = sc.next();
				gu = gu.toUpperCase();
				String sql = "select lprod_gu from lprod where lprod_gu = ?";
				
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(1, gu);
				
				rs = pstmt.executeQuery();
				
				while(rs.next()){
					if(!rs.getObject("lprod_gu").equals(gu)){
						break;
					}else{
						System.out.println("중복됩니다.");
						bl = false;
						break;
					}
					
				}
				if(bl == true) break;
			}
			System.out.print("lprod_nm : ");
			String nm = sc.next();
			
			
			String sql = "insert into LPROD "
					+ "(lprod_id, lprod_gu, lprod_nm) "
					+ "values((SELECT NVL(MAX(lprod_id),0)+1 FROM lprod), ?, ?)";
			if(pstmt!=null) try{pstmt.close();}catch(SQLException e){}
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, gu);
			pstmt.setString(2, nm);
			int cnt =  pstmt.executeUpdate();
			System.out.println("반환값 : " + cnt);
		} catch (SQLException e) {
			// TODO: handle exception
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(pstmt!=null) try{pstmt.close();}catch(SQLException e){}
			if(rs!=null) try{rs.close();}catch(SQLException e){}
			if(conn!=null) try{conn.close();}catch(SQLException e){}
		}
	}
}

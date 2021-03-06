package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import kr.or.ddit.util.DBUtil;

/*
 * - 회원을 관리하는 프로그램을 작성하시오.
 * 	(오라클 DB의 MYMEMBER 테이블 이용)
 * 
 * - 아래 메뉴의 기능을 모두 구현하시오. (CRUD 구현하기 연습)
 * 메뉴예시)
 * -- 작업 선택 --
 * 1. 자료 추가
 * 2. 자료 삭제
 * 3. 자료 수정
 * 4. 전체 자료 출력
 * 0. 작업 끝.
 * -------------
 * 작업 선택 >> 
 *  
 */
public class jdbcTest07 {
	Scanner sc = new Scanner(System.in);
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	public static void main(String[] args) {
		new jdbcTest07().start();
	}
	private void start() {
		menu();
	}
	private void menu() {
		while(true){
			System.out.println("--작업 선택--");
			System.out.println("1. 자료 추가");
			System.out.println("2. 자료 삭제");
			System.out.println("3. 자료 수정");
			System.out.println("4. 전체 자료 출력");
			System.out.println("0. 작업 끝.");
			System.out.println("----------------");
			System.out.print("작업 선택 >> ");
			int choice = sc.nextInt();
			switch (choice) {
			case 1:	
				insert();
				break;
			case 2:
				delete();
				break;
			case 3:
				update();
				break;
			case 4:
				print();
				break;
			default:
				break;
			}
		}
	}
	private void print() {
		System.out.println("전체 자료 출력 페이지");
		System.out.println("------------------------------------");
		try {
			conn = DBUtil.getConnection();
			String sql = "select * from mymember";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				System.out.println("아이디 : " + rs.getString("MEM_ID"));
				System.out.println("이름 : " + rs.getString("MEM_NAME"));
				System.out.println("전화번호 : " + rs.getString("MEM_TEL"));
				System.out.println("주소 : " + rs.getString("MEM_ADDR"));
				System.out.println("------------------------------------");
			}
			System.out.println("출력 끝.");
		} catch (SQLException e) {
			// TODO: handle exception
		} finally {
			if(pstmt!=null) try{pstmt.close();}catch(SQLException e){}
			if(rs!=null) try{rs.close();}catch(SQLException e){}
			if(conn!=null) try{conn.close();}catch(SQLException e){}
		}
	}
	private void update() {
		System.out.println("수정페이지");
		try {
			conn = DBUtil.getConnection();
			String id = "";
			int count = 0;
			do{
				System.out.print("수정하실 아이디 입력 : ");
				id = sc.next();
				String sql = "select count(*) cnt from mymember where mem_id = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, id);
				rs = pstmt.executeQuery();
				if(rs.next()){
					count = rs.getInt("cnt");
				}
				if(count == 0){
					System.out.println(id + "는 없는 아이디 입니다.");
				}
			}while(count==0);
			
			System.out.print("이름 입력 : ");
			String name = sc.next();
			System.out.print("전화번호 입력 : ");
			String tel = sc.next();
			System.out.print("주소 입력 : ");
			String addr = sc.next();
			
			
			String sql = "update mymember set mem_name = ?, mem_tel = ?, mem_addr = ? where mem_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, tel);
			pstmt.setString(3, addr);
			pstmt.setString(4, id);
			
			int cnt = pstmt.executeUpdate();
			if(cnt > 0){
				System.out.println("수정 성공~");
			}else{
				System.out.println("수정 실패~");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(pstmt!=null) try{pstmt.close();}catch(SQLException e){}
			if(rs!=null) try{rs.close();}catch(SQLException e){}
			if(conn!=null) try{conn.close();}catch(SQLException e){}
		}
	}
	private void delete() {
		System.out.println("삭제페이지");
		try {
			conn = DBUtil.getConnection();
			String id = "";
			int count = 0;
			do{
				System.out.print("삭제하실 아이디 입력 : ");
				id = sc.next();
				String sql = "select count(*) cnt from mymember where mem_id = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, id);
				rs = pstmt.executeQuery();
				if(rs.next()){
					count = rs.getInt("cnt");
				}
				if(count == 0){
					System.out.println(id + "는 없는 아이디 입니다.");
				}
			}while(count==0);
			
			String sql = "delete from mymember where mem_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			int cnt = pstmt.executeUpdate();
			if(cnt > 0){
				System.out.println("삭제 성공~");
			}else{
				System.out.println("삭제 실패~");
			}
		} catch (SQLException e) {
			// TODO: handle exception
		} finally {
			if(pstmt!=null) try{pstmt.close();}catch(SQLException e){}
			if(rs!=null) try{rs.close();}catch(SQLException e){}
			if(conn!=null) try{conn.close();}catch(SQLException e){}
		}
	}
	private void insert() {
		System.out.println("추가페이지");
		try {
			conn = DBUtil.getConnection();
			String id = "";
			int count = 0;
			do{
				System.out.print("아이디 입력 : ");
				id = sc.next();
				String sql = "select count(*) cnt from mymember where mem_id = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, id);
				rs = pstmt.executeQuery();
				if(rs.next()){
					count = rs.getInt("cnt");
				}
				if(count == 1){
					System.out.println(id + "는 중복된 아이디입니다.");
				}
			}while(count == 1);
			
			System.out.print("이름 입력 : ");
			String name = sc.next();
			System.out.print("전화번호 입력 : ");
			String tel = sc.next();
			System.out.print("주소 입력 : ");
			String addr = sc.next();
			
			String sql = "insert into mymember (mem_id, mem_name, mem_tel, mem_addr) values(?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, name);
			pstmt.setString(3, tel);
			pstmt.setString(4, addr);
			
			
			
			int cnt = pstmt.executeUpdate();
			if(cnt > 0){
				System.out.println("등록 성공~");
			}else{
				System.out.println("등록 실패~");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(pstmt!=null) try{pstmt.close();}catch(SQLException e){}
			if(rs!=null) try{rs.close();}catch(SQLException e){}
			if(conn!=null) try{conn.close();}catch(SQLException e){}
		}
	}
}

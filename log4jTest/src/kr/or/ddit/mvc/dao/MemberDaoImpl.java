package kr.or.ddit.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import kr.or.ddit.mvc.vo.MemberVO;
import kr.or.ddit.util.DBUtil3;

public class MemberDaoImpl implements IMemberDao{
	private static final Logger logger = Logger.getLogger(MemberDaoImpl.class);
	
	// 싱글톤으로 만들기!
	private static MemberDaoImpl dao;
	
	// 생성자가 없을때 컴파일이 자동으로 만들어주는 것은 public이기 떄문에 private로 적어주어야 한다.
	private MemberDaoImpl(){
		
	}
	// 외부에서 접근할수 있어야 하기 떄문에 public
	public static MemberDaoImpl getInstance(){
		if(dao == null) dao = new MemberDaoImpl();
		return dao;
	}
	// 싱글톤으로 만들기는 여기 까지!
	
	
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	int cnt = 0;
	@Override
	public int insertMember(MemberVO memVo) {
		
		try {
			conn = DBUtil3.getConnection();
			logger.info("Connection객체 생성 완료...");
			String sql = "insert into mymember "
					+ "(mem_id, mem_name, mem_tel, mem_addr) "
					+ "values(?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memVo.getMem_id());
			pstmt.setString(2, memVo.getMem_name());
			pstmt.setString(3, memVo.getMem_tel());
			pstmt.setString(4, memVo.getMem_addr());
			logger.info("PrepareadStatement객체 생성...");
			logger.info("실행 SQL문 : " + sql);
			logger.info("사용 데이터 : [" + memVo.getMem_id() + "," + memVo.getMem_name()+"," + memVo.getMem_tel() + "," + memVo.getMem_addr() + "]");
			
			
			cnt = pstmt.executeUpdate();
			logger.info("insert 작업 성공~~~~");
		} catch (SQLException e) {
			logger.error("insert 작업 실패~~~~");
			cnt = 0;
			e.printStackTrace();
		} finally {
			if(pstmt!=null) try{
				pstmt.close();
				logger.info("PreparedStatment객체 반납...");
			}catch(SQLException e){}
			if(conn!=null) try{conn.close();}catch(SQLException e){}
		}
		return cnt;
	}

	@Override
	public int deleteMember(String memId) {

		try {
			conn = DBUtil3.getConnection();
			logger.info("Connection객체 생성 완료...");
			String sql = "delete from mymember where mem_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memId);
			logger.info("PrepareadStatement객체 생성...");
			logger.info("실행 SQL문 : " + sql);
			logger.info("사용 데이터 : [" + memId + "]");
			cnt = pstmt.executeUpdate();
			logger.info("delete 작업 성공~~~~");
		} catch (SQLException e) {
			logger.info("delete 작업 실패~~~~");
			cnt = 0;
			e.printStackTrace();
		} finally {
			if(pstmt!=null) try{
				pstmt.close();
				logger.info("PreparedStatment객체 반납...");
			}catch(SQLException e){}
			if(conn!=null) try{conn.close();}catch(SQLException e){}
		}
		return cnt;
	}

	@Override
	public int updateMember(MemberVO memVo) {

		try {
			conn = DBUtil3.getConnection();
			logger.info("Connection객체 생성 완료...");
			String sql = "update mymember set mem_name = ?, mem_tel = ?, mem_addr = ? where mem_id = ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memVo.getMem_name());
			pstmt.setString(2, memVo.getMem_tel());
			pstmt.setString(3, memVo.getMem_addr());
			pstmt.setString(4, memVo.getMem_id());
			logger.info("PrepareadStatement객체 생성...");
			logger.info("실행 SQL문 : " + sql);
			logger.info("사용 데이터 : [" + memVo.getMem_id() + "," + memVo.getMem_name()+"," + memVo.getMem_tel() + "," + memVo.getMem_addr() + "]");
			
			cnt = pstmt.executeUpdate();
			logger.info("update 작업 성공~~~~");
		} catch (SQLException e) {
			logger.info("update 작업 실패~~~~");
			cnt = 0;
			e.printStackTrace();
		} finally {
			if(pstmt!=null) try{
				pstmt.close();
				logger.info("PreparedStatment객체 반납...");
			}catch(SQLException e){}
			if(conn!=null) try{conn.close();}catch(SQLException e){}
		}
		return cnt;
	}

	@Override
	public List<MemberVO> getAllMember() {
		List<MemberVO> list = new ArrayList<>();
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBUtil3.getConnection();
			logger.info("Connection객체 생성 완료...");
			String sql = "select * from mymember";
			stmt = conn.createStatement();
			logger.info("Statment 객체 생성...");
			logger.info("실행 SQL문 : " + sql);
			rs = stmt.executeQuery(sql);
			logger.info("ResultSet 객체 생성...");
			while(rs.next()){
				MemberVO memVo = new MemberVO();
				memVo.setMem_id(rs.getString("MEM_ID"));
				memVo.setMem_name(rs.getString("MEM_NAME"));
				memVo.setMem_tel(rs.getString("MEM_TEL"));
				memVo.setMem_addr(rs.getString("MEM_ADDR"));
				list.add(memVo);
			}
			logger.info("select 작업 성공~~~~");
		} catch (SQLException e) {
			logger.info("select 작업 실패~~~~");
			e.printStackTrace();
		} finally{
			if(rs!=null) try{
				rs.close();
				logger.info("ResultSet 객체 반납...");
				}catch(SQLException e){}
			if(stmt!=null) try{
				stmt.close();
				logger.info("Statment객체 반납...");
				}catch(SQLException e){}
			if(conn!=null) try{conn.close();}catch(SQLException e){}
		}
		return list;
	}

	@Override
	public int getMemberCount(String memId) {
		ResultSet rs = null;
		try {
			conn = DBUtil3.getConnection();
			logger.info("Connection객체 생성 완료...");
			String sql = "select count(*) cnt from mymember where mem_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memId);
			logger.info("PreparedStatment객체 생성...");
			logger.info("실행 SQL문 : " + sql);
			logger.info("사용 데이터 : [" + memId + "]");
			rs = pstmt.executeQuery();
			if(rs.next()){
				cnt = rs.getInt("cnt");
			}
			
			logger.info("select 작업 성공~~~~");
		} catch (SQLException e) {
			logger.info("select 작업 실패~~~~");
			cnt = 0;
			e.printStackTrace();
		} finally {
			if(rs!=null) try{
				rs.close();
				logger.info("ResultSet 객체 반납...");
				}catch(SQLException e){}
			if(pstmt!=null) try{
				pstmt.close();
				logger.info("PreparedStatment객체 반납...");
				}catch(SQLException e){}
			if(conn!=null) try{conn.close();}catch(SQLException e){}
		}
		return cnt;
	}

	@Override
	public int updateMember2(Map<String, String> paramMap) {
		// Key값 정보 = 회원ID(memid), 수정할 컬럼명(field), 수정할 데이터(data)
		try {
			conn = DBUtil3.getConnection();
			logger.info("Connection객체 생성 완료...");
			String sql = "update mymember set " + paramMap.get("field") + " = ? where mem_id = ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, paramMap.get("data"));
			pstmt.setString(2, paramMap.get("memid"));
			logger.info("PreparedStatment객체 생성...");
			logger.info("실행 SQL문 : " + sql);
			logger.info("사용 데이터 : [" + paramMap.get("data") + "," + paramMap.get("memid") + "]");
			cnt = pstmt.executeUpdate();
			logger.info("update 작업 성공~~~~");
		} catch (SQLException e) {
			logger.info("update 작업 실패~~~~");
			cnt = 0;
			e.printStackTrace();
		} finally {
			if(pstmt!=null) try{
				pstmt.close();
				logger.info("PreparedStatment객체 반납...");
				}catch(SQLException e){}
			if(conn!=null) try{conn.close();}catch(SQLException e){}
		}
		return cnt;
	}

}

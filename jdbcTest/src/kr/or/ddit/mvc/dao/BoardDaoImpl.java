package kr.or.ddit.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import kr.or.ddit.mvc.vo.BoardVO;
import kr.or.ddit.util.DBUtil3;

public class BoardDaoImpl implements IBoardDao {
	// 싱글톤으로 만들기!
	private static BoardDaoImpl dao;
	
	private BoardDaoImpl(){
		
	}
	public static BoardDaoImpl getInstance(){
		if(dao == null) dao = new BoardDaoImpl();
		return dao;
	}
	
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	Statement stmt = null;
	ResultSet rs = null;
	int cnt = 0;
	@Override
	public int insertBoard(BoardVO boardVo) {
		try {
			conn = DBUtil3.getConnection();
			String sql = "insert into jdbc_board "
					+ "(board_no, board_title, board_writer, board_date, board_cnt, board_content) "
					+ "values (board_seq.nextVal, ?, ? , sysdate, 0, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, boardVo.getBoard_title());
			pstmt.setString(2, boardVo.getBoard_writer());
			pstmt.setString(3, boardVo.getBoard_content());
			
			cnt = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		} finally {
			if(pstmt!=null) try{pstmt.close();}catch(SQLException e){}
			if(conn!=null) try{conn.close();}catch(SQLException e){}
		}
		return cnt;
	}

	@Override
	public int deleteBoard(int boardNo) {
		try {
			conn = DBUtil3.getConnection();
			String sql = "delete from jdbc_board where board_no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNo);
			
			cnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		} finally {
			if(pstmt!=null) try{pstmt.close();}catch(SQLException e){}
			if(conn!=null) try{conn.close();}catch(SQLException e){}
		}
		return cnt;
	}

	@Override
	public int updateBoard(BoardVO boardVo) {
		try {
			conn = DBUtil3.getConnection();
			String sql = "update jdbc_board set board_title = ?, board_content = ? where board_no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, boardVo.getBoard_title());
			pstmt.setString(2, boardVo.getBoard_content());
			pstmt.setInt(3, boardVo.getBoard_no());
			
			cnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		} finally {
			if(pstmt!=null) try{pstmt.close();}catch(SQLException e){}
			if(conn!=null) try{conn.close();}catch(SQLException e){}
		}
		return cnt;
	}

	@Override
	public List<BoardVO> getAllBoard() {
		List<BoardVO> list = new ArrayList<>();
		
		try {
			conn = DBUtil3.getConnection();
			String sql = "select * from jdbc_board order by board_no desc";
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				BoardVO boardVo = new BoardVO();
				boardVo.setBoard_no(rs.getInt("BOARD_NO"));
				boardVo.setBoard_title(rs.getString("BOARD_TITLE"));
				boardVo.setBoard_writer(rs.getString("BOARD_WRITER"));
				boardVo.setBoard_cnt(rs.getInt("BOARD_CNT"));
				list.add(boardVo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			if(rs!=null) try{rs.close();}catch(SQLException e){}
			if(stmt!=null) try{stmt.close();}catch(SQLException e){}
			if(conn!=null) try{conn.close();}catch(SQLException e){}
		}
		return list;
	}

	@Override
	public BoardVO getSelectBoard(int boardNo) {
		BoardVO boardVo = new BoardVO();
		
		try {
			conn = DBUtil3.getConnection();
			String sql = "select * from jdbc_board where board_no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNo);
			
			rs = pstmt.executeQuery();
			if (rs.next()){
				boardVo.setBoard_no(rs.getInt("BOARD_NO"));
				boardVo.setBoard_title(rs.getString("BOARD_TITLE"));
				boardVo.setBoard_writer(rs.getString("BOARD_WRITER"));
				boardVo.setBoard_content(rs.getString("BOARD_CONTENT"));
				boardVo.setBoard_date(rs.getString("BOARD_DATE"));
				boardVo.setBoard_cnt(rs.getInt("BOARD_CNT"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			if(rs!=null) try{rs.close();}catch(SQLException e){}
			if(pstmt!=null) try{pstmt.close();}catch(SQLException e){}
			if(conn!=null) try{conn.close();}catch(SQLException e){}
		}
		return boardVo;
	}

	@Override
	public List<BoardVO> getSearchBoard(String search) {
		List<BoardVO> list = new ArrayList<>();
		try {
			conn = DBUtil3.getConnection();
			String sql = "select * from jdbc_board  where board_title LIKE '%' || ? ||'%' order by board_no desc";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, search);
			
			rs = pstmt.executeQuery();
			while(rs.next()){
				BoardVO boardVo = new BoardVO();
				boardVo.setBoard_no(rs.getInt("BOARD_NO"));
				boardVo.setBoard_title(rs.getString("BOARD_TITLE"));
				boardVo.setBoard_writer(rs.getString("BOARD_WRITER"));
				boardVo.setBoard_content(rs.getString("BOARD_CONTENT"));
				boardVo.setBoard_date(rs.getString("BOARD_DATE"));
				boardVo.setBoard_cnt(rs.getInt("BOARD_CNT"));
				list.add(boardVo);
			}
					
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			if(rs!=null) try{rs.close();}catch(SQLException e){}
			if(pstmt!=null) try{pstmt.close();}catch(SQLException e){}
			if(conn!=null) try{conn.close();}catch(SQLException e){}
		}
		return list;
	}

	@Override
	public int countUp(int boardNo) {
		try {
			conn = DBUtil3.getConnection();
			String sql = "update jdbc_board set board_cnt = board_cnt+1 where board_no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNo);
			cnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		} finally {
			if(pstmt!=null) try{pstmt.close();}catch(SQLException e){}
			if(conn!=null) try{conn.close();}catch(SQLException e){}
		}
		return cnt;
	}

	

}
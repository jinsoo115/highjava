package kr.or.ddit.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.util.SqlMapUtil;
import kr.or.ddit.vo.MemberVO;



public class MemberDaoImpl implements IMemberDao{
	private SqlMapClient smc;
	// 싱글톤으로 만들기!
	private static MemberDaoImpl dao;
	
	// 생성자가 없을때 컴파일이 자동으로 만들어주는 것은 public이기 떄문에 private로 적어주어야 한다.
	private MemberDaoImpl(){
		smc = SqlMapUtil.getSqlMapClient();
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
			Object obj = smc.insert("mymember.insertMember",memVo);
			if(obj==null) cnt=1; // insert 성공 여부 판단
		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public int deleteMember(String memId) {

		try {
			cnt = smc.delete("mymember.deleteMember", memId);
		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public int updateMember(MemberVO memVo) {

		try {
			cnt = smc.update("mymember.updateMember", memVo);
		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		} 
		return cnt;
	}

	@Override
	public List<MemberVO> getAllMember() {
		List<MemberVO> list = new ArrayList<>();
		try {
			list = smc.queryForList("mymember.getAllMember");
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return list;
	}

	@Override
	public int getMemberCount(String memId) {
		try {
			cnt = (int) smc.queryForObject("mymember.getMemberCount",memId);
		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public int updateMember2(Map<String, String> paramMap) {
		// Key값 정보 = 회원ID(memid), 수정할 컬럼명(field), 수정할 데이터(data)
		try {
			cnt = smc.update("mymember.updateMember2", paramMap);
		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		} 
		return cnt;
	}

}

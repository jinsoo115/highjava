package kr.or.ddit.basic;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.util.SqlMapUtil;

// jdbcTest 프로젝트에 있는 'jdbcTest06.java'의 처리방법을
// ibatis를 이용하여 처리하는 것으로 변경하시오.

// 쿼리문이 저장될 xml문서 이름은 'jdbc06.xml'로 한다.
public class JdbcTest06ToIbatis {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		SqlMapClient smc = null; // SQL문을 처리할 SqlMapClient객체 변수 선언
//		Reader rd = null;
		try {
//			Charset charset = Charset.forName("UTF-8");
//			Resources.setCharset(charset);
//			
//			rd = Resources.getResourceAsReader("sqlMapConfig.xml");
//			
//			smc = SqlMapClientBuilder.buildSqlMapClient(rd);
			smc = SqlMapUtil.getSqlMapClient();
			System.out.println("insert작업 시작...");
			int lprodId = (int) smc.queryForObject("jdbc06.getMaxId");
			
			String lprodGu; // 상품분류코드가 저장될 변수
			int count = 0;
			do {
				System.out.print("검색할 lprod_gu 입력 : ");
				lprodGu = sc.next();
				lprodGu = (lprodGu + "   ").substring(0,4);
				count = (int) smc.queryForObject("jdbc06.getCount", lprodGu);
				if(count == 1) {
					System.out.println("입력한 상품분류코드" + lprodGu + "는 이미 등록된 코드입니다");
					System.out.println("다시 입력하세요");
				}
			}while(count == 1);
			System.out.print("lprod_nm 입력 : ");
			String lprodNm = sc.next();
			
			LprodVO lvo = new LprodVO();
			
			lvo.setLprod_id(lprodId);
			lvo.setLprod_gu(lprodGu);
			lvo.setLprod_nm(lprodNm);
			
			Object obj = smc.insert("jdbc06.insertLprod", lvo);
			
			if(obj == null) {
				System.out.println("insert 작업 성공!!!");
			}else {
				System.out.println("insert 작업 실패~~~");
			}
			
			System.out.println("insert 작업 끝....");
			
			
			
//		} catch (IOException e) {
//			e.printStackTrace();
		}  catch (SQLException e) {
			e.printStackTrace();
//		} finally {
//			if(rd!=null) try {rd.close();} catch (Exception e) {e.printStackTrace();}
		}
	}
}

package com.mystudy.cafetest.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.mystudy.cafetest.common.CommonJDBCUtil;
import com.mystudy.cafetest.vo.JoinedDataVO;
import com.mystudy.cafetest.vo.MenuVO;
import com.mystudy.cafetest.vo.OrdersVO;
import com.mystudy.cafetest.vo.OrdersdetailVO;
import com.mystudy.cafetest.vo.SalesVO;

public class OrdersdetailDAO {
	List<OrdersdetailVO> list = null;
	List<SalesVO> list2 = null;
	List<OrdersVO> list3 = null;
	List<MenuVO> list4 = null;
	List<JoinedDataVO> joinList = null;
	
	//(주문목록) 전체데이터 검색 - selectAll() : List<OrdersdetailVO>
	//SELECT 주문ID, 고객ID, 주문수량, 메뉴명, 가격 
	public List<JoinedDataVO> selectAll() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			//2. DB연결 - Connection 객체 생성 <- CommonJDBCUtil
			conn = CommonJDBCUtil.getConnection();
			
			//3. Statement 문 실행(SQL 문 실행)
			String str = "SELECT o.orderid, C.CUSTNAME, J.name, J.price"
					+ ", S.COUNT, S.ORDERDATE "
					+ "FROM ORDERS O "
					+ "   , SALES S "
					+ "   , CUSTOMER C "
					+ "   , (SELECT ODT.ORDERID, M.NAME, M.PRICE "
					+ "        FROM ORDERSDETAIL ODT, MENU M "
					+ "        WHERE ODT.MENUID = M.MENUID) J "
					+ "WHERE O.ORDERID = S.ORDERID "
					+ "  AND O.ORDERID = J.ORDERID "
					+ "  AND O.CUSTID = C.CUSTID ";
			
			pstmt = conn.prepareStatement(str);
			
			rs = pstmt.executeQuery();
			
			//4. SQL 실행 결과에 대한 처리
			//   - SELECT : 조회(검색) 데이터 결과 값에 대한 처리
			
			//list = new ArrayList<OrdersdetailVO>();
			
			joinList = new ArrayList<JoinedDataVO>();
			
			while (rs.next()) {
				JoinedDataVO vo = new JoinedDataVO(
						rs.getInt("ORDERID")
						, rs.getString("CUSTNAME")
						, rs.getString("NAME")
						, rs.getInt("PRICE")
						, rs.getInt("COUNT")
						, rs.getString("ORDERDATE"));
				joinList.add(vo);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//5. 클로징 처리에 의한 자원 반납
			CommonJDBCUtil.close(conn, pstmt, rs);
		}

		return joinList;
	}

	
}

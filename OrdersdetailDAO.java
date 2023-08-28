package com.mystudy.cafetest.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.mystudy.cafetest.common.CommonJDBCUtil;
import com.mystudy.cafetest.vo.MenuVO;
import com.mystudy.cafetest.vo.OrdersVO;
import com.mystudy.cafetest.vo.OrdersdetailVO;
import com.mystudy.cafetest.vo.SalesVO;

public class OrdersdetailDAO {
	List<OrdersdetailVO> list = null;
	List<SalesVO> list2 = null;
	List<OrdersVO> list3 = null;
	List<MenuVO> list4 = null;
	
	//(주문목록) 전체데이터 검색 - selectAll() : List<OrdersdetailVO>
	public List<OrdersdetailVO> selectAll() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		
		try {
			//2. DB연결 - Connection 객체 생성 <- CommonJDBCUtil
			conn = CommonJDBCUtil.getConnection();
			
			//3. Statement 문 실행(SQL 문 실행)
			String str = "SELECT o.orderid, o.custid, J.name, J.price, s.count, s.orderdate "
					+ "FROM ORDERS O "
					+ "   , SALES S "
					+ "   , (SELECT ODT.ORDERID, M.NAME, M.PRICE "
					+ "        FROM ordersdetail ODT, MENU M "
					+ "        WHERE odt.menuid = m.menuid) J "
					+ "WHERE O.ORDERID = S.ORDERID "
					+ "  AND O.ORDERID = J.ORDERID ";
			
			pstmt = conn.prepareStatement(str);
			
			rs = pstmt.executeQuery();
			
			//4. SQL 실행 결과에 대한 처리
			//   - SELECT : 조회(검색) 데이터 결과 값에 대한 처리
			
			list = new ArrayList<>();
			list2 = new ArrayList<SalesVO>();
			list3 = new ArrayList<OrdersVO>();
			list4 = new ArrayList<MenuVO>();
			
			//SalesVO와 OrdersVO 조인
			for(SalesVO vo2 : list2) {
				for (OrdersVO vo3 : list3) {
					if (vo2.getOrderId() == vo3.getOrderId()) {
						System.out.println(vo3.getOrderId() + "\t" 
								+ vo2.getOrderDate() + "\t"
								+ vo2.getCount() + "\t");
						//OrdersdetailVO와 MenuVO 조인
						for (OrdersdetailVO vo : list) {
							if (vo.getOrderId() == vo3.getOrderId()) {
								for (MenuVO vo4 : list4) {
									if (vo.getMenuId() == vo4.getMenuid()) {
										System.out.println(vo4.getName() + "\t"
												+ vo4.getPrice());
										break;
									}
								}
							}	
						}
					} 
				}
			}
			
//			while (rs.next()) {
//				OrdersdetailVO vo = new OrdersdetailVO(
//						rs.getInt("menuId"),
//						rs.getInt("orderId"),
//						rs.getInt("count")
//						);
//				list.add(vo);
//			}
//			
//			
//			while (rs.next()) {
//				SalesVO vo = new SalesVO(
//						rs.getInt("count")
//					  , rs.getString("orderdate"));
//				list2.add(vo);
//			}
//			System.out.println(list2.get(0).getCount() + " " 
//						+ list2.get(0).getOrderDate()); //반복문처리?
//			
//			
//			while (rs.next()) {
//				OrdersVO vo = new OrdersVO(
//						rs.getInt("orderid")
//					  , rs.getString("custid"));
//				list3.add(vo);		
//			}
//			System.out.println(list3.get(0).getOrderId() + " " 
//						+ list3.get(0).getCustId()); //반복문처리?
			
			

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//5. 클로징 처리에 의한 자원 반납
			CommonJDBCUtil.close(conn, pstmt, rs);
		}

		return list;
	}

	
}

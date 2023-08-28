package com.mystudy.cafetest.dao;

import java.util.List;

import com.mystudy.cafetest.vo.OrdersdetailVO;

public class OrdersdetailDAO_Test {

	public static void main(String[] args) {

		OrdersdetailDAO dao = new OrdersdetailDAO();
		//1.주문목록조회
		List<OrdersdetailVO> list = dao.selectAll();
		
		for (OrdersdetailVO vo : list) {
			System.out.println(vo);
			
		}
		
		
		

	}

}

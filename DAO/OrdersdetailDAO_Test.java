package com.mystudy.cafetest.dao;

import java.util.List;

import com.mystudy.cafetest.vo.JoinedDataVO;

public class OrdersdetailDAO_Test {

	public static void main(String[] args) {

		OrdersdetailDAO dao = new OrdersdetailDAO();
		//1.주문목록조회
		List<JoinedDataVO> list = dao.selectAll();
		
		for (JoinedDataVO vo : list) {
			System.out.println(vo);
		}
		
		
		

	}

}

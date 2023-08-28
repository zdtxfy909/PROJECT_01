package com.mystudy.cafetest.dao;

import java.util.List;

import com.mystudy.cafetest.vo.SalesVO;

public class SalesDAO_Test {

	public static void main(String[] args) {
		SalesDAO dao = new SalesDAO();
		
		//sales 전체 매출데이터 조회
		List<SalesVO> list = dao.selectAll();
		
		for (SalesVO vo : list) {
			System.out.println(vo);
		}
		
		//sales 일별 매출데이터 조회
		list = dao.selectDay();

		for (SalesVO vo : list) {
			System.out.println(vo);
		}

		//sales 월별 매출데이터 조회
		list = dao.selectMonth();

		for (SalesVO vo : list) {
			System.out.println(vo);
		}

		//sales 연도별 매출데이터 조회
		list = dao.selectYear();

		for (SalesVO vo : list) {
			System.out.println(vo);
		}

	}

}

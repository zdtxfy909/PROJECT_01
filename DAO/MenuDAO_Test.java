package com.mystudy.cafetest.dao;

import java.util.List;

import com.mystudy.cafetest.vo.MenuVO;

public class MenuDAO_Test {

	public static void main(String[] args) {
		MenuDAO dao = new MenuDAO();
		
		//menu 전체 데이터 조회
		List<MenuVO> list = dao.selectAll();
		
		for (MenuVO vo : list) {
			System.out.println(vo);
		}
		
		//insert(vo)
		MenuVO menu = new MenuVO(4, "아메리카노", 2500);
		int result = dao.insert(menu);
		System.out.println("입력건수 : " + result);
		
		//update(vo)
		menu = new MenuVO(2, "카페라떼수정", 3700);
		result = dao.update(menu);
		System.out.println("수정건수 : " + result);
		
		//delete(id)
		menu = new MenuVO(39);
		result = dao.delete(menu.getMenuid());
		System.out.println("삭제건수 : " + result);
		
	}

}

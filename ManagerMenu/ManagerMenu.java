package com.mystudy.cafetest.manager.menu;

import java.util.Scanner;

import com.mystudy.cafetest.dao.OrdersdetailDAO;

public class ManagerMenu {
	static Scanner scan = new Scanner(System.in);
	//static MenuDAO dao = new MenuDAO();
	//static List<MenuVO> list = dao.selectAll();
	static int menuId;
	static String menuName;
	static int price;
	static int select;
	static int select1;
	OrdersdetailDAO dao = new OrdersdetailDAO();
	
	//--------------------- 관리자 메뉴 운영 --------------------------
	public void runningManager() {
		
		int select = -1;
		
		//1. 관리자 작업 메뉴 선택
		showManagerMenu(); 

		//2. 숫자가 아닌 데이터(문자) 입력 시 예외 처리
		try {
			select = Integer.parseInt(scan.nextLine());
		} catch (NumberFormatException e) {
			System.out.println("메뉴 숫자(1 ~ 3)만 입력하세요");
		}

		//3. 메뉴 선택시
		if (select == 1) {
			System.out.println("======================");
			System.out.println("::: 1.주문상세조회");
			System.out.println("======================");
			System.out.println("1.주문목록조회 2.매출조회");

			int select1 = Integer.parseInt(scan.nextLine());
			if (select1 == 1) {
				//1.주문목록조회
				System.out.println("주문 전체 데이터 출력");
			}
			if (select1 == 2) {
				//2.매출조회
				System.out.println("1.일매출 2.월매출 3.연매출");
			}

		} 
		if (select == 2) {
			System.out.println("======================");
			System.out.println("::: 2.메뉴관리");
			System.out.println("======================");
			System.out.println("1.추가 2.수정 3.삭제");
			System.out.print("> 처리할 작업을 선택하세요 : ");

			int select2 = Integer.parseInt(scan.nextLine());
			if (select2 == 1) {
				addMenu(); //메뉴추가
			}
			if (select2 == 2) {
				updateMenu(); //메뉴수정
			}
			if (select2 == 3) {
				deleteMenu(); //메뉴삭제
			}

		}
		if (select == 3) {
			System.out.println("======================");
			System.out.println("::: 3. 회원관리");
			System.out.println("======================");
			System.out.println("1.조회 2.수정 3.탈퇴(삭제)");
			System.out.print("> 처리할 작업을 선택하세요 : ");
			
		}

	}
	
	//----------------------- 주문상세조회 메소드 -------------------------
	public void selectOrders() {
		System.out.println("======================");
		//들어온 주문 전체 확인
		
	}
	
	
	//-----------------------------------------------------------
	
	//-------------------------- 메뉴관리 메소드 ---------------------------
	public void deleteMenu() {
		System.out.println("======================");
		//전체메뉴출력하기 ---> showCoffeeMenu();
		
		deleteMenuId();
		
		//처음화면으로 돌아가기 ---> startCafe();
	}

	private void deleteMenuId() {
		do {
			try {
				System.out.println("----------------------");
				System.out.print("삭제할 MENUID를 입력하세요 : ");
				menuId = Integer.parseInt(scan.nextLine());
				
				if (menuId < 1 || menuId > 99) {
					System.out.println("[예외발생] 범위를 벗어난 값입니다. MENUID(1 ~ 99) 입력 가능");
				} 
				
			} catch (NumberFormatException e) {
				System.out.println("[예외발생] 문자입력불가. MENUID(1 ~ 99) 입력 가능");
			} 
		} while (menuId < 1 || menuId > 99);
		System.out.println(menuId + "번 메뉴가 삭제되었습니다.");
		
	}

	public void updateMenu() {
		System.out.println("======================");
		//전체메뉴출력하기 ---> showCoffeeMenu();
		System.out.println("::: 수정할 정보를 입력하세요.");
		System.out.print("MENUID : ");
		menuId = Integer.parseInt(scan.nextLine());
		System.out.print("MENUNAME : ");
		menuName = scan.nextLine();
		System.out.print("PRICE : ");
		price = Integer.parseInt(scan.nextLine());
		System.out.print("> 메뉴 수정 완료");
		System.out.println(" [ " + menuId + "." 
					+ menuName + " " 
					+ price + "원 ]");
		//처음화면으로 돌아가기 ---> startCafe();
	}
	
	public void addMenu() {
		System.out.println("======================");
		System.out.println("::: 추가할 정보를 입력하세요.");
		
		//MENUID
		addMenuId();
		
		//MENUNAME
		addMenuName();
		
		//PRICE
		addMenuPrice();
		
		//추가작업끝
		System.out.print("> 메뉴 추가 완료");
		System.out.println(" [ " + menuId + "." 
				+ menuName + " " 
				+ price + "원 ]");
		//처음화면으로 돌아가기 ---> startCafe();
	}
	
	private void addMenuPrice() {
		do {
			try {
				System.out.println("----------------------");
				System.out.print("PRICE : ");
				price = Integer.parseInt(scan.nextLine());
				
				if (price < 1 || price > 99999999) {
					System.out.println("[예외발생] 범위를 벗어난 값입니다. 다시 입력하세요.");
				} 
				
			} catch (NumberFormatException e) {
				System.out.println("[예외발생] 문자입력불가. 다시 입력하세요.");
			} 
		} while (price < 1 || price > 99999999);
	}

	private void addMenuName() {
		do {
			System.out.println("----------------------");
			System.out.print("MENUNAME : ");
			menuName = scan.nextLine();

			if (menuName.isEmpty()) {
				System.out.println("[예외발생] 메뉴 이름을 입력하세요.");
			} else if (!menuName.matches("[a-zA-Z가-힣]+")) {
				System.out.println("[예외발생] 메뉴 이름은 한글과 영어 문자만 입력하세요.");
			}
		} while (menuName.isEmpty() || !menuName.matches("[a-zA-Z가-힣]+"));
		
	}

	private void addMenuId() {
		do {
			try {
				System.out.println("----------------------");
				System.out.print("MENUID : ");
				menuId = Integer.parseInt(scan.nextLine());
				
				if (menuId < 1 || menuId > 99) {
					System.out.println("[예외발생] 범위를 벗어난 값입니다. MENUID(1 ~ 99) 입력 가능");
				} 
				
			} catch (NumberFormatException e) {
				System.out.println("[예외발생] 문자입력불가. MENUID(1 ~ 99) 입력 가능");
			} 
		} while (menuId < 1 || menuId > 99);
		
	}

	//-----------------------------------------------------------
	
	//관리자 메뉴 조회
	public void showManagerMenu () {
		System.out.println("4.주문상세조회 5.메뉴관리");
		System.out.print("> 작업할 메뉴를 선택하세요 : ");
		select = Integer.parseInt(scan.nextLine());

		selectManagerMenu();
		
	}

	private void selectManagerMenu() {
		//3. 4번 '주문상세조회' 메뉴 선택시
		selectManagerMenu4();
		//3. 5번 '메뉴관리' 메뉴 선택시
		selectManagerMenu5();
	}



	private void selectManagerMenu5() {
		if (select == 5) {
			System.out.println("======================");
			System.out.println("::: 5.메뉴관리");
			System.out.println("======================");
			System.out.println("1.추가 2.수정 3.삭제");
			System.out.print("> 처리할 작업을 선택하세요 : ");

			int select2 = Integer.parseInt(scan.nextLine());
			if (select2 == 1) {
				addMenu(); //메뉴추가
			}
			if (select2 == 2) {
				updateMenu(); //메뉴수정
			}
			if (select2 == 3) {
				deleteMenu(); //메뉴삭제
			}

		}
		
	}

	private void selectManagerMenu4() {
		if (select == 4) {
			System.out.println("======================");
			System.out.println("::: 4.주문상세조회");
			System.out.println("======================");
			System.out.println("1.주문목록조회 2.매출조회");
			System.out.print("> 작업할 메뉴를 선택하세요 : ");
			select1 = Integer.parseInt(scan.nextLine());

			if (select1 == 1) {
				//1.주문목록조회
				System.out.println("======================");
				System.out.println("::: 주문 전체 데이터 출력");
				System.out.println("주문ID" + "\t" + "고객ID" + "\t" + "주문수량" 
						+ "\t" + "메뉴명" + "\t" + "가격");
				dao.selectAll();
			}

			if (select1 == 2) {
				//2.매출조회
				System.out.println("======================");
				System.out.println("1.일매출 2.월매출 3.연매출");

				System.out.print("> 작업할 메뉴를 선택하세요 : ");
				int select2 = Integer.parseInt(scan.nextLine());

				if (select2 == 1) {
					//1.일매출
					System.out.println("======================");
					System.out.println("::: 일매출 데이터");
				}
				if (select2 == 2) {
					//2.월매출
					System.out.println("======================");
					System.out.println("::: 월매출 데이터");
				}
				if (select2 == 3) {
					//3.연매출
					System.out.println("======================");
					System.out.println("::: 연매출 데이터");
				}
			}
		}
		
	}
}







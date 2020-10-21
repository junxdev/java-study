package com.bit.day18;

import java.util.ArrayList;

public class BookViewer {
	private BookController bookController;
	private java.util.Scanner scanner;

	public BookViewer() {
		scanner = new java.util.Scanner(System.in);
		java.util.ArrayList<BookVO> inventory = new java.util.ArrayList<>();
		BookVO book = new BookVO();

		book.setId(1);
		book.setTitle("JAVA의 정석");
		book.setAuthor("남궁성");
		book.setPrice(10000);
		inventory.add(book);

		book = new BookVO();
		book.setId(2);
		book.setTitle("슬램덩크");
		book.setAuthor("김덩크");
		book.setPrice(3000);
		inventory.add(book);

		book = new BookVO();
		book.setId(3);
		book.setTitle("명탐정 코난");
		book.setAuthor("박코난");
		book.setPrice(2000);
		inventory.add(book);

		book = new BookVO();
		book.setId(4);
		book.setTitle("소년탐정 김전일");
		book.setAuthor("김전일");
		book.setPrice(7000);
		inventory.add(book);

		java.util.ArrayList<BookVO> rent = new java.util.ArrayList<>();
		bookController = new BookController(inventory, rent);
		showMenu();
	}

	private void showMenu() {
		System.out.println("=============================");
		System.out.println("비트 도서대여점");
		while (true) {
			System.out.println("=============================");
			System.out.println("1.대여 2.반납 3.출력 4.종료");
			System.out.print("> ");
			int choice = scanner.nextInt();
			scanner.nextLine();

			if (choice == 1) {
				rentBook();
			} else if (choice == 2) {
				returnBook();
			} else if (choice == 3) {
				printList();
			} else if (choice == 4) {
				System.out.println("사용해주셔서 감사합니다.");
				break;
			} else {
				System.out.println("잘못 입력하셨습니다.");
			}
		}
	}
	private void printList() {
		System.out.println("출력할 목록을 선택해주세요.");
		System.out.println("1.대여 가능 2.반납 가능 3.모든 도서");
		System.out.print("> ");
		int choice = scanner.nextInt();
		java.util.List<BookVO> selectedList = null;
		if(choice == 1) {
			selectedList = bookController.selectInventory();
		} else if(choice == 2) {
			selectedList = bookController.selectRent();
		} else if(choice == 3) {
			selectedList = bookController.selectAll();
		} else {
			System.out.println("잘못 입력하셨습니다.");
		}
		
		if(selectedList != null) {
			System.out.println("=============================");
			for(BookVO book : selectedList) {
				System.out.println(book);
			}
		}
	}

	private void returnBook() {
		if (bookController.isRentEmpty()) {
			System.out.println("반납 가능한 도서가 없습니다.");
			return;
		} 
		System.out.println("=====반납 가능 도서 목록=====");
		for (BookVO book : bookController.selectRent()) {
			System.out.println(book);
		}
		System.out.println("=============================");
		System.out.println("반납할 도서의 식별번호를 입력해주세요.");
		System.out.print("> ");
		int id = scanner.nextInt();
		BookVO book = new BookVO();
		book.setId(id);
		while (!bookController.validateReturn(book)) {
			System.out.println("잘못 선택하셨습니다.");
			System.out.println("반납할 도서의 식별번호를 입력해주세요.");
			System.out.print("> ");
			id = scanner.nextInt();
			book.setId(id);
		}

		bookController.returnBook(book);
		

	}

	private void rentBook() {
		if (bookController.isInventoryEmpty()) {
			System.out.println("대여 가능한 도서가 없습니다.");
			return;
		}
		System.out.println("=====대여 가능 도서 목록=====");
		for (BookVO book : bookController.selectInventory()) {
			System.out.println(book);
		}
		System.out.println("=============================");
		System.out.println("대여할 도서의 식별번호를 입력해주세요.");
		System.out.print("> ");
		int id = scanner.nextInt();
		BookVO book = new BookVO();
		book.setId(id);
		while (!bookController.validateRent(book)) {
			System.out.println("잘못 선택하셨습니다.");
			System.out.println("대여할 도서의 식별번호를 입력해주세요.");
			System.out.print("> ");
			id = scanner.nextInt();
			book.setId(id);
		}

		bookController.rentBook(book);
		

	}
}

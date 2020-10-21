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
		book.setTitle("JAVA�� ����");
		book.setAuthor("���ü�");
		book.setPrice(10000);
		inventory.add(book);

		book = new BookVO();
		book.setId(2);
		book.setTitle("������ũ");
		book.setAuthor("�赢ũ");
		book.setPrice(3000);
		inventory.add(book);

		book = new BookVO();
		book.setId(3);
		book.setTitle("��Ž�� �ڳ�");
		book.setAuthor("���ڳ�");
		book.setPrice(2000);
		inventory.add(book);

		book = new BookVO();
		book.setId(4);
		book.setTitle("�ҳ�Ž�� ������");
		book.setAuthor("������");
		book.setPrice(7000);
		inventory.add(book);

		java.util.ArrayList<BookVO> rent = new java.util.ArrayList<>();
		bookController = new BookController(inventory, rent);
		showMenu();
	}

	private void showMenu() {
		System.out.println("=============================");
		System.out.println("��Ʈ �����뿩��");
		while (true) {
			System.out.println("=============================");
			System.out.println("1.�뿩 2.�ݳ� 3.��� 4.����");
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
				System.out.println("������ּż� �����մϴ�.");
				break;
			} else {
				System.out.println("�߸� �Է��ϼ̽��ϴ�.");
			}
		}
	}
	private void printList() {
		System.out.println("����� ����� �������ּ���.");
		System.out.println("1.�뿩 ���� 2.�ݳ� ���� 3.��� ����");
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
			System.out.println("�߸� �Է��ϼ̽��ϴ�.");
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
			System.out.println("�ݳ� ������ ������ �����ϴ�.");
			return;
		} 
		System.out.println("=====�ݳ� ���� ���� ���=====");
		for (BookVO book : bookController.selectRent()) {
			System.out.println(book);
		}
		System.out.println("=============================");
		System.out.println("�ݳ��� ������ �ĺ���ȣ�� �Է����ּ���.");
		System.out.print("> ");
		int id = scanner.nextInt();
		BookVO book = new BookVO();
		book.setId(id);
		while (!bookController.validateReturn(book)) {
			System.out.println("�߸� �����ϼ̽��ϴ�.");
			System.out.println("�ݳ��� ������ �ĺ���ȣ�� �Է����ּ���.");
			System.out.print("> ");
			id = scanner.nextInt();
			book.setId(id);
		}

		bookController.returnBook(book);
		

	}

	private void rentBook() {
		if (bookController.isInventoryEmpty()) {
			System.out.println("�뿩 ������ ������ �����ϴ�.");
			return;
		}
		System.out.println("=====�뿩 ���� ���� ���=====");
		for (BookVO book : bookController.selectInventory()) {
			System.out.println(book);
		}
		System.out.println("=============================");
		System.out.println("�뿩�� ������ �ĺ���ȣ�� �Է����ּ���.");
		System.out.print("> ");
		int id = scanner.nextInt();
		BookVO book = new BookVO();
		book.setId(id);
		while (!bookController.validateRent(book)) {
			System.out.println("�߸� �����ϼ̽��ϴ�.");
			System.out.println("�뿩�� ������ �ĺ���ȣ�� �Է����ּ���.");
			System.out.print("> ");
			id = scanner.nextInt();
			book.setId(id);
		}

		bookController.rentBook(book);
		

	}
}

package com.bit.day18;

public class BookController {
	private java.util.List<BookVO> inventoryList;
	private java.util.List<BookVO> rentList;

	public BookController(java.util.List<BookVO> inventoryList,
			java.util.List<BookVO> rentList) {
		this.inventoryList = inventoryList;
		this.rentList = rentList;
	}

	public BookVO retrieveBook(java.util.List<BookVO> list, BookVO book) {
		int index = list.indexOf(book);
		return list.get(index);
	}

	public void rentBook(BookVO book) {
		rentList.add(retrieveBook(inventoryList, book));
		inventoryList.remove(book);
	}

	public void returnBook(BookVO book) {
		inventoryList.add(retrieveBook(rentList, book));
		rentList.remove(book);
	}

	public boolean validateRent(BookVO book) {
		return inventoryList.contains(book);
	}

	public boolean validateReturn(BookVO book) {
		return rentList.contains(book);
	}

	public java.util.List<BookVO> selectAll() {
		java.util.List<BookVO> list = new java.util.ArrayList<BookVO>();
		list.addAll(inventoryList);
		list.addAll(rentList);

		return list;
	}

	public java.util.List<BookVO> selectInventory() {
		return inventoryList;
	}

	public java.util.List<BookVO> selectRent() {
		return rentList;
	}

	public boolean isRentEmpty() {
		return rentList.size() == 0;
	}

	public boolean isInventoryEmpty() {
		return inventoryList.size() == 0;
	}

}

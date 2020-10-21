package com.bit.day18;

public class BookVO {
	private int id;
	private String title;
	private String author;
	private int price;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "BookVO [id=" + id + ", title=" + title + ", author=" + author
				+ ", price=" + price + "]";
	}

	public boolean equals(Object object) {
		if (object instanceof BookVO) {
			BookVO book = (BookVO) object;
			if (id == book.id) {
				return true;
			}
		}
		return false;
	}
}

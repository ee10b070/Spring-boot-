package com.memorytest.test;

public class BookService {
	
	private BookModel book;
	
	 public BookService(BookModel book) {
		super();
		this.book = book;
	}

	public BookModel getBook() {
		return book;
	}

	public void setBook(BookModel book) {
		this.book = book;
	}


}





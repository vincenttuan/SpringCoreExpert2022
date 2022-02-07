package com.spring.core.session07.tx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.spring.core.session07.tx.service.BookService;

@Controller
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	public void buyBook(String username, Integer bookId) {
		try {
			bookService.buyOne(username, bookId);
			System.out.println("Buy one book ok!");
		} catch (Exception e) {
			System.out.println("Buy one book error!");
			System.out.println(e);
		}
	}
	
	public void buyBooks(String username, Integer... bookIds) {
		try {
			bookService.buyMany(username, bookIds);
			System.out.println("Buy many books ok!");
		} catch (Exception e) {
			System.out.println("Buy many books error!");
			System.out.println(e);
		}
		
	}
}

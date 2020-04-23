package com.capgemini.librarymanagementsystem.dao;

import java.util.LinkedList;
import java.util.List;

import com.capgemini.librarymanagementsystem.dto.Book;
import com.capgemini.librarymanagementsystem.dto.Request;
import com.capgemini.librarymanagementsystem.dto.User;

public interface UserDAO {
	boolean registerUser(User user);
	User authUser(String email, String password);

	public Request bookRequest(User user, Book bookDetails);
	public Request bookReturn(User user, Book bookDetails);



	List<Book> searchBookBycategory (String bookCategory);
	LinkedList<Book> searchBookByTitle(String bookName);
	LinkedList<Book> searchBookByAuthor(String authorName);
	LinkedList<Book> getBooksInfo();


}

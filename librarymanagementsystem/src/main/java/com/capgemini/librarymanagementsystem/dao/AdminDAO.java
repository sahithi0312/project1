package com.capgemini.librarymanagementsystem.dao;

import java.util.LinkedList;
import java.util.List;

import com.capgemini.librarymanagementsystem.dto.Admin;
import com.capgemini.librarymanagementsystem.dto.Book;
import com.capgemini.librarymanagementsystem.dto.Request;
import com.capgemini.librarymanagementsystem.dto.User;

public interface AdminDAO {
	boolean registerAdmin(Admin admin);
	Admin authAdmin(String email, String password);
	boolean addBook(Book bookDetails);
	boolean removeBook(int bookId);
	boolean updateBook(int bookId);

	List<Book> searchBookBycategory (String bookCategory);
	LinkedList<Book> searchBookByTitle(String bookName);
	LinkedList<Book> searchBookByAuthor(String bookAuthor);

	LinkedList<Book> getBooksInfo();

	List<User> showUsers();
	List<Request> showRequests();
	boolean bookIssue(User user,Book bookDetails);
	boolean isBookReceived(User user,Book bookDetails);


}

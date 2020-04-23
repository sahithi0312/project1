package com.capgemini.librarymanagementsystem.service;

import java.util.LinkedList;
import java.util.List;

import com.capgemini.librarymanagementsystem.dao.AdminDAO;
import com.capgemini.librarymanagementsystem.dto.Admin;
import com.capgemini.librarymanagementsystem.dto.Book;
import com.capgemini.librarymanagementsystem.dto.Request;
import com.capgemini.librarymanagementsystem.dto.User;
import com.capgemini.librarymanagementsystem.factory.LibraryFactory;

public class AdminServiceImplement implements AdminService{
	
	private AdminDAO dao = LibraryFactory.getAdminDao();

	@Override
	public boolean registerAdmin(Admin admin) {
		// TODO Auto-generated method stub
		return dao.registerAdmin(admin);
	}

	@Override
	public Admin authAdmin(String email, String password) {
		// TODO Auto-generated method stub
		return dao.authAdmin(email, password);
	}

	@Override
	public boolean addBook(Book bookDetails) {
		// TODO Auto-generated method stub
		return dao.addBook(bookDetails);
	}

	@Override
	public boolean removeBook(int bookId) {
		// TODO Auto-generated method stub
		return dao.removeBook(bookId);
	}

	@Override
	public boolean updateBook(int bookId) {
		// TODO Auto-generated method stub
		return dao.updateBook(bookId);
	}

	@Override
	public List<Book> searchBookBycategory(String bookCategory) {
		// TODO Auto-generated method stub
		return dao.searchBookBycategory(bookCategory);
	}

	@Override
	public LinkedList<Book> searchBookByTitle(String bookName) {
		// TODO Auto-generated method stub
		return dao.searchBookByTitle(bookName);
	}

	@Override
	public LinkedList<Book> searchBookByAuthor(String bookAuthor) {
		// TODO Auto-generated method stub
		return dao.searchBookByAuthor(bookAuthor);
	}

	@Override
	public LinkedList<Book> getBooksInfo() {
		// TODO Auto-generated method stub
		return dao.getBooksInfo();
	}

	@Override
	public List<User> showUsers() {
		// TODO Auto-generated method stub
		return dao.showUsers();
	}

	@Override
	public List<Request> showRequests() {
		// TODO Auto-generated method stub
		return dao.showRequests();
	}

	@Override
	public boolean bookIssue(User user, Book bookDetails) {
		// TODO Auto-generated method stub
		return dao.bookIssue(user, bookDetails);
	}

	@Override
	public boolean isBookReceived(User user, Book bookDetails) {
		// TODO Auto-generated method stub
		return dao.isBookReceived(user, bookDetails);
	}

}

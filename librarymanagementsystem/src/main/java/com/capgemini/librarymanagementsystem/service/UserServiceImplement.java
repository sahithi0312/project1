package com.capgemini.librarymanagementsystem.service;

import java.util.LinkedList;
import java.util.List;

import com.capgemini.librarymanagementsystem.dao.UserDAO;
import com.capgemini.librarymanagementsystem.dto.Book;
import com.capgemini.librarymanagementsystem.dto.Request;
import com.capgemini.librarymanagementsystem.dto.User;
import com.capgemini.librarymanagementsystem.factory.LibraryFactory;

public class UserServiceImplement implements UserService{

	private UserDAO dao = LibraryFactory.getUserDao();

	@Override
	public boolean registerUser(User user) {
		// TODO Auto-generated method stub
		return dao.registerUser(user);
	}

	@Override
	public User authUser(String email, String password) {
		// TODO Auto-generated method stub
		return dao.authUser(email, password);
	}

	@Override
	public Request bookRequest(User user, Book bookDetails) {
		// TODO Auto-generated method stub
		return dao.bookRequest(user, bookDetails);
	}

	@Override
	public Request bookReturn(User user, Book bookDetails) {
		// TODO Auto-generated method stub
		return dao.bookReturn(user, bookDetails);
	}

	@Override
	public LinkedList<Book> searchBookByTitle(String bookName) {
		// TODO Auto-generated method stub
		return dao.searchBookByTitle(bookName);
	}

	@Override
	public LinkedList<Book> searchBookByAuthor(String authorName) {
		// TODO Auto-generated method stub
		return dao.searchBookByAuthor(authorName);
	}

	@Override
	public List<Book> searchBookBycategory(String bookCategory) {
		// TODO Auto-generated method stub
		return dao.searchBookBycategory(bookCategory);
	}

	@Override
	public LinkedList<Book> getBooksInfo() {
		// TODO Auto-generated method stub
		return dao.getBooksInfo();
	}

}

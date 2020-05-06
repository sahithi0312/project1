package com.capgemini.librarymanagementsystem_hibernate.service;

import java.util.List;

import com.capgemini.librarymanagementsystem_hibernate.dao.UsersDAO;
import com.capgemini.librarymanagementsystem_hibernate.dto.BookBean;
import com.capgemini.librarymanagementsystem_hibernate.dto.BookIssueBean;
import com.capgemini.librarymanagementsystem_hibernate.dto.BorrowedBooksBean;
import com.capgemini.librarymanagementsystem_hibernate.dto.RequestDetailsBean;
import com.capgemini.librarymanagementsystem_hibernate.dto.UsersBean;
import com.capgemini.librarymanagementsystem_hibernate.factory.LibraryFactory;

public class UsersServiceImplement implements UsersService{

	private UsersDAO dao = LibraryFactory.getUsersDao();

	@Override
	public boolean register(UsersBean user) {
		return dao.register(user);
	}

	@Override
	public UsersBean login(String email, String password) {
		return dao.login(email, password);
	}

	@Override
	public boolean addBook(BookBean book) {
		return dao.addBook(book);
	}

	@Override
	public boolean removeBook(int bId) {
		return dao.removeBook(bId);
	}

	@Override
	public boolean updateBook(BookBean book) {
		return dao.updateBook(book);
	}

	@Override
	public boolean issueBook(int bId, int uId) {
		return dao.issueBook(bId, uId);
	}

	@Override
	public boolean request(int uId, int bId) {
		return dao.request(uId, bId);
	}

	@Override
	public List<BorrowedBooksBean> borrowedBook(int uId) {
		return dao.borrowedBook(uId);
	}

	@Override
	public List<BookBean> searchBookById(int bId) {
		return dao.searchBookById(bId);
	}

	@Override
	public List<BookBean> searchBookByTitle(String bookName) {
		return dao.searchBookByTitle(bookName);
	}

	@Override
	public List<BookBean> searchBookByAuthor(String author) {
		return dao.searchBookByAuthor(author);
	}

	@Override
	public List<BookBean> getBooksInfo() {
		return dao.getBooksInfo();
	}

	@Override
	public boolean returnBook(int bId, int uId, String status) {
		return dao.returnBook(bId, uId, status);
	}

	@Override
	public List<Integer> bookHistoryDetails(int uId) {
		return dao.bookHistoryDetails(uId);
	}

	@Override
	public List<RequestDetailsBean> showRequests() {
		return dao.showRequests();
	}

	@Override
	public List<BookIssueBean> showIssuedBooks() {
		return dao.showIssuedBooks();
	}

	@Override
	public List<UsersBean> showUsers() {
		return dao.showUsers();
	}

	@Override
	public boolean updatePassword(int id, String password, String newPassword, String role) {
		return dao.updatePassword(id, password, newPassword, role);
	}
	
}

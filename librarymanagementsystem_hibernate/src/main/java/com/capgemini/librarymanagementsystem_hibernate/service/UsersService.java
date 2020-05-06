package com.capgemini.librarymanagementsystem_hibernate.service;

import java.util.List;

import com.capgemini.librarymanagementsystem_hibernate.dto.BookBean;
import com.capgemini.librarymanagementsystem_hibernate.dto.BookIssueBean;
import com.capgemini.librarymanagementsystem_hibernate.dto.BorrowedBooksBean;
import com.capgemini.librarymanagementsystem_hibernate.dto.RequestDetailsBean;
import com.capgemini.librarymanagementsystem_hibernate.dto.UsersBean;

public interface UsersService {
	boolean register(UsersBean user);
	UsersBean login(String email,String password);
	boolean addBook(BookBean book);
	boolean removeBook(int bId);
	boolean updateBook(BookBean book);
	boolean issueBook(int bId,int uId);
	boolean request(int uId, int bId);
	List<BorrowedBooksBean> borrowedBook(int uId);
	List<BookBean> searchBookById(int bId);
	List<BookBean> searchBookByTitle(String bookName);
	List<BookBean> searchBookByAuthor(String author);
	List<BookBean> getBooksInfo();
	boolean returnBook(int bId,int uId,String status);
	List<Integer> bookHistoryDetails(int uId);
	List<RequestDetailsBean> showRequests();
	List<BookIssueBean> showIssuedBooks();
	List<UsersBean> showUsers();
	boolean updatePassword(int id,String password,String newPassword,String role);

}

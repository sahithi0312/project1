package com.capgemini.librarymanagementsystem.dao;

import java.util.LinkedList;
import java.util.List;

import com.capgemini.librarymanagementsystem.database.LibraryDB;
import com.capgemini.librarymanagementsystem.dto.Book;
import com.capgemini.librarymanagementsystem.dto.Request;
import com.capgemini.librarymanagementsystem.dto.User;
import com.capgemini.librarymanagementsystem.exception.LMSException;

public class UserDAOImplement implements UserDAO{

	@Override
	public boolean registerUser(User user) {


			for(User u : LibraryDB.users) {
				if(u.getEmail().equals(user.getEmail())) {
					return false;
				}
			}
			LibraryDB.users.add(user);
			return true;
	}

	@Override
	public User authUser(String email, String password) {

		for(User user : LibraryDB.users) {
			if(user.getEmail().equals(email) && user.getPassword().equals(password)) {
				return user;
			}
		}
		throw new LMSException("Invalid Credentials");

	}

	@Override
	public Request bookRequest(User user, Book bookDetails) {

		boolean flag = false, 
				isRequestExists = false;
		Request requestInfo = new Request();
		User userInfo2 = new User();
		Book bookInfo2 = new Book();

		for (Request requestInfo2 : LibraryDB.REQUEST) {
			if (bookDetails.getBookId() == requestInfo2.getBookDetails().getBookId()) {
				isRequestExists = true;

			}

		}

		//check whether it is bookid or user id
		if (!isRequestExists) {
			for (User userBean : LibraryDB.users) {
				if (user.getUserId() == userBean.getUserId()) {
					for (Book book1 : LibraryDB.bookDetails) {
						if (book1.getBookId() == book1.getBookId()) {
							userInfo2 = userBean;
							bookInfo2 = book1;
							flag = true;
						}
					}
				}
			}
			if (flag == true) {
				requestInfo.setBookDetails(bookInfo2);
				requestInfo.setUserInfo(userInfo2);;
				LibraryDB.REQUEST.add(requestInfo);
				return requestInfo;
			}

		}

		throw new LMSException("Invalid request or you cannot request that book");

	}

	@Override
	public Request bookReturn(User user, Book bookDetails) {


		for (Request requestInfo : LibraryDB.REQUEST) {

			if (requestInfo.getBookDetails().getBookId() == bookDetails.getBookId() &&
					requestInfo.getUserInfo().getUserId() == user.getUserId() &&
					requestInfo.isIssued() == true) {


				System.out.println("Returning Issued book only");
				requestInfo.setReturned(true);


				return requestInfo;
			}

		}

		throw new  LMSException("Invalid return ");
	}



	@Override
	public List<Book> searchBookBycategory(String bookCategory) {


			LinkedList<Book> searchList=new LinkedList<Book>();
			for(int i=0;i<=LibraryDB.bookDetails.size()-1;i++)
			{
				Book retrievedBook=LibraryDB.bookDetails.get(i);
				String retrievedCategory=retrievedBook.getBookCategory();
				if(bookCategory.equals(retrievedCategory))
				{
					searchList.add(retrievedBook);	
				}
			}
			if(searchList.size()==0)
			{
				throw new LMSException("Book not found");
			}
			else
			{
				return searchList;
			}	

	}

	@Override
	public LinkedList<Book> searchBookByTitle(String bookName) {


			LinkedList<Book> searchList=new LinkedList<Book>();
			for(int i=0;i<=LibraryDB.bookDetails.size()-1;i++)
			{
				Book retrievedBook=LibraryDB.bookDetails.get(i);
				String retrievedBookName=retrievedBook.getBookName();
				if(bookName.equals(retrievedBookName))
				{
					searchList.add(retrievedBook);	
					return searchList;
				}
			}
			if(searchList.size()==0)
			{
				throw new LMSException ("Book is not found");
			}
			else
			{
				return searchList;
			}

	}

	@Override
	public LinkedList<Book> searchBookByAuthor(String authorName) {

		LinkedList<Book> searchList=new LinkedList<Book>();
		for(int i=0;i<=LibraryDB.bookDetails.size()-1;i++)
		{
			Book retrievedBook=LibraryDB.bookDetails.get(i);
			String retrievedBookAuthor=retrievedBook.getAuthorName();
			if(authorName.equals(retrievedBookAuthor))
			{
				searchList.add(retrievedBook);	
			}
		}
		if(searchList.size()==0)
		{
			throw new LMSException ("Book is not found");
		}
		else
		{
			return searchList;
		}	

	}

	@Override
	public LinkedList<Book> getBooksInfo() {

		return LibraryDB.bookDetails;

	}


}

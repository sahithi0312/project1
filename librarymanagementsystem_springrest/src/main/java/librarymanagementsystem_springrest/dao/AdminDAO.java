package librarymanagementsystem_springrest.dao;

import java.util.List;

import librarymanagementsystem_springrest.dto.BookBean;
import librarymanagementsystem_springrest.dto.BookIssueBean;
import librarymanagementsystem_springrest.dto.RequestDetailsBean;
import librarymanagementsystem_springrest.dto.UsersBean;

public interface AdminDAO {
	boolean addBook(BookBean book);
	boolean removeBook(int bId);
	boolean updateBook(BookBean book);
	boolean issueBook(int bId,int uId);
	List<Integer> bookHistoryDetails(int uId);
	List<RequestDetailsBean> showRequests();
	List<BookIssueBean> showIssuedBooks();
	List<UsersBean> showUsers();
}

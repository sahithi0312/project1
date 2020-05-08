package librarymanagementsystem_springrest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import librarymanagementsystem_springrest.dao.AdminDAO;
import librarymanagementsystem_springrest.dto.BookBean;
import librarymanagementsystem_springrest.dto.BookIssueBean;
import librarymanagementsystem_springrest.dto.RequestDetailsBean;
import librarymanagementsystem_springrest.dto.UsersBean;

@Service
public class AdminServiceImplement implements AdminService{
	
	@Autowired
	private AdminDAO dao;

	@Override
	public boolean addBook(BookBean book) {
		// TODO Auto-generated method stub
		return dao.addBook(book);
	}

	@Override
	public boolean removeBook(int bId) {
		// TODO Auto-generated method stub
		return dao.removeBook(bId);
	}

	@Override
	public boolean updateBook(BookBean book) {
		// TODO Auto-generated method stub
		return dao.updateBook(book);
	}

	@Override
	public boolean issueBook(int bId, int uId) {
		// TODO Auto-generated method stub
		return dao.issueBook(bId, uId);
	}

	@Override
	public List<Integer> bookHistoryDetails(int uId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RequestDetailsBean> showRequests() {
		// TODO Auto-generated method stub
		return dao.showRequests();
	}

	@Override
	public List<BookIssueBean> showIssuedBooks() {
		// TODO Auto-generated method stub
		return dao.showIssuedBooks();
	}

	@Override
	public List<UsersBean> showUsers() {
		// TODO Auto-generated method stub
		return dao.showUsers();
	}

}

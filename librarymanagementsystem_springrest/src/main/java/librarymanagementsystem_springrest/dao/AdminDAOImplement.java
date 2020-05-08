package librarymanagementsystem_springrest.dao;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import librarymanagementsystem_springrest.dto.BookBean;
import librarymanagementsystem_springrest.dto.BookIssueBean;
import librarymanagementsystem_springrest.dto.BorrowedBooksBean;
import librarymanagementsystem_springrest.dto.RequestDetailsBean;
import librarymanagementsystem_springrest.dto.UsersBean;
import librarymanagementsystem_springrest.exception.LMSException;

@Repository
public class AdminDAOImplement implements AdminDAO{
	
	EntityManager manager = null;
	EntityTransaction transaction = null;
	int noOfBooks;

	@PersistenceUnit
	private EntityManagerFactory factory;

	@Override
	public boolean addBook(BookBean book) {
		try {
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			manager.persist(book);
			transaction.commit();
			return true;
		}catch (Exception e) {
			System.err.println(e.getMessage());
			return false;
		}
	}

	@Override
	public boolean removeBook(int bId) {
		try {
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			BookBean record = manager.find(BookBean.class,bId);
			manager.remove(record);
			transaction.commit();
			return true;
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return false;
		} 
	}

	@Override
	public boolean updateBook(BookBean book) {
		try{
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			BookBean record = manager.find(BookBean.class, book.getBId());
			record.setBookName(book.getBookName());
			transaction.commit();
			return true;
		}catch (Exception e) {
			System.err.println(e.getMessage());
			return false;
		}
	}

	@Override 
	public boolean issueBook(int bId, int uId) {
		try {
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			String jpql = "select b from BookBean b where b.bId=:bId";
			TypedQuery<BookBean> query = manager.createQuery(jpql,BookBean.class);
			query.setParameter("bId", bId);
			BookBean rs = query.getSingleResult();
			if(rs != null) {
				String jpql1 = "select r from RequestDetailsBean r where r.uId=:uId and r.bId=:bId";
				TypedQuery<RequestDetailsBean> query1 = manager.createQuery(jpql1,RequestDetailsBean.class);
				query1.setParameter("uId", uId);
				query1.setParameter("bId", bId);
				List<RequestDetailsBean> rs1 = query1.getResultList();
				if(!rs1.isEmpty() && rs1 != null) {
					transaction.begin();
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
					Calendar cal = Calendar.getInstance();
					String issueDate = sdf.format(cal.getTime());
					cal.add(Calendar.DAY_OF_MONTH, 7);
					String returnDate = sdf.format(cal.getTime());
					BookIssueBean issueBook = new BookIssueBean();
					issueBook.setUId(uId);
					issueBook.setBId(bId);
					issueBook.setIssueDate(java.sql.Date.valueOf(issueDate));
					issueBook.setReturnDate(java.sql.Date.valueOf(returnDate));
					manager.persist(issueBook);
					transaction.commit();
					if(!rs1.isEmpty() && rs1 != null) {
						transaction.begin();
						Query bookName = manager.createQuery("select b.bookName from BookBean b where b.bId=:bId");
						bookName.setParameter("bId", bId);
						List book = bookName.getResultList();
						BorrowedBooksBean borrowedBooks = new BorrowedBooksBean();
						borrowedBooks.setUId(uId);
						borrowedBooks.setBId(bId);
						borrowedBooks.setBookName(book.get(0).toString());
						manager.persist(borrowedBooks);
						transaction.commit();
						return true;
					}else {
						throw new LMSException("Book Not issued");
					}
				}else {
					throw new LMSException("The respective user have not placed any request");
				}
			}else {
				throw new LMSException("There is no book exist with bookId"+bId);
			}
		}catch (Exception e) {
			System.err.println(e.getMessage());
			return false;
		}
	}



	@Override
	public List<Integer> bookHistoryDetails(int uId) {
		int count=0;
		manager = factory.createEntityManager();
		String jpql = "select b from BookIssueBean b";
		TypedQuery<BookIssueBean> query = manager.createQuery(jpql,BookIssueBean.class);
		List<BookIssueBean> recordList = query.getResultList();
		for(BookIssueBean p : recordList) {
			noOfBooks = count++;
		}
		LinkedList<Integer> list = new LinkedList<Integer>();
		list.add(noOfBooks);
		factory.close();
		return list;
	}
	
	@Override
	public List<RequestDetailsBean> showRequests() {
		manager = factory.createEntityManager();
		String jpql = "select r from RequestDetailsBean r";
		TypedQuery<RequestDetailsBean> query = manager.createQuery(jpql,RequestDetailsBean.class);
		List<RequestDetailsBean> recordList = query.getResultList();
		factory.close();
		return recordList;
	}

	@Override
	public List<BookIssueBean> showIssuedBooks() {
		manager = factory.createEntityManager();
		String jpql = "select b from BookIssueBean b";
		TypedQuery<BookIssueBean> query = manager.createQuery(jpql,BookIssueBean.class);
		List<BookIssueBean> recordList = query.getResultList();
		factory.close();
		return recordList;
	}

	@Override
	public List<UsersBean> showUsers() {
		manager = factory.createEntityManager();
		String jpql = "select u from UsersBean u";
		TypedQuery<UsersBean> query = manager.createQuery(jpql,UsersBean.class);
		List<UsersBean> recordList = query.getResultList();
		factory.close();
		return recordList;
	}


}

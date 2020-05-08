package librarymanagementsystem_springrest.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import librarymanagementsystem_springrest.dto.BookBean;
import librarymanagementsystem_springrest.dto.UsersBean;
import librarymanagementsystem_springrest.exception.LMSException;

@Repository
public class UsersDAOImplement implements UsersDAO{

	EntityManager manager = null;
	EntityTransaction transaction = null;
	int noOfBooks;

	@PersistenceUnit
	private EntityManagerFactory factory;

	@Override
	public boolean register(UsersBean user) {
		try {
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			manager.persist(user);
			transaction.commit();
			return true;
		}catch (Exception e) {
			System.err.println(e.getMessage());
			return false;
		}
	}

	@Override 
	public UsersBean login(String email, String password) {
		try {
			manager = factory.createEntityManager();
			String jpql="select u from UsersBean u where u.email=:email and u.password=:password";
			TypedQuery<UsersBean> query = manager.createQuery(jpql,UsersBean.class);
			query.setParameter("email", email);
			query.setParameter("password", password);
			UsersBean bean = query.getSingleResult();
			return bean;
		}catch(Exception e){
			System.err.println(e.getMessage());
			return null;
		}
	}


	@Override
	public List<BookBean> searchBookById(int bId) {
		try{
			manager = factory.createEntityManager();
			String jpql = "select b from BookBean b where b.bId=:bId";
			TypedQuery<BookBean> query = manager.createQuery(jpql,BookBean.class);
			query.setParameter("bId", bId);
			List<BookBean> recordList = query.getResultList();
			return recordList; 
		}catch (Exception e) {
			System.err.println(e.getMessage());
			return null;
		}
	}

	@Override
	public List<BookBean> searchBookByTitle(String bookName) {
		try{
			manager = factory.createEntityManager();
			String jpql = "select b from BookBean b where b.bookName=:bookName";
			TypedQuery<BookBean> query = manager.createQuery(jpql,BookBean.class);
			query.setParameter("bookName", bookName);
			List<BookBean> recordList = query.getResultList();
			return recordList; 
		}catch (Exception e) {
			System.err.println(e.getMessage());
			return null;
		}
	}

	@Override
	public List<BookBean> searchBookByAuthor(String author) {
		try{
			manager = factory.createEntityManager();
			String jpql = "select b from BookBean b where b.author=:author";
			TypedQuery<BookBean> query = manager.createQuery(jpql,BookBean.class);
			query.setParameter("author", author);
			List<BookBean> recordList = query.getResultList();
			return recordList; 
		}catch (Exception e) {
			System.err.println(e.getMessage());
			return null;
		}
	}

	@Override
	public List<BookBean> getBooksInfo() {
		manager = factory.createEntityManager();
		String jpql = "select b from BookBean b";
		TypedQuery<BookBean> query = manager.createQuery(jpql,BookBean.class);
		List<BookBean> recordList = query.getResultList();
		factory.close();
		return recordList;
	}


	@Override
	public boolean updatePassword(int id, String password, String newPassword, String role) {
		try{
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			String jpql = "select u from UsersBean u where u.uId=:uId and u.role=:role and u.password=:password";
			TypedQuery<UsersBean> query = manager.createQuery(jpql,UsersBean.class);
			query.setParameter("uId", id);
			query.setParameter("role", role);
			query.setParameter("password", password);
			UsersBean rs = query.getSingleResult();
			if(rs != null) {
				UsersBean record = manager.find(UsersBean.class,id);
				record.setPassword(newPassword);
				transaction.commit();
				return true;			
			}else {
				throw new LMSException("User doesnt exist");
			}

		} catch (Exception e) {
			System.err.println(e.getMessage());
			return false;
		} 
	}


}

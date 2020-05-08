package librarymanagementsystem_springrest.dao;

import java.util.List;

import librarymanagementsystem_springrest.dto.BorrowedBooksBean;

public interface StudentDAO {
	List<BorrowedBooksBean> borrowedBook(int uId);
	boolean request(int uId, int bId);
	boolean returnBook(int bId,int uId,String status);
}

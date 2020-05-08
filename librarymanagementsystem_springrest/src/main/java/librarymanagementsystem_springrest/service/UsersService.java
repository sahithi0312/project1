package librarymanagementsystem_springrest.service;

import java.util.List;

import librarymanagementsystem_springrest.dto.BookBean;
import librarymanagementsystem_springrest.dto.UsersBean;

public interface UsersService {
	boolean register(UsersBean user);
	UsersBean login(String email,String password);	
	List<BookBean> searchBookById(int bId);
	List<BookBean> searchBookByTitle(String bookName);
	List<BookBean> searchBookByAuthor(String author);
	List<BookBean> getBooksInfo();
	boolean updatePassword(int id,String password,String newPassword,String role);

}

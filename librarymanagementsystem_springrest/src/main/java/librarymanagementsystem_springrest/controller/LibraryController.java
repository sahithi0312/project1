package librarymanagementsystem_springrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import librarymanagementsystem_springrest.dto.BookBean;
import librarymanagementsystem_springrest.dto.BookIssueBean;
import librarymanagementsystem_springrest.dto.BorrowedBooksBean;
import librarymanagementsystem_springrest.dto.LmsResponse;
import librarymanagementsystem_springrest.dto.RequestDetailsBean;
import librarymanagementsystem_springrest.dto.UsersBean;
import librarymanagementsystem_springrest.service.AdminService;
import librarymanagementsystem_springrest.service.StudentService;
import librarymanagementsystem_springrest.service.UsersService;
@CrossOrigin(origins = "*")
@RestController
public class LibraryController {

	@Autowired
	private UsersService service;
	
	@Autowired
	private AdminService service1;
	
	@Autowired
	private StudentService service2;

	@PostMapping(path = "/addUser", 
			consumes= {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE},
			produces= {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public LmsResponse addUser(@RequestBody UsersBean user) {
		boolean isAdded = service.register(user);

		LmsResponse response = new LmsResponse();
		if(isAdded) {
			response.setMessage("Record is inserted Successfully");
		} else {
			response.setError(true);
			response.setMessage("Record is not inserted");
		}
		return response;
	}
	
	
	@PostMapping(path = "/login", 
			consumes= {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE},
			produces= {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public LmsResponse authentication(String email, String password) {
		UsersBean userLogin = service.login(email, password);
		LmsResponse response = new LmsResponse();
		if (userLogin != null) {
			response.setMessage("Login succesfull");
		} else {
			response.setError(true);
			response.setMessage("Invalid credentials,Please try again");
		}
		return response;
	}

	@PostMapping(path = "/addBook", 
			consumes= {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE},
			produces= {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public LmsResponse addBook(@RequestBody BookBean bean) {
		boolean isAdded = service1.addBook(bean);

		LmsResponse response = new LmsResponse();
		if(isAdded) {
			response.setMessage("Record is inserted Successfully");
		} else {
			response.setError(true);
			response.setMessage("Record is not inserted");
		}
		return response;	
	}

	@DeleteMapping(path="/deleteBook/{bId}",
			produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public LmsResponse removeBook(@PathVariable(name="bId") int bId ) {
		boolean isDeleted = service1.removeBook(bId);
		LmsResponse response = new LmsResponse();
		if(isDeleted) {
			response.setMessage("Record deleted");
		} else {
			response.setError(true);
			response.setMessage("Record not deleted");
		}
		return response;		
	}
	
	@PutMapping(path = "/updateBook",
			produces= {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE},
			consumes= {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public LmsResponse updateBook(@RequestBody BookBean bean) {
		boolean isUpdated = service1.updateBook(bean);
		LmsResponse response = new LmsResponse();
		if(isUpdated) {
			response.setMessage("Record is updated");
		} else {
			response.setError(true);
			response.setMessage("Record not updated");
		}
		return response;		
	}
	
	@GetMapping(path="/getBooksById",
			produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public LmsResponse getBooksById(int bId) {
		List<BookBean> recordList = service.searchBookById(bId);
		LmsResponse response = new LmsResponse();
		
		if(recordList != null && !recordList.isEmpty()) {
			response.setBooksInfo(recordList);
		} else {
			response.setError(true);
			response.setMessage("Book with given Id not present");
		}
		return response;
				
	}
	
	@GetMapping(path="/getBooksByTitle",
			produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public LmsResponse getBooksByTitle(String bookName) {
		List<BookBean> recordList = service.searchBookByTitle(bookName);
		LmsResponse response = new LmsResponse();
		
		if(recordList != null && !recordList.isEmpty()) {
			response.setBooksInfo(recordList);
		} else {
			response.setError(true);
			response.setMessage("Book with given Title not present");
		}
		return response;
				
	}
	
	@GetMapping(path="/getBooksByAuthor",
			produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public LmsResponse getBooksByAuthor(String author) {
		List<BookBean> recordList = service.searchBookByAuthor(author);
		LmsResponse response = new LmsResponse();
		
		if(recordList != null && !recordList.isEmpty()) {
			response.setBooksInfo(recordList);
		} else {
			response.setError(true);
			response.setMessage("Book with given Author not present");
		}
		return response;
				
	}
	
	@GetMapping(path="/getBooksInfo",
			produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public LmsResponse getBooksInfo() {
		List<BookBean> recordList = service.getBooksInfo();
		LmsResponse response = new LmsResponse();
		
		if(recordList != null && !recordList.isEmpty()) {
			response.setBooksInfo(recordList);
		} else {
			response.setError(true);
			response.setMessage("Book with given Author not present");
		}
		return response;
	}
	
	@GetMapping(path="/getBorrowedBooks",
			produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public LmsResponse getBorrowedBooks(int uId) {
		List<BorrowedBooksBean> recordList = service2.borrowedBook(uId);
		LmsResponse response = new LmsResponse();
		
		if(recordList != null && !recordList.isEmpty()) {
			response.setBorrowedBooks(recordList);
		} else {
			response.setError(true);
			response.setMessage("The respective user hasn't borrowed any books");
		}
		return response;
	}
	
	@GetMapping(path="/showRequests",
			produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public LmsResponse showRequests() {
		List<RequestDetailsBean> recordList = service1.showRequests();
		LmsResponse response = new LmsResponse();
		
		if(recordList != null && !recordList.isEmpty()) {
			response.setRequests(recordList);
		} else {
			response.setError(true);
			response.setMessage("No requests has been received");
		}
		return response;
	}
	
	@GetMapping(path="/showIssuedBooks",
			produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public LmsResponse showIssuedBooks() {
		List<BookIssueBean> recordList = service1.showIssuedBooks();
		LmsResponse response = new LmsResponse();
		
		if(recordList != null && !recordList.isEmpty()) {
			response.setIssueInfo(recordList);
		} else {
			response.setError(true);
			response.setMessage("No Books has been issued");
		}
		return response;
	}
	
	@GetMapping(path="/showUsers",
			produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public LmsResponse showUsers() {
		List<UsersBean> recordList = service1.showUsers();
		LmsResponse response = new LmsResponse();
		
		if(recordList != null && !recordList.isEmpty()) {
			response.setUsersInfo(recordList);
		} else {
			response.setError(true);
			response.setMessage("No Users in the database");
		}
		return response;
	}
	
	@PutMapping(path = "/updatePassword",
			produces= {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE},
			consumes= {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public LmsResponse updatePassord(int id, String password, String newPassword, String role) {
		boolean isUpdated = service.updatePassword(id, password, newPassword, role);
		LmsResponse response = new LmsResponse();
		
		if(isUpdated) {
			response.setMessage("Password is updated");
		} else {
			response.setError(true);
			response.setMessage("Password is not updated");
		}
		return response;	
	}
	
	@PostMapping(path = "/requestBook", 
			consumes= {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE},
			produces= {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public LmsResponse requestBook(int uId,int bId) {
		boolean isRequested = service2.request(uId, bId);

		LmsResponse response = new LmsResponse();
		if(isRequested) {
			response.setMessage("Request Placed");
		} else {
			response.setError(true);
			response.setMessage("Request not placed");
		}
		return response;
	}

	@PostMapping(path = "/issueBook", 
			consumes= {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE},
			produces= {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public LmsResponse issueBook(int uId,int bId) {
		boolean isIssued = service1.issueBook(bId, uId);

		LmsResponse response = new LmsResponse();
		if(isIssued) {
			response.setMessage("Book Issued");
		} else {
			response.setError(true);
			response.setMessage("Book not Issued");
		}
		return response;
	}
	
	
	@PostMapping(path="/returnBook",
			consumes= {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE},
			produces= {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public LmsResponse returnBook(int uId,int bId,String status ) {
		boolean isReturned = service2.returnBook(bId, uId, status);
		LmsResponse response = new LmsResponse();
		if(isReturned) {
			response.setMessage("Book Returned");
		} else {
			response.setError(true);
			response.setMessage("Book not returned");
		}
		return response;		
	}

}

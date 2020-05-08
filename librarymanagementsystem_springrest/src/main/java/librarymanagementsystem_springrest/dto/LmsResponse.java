package librarymanagementsystem_springrest.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LmsResponse {

	private boolean error;
	private String message;

	private BookBean bookInfo;
	private List<BookBean> booksInfo;
	
	private UsersBean userInfo;
	private List<UsersBean> usersInfo;

	private BookIssueBean bookIssueInfo;
	private List<BookIssueBean> issueInfo;
	
	private BorrowedBooksBean borrowedBooksInfo;
	private List<BorrowedBooksBean> borrowedBooks;
	
	private RequestDetailsBean requestInfo;
	private List<RequestDetailsBean> requests;
}

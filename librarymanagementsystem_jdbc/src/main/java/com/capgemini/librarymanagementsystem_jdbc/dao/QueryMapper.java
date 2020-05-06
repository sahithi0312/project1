package com.capgemini.librarymanagementsystem_jdbc.dao;

public interface QueryMapper {

	String registerQuery="insert into users values(?,?,?,?,?,?,?)";
	String loginQuery="select * from users where email=? and password=?";
	String addBookQuery="insert into bookbean values(?,?,?,?,?)";
	String removeBookQuery="delete from bookbean where bid=?";
	String updateBookQuery="update bookbean set bookname=? where bid=?";

	String issueBookQuery1="select * from bookbean where bid=?";
	String issueBookQuery2="select * from request_details where uid=? and bid=? and email=(select email from users where uid=?) ";
	String issueBookQuery3="insert into book_issue_details values(?,?,?,?)";
	String issueBookQuery4="insert into borrowed_books values(?,?,(select email from users where uid=?))";

	String requestBookQuery1="select * from bookbean where bid=?";
	String requestBookQuery2="select count(*) as uid from borrowed_books where uid=? and bid=? and email=(select email from users where uid=?)";
	String requestBookQuery3="select count(*) as uid from book_issue_details where uid=?";
	String requestBookQuery4="insert into request_details values(?,(select concat(firstname,'_',lastname) from users where uid=?),?,(select bookname from bookbean where bid=?),(select email from users where uid=?))";

	String searchBookByTitle="select * from bookbean where bookname=?";
	String searchBookByAuthor="select * from bookbean where author=?";
	String getBooksInfoQuery="select * from bookbean";

	String returnBookQuery1="select * from bookbean where bid=?";
	String returnBookQuery2="select * from book_issue_details where bid=? and uid=?";
	String returnBookQuery3="delete from book_issue_details where bid=? and uid=?";
	String returnBookQuery4="delete from borrowed_books where bid=? and uid=?";
	String returnBookQuery5="delete from request_details where bid=? and uid=?";

	String bookHistoryDetailsQuery="select count(*) as uid from book_issue_details where uid=?";
	String borrowedBookQuery="select * from borrowed_books where uid=?";

	String searchBookByIdQuery="select * from bookbean where bid=?";
	String showRequestsQuery="select * from request_details";
	String showIssuedBooksQuery="select * from book_issue_details";
	String showUsersQuery="select * from users";

	String updatePasswordQuery1="select * from users where email=? and role=?";
	String updatePasswordQuery2="update users set password=? where email=? and password=?";

}


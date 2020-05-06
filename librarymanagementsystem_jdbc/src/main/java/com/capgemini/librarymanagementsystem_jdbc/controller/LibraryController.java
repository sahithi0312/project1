package com.capgemini.librarymanagementsystem_jdbc.controller;

import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import com.capgemini.librarymanagementsystem_jdbc.dto.BookBean;
import com.capgemini.librarymanagementsystem_jdbc.dto.BookIssueDetails;
import com.capgemini.librarymanagementsystem_jdbc.dto.BorrowedBooks;
import com.capgemini.librarymanagementsystem_jdbc.dto.RequestDetails;
import com.capgemini.librarymanagementsystem_jdbc.dto.UsersBean;
import com.capgemini.librarymanagementsystem_jdbc.exception.LMSException;
import com.capgemini.librarymanagementsystem_jdbc.factory.LibraryFactory;
import com.capgemini.librarymanagementsystem_jdbc.service.UsersService;
import com.capgemini.librarymanagementsystem_jdbc.validation.Validation;

public class LibraryController {
	public static void main(String[] args) {
		DummyController.doReg();
	}
	
}
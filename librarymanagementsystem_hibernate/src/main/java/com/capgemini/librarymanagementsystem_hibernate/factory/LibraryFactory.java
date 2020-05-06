package com.capgemini.librarymanagementsystem_hibernate.factory;

import com.capgemini.librarymanagementsystem_hibernate.dao.UsersDAO;
import com.capgemini.librarymanagementsystem_hibernate.dao.UsersDAOImplement;
import com.capgemini.librarymanagementsystem_hibernate.service.UsersService;
import com.capgemini.librarymanagementsystem_hibernate.service.UsersServiceImplement;

public class LibraryFactory {
	public static UsersDAO getUsersDao() {
		return new UsersDAOImplement();
	}
	public static UsersService getUsersService() {
		return new UsersServiceImplement();
	}
}

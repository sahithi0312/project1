package com.capgemini.librarymanagementsystem.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.capgemini.librarymanagementsystem.exception.LMSException;

public class Validation {

	public boolean validateId(int id) throws LMSException {
		String idRegEx = "[1-9]{1}[0-9]{4}" ;
		boolean result = false;
		if (Pattern.matches(idRegEx, String.valueOf(id))) {
			result = true;
		} else {
			throw new LMSException("Id should contains exactly 5 digits");
		}
		return result;
	}
	public boolean validateName(String name) throws LMSException {
		String nameRegEx = "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$" ;
		boolean result = false;
		Pattern pattern = Pattern.compile(nameRegEx);
		Matcher matcher = pattern.matcher(name);
		if (matcher.matches()) {
			result = true;
		} else {
			throw new LMSException("Name should  contains only Alphabates");
		}
		return result;
	}
	public boolean validateMobileNo(long mobileNo) throws LMSException {
		String mobileRegEx = "(0/91)?[6-9][0-9]{9}" ;
		boolean result = false;
		if (Pattern.matches(mobileRegEx, String.valueOf(mobileNo))) {
			result = true;
		} else {
			throw new LMSException("Mobile Number  will start with  6 or 9 and It should contains 10 numbers");
		}
		return result;
	}
	public boolean validateEmail(String email) throws LMSException {
		String emailRegEx = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$";
		boolean result = false;
		Pattern pattern = Pattern.compile(emailRegEx);
		Matcher matcher = pattern.matcher(email);
		if (matcher.matches()) {
			result = true;
		} else {
			throw new LMSException("Enter proper email ");
		}
		return result;
	}
	public boolean validatePassword(String password) throws LMSException {
		String passwordRegEx = "((?=.\\d)(?=.[a-z])(?=.[A-Z])(?=.[@#$%]).{6,10})" ;
		boolean result = false;
		if (Pattern.matches(passwordRegEx, String.valueOf(password))) { 
			result = true;
		} 

		/*
		 * else { throw new
		 * LMSException("Password should contain atleast 8 characters ,one uppercase,one lowercase,one symbol"
		 * ); }
		 */

		return result;
	}

}

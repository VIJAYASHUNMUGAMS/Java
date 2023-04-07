package com.pkg.exception;

public class UserNotFoundException extends Exception {
	public UserNotFoundException() {
		System.out.println("U S E R  N O T  F O U N D");
	}
	
	public String toString()
	{
		return "UserNotFoundException";
	}
}
package com.pkg.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.pkg.exception.UserNotFoundException;
import java.util.function.BiPredicate;

public class AuthController {
	public boolean ValidateUser() throws IOException {
		try {
			String uname;
			String pwd;
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr);
			System.out.println("Enter User ID:");
			uname = br.readLine();
			System.out.println("Enter Password:");
			pwd = br.readLine();

			//Predefined functional interface - BiPredicate
			BiPredicate<String, String> res = (un, pw) -> un.equals("vijay") && pw.equals("pass");			
			if (res.test(uname, pwd)) {
				System.out.println("Welcome " + uname.toUpperCase() + " (Validated via BiPredicate) ");
				return true;
			} else {
				throw new UserNotFoundException();
			}
			
			/*if (uname.equals("vijay") && pwd.equals("pass")) {
				System.out.println("Welcome " + uname.toUpperCase());
				return true;
			} else {
				throw new UserNotFoundException();
			}*/						
		} catch (UserNotFoundException err) {
			System.out.println(err);
		}
		return false;
	}
}

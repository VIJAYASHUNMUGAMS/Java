package com.pkg.view;

import java.io.IOException;
import java.util.Scanner;

import com.pkg.controller.AuthController;
import com.pkg.controller.PatientController;

public class MainClass {

	static {
		String s = "  **Message from static block**  ";
		System.out.println(s.trim());
	}

	public static void main(String[] args) throws IOException {
		AuthController objAuth = new AuthController();
		if (objAuth.ValidateUser()) {

			PatientController objPC = new PatientController();
			Scanner sc = new Scanner(System.in);
			String sToContinue = "Y";
			do {
				System.out.println("Enter your choice \n 1: Add Patient\n 2: View Patient\n 3: Serialize Patient Data\n 4: DeSerialise Patient Data");
				System.out.println(" 5: Sort by Patient ID\n 6: Sort by Patient Name");

				int choice = sc.nextInt();
				switch (choice) {
					case 1: {
						objPC.AddPatient();
						break;
					}
					case 2: {
						objPC.ViewPatient();
						break;
					}
					case 3: {
						objPC.Serialize();
						break;
					}
					case 4: {
						objPC.DeSerialize();
						break;
					}
					case 5: {
						objPC.SortById();
						break;
					}
					case 6: {
						objPC.SortyByName();
						break;
					}
				}
				System.out.println("Do you wish to continue Y or y");
				sToContinue = sc.next();
			} while (sToContinue.equals("Y") || sToContinue.equals("y"));

			sc.close();
			System.out.println("Exited");
			System.exit(0);
		}
	}
}

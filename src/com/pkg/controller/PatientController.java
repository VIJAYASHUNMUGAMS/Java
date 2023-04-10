package com.pkg.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import com.pkg.model.Patient;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.*;

public class PatientController implements PatientInterface {

	Patient objPatient;
	List<Patient> lstPatient = new ArrayList<Patient>();
	
	public void AddPatient() {

		objPatient = new Patient();
		// User Input - Id
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter patient id");
		int patientid = sc.nextInt();
		objPatient.setId(patientid);

		// User Input - Name
		System.out.println("Enter patient name");
		String name = sc.next();
		objPatient.setSurname(name);
		// sc.close();

		lstPatient.add(objPatient);
	}

	public void ViewPatient() {
		System.out.println(lstPatient);
		lstPatient.forEach(System.out :: println);
	}

	public List<Patient> GetPatient() {
		return (ArrayList<Patient>) lstPatient;
	}

	public void Serialize() {
		try {
			FileOutputStream fos = new FileOutputStream("dedalus.txt");
			ObjectOutputStream objOutput = new ObjectOutputStream(fos);

			objOutput.writeObject(GetPatient());
			System.out.println("Serialized to file dedalus.txt");
			objOutput.close();
			fos.close();
		} catch (Exception fnf) {
			System.out.println(fnf);
		}
	}

	public void DeSerialize() {
		try {
			FileInputStream fis = new FileInputStream("dedalus.txt");
			ObjectInputStream objInput = new ObjectInputStream(fis);

			ArrayList<Patient> arrPatInfo = (ArrayList<Patient>) objInput.readObject();
			System.out.println("DeSerialized from file dedalus.txt");
			System.out.println(arrPatInfo);
			objInput.close();
			fis.close();
		} catch (FileNotFoundException fnf) {
			System.out.println("No file");
		} catch (ClassNotFoundException cnf) {
			System.out.println("No Emp class");
		} catch (Exception fnf) {
			System.out.println(fnf);
		}
	}

	public void SortById() {
		Collections.sort(lstPatient);
		System.out.println("Sorted by Patient ID");
		System.out.println(lstPatient);
	}	
	
	public void SortyByName() {
		Collections.sort(lstPatient, Patient.NameComparator);
		System.out.println(lstPatient);
	}
}
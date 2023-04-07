package com.pkg.model;
import java.io.Serializable;
import java.util.Comparator;

//POJO Class - Plain Old Java Object
public class Patient implements Serializable,Comparable<Patient>{
	
	private int id;
	private String surname;
	
	public Patient()
	{}
	
	public Patient(int id,String surname)
	 {		 
		this.id =id;
		this.surname = surname;
	 }
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public String toString()
	{
		return "Patient ID : " + this.id + "\nPatient name : " + this.surname ;
	}
	
	public int compareTo(Patient patient) {
		return this.id - patient.id;
	}
	
	public static Comparator<Patient> NameComparator = new Comparator<Patient>() {		
		public int compare(Patient objPatient1, Patient objPatient2) {
			return objPatient1.getSurname().compareTo(objPatient2.getSurname());
		}	
	};
}

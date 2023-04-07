package com.pkg.inh;

class Patient {
	int patientid = 1;
	String patientname = "testname";
	String sRelationType = "";

	public Patient() {
		System.out.println("From Parent Constructor");
	}
	public Patient(String sRelationType) {
		this.sRelationType = sRelationType;
	}
	
	public Patient(int nPatientID) {
		this("Cousin"); // passed value to the same class
	}

	public String getPatientDetails() {
		return "From Parent Class\n" + patientid + "-" + patientname + "-" + this.sRelationType +"\n";
	}
}

class Relations extends Patient {

	public Relations() {
		super("Brother"); // to pass value from child to parent class.
		// this("Brother"); // to pass value to the same class.
	}

	public String getRelationDetails() {
		return "From Child Class \n" + patientid + "-" + patientname+"\n";
	}
}

public class InhMainClass {
	public static void main(String[] args) {
		Relations objRelation = new Relations();
		System.out.println(objRelation.getPatientDetails());
		System.out.println(objRelation.getRelationDetails());
		
		Patient objPatient = new Patient("Cousin");
		System.out.println(objPatient.getPatientDetails());
	}
}
package com.pkg.dao;

import com.pkg.model.Patient;

public interface IPatientDao {

	public void insertPatient(Patient patient);

	public void showPatient();

	public void deletePatient(int id);

	void updatePatient(Patient patient);
}
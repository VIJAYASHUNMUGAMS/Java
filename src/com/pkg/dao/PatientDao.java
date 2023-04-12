package com.pkg.dao;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.pkg.helper.MyDBConnection;
import com.pkg.model.Patient;

public class PatientDao implements IPatientDao {

	Connection con;
	PreparedStatement ps;
	Statement stmt;
	ResultSet rs;
	
	public void insertPatient(Patient patient)
	{
		try {
			con = MyDBConnection.getDbConnection();
			ps = con.prepareStatement("insert into Patients values (?,?)");
			
			ps.setInt(1,patient.getId());
			ps.setString(2, patient.getSurname());
			int noofrows = ps.executeUpdate();
			System.out.println(noofrows  + " got inserted... ");
		}
		catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	public void showPatient() {
		try {
			con = MyDBConnection.getDbConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery("select * from patients");
			while (rs.next()) {
				System.out.println(rs.getInt(1) + " -- " + rs.getString(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updatePatient(Patient patient) {
		try {
			con = MyDBConnection.getDbConnection();
			ps = con.prepareStatement("Update Patients set surname = ? where id =?");			
			ps.setString(1, patient.getSurname());
			ps.setInt(2,patient.getId());
			int noofrows = ps.executeUpdate();
			System.out.println(noofrows  + " got updated... ");
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public void deletePatient(int id) {
		try {
			con = MyDBConnection.getDbConnection();
			ps = con.prepareStatement("delete from patients where id = ?");
			ps.setInt(1, id);
			int noofrows = ps.executeUpdate();
			if (noofrows > 0) {
				System.out.println("Patient of ID : " + id + " deleted successfully.\nTotal Records Deleted : " + noofrows);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

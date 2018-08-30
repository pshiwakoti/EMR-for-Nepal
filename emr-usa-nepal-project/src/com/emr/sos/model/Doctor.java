/*
 * @AUTHOR: Prakash Shiwakoti
 */
package com.emr.sos.model;
import java.util.List;

public interface Doctor {

	    public enum Speciality {
	    	SURGEON, OPTHALMOLOGIST, OTO
	    }

	    public String getName();

	    public Speciality getSpeciality();

	    public List<Patient> getPatients();

	    public void addPatients(Patient patient);
	}


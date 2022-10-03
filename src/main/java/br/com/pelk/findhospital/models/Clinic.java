package br.com.pelk.findhospital.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

public class Clinic implements Serializable{
    private String specialization;
    private ArrayList<Doctor> listDoctors;
    private Schedule schedule;
    
    public Clinic() {
    	
    }
    public Clinic(String specialization, Doctor doctor, Schedule schedule) {
		super();
		this.specialization = specialization;
		this.listDoctors = new ArrayList<>(Arrays.asList(doctor));
		this.schedule = schedule;
    
	public Clinic(String specialization, ArrayList<Doctor> listDoctors, Schedule schedule) {
		super();
		this.specialization = specialization;
		this.listDoctors = listDoctors;
		this.schedule = schedule;
	}
	public String getSpecialization() {
		return specialization;
	}
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
	public ArrayList<Doctor> getListDoctors() {
		return listDoctors;
	}
	public void setListDoctors(ArrayList<Doctor> listDoctors) {
		this.listDoctors = listDoctors;
	}
	public Schedule getSchedule() {
		return schedule;
	}
	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}
    
    
    
}

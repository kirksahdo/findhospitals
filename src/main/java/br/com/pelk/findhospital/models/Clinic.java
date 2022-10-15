package br.com.pelk.findhospital.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

public class Clinic implements Serializable{
    private String id;
    private String specialization;
    private ArrayList<String> listDoctors;
    private Schedule schedule;
    
    public Clinic() {	
    }
    
    public Clinic(String id, String specialization, String doctor, Schedule schedule) {
        super();
        this.id = id;
        this.specialization = specialization;
        this.listDoctors = new ArrayList<>(Arrays.asList(doctor));
        this.schedule = schedule;
    }
    
    public Clinic(String id, String specialization, ArrayList<String> listDoctors, Schedule schedule) {
        super();
        this.id = id;
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
    
    public void addDoctor(String doctor) {
            this.listDoctors.add(doctor);
    }
    
    public void removeDoctor(String doctor) {
        if (this.listDoctors.contains(doctor)) {
            this.listDoctors.remove(doctor);
        }
    }
    
    public ArrayList<String> getListDoctors() {
        return listDoctors;
    }
    
    public void setListDoctors(ArrayList<String> listDoctors) {
        this.listDoctors = listDoctors;
    }
   
    
    public Schedule getSchedule() {
        return schedule;
    }
    
    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}

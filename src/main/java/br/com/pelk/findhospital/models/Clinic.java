package br.com.pelk.findhospital.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

public class Clinic implements Serializable{
    private String id;
    private String specialization;
    private ArrayList<String> listDoctors;
    private String scheduleId;
    
    public Clinic() {	
    }
    
    public Clinic(String id, String specialization, String doctor, String scheduleId) {
        super();
        this.id = id;
        this.specialization = specialization;
        this.listDoctors = new ArrayList<>(Arrays.asList(doctor));
        this.scheduleId = scheduleId;
    }
    
    public Clinic(String id, String specialization, ArrayList<String> listDoctors, String scheduleId) {
        super();
        this.id = id;
        this.specialization = specialization;
        this.listDoctors = listDoctors;
        this.scheduleId = scheduleId;
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

    public String getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(String scheduleId) {
        this.scheduleId = scheduleId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}

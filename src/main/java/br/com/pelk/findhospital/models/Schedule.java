package br.com.pelk.findhospital.models;

import java.util.ArrayList;

public class Schedule {
    private String id;
    private ArrayList<Appointment> appointments = new ArrayList<>();

    public Schedule(){
    }

    public Schedule(String id){
        this.id = id;
    }

    public void addAppointment(Appointment appointment) {
        this.appointments.add(appointment);
    }

    public void removeAppointment(Appointment appointment) {
        this.appointments.remove(appointment);
    }

    public void consultAppointment() {
        System.out.println("________________________");
        for(int i =0; i < appointments.size(); i++) {
            System.out.println(appointments.get(i).toString());
        }
        System.out.println("________________________");	
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ArrayList<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(ArrayList<Appointment> appointments) {
        this.appointments = appointments;
    }
	
        
}

package br.com.pelk.findhospital.models;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Calendar;

public class Schedule {
	private ArrayList<Appointment> appointments = new ArrayList<Appointment>();
	
	public Schedule(){
		this.appointments = new ArrayList<Appointment>();
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
	
}

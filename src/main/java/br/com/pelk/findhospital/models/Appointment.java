package br.com.pelk.findhospital.models;
import java.io.Serializable;
import java.util.Date;

public class Appointment implements Serializable{
	private User user;
	private Date apppointmentHour;
	private Date appointmentDate;
	private Doctor doctor;
	private Clinic clinic;
	
	public Appointment(User user, Date apppointmentHour, Date appointmentDate, Doctor doctor, Clinic clinic) {
		super();
		this.user = user;
		this.apppointmentHour = apppointmentHour;
		this.appointmentDate = appointmentDate;
		this.doctor = doctor;
		this.clinic = clinic;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Date getApppointmentHour() {
		return apppointmentHour;
	}
	public void setApppointmentHour(Date apppointmentHour) {
		this.apppointmentHour = apppointmentHour;
	}
	public Date getAppointmentDate() {
		return appointmentDate;
	}
	public void setAppointmentDate(Date appointmentDate) {
		this.appointmentDate = appointmentDate;
	}
	public Doctor getDoctor() {
		return doctor;
	}
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	public Clinic getClinic() {
		return clinic;
	}
	public void setClinic(Clinic clinic) {
		this.clinic = clinic;
	}
	
	
	
	
	
	

}

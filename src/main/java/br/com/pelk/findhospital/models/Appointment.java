package br.com.pelk.findhospital.models;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DateTimeException;
import java.time.LocalDateTime;


public class Appointment implements Serializable{
	private User user;
	private LocalDateTime appointmentDate;
	private Doctor doctor;
	private Clinic clinic;
	
	
	public Appointment(User user, int year, int month, int day, int hour, int minute, Doctor doctor, Clinic clinic) {
		super();
		this.user = user;
		try {
			this.appointmentDate = LocalDateTime.of(year, month, day, hour, minute);
		}catch (DateTimeException e) {
			e.printStackTrace();
		}
		this.doctor = doctor;
		this.clinic = clinic;
	}
	
	@Override
	public String toString() {
		return user.getId() + "/" + user.getName() + " " + user.getLastName() + "---" + clinic.getSpecialization() + "-" + doctor.getName() + "--- Data:" + appointmentDate;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	public LocalDateTime getAppointmentDate() {
		return appointmentDate;
	}

	public void setAppointmentDate(LocalDateTime appointmentDate) {
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

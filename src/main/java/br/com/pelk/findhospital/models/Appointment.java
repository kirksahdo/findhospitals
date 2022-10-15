package br.com.pelk.findhospital.models;
import br.com.pelk.findhospital.backend.services.ClinicService;
import br.com.pelk.findhospital.backend.services.DoctorService;
import br.com.pelk.findhospital.exceptions.ClinicNotFoundException;
import br.com.pelk.findhospital.exceptions.DoctorNotFoundException;
import java.io.Serializable;
import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Appointment implements Serializable{
	private User user;
	private LocalDateTime appointmentDate;
	private String doctor;
	private String clinic;
	
	
	public Appointment(User user, int year, int month, int day, int hour, int minute, String doctorId, String clinicId) {
            super();
            this.user = user;
            try {
                this.appointmentDate = LocalDateTime.of(year, month, day, hour, minute);
            }catch (DateTimeException e) {
                e.printStackTrace();
            }
            this.doctor = doctorId;
            this.clinic = clinicId;
	}
	
	@Override
	public String toString() {
            try {
                Clinic clinic = ClinicService.getClinic(this.clinic);
                Doctor doctor = DoctorService.getDoctor(this.doctor);
                return user.getId() + "/" + user.getName() + " " + user.getLastName() + "---" + clinic.getSpecialization() + "-" + doctor.getName() + "--- Data:" + appointmentDate;
            } catch (ClinicNotFoundException ex) {
                Logger.getLogger(Appointment.class.getName()).log(Level.SEVERE, null, ex);
            } catch (DoctorNotFoundException ex) {
                Logger.getLogger(Appointment.class.getName()).log(Level.SEVERE, null, ex);
            }
            return "";
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

	public String getDoctor() {
		return doctor;
	}
	public void setDoctor(String doctorId) {
		this.doctor = doctorId;
	}
	public String getClinic() {
		return clinic;
	}
	public void setClinic(String clinicId) {
		this.clinic = clinicId;
	}
	
	
	
	
	
	

}

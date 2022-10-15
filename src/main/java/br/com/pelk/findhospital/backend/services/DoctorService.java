package br.com.pelk.findhospital.backend.services;

import br.com.pelk.findhospital.backend.serialization.DoctorSerialization;
import br.com.pelk.findhospital.exceptions.DoctorNotFoundException;
import br.com.pelk.findhospital.models.Doctor;
import java.util.ArrayList;

public final class DoctorService {
    public static void createDoctor(Doctor doctor) {
        DoctorSerialization.writeFile(doctor);
    }
    
    public static Doctor getDoctor(String id) throws DoctorNotFoundException {
        ArrayList<Doctor> doctors = DoctorSerialization.readFile();
        for(Doctor u : doctors) { 
            if (u.getId().equalsIgnoreCase(id)) { 
                return u;
            }
        }
        throw new DoctorNotFoundException();
    }
    
    public static ArrayList<Doctor> getDoctors() {
        return DoctorSerialization.readFile();
    }
    
    public static void deleteDoctor(Doctor doctor) throws DoctorNotFoundException {
        ArrayList<Doctor> doctors = DoctorSerialization.readFile();
        
        for(Doctor u : doctors) { 
            if(u.getId().equalsIgnoreCase(doctor.getId())) { 
                doctors.remove(doctor);
                return;
            }
        }
        throw new DoctorNotFoundException();
    }
    
    public static void editDoctor(Doctor doctor) throws DoctorNotFoundException { 
        ArrayList<Doctor> doctors = DoctorSerialization.readFile();
        
        for(Doctor u : doctors) { 
            if(u.getId().equalsIgnoreCase(doctor.getId())) { 
                doctors.remove(u);
                doctors.add(doctor);
                DoctorSerialization.writeFile(doctors);
                return;
            }
        }
        throw new DoctorNotFoundException();
    }
}

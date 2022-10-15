package br.com.pelk.findhospital.backend.services;

import br.com.pelk.findhospital.backend.serialization.ClinicSerialization;
import br.com.pelk.findhospital.exceptions.ClinicNotFoundException;
import br.com.pelk.findhospital.models.Clinic;
import java.util.ArrayList;

public final class ClinicService {
    public static void createClinic(Clinic clinic) {
        ClinicSerialization.writeFile(clinic);
    }
    
    public static Clinic getClinic(String id) throws ClinicNotFoundException {
        Clinic clinic;
        ArrayList<Clinic> clinics = ClinicSerialization.readFile();
        for(Clinic u : clinics) { 
            if (u.getId().equalsIgnoreCase(id)) { 
                return u;
            }
        }
        throw new ClinicNotFoundException();
    }
    
    public static ArrayList<Clinic> getClinics() {
        return ClinicSerialization.readFile();
    }
    
    public static void deleteClinic(Clinic clinic) throws ClinicNotFoundException {
        ArrayList<Clinic> clinics = ClinicSerialization.readFile();
        
        for(Clinic u : clinics) { 
            if(u.getId().equalsIgnoreCase(clinic.getId())) { 
                clinics.remove(clinic);
                return;
            }
        }
        throw new ClinicNotFoundException();
    }
    
    public static void editClinic(Clinic clinic) throws ClinicNotFoundException { 
        ArrayList<Clinic> clinics = ClinicSerialization.readFile();
        
        for(Clinic u : clinics) { 
            if(u.getId().equalsIgnoreCase(clinic.getId())) { 
                clinics.remove(u);
                clinics.add(clinic);
                ClinicSerialization.writeFile(clinics);
                return;
            }
        }
        throw new ClinicNotFoundException();
    }
}

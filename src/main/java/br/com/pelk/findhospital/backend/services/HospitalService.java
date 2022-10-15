package br.com.pelk.findhospital.backend.services;

import br.com.pelk.findhospital.backend.serialization.HospitalSerialization;
import br.com.pelk.findhospital.exceptions.HospitalNotFoundException;
import br.com.pelk.findhospital.models.Hospital;
import java.util.ArrayList;

public final class HospitalService {
    public static void createHospital(Hospital hospital) {
        HospitalSerialization.writeFile(hospital);
    }
    
    public static Hospital getHospital(String id) throws HospitalNotFoundException {
        Hospital hospital;
        ArrayList<Hospital> hospitals = HospitalSerialization.readFile();
        for(Hospital u : hospitals) { 
            if (u.getId().equalsIgnoreCase(id)) { 
                return u;
            }
        }
        throw new HospitalNotFoundException();
    }
    
    public static Hospital getHospitalByClinicId(String id) throws HospitalNotFoundException {
        ArrayList<Hospital> hospitals = HospitalSerialization.readFile();
        for(Hospital u : hospitals) { 
            if (u.getClinics().contains(id)) { 
                return u;
            }
        }
        throw new HospitalNotFoundException();
    }
    
    public static void deleteHospital(Hospital hospital) throws HospitalNotFoundException {
        ArrayList<Hospital> hospitals = HospitalSerialization.readFile();
        
        for(Hospital u : hospitals) { 
            if(u.getId().equalsIgnoreCase(hospital.getId())) { 
                hospitals.remove(hospital);
                return;
            }
        }
        throw new HospitalNotFoundException();
    }
    
    public static void editHospital(Hospital hospital) throws HospitalNotFoundException { 
        ArrayList<Hospital> hospitals = HospitalSerialization.readFile();
        
        for(Hospital u : hospitals) { 
            if(u.getId().equalsIgnoreCase(hospital.getId())) { 
                hospitals.remove(u);
                hospitals.add(hospital);
                HospitalSerialization.writeFile(hospitals);
                return;
            }
        }
        throw new HospitalNotFoundException();
    }
}

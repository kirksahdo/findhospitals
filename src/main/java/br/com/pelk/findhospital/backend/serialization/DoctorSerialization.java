package br.com.pelk.findhospital.backend.serialization;

import br.com.pelk.findhospital.models.Doctor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class DoctorSerialization {

    
    private static final String PATH_FILE = "res/";
    private static final String FILE_NAME = PATH_FILE + "doctors.txt";
    
    public static ArrayList<Doctor> readFile() {
        ArrayList<Doctor> doctors = new ArrayList<>();
        try {
            ObjectInputStream objectInputStream;
            try (FileInputStream fileInputStream = new FileInputStream(FILE_NAME)) {
                objectInputStream = new ObjectInputStream(fileInputStream);
                Object object;
                object = objectInputStream.readObject();
                if(object != null) doctors = (ArrayList<Doctor>) object;
            }
            objectInputStream.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DoctorSerialization.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(DoctorSerialization.class.getName()).log(Level.SEVERE, null, ex);
        }
        return doctors;
    }
    
    public static void writeFile(Doctor clinic) {
        ArrayList<Doctor> doctors = readFile();
        if (doctors == null) {
            doctors = new ArrayList<>();
        }
        try {
            ObjectOutputStream objectOutputStream;
            try (FileOutputStream fileOutputStream = new FileOutputStream(FILE_NAME)) {
                objectOutputStream = new ObjectOutputStream(fileOutputStream);
                doctors.add(clinic);
                objectOutputStream.writeObject(doctors);
            }
            objectOutputStream.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DoctorSerialization.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DoctorSerialization.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void writeFile(ArrayList<Doctor> doctors) {
        try {
            ObjectOutputStream objectOutputStream;
            try (FileOutputStream fileOutputStream = new FileOutputStream(FILE_NAME)) {
                objectOutputStream = new ObjectOutputStream(fileOutputStream);
                objectOutputStream.writeObject(doctors);
            }
            objectOutputStream.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DoctorSerialization.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DoctorSerialization.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
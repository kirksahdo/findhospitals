package br.com.pelk.findhospital.backend.serialization;

import br.com.pelk.findhospital.models.Clinic;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class ClinicSerialization {

    
    private static final String PATH_FILE = "res/";
    private static final String FILE_NAME = PATH_FILE + "clinics.txt";
    
    public static ArrayList<Clinic> readFile() {
        ArrayList<Clinic> clinics = new ArrayList<>();
        try {
            ObjectInputStream objectInputStream;
            try (FileInputStream fileInputStream = new FileInputStream(FILE_NAME)) {
                objectInputStream = new ObjectInputStream(fileInputStream);
                Object object;
                object = objectInputStream.readObject();
                if(object != null) clinics = (ArrayList<Clinic>) object;
            }
            objectInputStream.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ClinicSerialization.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(ClinicSerialization.class.getName()).log(Level.SEVERE, null, ex);
        }
        return clinics;
    }
    
    public static void writeFile(Clinic clinic) {
        ArrayList<Clinic> clinics = readFile();
        if (clinics == null) {
            clinics = new ArrayList<>();
        }
        try {
            ObjectOutputStream objectOutputStream;
            try (FileOutputStream fileOutputStream = new FileOutputStream(FILE_NAME)) {
                objectOutputStream = new ObjectOutputStream(fileOutputStream);
                clinics.add(clinic);
                objectOutputStream.writeObject(clinics);
            }
            objectOutputStream.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ClinicSerialization.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ClinicSerialization.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void writeFile(ArrayList<Clinic> clinics) {
        try {
            ObjectOutputStream objectOutputStream;
            try (FileOutputStream fileOutputStream = new FileOutputStream(FILE_NAME)) {
                objectOutputStream = new ObjectOutputStream(fileOutputStream);
                objectOutputStream.writeObject(clinics);
            }
            objectOutputStream.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ClinicSerialization.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ClinicSerialization.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
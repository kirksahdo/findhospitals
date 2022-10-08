package br.com.pelk.findhospital.backend.serialization;

import br.com.pelk.findhospital.models.Hospital;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class HospitalSerialization {

    
    private static final String PATH_FILE = "res/";
    private static final String FILE_NAME = PATH_FILE + "hospitals.txt";
    
    public static ArrayList<Hospital> readFile() {
        ArrayList<Hospital> hospitals = new ArrayList<>();
        try {
            ObjectInputStream objectInputStream;
            try (FileInputStream fileInputStream = new FileInputStream(FILE_NAME)) {
                objectInputStream = new ObjectInputStream(fileInputStream);
                Object object;
                object = objectInputStream.readObject();
                if(object != null) hospitals = (ArrayList<Hospital>) object;
            }
            objectInputStream.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(HospitalSerialization.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(HospitalSerialization.class.getName()).log(Level.SEVERE, null, ex);
        }
        return hospitals;
    }
    
    public static void writeFile(Hospital hospital) {
        ArrayList<Hospital> hospitals = readFile();
        if (hospitals == null) {
            hospitals = new ArrayList<>();
        }
        try {
            ObjectOutputStream objectOutputStream;
            try (FileOutputStream fileOutputStream = new FileOutputStream(FILE_NAME)) {
                objectOutputStream = new ObjectOutputStream(fileOutputStream);
                hospitals.add(hospital);
                objectOutputStream.writeObject(hospitals);
            }
            objectOutputStream.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(HospitalSerialization.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(HospitalSerialization.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void writeFile(ArrayList<Hospital> hospitals) {
        try {
            ObjectOutputStream objectOutputStream;
            try (FileOutputStream fileOutputStream = new FileOutputStream(FILE_NAME)) {
                objectOutputStream = new ObjectOutputStream(fileOutputStream);
                objectOutputStream.writeObject(hospitals);
            }
            objectOutputStream.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(HospitalSerialization.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(HospitalSerialization.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
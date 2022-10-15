package br.com.pelk.findhospital.backend.serialization;

import br.com.pelk.findhospital.models.Schedule;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class ScheduleSerialization {

    
    private static final String PATH_FILE = "res/";
    private static final String FILE_NAME = PATH_FILE + "schedules.txt";
    
    public static ArrayList<Schedule> readFile() {
        ArrayList<Schedule> schedules = new ArrayList<>();
        try {
            ObjectInputStream objectInputStream;
            try (FileInputStream fileInputStream = new FileInputStream(FILE_NAME)) {
                objectInputStream = new ObjectInputStream(fileInputStream);
                Object object;
                object = objectInputStream.readObject();
                if(object != null) schedules = (ArrayList<Schedule>) object;
            }
            objectInputStream.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ScheduleSerialization.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(ScheduleSerialization.class.getName()).log(Level.SEVERE, null, ex);
        }
        return schedules;
    }
    
    public static void writeFile(Schedule schedule) {
        ArrayList<Schedule> schedules = readFile();
        if (schedules == null) {
            schedules = new ArrayList<>();
        }
        try {
            ObjectOutputStream objectOutputStream;
            try (FileOutputStream fileOutputStream = new FileOutputStream(FILE_NAME)) {
                objectOutputStream = new ObjectOutputStream(fileOutputStream);
                schedules.add(schedule);
                objectOutputStream.writeObject(schedules);
            }
            objectOutputStream.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ScheduleSerialization.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ScheduleSerialization.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void writeFile(ArrayList<Schedule> schedules) {
        try {
            ObjectOutputStream objectOutputStream;
            try (FileOutputStream fileOutputStream = new FileOutputStream(FILE_NAME)) {
                objectOutputStream = new ObjectOutputStream(fileOutputStream);
                objectOutputStream.writeObject(schedules);
            }
            objectOutputStream.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ScheduleSerialization.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ScheduleSerialization.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
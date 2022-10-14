package br.com.pelk.findhospital.backend.serialization;

import br.com.pelk.findhospital.models.User;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class UserSerialization {

    
    private static final String PATH_FILE = "res/";
    private static final String FILE_NAME = PATH_FILE + "users.txt";
    
    public static ArrayList<User> readFile() {
        ArrayList<User> users = new ArrayList<>();
        try {
            FileInputStream fileInputStream = new FileInputStream(FILE_NAME);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            Object object;
            object = objectInputStream.readObject();
            if(object != null) users = (ArrayList<User>) object;
            
            fileInputStream.close();
            objectInputStream.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(UserSerialization.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(UserSerialization.class.getName()).log(Level.SEVERE, null, ex);
        }
        return users;
    }
    
    public static void writeFile(User user) {
        ArrayList<User> users = readFile();
        if (users == null) {
            users = new ArrayList<>();
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(FILE_NAME);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            
            users.add(user);
            objectOutputStream.writeObject(users);
            fileOutputStream.close();
            objectOutputStream.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(UserSerialization.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(UserSerialization.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void writeFile(ArrayList<User> users) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(FILE_NAME);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(users);
            fileOutputStream.close();
            objectOutputStream.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(UserSerialization.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(UserSerialization.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
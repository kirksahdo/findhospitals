package br.com.pelk.findhospital.backend.services;

import br.com.pelk.findhospital.backend.serialization.UserSerialization;
import br.com.pelk.findhospital.exceptions.UserNotFoundException;
import br.com.pelk.findhospital.frames.LoginFrame;
import br.com.pelk.findhospital.models.User;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

public final class UserService {
    private static User user;
    
    public static void createUser(User user) {
        UserSerialization.writeFile(user);
    }
    
    public static User getUser(String id) throws UserNotFoundException {
        ArrayList<User> users = UserSerialization.readFile();
        for(User u : users) { 
            if (u.getId().equalsIgnoreCase(id)) { 
                return u;
            }
        }
        throw new UserNotFoundException();
    }
    
    public static User getUserByUsername(String username) throws UserNotFoundException {
        ArrayList<User> users = UserSerialization.readFile();
        for(User u : users) { 
            if (u.getUsername().equalsIgnoreCase(username)) { 
                return u;
            }
        }
        throw new UserNotFoundException();
    }
    
    public static void deleteUser(User user) throws UserNotFoundException {
        ArrayList<User> users = UserSerialization.readFile();
        
        for(User u : users) { 
            if(u.getId().equalsIgnoreCase(user.getId())) { 
                users.remove(user);
                return;
            }
        }
        throw new UserNotFoundException();
    }
    
    public static void editUser(User user) throws UserNotFoundException { 
        ArrayList<User> users = UserSerialization.readFile();
        
        for(User u : users) { 
            if(u.getId().equalsIgnoreCase(user.getId())) { 
                users.remove(u);
                users.add(user);
                UserSerialization.writeFile(users);
                return;
            }
        }
        throw new UserNotFoundException();
    }
    
    public static User getUser() {
        return user;
    }

    public static void setUser(User user) {
        UserService.user = user;
    }
    
    public static boolean login(String username, String password) {
        try {
            User user = UserService.getUserByUsername(username);
            if (! user.getPassword().equals(password)) {
                return false;
            }
            UserService.setUser(user);
            return true;
        } catch (UserNotFoundException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public static void logout(JFrame frame) {
        UserService.setUser(null);
        frame.setVisible(false);
        frame.dispose();
        LoginFrame loginFrame = new LoginFrame();
        loginFrame.setVisible(true);
    }
}

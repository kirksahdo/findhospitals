package br.com.pelk.findhospital.backend.services;

import br.com.pelk.findhospital.backend.serialization.UserSerialization;
import br.com.pelk.findhospital.exceptions.UserNotFoundException;
import br.com.pelk.findhospital.models.User;
import java.util.ArrayList;

public final class UserService {
    public static void createUser(User user) {
        UserSerialization.writeFile(user);
    }
    
    public static User getUser(String id) throws UserNotFoundException {
        User user;
        ArrayList<User> users = UserSerialization.readFile();
        for(User u : users) { 
            if (u.getId() == id) { 
                return u;
            }
        }
        throw new UserNotFoundException();
    }
    
    public static void deleteUser(User user) throws UserNotFoundException {
        ArrayList<User> users = UserSerialization.readFile();
        
        for(User u : users) { 
            if(u.getId() == user.getId()) { 
                users.remove(user);
                return;
            }
        }
        throw new UserNotFoundException();
    }
    
    public static void editUser(User user) throws UserNotFoundException { 
        ArrayList<User> users = UserSerialization.readFile();
        
        for(User u : users) { 
            if(u.getId() == user.getId()) { 
                users.remove(u);
                users.add(user);
                UserSerialization.writeFile(users);
                return;
            }
        }
        throw new UserNotFoundException();
    }
}

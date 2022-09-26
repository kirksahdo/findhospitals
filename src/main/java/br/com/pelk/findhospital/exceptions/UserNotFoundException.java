package br.com.pelk.findhospital.exceptions;

public class UserNotFoundException extends Exception{
    public UserNotFoundException() {
        super("User not found!");
    }
}

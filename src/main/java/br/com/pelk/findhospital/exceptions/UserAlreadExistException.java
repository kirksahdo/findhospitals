package br.com.pelk.findhospital.exceptions;

public class UserAlreadExistException extends Exception{
    public UserAlreadExistException() {
        super("User already exist!");
    }
}

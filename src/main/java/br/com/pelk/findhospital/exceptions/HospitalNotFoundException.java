package br.com.pelk.findhospital.exceptions;

public class HospitalNotFoundException extends Exception{
    public HospitalNotFoundException() {
        super("Hospital not found!");
    }
}

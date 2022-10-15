package br.com.pelk.findhospital.exceptions;

public class DoctorNotFoundException extends Exception{
    public DoctorNotFoundException() {
        super("Doctor not found!");
    }
}

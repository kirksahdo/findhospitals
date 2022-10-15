package br.com.pelk.findhospital.exceptions;

public class ClinicNotFoundException extends Exception{
    public ClinicNotFoundException() {
        super("Clinic not found!");
    }
}

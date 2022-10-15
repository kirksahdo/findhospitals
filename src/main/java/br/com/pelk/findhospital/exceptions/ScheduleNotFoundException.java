package br.com.pelk.findhospital.exceptions;

public class ScheduleNotFoundException extends Exception{
    public ScheduleNotFoundException() {
        super("Schedule not found!");
    }
}

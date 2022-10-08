package br.com.pelk.findhospital.models;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

public class Hospital implements Serializable{
    private String id;
    private String name;
    private Localization localization;
    private ArrayList<Clinic> clinics;
    
    public Hospital() {
    	
    }
    
    public Hospital(String id, String name, Localization localization, Clinic clinic) {
            super();
            this.name = name;
            this.localization = localization;
            this.clinics = new ArrayList<>(Arrays.asList(clinic));
    }
    
    public Hospital(String name, Localization localization, ArrayList<Clinic> clinics) {
            super();
            this.name = name;
            this.localization = localization;
            this.clinics = clinics;
    }

    public String getName() {
            return name;
    }

    public void setName(String name) {
            this.name = name;
    }

    public Localization getLocalization() {
            return localization;
    }

    public void setLocalization(Localization localization) {
            this.localization = localization;
    }

    public ArrayList<Clinic> getClinics() {
            return clinics;
    }

    public void setClinics(ArrayList<Clinic> clinics) {
            this.clinics = clinics;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
}

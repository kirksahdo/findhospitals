package br.com.pelk.findhospital.models;
import java.io.Serializable;
import java.util.ArrayList;

public class Hospital implements Serializable{
    private String id;
    private String name;
    private Localization localization;
    private ArrayList<String> clinics;
    
    public Hospital() {
    	
    }
    
    public Hospital(String id, String name, Localization localization) {
            super();
            this.id = id;
            this.name = name;
            this.localization = localization;
            this.clinics = new ArrayList<>();
    }
    
    public Hospital(String id, String name, Localization localization, ArrayList<String> clinics) {
            super();
            this.id = id;
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
    
    public void addClinic(String id) {
        this.clinics.add(id);
    }
    
    public void removeClinic(String id) {
        if (this.clinics.contains(id)) {
            this.clinics.remove(id);
        }
    }

    public ArrayList<String> getClinics() {
            return clinics;
    }

    public void setClinics(ArrayList<String> clinics) {
            this.clinics = clinics;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
}

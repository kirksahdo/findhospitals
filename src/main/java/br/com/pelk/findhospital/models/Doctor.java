
package br.com.pelk.findhospital.models;

import java.io.Serializable;

public class Doctor extends User implements Serializable{
    private String formation;
    
    public Doctor(String id, String name, String lastName, String email, String username, String password, String rg, String cpf, String adress, String cep, String phoneNumber, Localization localization, String formation) {
        super(id, name, lastName, email, username, password, rg, cpf, adress, cep, phoneNumber, localization);
        this.formation = formation;
    }

    public String getFormation() {
        return formation;
    }

    public void setFormation(String formation) {
        this.formation = formation;
    }
    
    public void completeConsultation(){
        
    }
    public void postponeConsultation(){
        
    }
}

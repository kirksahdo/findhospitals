package br.com.pelk.findhospital.models;

import java.io.Serializable;

public class Localization implements Serializable{
    private String road;
    private String district;
    private String number;
    private String cep;
    private String complement;
    
    public Localization() {
        
    }
    
    public Localization(String road, String district, String number, String cep) {
        this.road = road;
        this.district = district;
        this.number = number;
        this.cep = cep;
    }

    public Localization(String road, String district, String number, String cep, String complement) {
        this.road = road;
        this.district = district;
        this.number = number;
        this.cep = cep;
        this.complement = complement;
    }
    
    public String toStringLocalization() {
    	return road + " " + number + ", " + district + ". " + complement +
    			 cep;
    }

    public String getRoad() {
        return road;
    }

    public void setRoad(String road) {
        this.road = road;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }
    public String getLocalization(){
        return this.road;
        
    }

    @Override
    public String toString() {
        return road + ", " + district + " - N " + number + " - CEP: " +  cep;
    }
    
    
    
    
}

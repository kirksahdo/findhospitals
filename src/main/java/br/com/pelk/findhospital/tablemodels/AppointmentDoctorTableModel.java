package br.com.pelk.findhospital.tablemodels;

import br.com.pelk.findhospital.backend.services.ClinicService;
import br.com.pelk.findhospital.backend.services.HospitalService;
import br.com.pelk.findhospital.backend.services.UserService;
import br.com.pelk.findhospital.exceptions.ClinicNotFoundException;
import br.com.pelk.findhospital.exceptions.HospitalNotFoundException;
import br.com.pelk.findhospital.exceptions.UserNotFoundException;
import br.com.pelk.findhospital.models.Appointment;
import br.com.pelk.findhospital.models.Clinic;
import br.com.pelk.findhospital.models.Doctor;
import br.com.pelk.findhospital.models.Hospital;
import br.com.pelk.findhospital.models.User;
import java.awt.Color;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

public class AppointmentDoctorTableModel extends AbstractTableModel {

    private List<Appointment> dados = new ArrayList<>();
    private String[] colunas = {"Horário", "Paciente"};

    List<Color> rowColours = Arrays.asList(
        Color.RED,
        Color.GREEN,
        Color.CYAN
    );

    public void setRowColour(int row, Color c) {
        rowColours.set(row, c);
        fireTableRowsUpdated(row, row);
    }

    public Color getRowColour(int row) {
        return rowColours.get(row);
    }
    
    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }
    
    @Override
    public int getRowCount() {
        return dados.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
         switch(coluna){
             case 1:
                 User patient = dados.get(linha).getUser();
                 return patient.getName() + " " + patient.getLastName();
             case 0:
                 LocalDateTime ldts = dados.get(linha).getAppointmentDate();
                 return ldts.format(DateTimeFormatter.ofPattern("HH:mm"));
         }
         return null;
    }

    
    public Appointment getValueAt(int linha) {
         return dados.get(linha);
    }
    
//    public void setValueAt(int linha, String HospitaNname, Localization localization) {
//        dados.get(linha).setName(name);
//        dados.get(linha).setLocalization(localization);
//        this.fireTableRowsUpdated(linha, linha);
//    }
    
    public void removeAll(){
        dados.clear();
        this.fireTableRowsDeleted(0, dados.size());
    }
    
    public void addRow(Appointment p){
        this.dados.add(p);
        this.fireTableDataChanged();
    }
    
    public void setList(List<Appointment> lista){
        this.dados = lista;
        this.fireTableDataChanged();
    }
    
    public void removeRow(int linha){
        this.dados.remove(linha);
        this.fireTableRowsDeleted(linha, linha);
    }
}
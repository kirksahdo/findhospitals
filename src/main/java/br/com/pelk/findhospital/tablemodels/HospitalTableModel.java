package br.com.pelk.findhospital.tablemodels;

import br.com.pelk.findhospital.models.Hospital;
import br.com.pelk.findhospital.models.Localization;
import java.awt.Color;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

public class HospitalTableModel extends AbstractTableModel {

    private List<Hospital> dados = new ArrayList<>();
    private String[] colunas = {"Hospital", "Localização", "Distância"};

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
             case 0:
                 return dados.get(linha).getName();
             case 1:
                 return dados.get(linha).getLocalization();
             case 2:
                 return "199km";
         }
         return null;
    }

    
    public Hospital getValueAt(int linha) {
         return dados.get(linha);
    }
    
    public void setValueAt(int linha, String name, Localization localization) {
        dados.get(linha).setName(name);
        dados.get(linha).setLocalization(localization);
        this.fireTableRowsUpdated(linha, linha);
    }
    
    public void removeAll(){
        dados.clear();
        this.fireTableRowsDeleted(0, dados.size());
    }
    
    public void addRow(Hospital p){
        this.dados.add(p);
        this.fireTableDataChanged();
    }
    
    public void setList(List<Hospital> lista){
        this.dados = lista;
        this.fireTableDataChanged();
    }
    
    public void removeRow(int linha){
        this.dados.remove(linha);
        this.fireTableRowsDeleted(linha, linha);
    }
}
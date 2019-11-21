/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifprbiopark.queijo_desktop.view.tablemodel;
import br.com.ifprbiopark.queijo_desktop.dao.FermentoDao;
import br.com.ifprbiopark.queijo_desktop.model.Fermento;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author macbook
 */
public class TableFermento extends AbstractTableModel {
    FermentoDao tipo = new FermentoDao();
   
    List<Fermento> fermentos = tipo.listar();
    
    
    private String[] nomeColunas = {"Código", "Tipo", "Marca"};
   
    public String getColumnName(int column) {
        return nomeColunas[column];
    }
            
    public int getRowCount() {
        return fermentos.size();
    }

    public int getColumnCount() {
        return nomeColunas.length;
    }

    public Object getValueAt(int linha, int coluna) {
        switch(coluna){
            case 0:
                return fermentos.get(linha).getIdFermento();
            case 1:
                return fermentos.get(linha).getTipoFermento();
            case 3:
                return fermentos.get(linha).getMarca();
        }
        
        return null;
        
    }
    
    public void addRow(Fermento c){
        this.fermentos.add(c);

    }
    
    public void removeRow(int linha){
        this.fermentos.remove(linha);
 }
    
    public void updateRow(){
  }
}

package br.com.ifprbiopark.queijo_desktop.view.tablemodel;

import br.com.ifprbiopark.queijo_desktop.dao.*;
import br.com.ifprbiopark.queijo_desktop.model.ColetaLeite;
import java.util.List;
import javax.swing.table.AbstractTableModel;


public class TableRecebimentoLeite extends AbstractTableModel {
    
    ColetaLeiteDao coleta = new ColetaLeiteDao();
   
    List<ColetaLeite> listaEntregas = coleta.listarColetas();
    
    
    private String[] nomeColunas = {"Id", "Produtor", "Quantidade", "Data Coleta", "Funcionario", "Lote"};
   
    @Override
    public String getColumnName(int column) {
        return nomeColunas[column];
    }
    
        
    @Override
    public int getRowCount() {
        return listaEntregas.size();
    }

    @Override
    public int getColumnCount() {
        return nomeColunas.length;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        switch(coluna){
            case 0:
                return listaEntregas.get(linha).getIdColetaLeite();
            case 1:
                return listaEntregas.get(linha).getProdutor_idProdutor().getIdPessoa();
            case 2:
                return listaEntregas.get(linha).getQtdLeite();
            case 3:
                return listaEntregas.get(linha).getDtColeta();
            case 4:
                return listaEntregas.get(linha).getPessoa_idPessoa().getIdPessoa();
            case 5:
                return listaEntregas.get(linha).getLoteColeta();
                                    
        }
        
        return null;
        
    }
    
    public void addRow(ColetaLeite c){
        this.listaEntregas.add(c);
        this.fireTableDataChanged();
    }
    
    public void removeRow(int linha){
        this.listaEntregas.remove(linha);
        this.fireTableRowsDeleted(linha, linha);
    }
    
    public void updateRow(){
        this.fireTableDataChanged();
    }
    
}

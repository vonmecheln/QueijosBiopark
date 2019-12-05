/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifprbiopark.queijo_desktop.view.tablemodel;

import br.com.ifprbiopark.queijo_desktop.control.ControleEntregaAtributo;
import br.com.ifprbiopark.queijo_desktop.dao.EntradaAtributoDao;
import br.com.ifprbiopark.queijo_desktop.exception.db.DbException;
import br.com.ifprbiopark.queijo_desktop.model.EntradaAtributo;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author macbook
 */
public class TableClassificacao extends AbstractTableModel {

    EntradaAtributoDao tipo;

    List<EntradaAtributo> entrada;

    private String[] nomeColunas = {"idEntradaAtributo", "Lote", "Tipo de Observação", "Resultado"};
    private int idEntrada;
    
    public TableClassificacao(int idEntrada) {
        try {
            this.idEntrada = idEntrada;
            this.tipo = new EntradaAtributoDao();
            this.entrada = tipo.listar(idEntrada);
        } catch (DbException ex) {
            Logger.getLogger(TableFermento.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void recarregar() {
        entrada = tipo.listar(this.idEntrada);
    }

    public String getColumnName(int column) {
        return nomeColunas[column];
    }

    public int getRowCount() {
        return entrada.size();
    }

    public int getColumnCount() {
        return nomeColunas.length;
    }

    public Object getValueAt(int linha, int coluna) {
        switch (coluna) {
            
            case 0:
                return entrada.get(linha).getIdEntregaAtributo();          //idEntradaAtributo  getEntradaAtributo().            
            case 1:
                return entrada.get(linha).getColetaLeite_idColetaLeite().getLoteColeta();
            case 2:
                return entrada.get(linha).getAtributo().getNomeAtributo();
            case 3: 
                return entrada.get(linha).getValor();
        }

        return null;

    }

    public void addRow(EntradaAtributo c) {
        this.entrada.add(c);

    }

    public void removeRow(int linha) {
        this.entrada.remove(linha);
        
    }
   
    public void updateRow(){
        entrada = tipo.listar(idEntrada);
        this.fireTableDataChanged();
    }
}

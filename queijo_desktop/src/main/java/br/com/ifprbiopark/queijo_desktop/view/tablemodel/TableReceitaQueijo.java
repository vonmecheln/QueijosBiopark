/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifprbiopark.queijo_desktop.view.tablemodel;

import br.com.ifprbiopark.queijo_desktop.dao.ReceitaQueijoDao;
import br.com.ifprbiopark.queijo_desktop.exception.db.DbException;
import br.com.ifprbiopark.queijo_desktop.model.ReceitaQueijo;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author macbook
 */
public class TableReceitaQueijo extends AbstractTableModel {

    ReceitaQueijoDao tipo;

    List<ReceitaQueijo> tiposQueijo = tipo.listarColetas();

    private String[] nomeColunas = {"Código", "Descrição"};

    public TableReceitaQueijo() {
        try {
            this.tipo = new ReceitaQueijoDao();
        } catch (DbException ex) {
            Logger.getLogger(TableReceitaQueijo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getColumnName(int column) {
        return nomeColunas[column];
    }

    public int getRowCount() {
        return tiposQueijo.size();
    }

    public int getColumnCount() {
        return nomeColunas.length;
    }

    public Object getValueAt(int linha, int coluna) {
        switch (coluna) {
            case 0:
                return tiposQueijo.get(linha).getIdTipoQueijo();
            case 1:
                return tiposQueijo.get(linha).getNomeTipo();
        }

        return null;

    }

    public void addRow(ReceitaQueijo c) {
        this.tiposQueijo.add(c);

    }

    public void removeRow(int linha) {
        this.tiposQueijo.remove(linha);
    }

    public void updateRow() {
    }
}

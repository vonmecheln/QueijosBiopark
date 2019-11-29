package br.com.ifprbiopark.queijo_desktop.view.tablemodel;

import br.com.ifprbiopark.queijo_desktop.control.ControleFermento;
import br.com.ifprbiopark.queijo_desktop.exception.db.DbException;
import br.com.ifprbiopark.queijo_desktop.model.Fermento;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class TableFermento extends AbstractTableModel {

    ControleFermento cf = new ControleFermento();
    List<Fermento> fermentos;

    private String[] nomeColunas = {"Código", "Tipo", "Marca"};

    public TableFermento() throws DbException {
        this.fermentos = cf.listaFermento();
    }

    public void recarregar() throws DbException {
        fermentos = cf.listaFermento();
    }

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
        switch (coluna) {
            case 0:
                return fermentos.get(linha).getIdFermento();
            case 1:
                return fermentos.get(linha).getNome();
            case 2:
                return fermentos.get(linha).getMarca();
        }

        return null;

    }

    public void addRow(Fermento c) {
        this.fermentos.add(c);

    }

    public void removeRow(int linha) {
        this.fermentos.remove(linha);
    }

    public void updateRow() {
    }
}

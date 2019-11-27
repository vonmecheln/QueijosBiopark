package br.com.ifprbiopark.queijo_desktop.view.tablemodel;

import br.com.ifprbiopark.queijo_desktop.dao.FermentoDao;
import br.com.ifprbiopark.queijo_desktop.exception.db.DbException;
import br.com.ifprbiopark.queijo_desktop.model.Fermento;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

public class TableFermento extends AbstractTableModel {

    FermentoDao tipo;

    List<Fermento> fermentos;

    private String[] nomeColunas = {"Código", "Tipo", "Marca"};

    public TableFermento() {
        try {
            this.tipo = new FermentoDao();
            this.fermentos = tipo.listar();
        } catch (DbException ex) {
            Logger.getLogger(TableFermento.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void recarregar() {
        fermentos = tipo.listar();
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
                return fermentos.get(linha).getTipoFermento();
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

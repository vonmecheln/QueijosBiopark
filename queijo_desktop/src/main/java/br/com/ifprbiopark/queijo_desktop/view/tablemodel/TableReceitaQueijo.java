package br.com.ifprbiopark.queijo_desktop.view.tablemodel;

import br.com.ifprbiopark.queijo_desktop.control.ControleReceitaQueijo;
import br.com.ifprbiopark.queijo_desktop.exception.ReceitaQueijoException;
import br.com.ifprbiopark.queijo_desktop.exception.db.DbException;
import br.com.ifprbiopark.queijo_desktop.model.ReceitaQueijo;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class TableReceitaQueijo extends AbstractTableModel {

    List<ReceitaQueijo> tiposQueijo;

    private String[] nomeColunas = {"Código", "Descrição"};

    public TableReceitaQueijo() throws ReceitaQueijoException {
        try {
            ControleReceitaQueijo crc = new ControleReceitaQueijo();
            this.tiposQueijo = crc.listaReceitaQueijo();
        } catch (DbException ex) {
            throw new ReceitaQueijoException(ex);
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

    public void updateRow(int linha, ReceitaQueijo c) {
        this.tiposQueijo.get(linha).setNomeTipo(c.getNomeTipo());

    }

}

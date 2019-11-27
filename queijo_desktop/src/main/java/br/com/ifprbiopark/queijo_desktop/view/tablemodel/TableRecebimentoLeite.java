package br.com.ifprbiopark.queijo_desktop.view.tablemodel;

import br.com.ifprbiopark.queijo_desktop.dao.*;
import br.com.ifprbiopark.queijo_desktop.exception.db.DbException;
import br.com.ifprbiopark.queijo_desktop.model.ColetaLeite;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

public class TableRecebimentoLeite extends AbstractTableModel {

    ColetaLeiteDao coleta;

    List<ColetaLeite> listaEntregas;

    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    private String[] nomeColunas = {"Id", "Produtor", "Quantidade", "Data Coleta", "Funcionario", "Lote", "Situação"};

    public TableRecebimentoLeite() {
        try {
            this.coleta = new ColetaLeiteDao();
            this.listaEntregas = coleta.listarColetas();
        } catch (DbException ex) {
            Logger.getLogger(TableRecebimentoLeite.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

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
        switch (coluna) {
            case 0:
                return listaEntregas.get(linha).getIdColetaLeite();
            case 1:
                return listaEntregas.get(linha).getProdutor_idProdutor().getNome();
            case 2:
                return listaEntregas.get(linha).getQtdLeite();
            case 3:
                if (listaEntregas.get(linha).getDtColeta() != null) {
                    return sdf.format(listaEntregas.get(linha).getDtColeta());
                }
                return listaEntregas.get(linha).getDtColeta();
            case 4:
                return listaEntregas.get(linha).getPessoa_idPessoa().getNome();
            case 5:
                return listaEntregas.get(linha).getLoteColeta();
            case 6:
                return listaEntregas.get(linha).getSituacao();

        }

        return null;

    }

    public void addRow(ColetaLeite c) {
        this.listaEntregas.add(c);
        this.fireTableDataChanged();
    }

    public void removeRow(int linha) {
        this.listaEntregas.remove(linha);
        this.fireTableRowsDeleted(linha, linha);
    }

    public void updateRow() {
        this.fireTableDataChanged();
    }

}

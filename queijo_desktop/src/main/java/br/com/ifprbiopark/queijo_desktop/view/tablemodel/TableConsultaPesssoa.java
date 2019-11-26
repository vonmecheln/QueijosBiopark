package br.com.ifprbiopark.queijo_desktop.view.tablemodel;

import br.com.ifprbiopark.queijo_desktop.control.ControlePessoa;
import br.com.ifprbiopark.queijo_desktop.model.Pessoa;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class TableConsultaPesssoa extends AbstractTableModel {

    private ControlePessoa c = new ControlePessoa();
    private List<Pessoa> dados = new ArrayList<Pessoa>();
    private String[] colunas = {"ID", "Nome", "Tipo"};

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
        switch (coluna) {
            case 0:
                return dados.get(linha).getIdPessoa();
            case 1:
                return dados.get(linha).getNome();
            case 2:
                return dados.get(linha).getTipoPessoa();
        }
        return null;
    }

    public void consultar(int id, String nome, String tipo) throws Exception {
        try {
            List<Pessoa> lista = c.consultar(id, nome, tipo);

            dados = lista;
            this.fireTableDataChanged();
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }

    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifprbiopark.queijo_desktop.view.tablemodel;

import br.com.ifprbiopark.queijo_desktop.control.ControleFabricacaoQueijo;
import br.com.ifprbiopark.queijo_desktop.model.FabricacaoQueijo;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author jhona
 */
public class TableConsultaFabricacao extends AbstractTableModel {

    private ControleFabricacaoQueijo c = new ControleFabricacaoQueijo();
    private List<FabricacaoQueijo> dados = new ArrayList<FabricacaoQueijo>();
    private String[] colunas = {"ID", "Receita do queijo", "Lote do processamento", "Lote do leite", "Quantidade de leite"};

    @Override
    public int getRowCount() {
        return dados.size();
    }

    @Override
    public int getColumnCount() {
        return dados.size();
    }

    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        switch (coluna) {
            case 0:
                return dados.get(linha).getIdFabricacaoQueijo();
            case 1:
                return dados.get(linha).getTipoQueijo_idTipoQueijo().getNomeTipo();
            case 2:
                return dados.get(linha).getLoteAcabado();
            case 3:
                return dados.get(linha).getLoteQueijo();
            case 4:
                return dados.get(linha).getQtdLeiteUtilizada();
        }
        return null;
    }

    public void consultar(int idTipoQueijo, boolean inativos) throws Exception {
        try {
            List<FabricacaoQueijo> lista = c.consultarTabela(idTipoQueijo, inativos);

            dados = lista;
            this.fireTableDataChanged();
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }

    }

}

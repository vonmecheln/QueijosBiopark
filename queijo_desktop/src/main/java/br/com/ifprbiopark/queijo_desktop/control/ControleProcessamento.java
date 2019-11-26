package br.com.ifprbiopark.queijo_desktop.control;

import br.com.ifprbiopark.queijo_desktop.dao.ProcessamentoDao;
import br.com.ifprbiopark.queijo_desktop.model.Processamento;

public class ControleProcessamento {

    public Processamento consultar(int id) throws Exception {
        try {
            ProcessamentoDao p = new ProcessamentoDao();
            return p.consultar(id);
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }
}

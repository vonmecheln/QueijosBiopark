/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifprbiopark.queijo_desktop.control;

import br.com.ifprbiopark.queijo_desktop.dao.ProcessamentoDao;
import br.com.ifprbiopark.queijo_desktop.model.Processamento;

/**
 *
 * @author jhona
 */
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

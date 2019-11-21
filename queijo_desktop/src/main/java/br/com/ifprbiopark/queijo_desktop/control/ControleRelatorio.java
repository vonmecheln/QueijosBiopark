/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifprbiopark.queijo_desktop.control;

import br.com.ifprbiopark.queijo_desktop.dao.RelatorioDao;
import br.com.ifprbiopark.queijo_desktop.model.Relatorio;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author macbook
 */
public class ControleRelatorio {

    RelatorioDao dao = new RelatorioDao();

    public ArrayList<Relatorio> pesquisar(String filtro) throws SQLException {
        return dao.pesquisar(filtro);
    }
}

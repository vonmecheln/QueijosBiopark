/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifprbiopark.queijo_desktop.control;

import br.com.ifprbiopark.queijo_desktop.dao.ReceitaQueijoDao;
import br.com.ifprbiopark.queijo_desktop.exception.db.DbException;
import br.com.ifprbiopark.queijo_desktop.model.ReceitaQueijo;
import java.util.List;

/**
 *
 * @author UnioestePROEX
 */
public class ControleReceitaQueijo {

    //inserir dao correspondente;
    ReceitaQueijoDao dao = new ReceitaQueijoDao();

    public void salvar(ReceitaQueijo c) throws DbException {
        dao.inserir(c);
    }

    public void excluir(ReceitaQueijo c) throws DbException {
        dao.excluir(c);
    }

    public void alterar(ReceitaQueijo c) throws DbException {
        dao.alterar(c);
    }

    public List<ReceitaQueijo> listaReceitaQueijo() throws DbException {
        return dao.consultar();
    }

    public ReceitaQueijo consultar(int i) throws Exception {
        return dao.consultar(i);
    }

}

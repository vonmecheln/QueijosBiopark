/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifprbiopark.queijo_desktop.control;

import br.com.ifprbiopark.queijo_desktop.dao.FermentoDao;
import br.com.ifprbiopark.queijo_desktop.exception.db.DbException;
import br.com.ifprbiopark.queijo_desktop.model.Fermento;
import java.util.List;

/**
 *
 * @author UnioestePROEX
 */
public class ControleFermento {
    
    //inserir dao correspondente;
    FermentoDao dao = new FermentoDao();
    
    public void salvar(Fermento c) throws DbException{
        dao.inserir(c);
    }
    
    public void excluir (Fermento c) throws DbException{
        dao.excluir(c);
    }
    
    public void alterar(Fermento c) throws DbException {
        dao.alterar(c);
    }
    
    public List<Fermento> listaColeta(Fermento c) throws DbException{
        return  null;

}
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifprbiopark.queijo_desktop.control;

import br.com.ifprbiopark.queijo_desktop.dao.TipoQueijoDao;
import br.com.ifprbiopark.queijo_desktop.exception.db.DbException;
import br.com.ifprbiopark.queijo_desktop.model.ColetaLeite;
import br.com.ifprbiopark.queijo_desktop.model.TipoQueijo;
import java.util.List;

/**
 *
 * @author UnioestePROEX
 */
public class ControleTipoQueijo {
    
    //inserir dao correspondente;
    TipoQueijoDao dao = new TipoQueijoDao();
    
    public void salvar(TipoQueijo c) throws DbException{
        dao.inserir(c);
    }
    
    public void excluir (TipoQueijo c) throws DbException{
        dao.excluir(c);
    }
    
    public void alterar(TipoQueijo c) throws DbException {
        dao.alterar(c);
    }
    
    public List<ColetaLeite> listaColeta(TipoQueijo c) throws DbException{
        return null;

}
    
}

package br.com.ifprbiopark.queijo_desktop.control;

import br.com.ifprbiopark.queijo_desktop.dao.ReceitaQueijoDao;
import br.com.ifprbiopark.queijo_desktop.exception.db.DbException;
import br.com.ifprbiopark.queijo_desktop.model.ReceitaQueijo;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControleReceitaQueijo {

    ReceitaQueijoDao dao;

    public ControleReceitaQueijo() {
        try {
            this.dao = new ReceitaQueijoDao();
        } catch (DbException ex) {
            Logger.getLogger(ControleReceitaQueijo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

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

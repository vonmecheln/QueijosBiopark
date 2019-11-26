package br.com.ifprbiopark.queijo_desktop.control;

import br.com.ifprbiopark.queijo_desktop.dao.FermentoDao;
import br.com.ifprbiopark.queijo_desktop.exception.db.DbException;
import br.com.ifprbiopark.queijo_desktop.model.Fermento;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControleFermento {

    FermentoDao dao;

    public ControleFermento() {
        try {
            this.dao = new FermentoDao();
        } catch (DbException ex) {
            Logger.getLogger(ControleFermento.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void salvar(Fermento c) throws DbException {
        dao.inserir(c);
    }

    public void excluir(Fermento c) throws DbException {
        dao.excluir(c);
    }

    public void alterar(Fermento c) throws DbException {
        dao.alterar(c);
    }

    public List<Fermento> listaColeta(Fermento c) throws DbException {
        return null;

    }

}

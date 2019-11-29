package br.com.ifprbiopark.queijo_desktop.control;

import br.com.ifprbiopark.queijo_desktop.dao.FermentoDao;
import br.com.ifprbiopark.queijo_desktop.exception.FermentoException;
import br.com.ifprbiopark.queijo_desktop.exception.ReceitaQueijoException;
import br.com.ifprbiopark.queijo_desktop.exception.RequiredFieldException;
import br.com.ifprbiopark.queijo_desktop.exception.db.DbException;
import br.com.ifprbiopark.queijo_desktop.model.Fermento;
import com.google.common.base.Strings;
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

    public void salvar(Fermento f) throws FermentoException {
        if (Strings.isNullOrEmpty(f.getNome())) {
            throw new FermentoException(new RequiredFieldException("Nome"));
        }

        if (Strings.isNullOrEmpty(f.getMarca())) {
            throw new FermentoException(new RequiredFieldException("Marca"));
        }

        try {
            if (f.getId() == 0) {
                dao.inserir(f);
            } else {
                dao.alterar(f);
            }

        } catch (DbException ex) {
            throw new FermentoException(ex);
        }
    }

    public void excluir(Fermento c) throws FermentoException {
        try {
            dao.excluir(c);
        } catch (DbException ex) {
            throw new FermentoException(ex);
        }
    }

    public List<Fermento> listarTodos() throws DbException {
        return null;
    }

    public Fermento consultar(int id) throws Exception {
        return dao.consultar(id);
    }

}

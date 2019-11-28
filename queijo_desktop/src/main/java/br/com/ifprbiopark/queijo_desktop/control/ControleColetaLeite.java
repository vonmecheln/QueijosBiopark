package br.com.ifprbiopark.queijo_desktop.control;

import br.com.ifprbiopark.queijo_desktop.dao.ColetaLeiteDao;
import br.com.ifprbiopark.queijo_desktop.exception.ColetaLeiteException;
import br.com.ifprbiopark.queijo_desktop.exception.ReceitaQueijoException;
import br.com.ifprbiopark.queijo_desktop.exception.RequiredFieldException;
import br.com.ifprbiopark.queijo_desktop.exception.db.DbException;
import br.com.ifprbiopark.queijo_desktop.model.ColetaLeite;
import com.google.common.base.Strings;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControleColetaLeite {

    ColetaLeiteDao dao;

    public ControleColetaLeite() {
        try {
            this.dao = new ColetaLeiteDao();
        } catch (DbException ex) {
            Logger.getLogger(ControleColetaLeite.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void salvar(ColetaLeite c) throws ColetaLeiteException {

        if (Strings.isNullOrEmpty(c.getLoteColeta())) {
            throw new ColetaLeiteException(new RequiredFieldException("Lote"));
        }

        if (c.getDtColeta() == null) {
            throw new ColetaLeiteException(new RequiredFieldException("Data de Coleta"));
        }

        if (c.getQtdLeite() == null || c.getQtdLeite() == 0) {
            throw new ColetaLeiteException(new RequiredFieldException("Quantidade"));
        }

        if (c.getProdutor() == null) {
            throw new ColetaLeiteException(new RequiredFieldException("Produtor"));
        }

        if (c.getFuncionario_idPessoa() == null) {
            throw new ColetaLeiteException(new RequiredFieldException("Funcionário"));
        }

        try {
            if (c.getId() == 0) {
                dao.inserir(c);
            } else {
                dao.alterar(c);
            }

        } catch (DbException ex) {
            throw new ColetaLeiteException(ex);
        }

    }

    public void excluir(ColetaLeite c) throws ColetaLeiteException {
        try {
            dao.excluir(c);
        } catch (DbException ex) {
            throw new ColetaLeiteException(ex);
        }
    }

    public List<ColetaLeite> listaColeta() throws DbException {
        return dao.listarColetas();
    }

    public ColetaLeite consultar(int aInt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

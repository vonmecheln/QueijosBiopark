package br.com.ifprbiopark.queijo_desktop.control;

import br.com.ifprbiopark.queijo_desktop.dao.ColetaLeiteDao;
import br.com.ifprbiopark.queijo_desktop.exception.db.DbException;
import br.com.ifprbiopark.queijo_desktop.model.ColetaLeite;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControleColetaLeite {

    ColetaLeiteDao coleta;

    public ControleColetaLeite() {
        try {
            this.coleta = new ColetaLeiteDao();
        } catch (DbException ex) {
            Logger.getLogger(ControleColetaLeite.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void salvar(ColetaLeite c) throws DbException {
        coleta.inserir(c);
    }

    public void excluir(ColetaLeite c) throws DbException {
        coleta.excluir(c);
    }

    public void alterar(ColetaLeite c) throws DbException {
        coleta.alterar(c);
    }

    public List<ColetaLeite> listaColeta() throws DbException {
        return coleta.listarColetas();

    }

    public ColetaLeite consultar(int aInt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

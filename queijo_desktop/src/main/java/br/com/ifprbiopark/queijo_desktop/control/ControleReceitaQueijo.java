package br.com.ifprbiopark.queijo_desktop.control;

import br.com.ifprbiopark.queijo_desktop.dao.ReceitaQueijoDao;
import br.com.ifprbiopark.queijo_desktop.exception.ReceitaQueijoException;
import br.com.ifprbiopark.queijo_desktop.exception.RequiredFieldException;
import br.com.ifprbiopark.queijo_desktop.exception.db.DbException;
import br.com.ifprbiopark.queijo_desktop.model.ReceitaQueijo;
import com.google.common.base.Strings;
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

    public void salvar(ReceitaQueijo r) throws ReceitaQueijoException {
        if (Strings.isNullOrEmpty(r.getNomeTipo())) {
            throw new ReceitaQueijoException(new RequiredFieldException("Nome"));
        }
               
        try {
            if (r.getId() == 0) {
                dao.inserir(r);
            } else {
                dao.alterar(r);
            }

        } catch (DbException ex) {
            throw new ReceitaQueijoException(ex);
        }
    }

    public void excluir(ReceitaQueijo c) throws ReceitaQueijoException {
        try {
            dao.excluir(c);
        } catch (DbException ex) {
            throw new ReceitaQueijoException(ex);
        }
    }

    
    public List<ReceitaQueijo> listaReceitaQueijo() throws DbException {
        return dao.consultar();
    }

    public ReceitaQueijo consultar(int i) throws Exception {
        return dao.consultar(i);
    }

}

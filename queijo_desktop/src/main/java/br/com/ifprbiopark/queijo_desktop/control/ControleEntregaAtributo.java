package br.com.ifprbiopark.queijo_desktop.control;

import br.com.ifprbiopark.queijo_desktop.dao.EntregaAtributoDao;
import br.com.ifprbiopark.queijo_desktop.exception.EntregaAtributoException;
import br.com.ifprbiopark.queijo_desktop.exception.RequiredFieldException;
import br.com.ifprbiopark.queijo_desktop.exception.db.DbException;
import br.com.ifprbiopark.queijo_desktop.model.EntregaAtributo;
import com.google.common.base.Strings;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControleEntregaAtributo {

    EntregaAtributoDao dao;

    public ControleEntregaAtributo() {
        try {
            this.dao = new EntregaAtributoDao();
        } catch (DbException ex) {
            Logger.getLogger(ControleEntregaAtributo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void salvar(EntregaAtributo e) throws EntregaAtributoException {

        if (Strings.isNullOrEmpty(e.getValor())) {
            throw new EntregaAtributoException(new RequiredFieldException("Valor"));
        }

        if (e.getAtributo_idAtributo() == null) {
            throw new EntregaAtributoException(new RequiredFieldException("Atributo"));
        }

        if (e.getColetaLeite_idColetaLeite() == null) {
            throw new EntregaAtributoException(new RequiredFieldException("Coleta de Leite"));
        }

        try {
            if (e.getId() == 0) {
                dao.inserir(e);
            } else {
                dao.alterar(e);
            }

        } catch (DbException ex) {
            throw new EntregaAtributoException(ex);
        }

    }

    public void excluir(EntregaAtributo e) throws EntregaAtributoException {
        try {
            dao.excluir(e);
        } catch (DbException ex) {
            throw new EntregaAtributoException(ex);
        }
    }

}

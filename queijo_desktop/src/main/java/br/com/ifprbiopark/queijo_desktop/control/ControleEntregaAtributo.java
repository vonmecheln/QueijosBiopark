package br.com.ifprbiopark.queijo_desktop.control;

import br.com.ifprbiopark.queijo_desktop.dao.EntradaAtributoDao;
import br.com.ifprbiopark.queijo_desktop.exception.EntregaAtributoException;
import br.com.ifprbiopark.queijo_desktop.exception.RequiredFieldException;
import br.com.ifprbiopark.queijo_desktop.exception.db.DbException;
import br.com.ifprbiopark.queijo_desktop.model.EntradaAtributo;
import com.google.common.base.Strings;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControleEntregaAtributo {

    EntradaAtributoDao dao;

    public ControleEntregaAtributo() {
        try {
            this.dao = new EntradaAtributoDao();
        } catch (DbException ex) {
            Logger.getLogger(ControleEntregaAtributo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void salvar(EntradaAtributo e) throws EntregaAtributoException {

        if (Strings.isNullOrEmpty(e.getValor())) {
            throw new EntregaAtributoException(new RequiredFieldException("Valor"));
        }

        if (e.getAtributo() == null) {
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

    public void excluir(EntradaAtributo e) throws EntregaAtributoException {
        try {
            dao.excluir(e);
        } catch (DbException ex) {
            throw new EntregaAtributoException(ex);
        }
    }

}

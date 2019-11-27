package br.com.ifprbiopark.queijo_desktop.dao;

import br.com.ifprbiopark.queijo_desktop.exception.db.DbException;
import br.com.ifprbiopark.queijo_desktop.model.EntregaAtributo;
import java.util.ArrayList;
import java.util.List;

public class EntregaAtributoDao extends AbstractDao<EntregaAtributo> {

    public EntregaAtributoDao() throws DbException {
        super("entradaatributo", new ArrayList<>(List.of(
                "idEntradaAtributo",
                "valor",
                "atributo_id",
                "coleta_id")));
    }

    @Override
    public void inserir(EntregaAtributo objeto) throws DbException {
        throw new UnsupportedOperationException("Não suportado ainda."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean excluir(EntregaAtributo objeto) throws DbException {
        throw new UnsupportedOperationException("Não suportado ainda."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public EntregaAtributo consultar(EntregaAtributo objeto) throws DbException {
        throw new UnsupportedOperationException("Não suportado ainda."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public EntregaAtributo alterar(EntregaAtributo objeto) throws DbException {
        throw new UnsupportedOperationException("Não suportado ainda."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public EntregaAtributo consultar(int id) throws DbException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

package br.com.ifprbiopark.queijo_desktop.dao;

import br.com.ifprbiopark.queijo_desktop.exception.db.DbException;
import br.com.ifprbiopark.queijo_desktop.model.EntregaAtributo;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

public class EntregaAtributoDao extends AbstractDao<EntregaAtributo> {

    public EntregaAtributoDao() throws DbException {
        super("entradaatributo", new ArrayList<>(Arrays.asList(
                "idEntradaAtributo",
                "valor",
                "atributo_id",
                "coleta_id")));
    }

    @Override
    protected void confStantement(NamedParameterStatement nps, EntregaAtributo objeto) throws SQLException {
        nps.setString("valor", objeto.getValor());
        nps.setInt("atributo_id", nullId(objeto.getAtributo()));
        nps.setInt("coleta_id", nullId(objeto.getColetaLeite_idColetaLeite()));                
    }

    @Override
    public void inserir(EntregaAtributo objeto) throws DbException {
        inserirDefault(objeto);
    }

    @Override
    public boolean excluir(EntregaAtributo objeto) throws DbException {
        return excluirDefault(objeto);
    }

    @Override
    public EntregaAtributo consultar(EntregaAtributo objeto) throws DbException {
        throw new UnsupportedOperationException("Não suportado ainda."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public EntregaAtributo alterar(EntregaAtributo objeto) throws DbException {
        alterarDefault(objeto);
        return objeto;
    }

    @Override
    public EntregaAtributo consultar(int id) throws DbException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

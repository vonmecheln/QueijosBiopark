package br.com.ifprbiopark.queijo_desktop.dao;

import br.com.ifprbiopark.queijo_desktop.control.ControleAtributos;
import br.com.ifprbiopark.queijo_desktop.control.ControleColetaLeite;
import br.com.ifprbiopark.queijo_desktop.control.ControleEntregaAtributo;
import br.com.ifprbiopark.queijo_desktop.exception.db.DbException;
import br.com.ifprbiopark.queijo_desktop.model.Atributos;
import br.com.ifprbiopark.queijo_desktop.model.EntradaAtributo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EntradaAtributoDao extends AbstractDao<EntradaAtributo> {

    public EntradaAtributoDao() throws DbException {
        super("entradaatributo", new ArrayList<>(Arrays.asList(
                "idEntradaAtributo",
                "valor",
                "atributo_id",
                "coleta_id")));
    }

    @Override
    protected void confStantement(NamedParameterStatement nps, EntradaAtributo objeto) throws SQLException {
        nps.setString("valor", objeto.getValor());
        nps.setInt("atributo_id", nullId(objeto.getAtributo()));
        nps.setInt("coleta_id", nullId(objeto.getColetaLeite_idColetaLeite()));
    }

    @Override
    public void inserir(EntradaAtributo objeto) throws DbException {
        inserirDefault(objeto);
    }

    @Override
    public boolean excluir(EntradaAtributo objeto) throws DbException {
        return excluirDefault(objeto);
    }

    @Override
    public EntradaAtributo consultar(EntradaAtributo objeto) throws DbException {
        throw new UnsupportedOperationException("Não suportado ainda."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public EntradaAtributo alterar(EntradaAtributo objeto) throws DbException {
        alterarDefault(objeto);
        return objeto;
    }

    @Override
    public EntradaAtributo consultar(int id) throws DbException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<EntradaAtributo> listar(int idEntrada) {
        try {
            List<EntradaAtributo> retornoEntrada = new ArrayList<>();
            //String SQL;
            StringBuilder sql = getConsultaBasica();
            sql.append(" WHERE coleta_id = :id");

            NamedParameterStatement nps = con.NamedParameterStatement(sql.toString());
            nps.setInt("id", idEntrada);
            ResultSet consulta = nps.executeQuery();
            while (consulta.next()) {
                EntradaAtributo entrada = new EntradaAtributo();
                entrada.setIdEntregaAtributo(consulta.getInt("idEntradaAtributo"));
                ControleColetaLeite coleta = new ControleColetaLeite();
                entrada.setColetaLeite_idColetaLeite(coleta.consultar(consulta.getInt("coleta_id")));
                ControleAtributos atributo = new ControleAtributos();
                entrada.setAtributo(atributo.consultar(consulta.getInt("atributo_id")));
                entrada.setValor(consulta.getString("valor"));

                retornoEntrada.add(entrada);

            }
            return retornoEntrada;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;

    }



}

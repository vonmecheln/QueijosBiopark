package br.com.ifprbiopark.queijo_desktop.dao;

import br.com.ifprbiopark.queijo_desktop.exception.db.DbException;
import br.com.ifprbiopark.queijo_desktop.model.Atributos;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AtributosDao extends AbstractDao<Atributos> {

    public AtributosDao() throws DbException {
        super("atributos", new ArrayList<>(List.of(
                "idAtributo",
                "nomeAtributo")));
    }

    @Override
    protected void confStantement(NamedParameterStatement nps, Atributos objeto) throws SQLException {
        nps.setString("nomeAtributo", objeto.getNomeAtributo());
    }

    @Override
    public void inserir(Atributos a) throws DbException {
        InserirDefault(a);
    }

    @Override
    public boolean excluir(Atributos a) throws DbException {
        return excluirDefault(a);
    }

    @Override
    public Atributos alterar(Atributos a) throws DbException {
        alterarDefault(a);
        return a;
    }

    @Override
    public Atributos consultar(Atributos objeto) throws DbException {
        throw new UnsupportedOperationException("Não suportado ainda."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Atributos consultar(int id) throws DbException {
        try {
            Atributos a = new Atributos();

            //String SQL;
            String sql = "SELECT idAtributo, nomeAtributo FROM atributos WHERE idAtributo = :id ";

            NamedParameterStatement nps = con.NamedParameterStatement(sql);

            nps.setInt("id", id);

            ResultSet consulta = nps.executeQuery();
            while (consulta.next()) {
                a.setIdAtributo(consulta.getInt("idAtributo"));
                a.setNomeAtributo(consulta.getString("nomeAtributo"));
            }
            consulta.close();
            return a;
        } catch (SQLException ex) {
            throw new DbException(ex);
        }
    }

    public List<Atributos> consultar() throws DbException {
        try {
            List<Atributos> lista = new ArrayList<Atributos>();

            //String SQL;
            String sql = "SELECT idAtributo, nomeAtributo FROM atributos";

            NamedParameterStatement nps = con.NamedParameterStatement(sql);

            ResultSet consulta = nps.executeQuery();
            while (consulta.next()) {
                Atributos a = new Atributos();
                a.setIdAtributo(consulta.getInt("idAtributo"));
                a.setNomeAtributo(consulta.getString("nomeAtributo"));
                lista.add(a);
            }
            consulta.close();
            return lista;
        } catch (SQLException ex) {
            throw new DbException(ex);
        }
    }
}

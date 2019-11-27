package br.com.ifprbiopark.queijo_desktop.dao;

import br.com.ifprbiopark.queijo_desktop.exception.db.DbException;
import br.com.ifprbiopark.queijo_desktop.model.Fermento;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FermentoDao extends AbstractDao<Fermento> {

    public FermentoDao() throws DbException {
        super("fermento", new ArrayList<>(List.of(
                "idFermento",
                "tipoFermento",
                "marca")));
    }

    @Override
    protected void confStantement(NamedParameterStatement nps, Fermento objeto) throws SQLException {
        nps.setString("tipoFermento", objeto.getTipoFermento());
        nps.setString("marca", objeto.getMarca());
    }

    @Override
    public void inserir(Fermento fermento) throws DbException {
        inserirDefault(fermento);
    }

    @Override
    public boolean excluir(Fermento fermento) throws DbException {
        return excluirDefault(fermento);
    }

    @Override
    public Fermento consultar(Fermento fermento) throws DbException {
        if (fermento == null) {
            return null;
        }
        return consultar(fermento.getIdFermento());
    }

    @Override
    public Fermento alterar(Fermento fermento) throws DbException {
        alterarDefault(fermento);
        return fermento;
    }

    @Override
    public Fermento consultar(int id) throws DbException {
        try {

            //String SQL;
            String sql = "SELECT idFermento, tipoFermento,marca FROM fermento WHERE idFermento = :idFermento";

            NamedParameterStatement nps = con.NamedParameterStatement(sql);
            nps.setInt("idFermento", id);
            ResultSet consulta = nps.executeQuery();
            while (consulta.next()) {
                Fermento fermento = new Fermento();
                fermento.setIdFermento(consulta.getInt("idFermento"));
                fermento.setTipoFermento(consulta.getString("tipoFermento"));
                fermento.setMarca(consulta.getString("marca"));

                return fermento;

            }
            return null;
        } catch (SQLException ex) {
            throw new DbException(ex);
        }
    }

    public List<Fermento> listar() {
        try {
            List<Fermento> retornoFermento = new ArrayList<>();
            //String SQL;
            String sql = "SELECT idFermento, tipoFermento,marca FROM fermento";

            NamedParameterStatement nps = con.NamedParameterStatement(sql);
            ResultSet consulta = nps.executeQuery();
            while (consulta.next()) {
                Fermento fermento = new Fermento();
                fermento.setIdFermento(consulta.getInt("idFermento"));
                fermento.setTipoFermento(consulta.getString("tipoFermento"));
                fermento.setMarca(consulta.getString("marca"));

                retornoFermento.add(fermento);

            }
            return retornoFermento;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;

    }

}

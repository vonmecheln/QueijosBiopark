package br.com.ifprbiopark.queijo_desktop.dao;

import br.com.ifprbiopark.queijo_desktop.exception.db.DbException;
import br.com.ifprbiopark.queijo_desktop.exception.db.GeneratedKeysException;
import br.com.ifprbiopark.queijo_desktop.exception.db.NotExecuteInsertException;
import br.com.ifprbiopark.queijo_desktop.model.ReceitaQueijo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReceitaQueijoDao extends AbstractDao<ReceitaQueijo> {

    public ReceitaQueijoDao() throws DbException {
        super("receitaqueijo", new ArrayList<>(List.of(
                "idReceita",
                "nomeReceita")));
    }

    @Override
    protected void confStantementInsert(NamedParameterStatement nps, ReceitaQueijo objeto) throws SQLException {
        nps.setString("nomeReceita", objeto.getNomeTipo());
    }

    @Override
    public void inserir(ReceitaQueijo objeto) throws DbException {
        InserirDefault(objeto);
    }

    @Override
    public boolean excluir(ReceitaQueijo objeto) throws DbException {
        return excluirDefault(objeto);
    }

    @Override
    public ReceitaQueijo consultar(ReceitaQueijo tq) throws DbException {
        return consultar(tq.getIdTipoQueijo());
    }

    @Override
    public ReceitaQueijo alterar(ReceitaQueijo tq) throws DbException {
        try {

            String sql = "UPDATE receitaqueijo SET nomeReceita = :nomeReceita WHERE idReceita = :id";

            NamedParameterStatement nps = con.NamedParameterStatement(sql);
            nps.setString("nomeReceita", tq.getNomeTipo());
            nps.setInt("id", tq.getIdTipoQueijo());

            int exec = nps.executeUpdate();
            if (exec == 0) {
                throw new NotExecuteInsertException();
            }
            return tq;

        } catch (SQLException ex) {
            throw new DbException(ex);
        }
    }

    @Override
    public ReceitaQueijo consultar(int id) throws DbException {
        try {
            ReceitaQueijo tq = new ReceitaQueijo();

            //String SQL;
            String sql = "SELECT idReceita, nomeReceita FROM receitaqueijo WHERE idReceita = :id ";

            NamedParameterStatement nps = con.NamedParameterStatement(sql);

            nps.setInt("id", id);

            ResultSet consulta = nps.executeQuery();
            while (consulta.next()) {
                tq.setIdTipoQueijo(consulta.getInt("idReceita"));
                tq.setNomeTipo(consulta.getString("nomeReceita"));
            }
            consulta.close();
            return tq;
        } catch (SQLException ex) {
            throw new DbException(ex);
        }
    }

    public List<ReceitaQueijo> consultar() throws DbException {
        try {
            List<ReceitaQueijo> lista = new ArrayList<ReceitaQueijo>();

            //String SQL;
            String sql = "SELECT idReceita, nomeReceita FROM receitaqueijo";

            NamedParameterStatement nps = con.NamedParameterStatement(sql);

            ResultSet consulta = nps.executeQuery();
            while (consulta.next()) {
                ReceitaQueijo tq = new ReceitaQueijo();
                tq.setIdTipoQueijo(consulta.getInt("idReceita"));
                tq.setNomeTipo(consulta.getString("nomeReceita"));
                lista.add(tq);
            }
            consulta.close();
            return lista;
        } catch (SQLException ex) {
            throw new DbException(ex);
        }
    }

    public List<ReceitaQueijo> consultar(String nome) throws DbException {
        try {
            List<ReceitaQueijo> lista = new ArrayList<ReceitaQueijo>();

            //String SQL;
            String sql = "SELECT idReceita, nomeReceita FROM receitaqueijo WHERE nomeReceita LIKE '%:nomeReceita%'";

            NamedParameterStatement nps = con.NamedParameterStatement(sql);
            nps.setString("nomeReceita", nome);

            ResultSet consulta = nps.executeQuery();
            while (consulta.next()) {
                ReceitaQueijo tq = new ReceitaQueijo();
                tq.setIdTipoQueijo(consulta.getInt("idReceita"));
                tq.setNomeTipo(consulta.getString("nomeReceita"));
                lista.add(tq);
            }
            consulta.close();
            return lista;
        } catch (SQLException ex) {
            throw new DbException(ex);
        }
    }

    public List<ReceitaQueijo> listarColetas() {
        try {
            List<ReceitaQueijo> tipoQueijo = new ArrayList<>();
            String sql = "SELECT idReceita, nomeReceita FROM receitaqueijo";

            NamedParameterStatement nps = con.NamedParameterStatement(sql);

            ResultSet consulta = nps.executeQuery();
            while (consulta.next()) {
                ReceitaQueijo tipo = new ReceitaQueijo();
                tipo.setIdTipoQueijo(consulta.getInt("idReceita"));
                tipo.setNomeTipo(consulta.getString("nomeReceita"));

                tipoQueijo.add(tipo);

            }
            return tipoQueijo;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

}

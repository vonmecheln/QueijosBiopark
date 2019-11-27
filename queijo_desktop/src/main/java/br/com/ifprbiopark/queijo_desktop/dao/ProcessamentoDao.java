package br.com.ifprbiopark.queijo_desktop.dao;

import br.com.ifprbiopark.queijo_desktop.exception.db.DbException;
import br.com.ifprbiopark.queijo_desktop.model.Processamento;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProcessamentoDao extends AbstractDao<Processamento> {

    public ProcessamentoDao() throws DbException {
        super("processamento", new ArrayList<>(List.of(
                "idProcessamento",
                "TipoProcessamento")));
    }

    @Override
    protected void confStantement(NamedParameterStatement nps, Processamento objeto) throws SQLException {
        nps.setString("TipoProcessamento", objeto.getTipoProcessamento());
    }

    @Override
    public void inserir(Processamento p) throws DbException {
        inserirDefault(p);
    }

    @Override
    public boolean excluir(Processamento p) throws DbException {
        return excluirDefault(p);
    }

    @Override
    public Processamento consultar(Processamento objeto) throws DbException {
        throw new UnsupportedOperationException("Não suportado ainda."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Processamento alterar(Processamento p) throws DbException {
        alterarDefault(p);
        return p;
    }

    @Override
    public Processamento consultar(int id) throws DbException {
        try {
            Processamento p = new Processamento();

            //String SQL;
            String sql = "SELECT idProcessamento, TipoProcessamento FROM processamento WHERE idProcessamento = :id ";

            NamedParameterStatement nps = con.NamedParameterStatement(sql);

            nps.setInt("id", id);

            ResultSet consulta = nps.executeQuery();
            while (consulta.next()) {
                p.setIdProcesamento(consulta.getInt("idProcessamento"));
                p.setTipoProcessamento(consulta.getString("TipoProcessamento"));
            }
            consulta.close();
            return p;
        } catch (SQLException ex) {
            throw new DbException(ex);
        }
    }

    public List<Processamento> consultar() throws DbException {
        try {
            List<Processamento> lista = new ArrayList<Processamento>();

            //String SQL;
            String sql = "SELECT idProcessamento, TipoProcessamento FROM processamento";

            NamedParameterStatement nps = con.NamedParameterStatement(sql);

            ResultSet consulta = nps.executeQuery();
            while (consulta.next()) {
                Processamento p = new Processamento();
                p.setIdProcesamento(consulta.getInt("idProcessamento"));
                p.setTipoProcessamento(consulta.getString("TipoProcessamento"));
                lista.add(p);
            }
            consulta.close();
            return lista;
        } catch (SQLException ex) {
            throw new DbException(ex);
        }
    }
}

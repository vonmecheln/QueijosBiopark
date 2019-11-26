/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifprbiopark.queijo_desktop.dao;

import br.com.ifprbiopark.queijo_desktop.exception.db.DbException;
import br.com.ifprbiopark.queijo_desktop.exception.db.GeneratedKeysException;
import br.com.ifprbiopark.queijo_desktop.exception.db.NotExecuteInsertException;
import br.com.ifprbiopark.queijo_desktop.model.Fermento;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jhona
 */
public class FermentoDao extends AbstractDao<Fermento> {

    public FermentoDao() {
        super("fermento");
    }

    @Override
    public void inserir(Fermento fermento) throws DbException {
        try {

            String sql = "INSERT INTO fermento( idFermento, "
                    + "tipoFermento, marca "
                    + ") VALUES ("
                    + " (select count(*) + 1 from fermento),  :tipoFermento, :marca)";

            Conexao con = Conexao.getInstance();
            NamedParameterStatement nps = con.NamedParameterStatement(sql);
            nps.setString("tipoFermento", fermento.getTipoFermento());
            nps.setString("marca", fermento.getMarca());

            int exec = nps.executeUpdate();
            if (exec == 0) {
                throw new NotExecuteInsertException();
            }

            int key = 0;
            ResultSet retorno = nps.getGeneratedKeys();
            if (retorno != null && retorno.next()) {
                key = retorno.getInt(1);
            } else {
                throw new GeneratedKeysException();
            }
            fermento.setIdFermento(key);

        } catch (SQLException ex) {
            throw new DbException(ex);
        }

    }

    @Override
    public boolean excluir(Fermento fermento) throws DbException {
        String sql = "delete from fermento where idFermento = :idFermento";

        try {
            Conexao con = Conexao.getInstance();
            NamedParameterStatement nps = con.NamedParameterStatement(sql);
            nps.setInt("idFermento", fermento.getIdFermento());
            int exec = nps.executeUpdate();
            if (exec == 0) {
                throw new NotExecuteInsertException();
            }
        } catch (SQLException ex) {
            Logger.getLogger(FermentoDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;

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
        String sql = "update fermento set tipoFermento = :tipoFermento, marca = :marca where idFermento = :idFermento";

        try {
            Conexao con = Conexao.getInstance();
            NamedParameterStatement nps = con.NamedParameterStatement(sql);
            nps.setInt("idFermento", fermento.getIdFermento());
            nps.setString("tipoFermento", fermento.getTipoFermento());
            nps.setString("marca", fermento.getMarca());
            int exec = nps.executeUpdate();
            if (exec == 0) {
                throw new NotExecuteInsertException();
            }
        } catch (SQLException ex) {
            Logger.getLogger(FermentoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return fermento;
    }

    @Override
    public Fermento consultar(int id) throws DbException {
        try {

            //String SQL;
            String sql = "SELECT idFermento, tipoFermento,marca FROM fermento WHERE idFermento = :idFermento";

            Conexao con = Conexao.getInstance();
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

            Conexao con = Conexao.getInstance();
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

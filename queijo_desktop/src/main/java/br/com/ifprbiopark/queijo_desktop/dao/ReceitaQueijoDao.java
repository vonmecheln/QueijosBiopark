/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifprbiopark.queijo_desktop.dao;

import br.com.ifprbiopark.queijo_desktop.exception.db.DbException;
import br.com.ifprbiopark.queijo_desktop.exception.db.GeneratedKeysException;
import br.com.ifprbiopark.queijo_desktop.exception.db.NotExecuteInsertException;
import br.com.ifprbiopark.queijo_desktop.model.ReceitaQueijo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jhona
 */
public class ReceitaQueijoDao extends AbstractDao<ReceitaQueijo> {

    @Override
    public void inserir(ReceitaQueijo tq) throws DbException {
        try {
            
            String sql = "INSERT INTO tipoqueijo(nomeTipo) VALUES(:nomeTipo)";
            
            Conexao con = Conexao.getInstance();
            NamedParameterStatement nps = con.NamedParameterStatement(sql);
            nps.setString("nomeTipo", tq.getNomeTipo());

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
            tq.setIdTipoQueijo(key);

        } catch (SQLException ex) {
            throw new DbException(ex);
        }
    }

    @Override
    public boolean excluir(ReceitaQueijo tq) throws DbException {
        try {
            
            String sql = "DELETE tipoqueijo WHERE idTipoQueijo = :id";
            
            Conexao con = Conexao.getInstance();
            NamedParameterStatement nps = con.NamedParameterStatement(sql);
            nps.setInt("id", tq.getIdTipoQueijo());

            boolean exec = nps.execute();
            if (!exec) {
                throw new SQLException();
            }
            else{
                return exec;
            }          

        } catch (SQLException ex) {
            throw new DbException(ex);
        }
    }

    @Override
    public ReceitaQueijo consultar(ReceitaQueijo tq) throws DbException {
        return consultar(tq.getIdTipoQueijo());
    }

    @Override
    public ReceitaQueijo alterar(ReceitaQueijo tq) throws DbException {
        try {
            
            String sql = "UPDATE tipoqueijo SET nomeTipo = :nomeTipo WHERE idTipoQueijo = :id";
            
            Conexao con = Conexao.getInstance();
            NamedParameterStatement nps = con.NamedParameterStatement(sql);
            nps.setString("nomeTipo", tq.getNomeTipo());
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
            String sql = "SELECT idTipoQueijo, nomeTipo FROM tipoqueijo WHERE idTipoQueijo = :id ";

            Conexao con = Conexao.getInstance();
            NamedParameterStatement nps = con.NamedParameterStatement(sql);
            
            nps.setInt("id", id);

            ResultSet consulta = nps.executeQuery();
            while (consulta.next()) {
                tq.setIdTipoQueijo(consulta.getInt("idTipoQueijo"));
                tq.setNomeTipo(consulta.getString("nomeTipo"));
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
            String sql = "SELECT idTipoQueijo, nomeTipo FROM tipoqueijo";

            Conexao con = Conexao.getInstance();
            NamedParameterStatement nps = con.NamedParameterStatement(sql);
            
            ResultSet consulta = nps.executeQuery();
            while (consulta.next()) {
                ReceitaQueijo tq = new ReceitaQueijo();
                tq.setIdTipoQueijo(consulta.getInt("idTipoQueijo"));
                tq.setNomeTipo(consulta.getString("nomeTipo"));
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
            String sql = "SELECT idTipoQueijo, nomeTipo FROM tipoqueijo WHERE nomeTipo LIKE '%:nomeTipo%'";

            Conexao con = Conexao.getInstance();
            NamedParameterStatement nps = con.NamedParameterStatement(sql);
            nps.setString("nomeTipo", nome);
            
            ResultSet consulta = nps.executeQuery();
            while (consulta.next()) {
                ReceitaQueijo tq = new ReceitaQueijo();
                tq.setIdTipoQueijo(consulta.getInt("idTipoQueijo"));
                tq.setNomeTipo(consulta.getString("nomeTipo"));
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
            String sql = "SELECT idTipoQueijo, nomeTipo FROM tipoqueijo";

            Conexao con = Conexao.getInstance();
            NamedParameterStatement nps = con.NamedParameterStatement(sql);

            ResultSet consulta = nps.executeQuery();
            while (consulta.next()) {
                ReceitaQueijo tipo = new ReceitaQueijo();
                tipo.setIdTipoQueijo(consulta.getInt("idTipoQueijo"));
                tipo.setNomeTipo(consulta.getString("nomeTipo"));

                tipoQueijo.add(tipo);

            }
            return tipoQueijo;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
    
}

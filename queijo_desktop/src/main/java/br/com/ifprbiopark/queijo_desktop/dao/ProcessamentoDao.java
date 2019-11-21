/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifprbiopark.queijo_desktop.dao;

import br.com.ifprbiopark.queijo_desktop.exception.db.DbException;
import br.com.ifprbiopark.queijo_desktop.exception.db.GeneratedKeysException;
import br.com.ifprbiopark.queijo_desktop.exception.db.NotExecuteInsertException;
import br.com.ifprbiopark.queijo_desktop.model.Processamento;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jhona
 */
public class ProcessamentoDao extends AbstractDao<Processamento>{

    @Override
    public void inserir(Processamento p) throws DbException {
        try {
            
            String sql = "INSERT INTO processamento(TipoProcessamento) VALUES(:TipoProcessamento)";
            
            Conexao con = Conexao.getInstance();
            NamedParameterStatement nps = con.NamedParameterStatement(sql);
            nps.setString("TipoProcessamento", p.getTipoProcessamento());

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
            p.setIdProcesamento(key);

        } catch (SQLException ex) {
            throw new DbException(ex);
        }
    }

    @Override
    public boolean excluir(Processamento p) throws DbException {
        try {
            
            String sql = "DELETE processamento WHERE idProcessamento = :id";
            
            Conexao con = Conexao.getInstance();
            NamedParameterStatement nps = con.NamedParameterStatement(sql);
            nps.setInt("id", p.getIdProcesamento());

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
    public Processamento consultar(Processamento objeto) throws DbException {
        throw new UnsupportedOperationException("Não suportado ainda."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Processamento alterar(Processamento p) throws DbException {
                try {            
            String sql = "UPDATE processamento SET TipoProcessamento = :TipoProcessamento WHERE idProcessamento = :id";
            
            Conexao con = Conexao.getInstance();
            NamedParameterStatement nps = con.NamedParameterStatement(sql);
            nps.setString("TipoProcessamento", p.getTipoProcessamento());
            nps.setInt("id", p.getIdProcesamento());

            int exec = nps.executeUpdate();
            if (exec == 0) {
                throw new NotExecuteInsertException();
            }            
            return p;

        } catch (SQLException ex) {
            throw new DbException(ex);
        }
    }

    @Override
    public Processamento consultar(int id) throws DbException {
        try {
            Processamento p = new Processamento();
            
            //String SQL;
            String sql = "SELECT idProcessamento, TipoProcessamento FROM processamento WHERE idProcessamento = :id ";

            Conexao con = Conexao.getInstance();
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

            Conexao con = Conexao.getInstance();
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

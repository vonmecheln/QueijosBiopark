package br.com.ifprbiopark.queijo_desktop.dao;

import br.com.ifprbiopark.queijo_desktop.exception.db.DbException;
import br.com.ifprbiopark.queijo_desktop.exception.db.GeneratedKeysException;
import br.com.ifprbiopark.queijo_desktop.exception.db.NotExecuteInsertException;
import br.com.ifprbiopark.queijo_desktop.model.ColetaLeite;
import br.com.ifprbiopark.queijo_desktop.model.Pessoa;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ColetaLeiteDao extends AbstractDao<ColetaLeite> {

    @Override
    public void inserir(ColetaLeite c) throws DbException {
        try {

            String sql = "INSERT INTO coletaLeite( loteColeta, dtColeta, qtdLeite, produtor_idProdutor, Pessoa_idPessoa) "
                    + "VALUES (:loteColeta, :dtColeta, :qtdLeite, :produtor_idProdutor, :Pessoa_idPessoa)";
                        
            Conexao con = Conexao.getInstance();
            NamedParameterStatement nps = con.NamedParameterStatement(sql);
            
            nps.setString("loteColeta", c.getLoteColeta());
            nps.setDate("dtColeta", new java.sql.Date(c.getDtColeta().getTime()));
            nps.setDouble("qtdLeite", c.getQtdLeite());
            nps.setInt("produtor_idProdutor", c.getProdutor_idProdutor().getIdPessoa());
            nps.setInt("Pessoa_idPessoa", c.getPessoa_idPessoa().getIdPessoa());
            
            
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
            c.setIdColetaLeite(key);

        } catch (SQLException ex) {
            throw new DbException(ex);
        }
    }

    @Override
    public boolean excluir(ColetaLeite objeto) throws DbException {
        try {
            String sql = " delete from coletaLeite where idColetaLeite = :idColetaLeite";
            Conexao con = Conexao.getInstance();
            NamedParameterStatement nps = con.NamedParameterStatement(sql);
            nps.setInt("idColetaLeite", objeto.getIdColetaLeite());
            int exec = nps.executeUpdate();
            if (exec == 0) {
                throw new NotExecuteInsertException();
            }
        } catch (SQLException ex) {
            throw new DbException(ex);
        }
        return true;
    }

    @Override
    public ColetaLeite consultar(ColetaLeite objeto) throws DbException {
        throw new UnsupportedOperationException("Não suportado ainda."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ColetaLeite alterar(ColetaLeite objeto) throws DbException {
        throw new UnsupportedOperationException("Não suportado ainda."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<ColetaLeite> listarColetas() {
        try {
            List<ColetaLeite> coletas = new ArrayList<>();

            //String SQL;
            String sql = "SELECT idColetaLeite, loteColeta, dtColeta, Produtor_idProdutor, qtdLeite, "
                    + "Pessoa_idPessoa FROM coletaleite";

            Conexao con = Conexao.getInstance();
            NamedParameterStatement nps = con.NamedParameterStatement(sql);

            ResultSet consulta = nps.executeQuery();
            while (consulta.next()) {
                ColetaLeite coleta = new ColetaLeite();
                coleta.setIdColetaLeite(consulta.getInt("idColetaLeite"));
                coleta.setLoteColeta(consulta.getString("loteColeta"));
                coleta.setDtColeta(consulta.getDate("dtColeta"));
                
                //seta funcionario;
                Pessoa f = new Pessoa();
                f.setIdPessoa(consulta.getInt("Pessoa_idPessoa"));
                coleta.setPessoa_idPessoa(f);

                //seta produtor;
                Pessoa p = new Pessoa();
                p.setIdPessoa(consulta.getInt("Produtor_idProdutor"));
                coleta.setProdutor_idProdutor(p);
                
                //PessoaDao pessoaDao = new PessoaDao();
                //coleta.setProdutor_idProdutor(pessoaDao.consultar(consulta.getInt("idProdutor")));

                coletas.add(coleta);

            }
            return coletas;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public ColetaLeite consultar(int id) throws DbException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

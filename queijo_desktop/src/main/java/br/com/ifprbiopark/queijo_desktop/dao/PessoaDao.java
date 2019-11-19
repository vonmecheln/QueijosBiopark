/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifprbiopark.queijo_desktop.dao;

import br.com.ifprbiopark.queijo_desktop.exception.db.DbException;
import br.com.ifprbiopark.queijo_desktop.exception.db.GeneratedKeysException;
import br.com.ifprbiopark.queijo_desktop.exception.db.NotExecuteInsertException;
import br.com.ifprbiopark.queijo_desktop.model.Pessoa;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jhona
 */
public class PessoaDao extends AbstractDao<Pessoa>{

    @Override
    public void inserir(Pessoa p) throws DbException {
        try {
            
            String sql = "INSERT INTO pessoa( "
                    + "nome, endereco, tipoFiscal, cadastro, tipoPessoa "
                    + ") VALUES ("
                    + ":nome, :endereco, :tipoFiscal, :cadastro, :tipoPessoa)";
            
            Conexao con = Conexao.getInstance();
            NamedParameterStatement nps = con.NamedParameterStatement(sql);
            nps.setString("nome", p.getNome());            
            nps.setString("endereco", p.getEndereco());
            nps.setString("tipoFiscal", p.getTipoFiscal());
            nps.setString("cadastro", p.getCadastro());
            nps.setString("tipoPessoa", p.getTipoPessoa());

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
            p.setIdPessoa(key);

        } catch (SQLException ex) {
            throw new DbException(ex);
        }
    }

    @Override
    public boolean excluir(Pessoa objeto) throws DbException {
        throw new UnsupportedOperationException("Não suportado ainda."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Pessoa consultar(Pessoa objeto) throws DbException {
        if(objeto == null){
            return null;
        }
        return consultar(objeto.getIdPessoa());
    }

    @Override
    public Pessoa alterar(Pessoa objeto) throws DbException {
        throw new UnsupportedOperationException("Não suportado ainda."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Pessoa consultar(int id) throws DbException {
        try {
            
            //String SQL;
            String sql = "SELECT FROM coletaLeite( idColetaLeite, loteColeta, dtColeta, idProdutor ) "
                    + "VALUES (:idColetaLeite, :loteColeta, :dtColeta, idProdutor)";

            Conexao con = Conexao.getInstance();
            NamedParameterStatement nps = con.NamedParameterStatement(sql);

            ResultSet consulta = nps.executeQuery();
            while (consulta.next()) {
                Pessoa pessoa = new Pessoa();
                pessoa.setIdPessoa(consulta.getInt("idPessoa"));
                pessoa.setNome(consulta.getString("nome"));
                pessoa.setEndereco(consulta.getString("endereco"));
                pessoa.setTipoFiscal(consulta.getString("tipoFiscal"));
                pessoa.setCadastro(consulta.getString("cadastro"));
                pessoa.setTipoPessoa(consulta.getString("tipoPessoa"));
                
                return pessoa;
                
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }
    
    public List<Pessoa> consultarFornecedores() throws DbException {
        try {
            
            List<Pessoa> pessoas = new ArrayList<Pessoa>();
            
            String sql = "SELECT idPessoa, nome FROM pessoa WHERE tipoPessoa = 'fornecedor' ORDER BY nome ASC";

            Conexao con = Conexao.getInstance();
            NamedParameterStatement nps = con.NamedParameterStatement(sql);

            ResultSet consulta = nps.executeQuery();
            while (consulta.next()) {
                Pessoa pessoa = new Pessoa();
                pessoa.setIdPessoa(consulta.getInt("idPessoa"));
                pessoa.setNome(consulta.getString("nome"));
                pessoas.add(pessoa);
            }
            return pessoas;

        } catch (SQLException ex) {
            throw new DbException(ex);
        }
    }
    
        public List<Pessoa> consultarFuncionarios() throws DbException {
        try {
            
            List<Pessoa> pessoas = new ArrayList<Pessoa>();
            
            String sql = "SELECT idPessoa, nome FROM pessoa WHERE tipoPessoa = 'funcionario' ORDER BY nome ASC";

            Conexao con = Conexao.getInstance();
            NamedParameterStatement nps = con.NamedParameterStatement(sql);

            ResultSet consulta = nps.executeQuery();
            while (consulta.next()) {
                Pessoa pessoa = new Pessoa();
                pessoa.setIdPessoa(consulta.getInt("idPessoa"));
                pessoa.setNome(consulta.getString("nome"));
                pessoas.add(pessoa);
            }
            return pessoas;

        } catch (SQLException ex) {
            throw new DbException(ex);
        }
    }
    
}

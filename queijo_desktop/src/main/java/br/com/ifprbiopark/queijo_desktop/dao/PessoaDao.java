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
        throw new UnsupportedOperationException("Não suportado ainda."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Pessoa alterar(Pessoa objeto) throws DbException {
        throw new UnsupportedOperationException("Não suportado ainda."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Pessoa consultar(int id) throws DbException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

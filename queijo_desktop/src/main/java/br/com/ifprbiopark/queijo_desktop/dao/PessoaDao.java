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
public class PessoaDao extends AbstractDao<Pessoa> {

    @Override
    public void inserir(Pessoa p) throws DbException {
        try {

            String sql = "INSERT INTO pessoa( "
                    + "nome, endereco, tipoFiscal, documento, tipoPessoa, telefone "
                    + ") VALUES ("
                    + ":nome, :endereco, :tipoFiscal, :documento, :tipoPessoa, :telefone)";

            Conexao con = Conexao.getInstance();
            NamedParameterStatement nps = con.NamedParameterStatement(sql);
            nps.setString("nome", p.getNome());
            nps.setString("endereco", p.getEndereco());
            nps.setString("tipoFiscal", p.getTipoFiscal());
            nps.setString("documento", p.getDocumento());
            nps.setString("tipoPessoa", p.getTipoPessoa());
            nps.setString("telefone", p.getTelefone());

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
    public boolean excluir(Pessoa p) throws DbException {
        try {

            String sql = "DELETE pessoa WHERE idPessoa = :id";

            Conexao con = Conexao.getInstance();
            NamedParameterStatement nps = con.NamedParameterStatement(sql);
            nps.setInt("id", p.getIdPessoa());

            boolean exec = nps.execute();
            if (!exec) {
                throw new SQLException();
            } else {
                return exec;
            }

        } catch (SQLException ex) {
            throw new DbException(ex);
        }
    }

    @Override
    public Pessoa consultar(Pessoa objeto) throws DbException {
        if (objeto == null) {
            return null;
        }
        return consultar(objeto.getIdPessoa());
    }

    @Override
    public Pessoa alterar(Pessoa p) throws DbException {
        try {

            String sql = "UPDATE pessoa SET "
                    + "nome = :nome, endereco = :endereco, tipoFiscal = :tipoFiscal, documento = :documento, tipoPessoa = :tipoPessoa, telefone = :telefone"
                    + " WHERE "
                    + "idPessoa = :id";

            Conexao con = Conexao.getInstance();
            NamedParameterStatement nps = con.NamedParameterStatement(sql);
            nps.setString("nome", p.getNome());
            nps.setString("endereco", p.getEndereco());
            nps.setString("tipoFiscal", p.getTipoFiscal());
            nps.setString("documento", p.getDocumento());
            nps.setString("tipoPessoa", p.getTipoPessoa());
            nps.setString("telefone", p.getTelefone());
            nps.setInt("id", p.getIdPessoa());

            int exec = nps.executeUpdate();
            if (exec == 0) {
                throw new Exception("Erro ao alterar dados.");
            }

            return p;
        } catch (Exception ex) {
            throw new DbException(ex.getMessage());
        }
    }

    @Override
    public Pessoa consultar(int id) throws DbException {
        try {

            //String SQL;
            String sql = "SELECT idPessoa, nome, endereco, tipoFiscal, documento, tipoPessoa, telefone FROM pessoa WHERE idPessoa = :id";

            Conexao con = Conexao.getInstance();
            NamedParameterStatement nps = con.NamedParameterStatement(sql);

            nps.setInt("id", id);

            ResultSet consulta = nps.executeQuery();
            while (consulta.next()) {
                Pessoa pessoa = new Pessoa();
                pessoa.setIdPessoa(consulta.getInt("idPessoa"));
                pessoa.setNome(consulta.getString("nome"));
                pessoa.setEndereco(consulta.getString("endereco"));
                pessoa.setTipoFiscal(consulta.getString("tipoFiscal"));
                pessoa.setDocumento(consulta.getString("documento"));
                pessoa.setTipoPessoa(consulta.getString("tipoPessoa"));
                pessoa.setTelefone(consulta.getString("telefone"));

                return pessoa;
            }
            return null;
        } catch (SQLException ex) {
            throw new DbException(ex);
        }
    }

    public List<Pessoa> consultarFornecedores() throws DbException {
        try {

            List<Pessoa> pessoas = new ArrayList<Pessoa>();

            String sql = "SELECT idPessoa, nome FROM pessoa WHERE tipoPessoa = 'Fornecedor' ORDER BY nome ASC";

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

            String sql = "SELECT idPessoa, nome FROM pessoa WHERE tipoPessoa = 'Funcionário' ORDER BY nome ASC";

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

    public List<Pessoa> consultar(String nome) throws DbException {
        try {

            List<Pessoa> pessoas = new ArrayList<Pessoa>();

            //String SQL;
            String sql = "SELECT idPessoa, nome, endereco, tipoFiscal, documento, tipoPessoa, telefone FROM pessoa WHERE nome LIKE '%:nome%'";

            Conexao con = Conexao.getInstance();
            NamedParameterStatement nps = con.NamedParameterStatement(sql);

            nps.setString("nome", nome);

            ResultSet consulta = nps.executeQuery();
            while (consulta.next()) {
                Pessoa pessoa = new Pessoa();
                pessoa.setIdPessoa(consulta.getInt("idPessoa"));
                pessoa.setNome(consulta.getString("nome"));
                pessoa.setEndereco(consulta.getString("endereco"));
                pessoa.setTipoFiscal(consulta.getString("tipoFiscal"));
                pessoa.setDocumento(consulta.getString("documento"));
                pessoa.setTipoPessoa(consulta.getString("tipoPessoa"));
                pessoa.setTelefone(consulta.getString("telefone"));

                pessoas.add(pessoa);
            }
            return pessoas;
        } catch (SQLException ex) {
            throw new DbException(ex);
        }
    }

    public List<Pessoa> consultar(String nome, String tipo) throws Exception {
        try {

            List<Pessoa> pessoas = new ArrayList<Pessoa>();
            String sql = "SELECT idPessoa, nome, endereco, tipoFiscal, documento, tipoPessoa, telefone FROM pessoa WHERE ";
            //String SQL;
            if (nome != null && tipo != null) {
                sql += "nome LIKE '%" + nome + "%' AND tipoPessoa = '" + tipo + "'";
            } else if (nome == null && tipo != null) {
                sql += "tipoPessoa = '" + tipo + "'";
            } else if (nome != null && tipo == null) {
                sql += "nome LIKE '%" + nome + "%'";
            }

            Conexao con = Conexao.getInstance();
            NamedParameterStatement nps = con.NamedParameterStatement(sql);

//            if (nome != null && tipo != null){
//                nps.setString("nome", nome);
//                nps.setString("tipo", tipo);
//            }
//            else if (nome == null && tipo != null)
//                nps.setString("tipo", tipo);
//            else if (nome != null && tipo == null)
//                nps.setString("nome", nome);
            ResultSet consulta = nps.executeQuery();
            while (consulta.next()) {
                Pessoa pessoa = new Pessoa();
                pessoa.setIdPessoa(consulta.getInt("idPessoa"));
                pessoa.setNome(consulta.getString("nome"));
                pessoa.setEndereco(consulta.getString("endereco"));
                pessoa.setTipoFiscal(consulta.getString("tipoFiscal"));
                pessoa.setDocumento(consulta.getString("documento"));
                pessoa.setTipoPessoa(consulta.getString("tipoPessoa"));
                pessoa.setTelefone(consulta.getString("telefone"));

                pessoas.add(pessoa);
            }
            return pessoas;
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }

    public List<Pessoa> consultar() throws Exception {
        try {

            List<Pessoa> pessoas = new ArrayList<Pessoa>();
            String sql = "SELECT idPessoa, nome, endereco, tipoFiscal, documento, tipoPessoa, telefone FROM pessoa";

            Conexao con = Conexao.getInstance();
            NamedParameterStatement nps = con.NamedParameterStatement(sql);

            ResultSet consulta = nps.executeQuery();
            while (consulta.next()) {
                Pessoa pessoa = new Pessoa();
                pessoa.setIdPessoa(consulta.getInt("idPessoa"));
                pessoa.setNome(consulta.getString("nome"));
                pessoa.setEndereco(consulta.getString("endereco"));
                pessoa.setTipoFiscal(consulta.getString("tipoFiscal"));
                pessoa.setDocumento(consulta.getString("documento"));
                pessoa.setTipoPessoa(consulta.getString("tipoPessoa"));
                pessoa.setTelefone(consulta.getString("telefone"));

                pessoas.add(pessoa);
            }
            return pessoas;
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }

}

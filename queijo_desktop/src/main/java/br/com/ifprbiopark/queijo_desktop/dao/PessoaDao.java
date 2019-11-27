package br.com.ifprbiopark.queijo_desktop.dao;

import br.com.ifprbiopark.queijo_desktop.exception.db.DbException;
import br.com.ifprbiopark.queijo_desktop.model.Pessoa;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PessoaDao extends AbstractDao<Pessoa> {

    public PessoaDao() throws DbException {
        super("pessoa", new ArrayList<>(Arrays.asList(
                "idPessoa",
                "nome",
                "endereco",
                "tipoFiscal",
                "documento",
                "tipoPessoa",
                "telefone")));
    }

    @Override
    protected void confStantement(NamedParameterStatement nps, Pessoa objeto) throws SQLException {
        nps.setString("nome", objeto.getNome());
        nps.setString("endereco", objeto.getEndereco());
        nps.setString("tipoFiscal", objeto.getTipoFiscal());
        nps.setString("documento", objeto.getDocumento());
        nps.setString("tipoPessoa", objeto.getTipoPessoa());
        nps.setString("telefone", objeto.getTelefone());
    }

    @Override
    public void inserir(Pessoa p) throws DbException {
        inserirDefault(p);
    }

    @Override
    public boolean excluir(Pessoa p) throws DbException {
        return excluirDefault(p);
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
        alterarDefault(p);
        return p;
    }

    @Override
    public Pessoa consultar(int id) throws DbException {
        try {

            //String SQL;
            String sql = "SELECT idPessoa, nome, endereco, tipoFiscal, documento, tipoPessoa, telefone FROM pessoa WHERE idPessoa = :id";

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

    public Pessoa consultarPorDocumento(String documento) throws DbException {
        try {

            StringBuilder sql = super.getConsultaBasica();
            sql.append(" WHERE documento = :doc");
            NamedParameterStatement nps = con.NamedParameterStatement(sql.toString());

            nps.setString("doc", documento);

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

}

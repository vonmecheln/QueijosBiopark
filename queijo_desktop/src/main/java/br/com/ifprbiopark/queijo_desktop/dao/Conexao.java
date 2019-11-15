package br.com.ifprbiopark.queijo_desktop.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexao {

    private static Conexao unique;

    public Connection conexao;

    private Conexao() {
        try {
            conexao = DriverManager.getConnection("jdbc:sqlite:bancoqueijos.db");

            Statement statement = conexao.createStatement();
            // criando tabelas
            statement.execute("CREATE TABLE IF NOT EXISTS `pessoa` ("
                    + "  `idPessoa` INT(11) NOT NULL,"
                    + "  `nome` VARCHAR(45) NOT NULL,"
                    + "  `endereco` VARCHAR(50) NOT NULL,"
                    + "  `tipoFiscal` VARCHAR(1) NOT NULL,"
                    + "  `cadastro` VARCHAR(14) NOT NULL,"
                    + "  `tipoPessoa` VARCHAR(45) NOT NULL,"
                    + "  PRIMARY KEY (`idPessoa`))");

            statement.execute("CREATE TABLE IF NOT EXISTS `atributos` ("
                    + "  `idAtributo` INT(11) NOT NULL,"
                    + "  `nomeAtributo` VARCHAR(45) NOT NULL,"
                    + "  PRIMARY KEY (`idAtributo`))");

        } catch (SQLException ex) {
            conexao = null;
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static Conexao getInstance() {
        if (unique == null) {
            unique = new Conexao();
        }
        return unique;
    }

    public ResultSet executarConsulta(String sql) {
        PreparedStatement pstm;
        ResultSet rs;
        try {
            pstm = conexao.prepareStatement(sql);
            rs = pstm.executeQuery();
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void fecharConexao() {
        try {
            conexao.close();
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    NamedParameterStatement NamedParameterStatement(String sql) throws SQLException {
        return new NamedParameterStatement(conexao, sql);
    }

    NamedParameterStatement NamedParameterStatement(String sql, int RETURN_GENERATED_KEYS) throws SQLException {
        return new NamedParameterStatement(conexao, sql, RETURN_GENERATED_KEYS);
    }

}

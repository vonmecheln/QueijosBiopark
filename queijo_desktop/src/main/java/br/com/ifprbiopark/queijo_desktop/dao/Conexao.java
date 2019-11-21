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
            statement.execute("CREATE TABLE IF NOT EXISTS pessoa ("
                    + "    idPessoa INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + "    nome VARCHAR(45) NOT NULL, "
                    + "    endereco VARCHAR(50) NOT NULL, "
                    + "    telefone VARCHAR (20), "
                    + "    tipoFiscal VARCHAR(1) NOT NULL, "
                    + "    documento VARCHAR(14) NOT NULL, "
                    + "    tipoPessoa VARCHAR(45) NOT NULL);");

            statement.execute("CREATE TABLE IF NOT EXISTS atributo ("
                    + "  idAtributo INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + "  nomeAtributo VARCHAR(45) NOT NULL);");

            statement.execute("CREATE TABLE IF NOT EXISTS coletaleite ("
                    + "    idColetaLeite INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + "    loteColeta VARCHAR(45) NOT NULL, "
                    + "    dtColeta DATE NOT NULL, "
                    + "    produtor_id INTEGER NOT NULL REFERENCES pessoa(idPessoa), "
                    + "    qtdLeite NUMERIC(14,2) NOT NULL, "
                    + "    funcionario_id INTEGER NOT NULL REFERENCES pessoa(idPessoa), "
                    + "    situacao VARCHAR(15));");

            statement.execute("CREATE TABLE IF NOT EXISTS entradaatributo ("
                    + "    idEntradaAtributo INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + "    valor VARCHAR(10) NOT NULL, "
                    + "    atributo_id INTEGER NOT NULL REFERENCES atributo(idAtributo), "
                    + "    coleta_id INTEGER NOT NULL REFERENCES coletaleite(idColetaLeite));");

            statement.execute("CREATE TABLE IF NOT EXISTS fermento ("
                    + "    idFermento INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + "    tipoFermento VARCHAR(45) NOT NULL, "
                    + "    Marca VARCHAR(45) NOT NULL);");

            statement.execute("CREATE TABLE IF NOT EXISTS receitaqueijo ("
                    + "    idReceita INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + "    nomeReceita VARCHAR(45) NOT NULL);");

            statement.execute("CREATE TABLE IF NOT EXISTS fabricacaoqueijo ( "
                    + "    idFabricacaoQueijo INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + "    receita_id INTEGER NOT NULL REFERENCES receitaqueijo(idReceita), "
                    + "    dataFabricacao DATE, "
                    + "    loteQueijo VARCHAR(45), "
                    + "    coleta_id INTEGER NOT NULL REFERENCES coletaleite(idColetaLeite), "
                    + "    qtdLeite NUMERIC(14,2) NOT NULL, "
                    + "    TipoProcessamento VARCHAR(45) NOT NULL, "
                    + "    tempoProcessamento INTEGER, "
                    + "    temperaturaProcessamento INTEGER, "
                    + "    temperaturaPreMaturacao INTEGER, "
                    + "    fermento_id INTEGER NOT NULL REFERENCES fermento(idFermento), "
                    + "    qtdFermento NUMERIC(14,2), "
                    + "    tempoMaturacao INTEGER, "
                    + "    phMaturacao NUMERIC(14,2), "
                    + "    temperaturaCoagulacao INTEGER, "
                    + "    qtdClCalcio NUMERIC(14,2), "
                    + "    qtdCoagulante NUMERIC(14,2), "
                    + "    tempoCoagulacao INTEGER, "
                    + "    phCorte NUMERIC(14,2), "
                    + "    phEnformagem NUMERIC(14,2), "
                    + "    phFinal NUMERIC(14,2), "
                    + "    dessoragem INTEGER, "
                    + "    temperaturaDessoragem INTEGER, "
                    + "    tipoSalga VARCHAR(45), "
                    + "    dataMaturacao DATE, "
                    + "    temperaturaMaturacao INTEGER, "
                    + "    dataLavagem DATE, "
                    + "    tipoTratamento VARCHAR(45), "
                    + "    tempoTratamento INTEGER, "
                    + "    qtdPecas INTEGER, "
                    + "    pesoMPecas NUMERIC(14,2), "
                    + "    observacoes TEXT);");

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

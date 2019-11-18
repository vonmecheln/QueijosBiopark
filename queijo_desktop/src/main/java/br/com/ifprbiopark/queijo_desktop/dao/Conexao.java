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
            statement.execute("  CREATE TABLE IF NOT EXISTS atributos (" +
                                "  idAtributo INT(11) PRIMARY KEY," +
                                "  nomeAtributo VARCHAR(45) NOT NULL)");
            
            statement.execute("  CREATE TABLE IF NOT EXISTS pessoa (" +
                                "  idPessoa INT(11) PRIMARY KEY," +
                                "  nome VARCHAR(45) NOT NULL," +
                                "  endereco VARCHAR(50) NOT NULL," +
                                "  tipoFiscal VARCHAR(1) NOT NULL," +
                                "  cadastro VARCHAR(14) NOT NULL," +
                                "  tipoPessoa VARCHAR(45) NOT NULL)");

            statement.execute("  CREATE TABLE IF NOT EXISTS coletaleite (" +
                                "  idColetaLeite INT(11) PRIMARY KEY," +
                                "  loteColeta VARCHAR(45) NOT NULL," +
                                "  dtColeta DATE NOT NULL," +
                                "  Produtor_idProdutor INT(11) NOT NULL," +
                                "  qtdLeite DOUBLE NOT NULL," +
                                "  Pessoa_idPessoa INT(11) NOT NULL)");
            
            statement.execute("  CREATE TABLE IF NOT EXISTS entradaatributo (" +
                                "  idEntradaAtributo INT(11) PRIMARY KEY," +
                                "  valor VARCHAR(10) NOT NULL," +
                                "  Atributos_idAtributo INT(11) NOT NULL," +
                                "  ColetaLeite_idColetaLeite INT(11) NOT NULL)");

            statement.execute("  CREATE TABLE IF NOT EXISTS fermento (" +
                                "  idFermento INT(11) PRIMARY KEY," +
                                "  tipoFermento VARCHAR(45) NOT NULL," +
                                "  Marca VARCHAR(45) NOT NULL)");

            statement.execute("  CREATE TABLE IF NOT EXISTS processamento (" +
                                "  idProcessamento INT(11) PRIMARY KEY," +
                                "  TipoProcessamento VARCHAR(45) NOT NULL)");

            statement.execute("  CREATE TABLE IF NOT EXISTS tipoqueijo (" +
                                "  idTipoQueijo INT(11) PRIMARY KEY," +
                                "  nomeTipo VARCHAR(45) NOT NULL)");

            statement.execute("  CREATE TABLE IF NOT EXISTS fabricacaoqueijo (" +
                                "  idFabricacaoQueijo INT(11) PRIMARY KEY," +
                                "  TipoQueijo_idTipoQueijo INT(11) NOT NULL," +
                                "  dataFabricacao DATE NOT NULL," +
                                "  loteQueijo VARCHAR(45) NOT NULL," +
                                "  ColetaLeite_idColetaLeite INT(11) NOT NULL," +
                                "  Processamento_idProcessamento INT(11) NOT NULL," +
                                "  tempoProcessamento INT(11) NOT NULL," +
                                "  temperaturaProcessamento INT(11) NOT NULL," +
                                "  temperaturaPreMaturacao INT(11) NOT NULL," +
                                "  Fermento_idFermento INT(11) NOT NULL," +
                                "  qtdFermento DOUBLE NOT NULL," +
                                "  tempoMaturacao INT(11) NOT NULL," +
                                "  phMaturacao DOUBLE NOT NULL," +
                                "  temperaturaCoagulacao INT(11) NOT NULL," +
                                "  qtdClCalcio DOUBLE NOT NULL," +
                                "  qtdCoagulante DOUBLE NOT NULL," +
                                "  tempoCoagulacao INT(11) NOT NULL," +
                                "  phCorte DOUBLE NOT NULL," +
                                "  phEnformagem DOUBLE NOT NULL," +
                                "  phFinal DOUBLE NOT NULL," +
                                "  dessoragem INT(11) NOT NULL," +
                                "  temperaturaDessoragem INT(11) NOT NULL," +
                                "  tipoSalga VARCHAR(45) NULL DEFAULT NULL," +
                                "  dataMaturacao DATE NULL DEFAULT NULL," +
                                "  temperaturaMaturacao INT(11) NULL DEFAULT NULL," +
                                "  dataLavagem DATE NULL DEFAULT NULL," +
                                "  tipoTratamento VARCHAR(45) NULL DEFAULT NULL," +
                                "  tempoTratamento INT(11) NULL DEFAULT NULL," +
                                "  qtdPecas INT(11) NOT NULL," +
                                "  pesoMPecas DOUBLE NOT NULL," +
                                "  pesoTotal DOUBLE NOT NULL," +
                                "  observacoes LONGTEXT NULL DEFAULT NULL," +
                                "  FabricacaoQueijocol VARCHAR(45) NULL DEFAULT NULL," +
                                "  Responsavel_idResponsavel INT(11) NOT NULL)");

//            statement.execute("CREATE TABLE IF NOT EXISTS `pessoa` ("
//                    + "  `idPessoa` INT(11) PRIMARY KEY,"
//                    + "  `nome` VARCHAR(45) NOT NULL,"
//                    + "  `endereco` VARCHAR(50) NOT NULL,"
//                    + "  `tipoFiscal` VARCHAR(1) NOT NULL,"
//                    + "  `cadastro` VARCHAR(14) NOT NULL,"
//                    + "  `tipoPessoa` VARCHAR(45) NOT NULL)");

//            statement.execute("CREATE TABLE IF NOT EXISTS `coletaleite` ("
//                    + "  `idColetaLeite` INT(11) PRIMARY KEY,"
//                    + "  `loteColeta` VARCHAR(45) NOT NULL,"
//                    + "  `dtColeta` DATE NOT NULL,"
//                    + "  `qtdLeite` DOUBLE NOT NULL,"
//                    + "  `Pessoa_idPessoa` INT(11) NOT NULL,"                    
//                    + "  CONSTRAINT `fk_ColetaLeite_Pessoa1`"
//                    + "    FOREIGN KEY (`Pessoa_idPessoa`)"
//                    + "    REFERENCES `mydb`.`pessoa` (`idPessoa`))");

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

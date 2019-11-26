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
                    + "    observacoes TEXT, "
                    + "    inativo INTEGER);");

            //verifica se a tabela de pessoas não tem registros para o insert inicial
            ResultSet consulta = statement.executeQuery("SELECT count(1) as qtd FROM pessoa");
            if (consulta.next()) {
                if (consulta.getInt("qtd") == 0) {

                    //-- Populando tabela de ReceitaQueijo 
                    statement.executeUpdate("INSERT INTO receitaqueijo (nomeReceita) VALUES ('Saint Paulin'); ");
                    statement.executeUpdate("INSERT INTO receitaqueijo (nomeReceita) VALUES ('Queijo Gouda'); ");
                    statement.executeUpdate("INSERT INTO receitaqueijo (nomeReceita) VALUES ('Tomme - Leite Cru'); ");
                    statement.executeUpdate("INSERT INTO receitaqueijo (nomeReceita) VALUES ('Morbier'); ");
                    statement.executeUpdate("INSERT INTO receitaqueijo (nomeReceita) VALUES ('Brie/Camembert'); ");
                    statement.executeUpdate("INSERT INTO receitaqueijo (nomeReceita) VALUES ('Morbier - Casca lavada com cachaça'); ");
                    statement.executeUpdate("INSERT INTO receitaqueijo (nomeReceita) VALUES ('Queijo Gouda - Leite Orgânico'); ");
                    statement.executeUpdate("INSERT INTO receitaqueijo (nomeReceita) VALUES ('Queijos diversos'); ");
                    statement.executeUpdate("INSERT INTO receitaqueijo (nomeReceita) VALUES ('Queijo massa crua prensada'); ");
                    statement.executeUpdate("INSERT INTO receitaqueijo (nomeReceita) VALUES ('Queijo Artesanal'); ");
                    statement.executeUpdate("INSERT INTO receitaqueijo (nomeReceita) VALUES ('Queijo Reblochon'); ");

                    //-- Populando tabela Fermento 
                    statement.executeUpdate("INSERT INTO fermento (tipofermento, marca) VALUES ('Mesofilico old', 'Docina'); ");
                    statement.executeUpdate("INSERT INTO fermento (tipofermento, marca) VALUES ('Mesofilico termofilico', 'Docina'); ");
                    statement.executeUpdate("INSERT INTO fermento (tipofermento, marca) VALUES ('Mesofilico tipo O', 'Docina'); ");
                    statement.executeUpdate("INSERT INTO fermento (tipofermento, marca) VALUES ('Mesofilico +PPR10', 'Docina+Lactopar'); ");

                    //-- Populando tabela Pessoa 
                    statement.executeUpdate("INSERT INTO pessoa (nome, endereco, telefone, tipoFiscal, documento, tipoPessoa) VALUES ('Beatriz Durlan', 'Rua Roxo nr 11','45 3333-3333','F', '00000000000','Fornecedor');  ");
                    statement.executeUpdate("INSERT INTO pessoa (nome, endereco, telefone, tipoFiscal, documento, tipoPessoa) VALUES ('Cirlei Rossi', 'Rua Preto nr 22','45 3333-3333','F', '11111111111','Fornecedor');  ");
                    statement.executeUpdate("INSERT INTO pessoa (nome, endereco, telefone, tipoFiscal, documento, tipoPessoa) VALUES ('Saul', 'Rua Verde nr 33','45 3333-3333','F', '22222222222','Fornecedor');  ");
                    statement.executeUpdate("INSERT INTO pessoa (nome, endereco, telefone, tipoFiscal, documento, tipoPessoa) VALUES ('Lovani', 'Rua Amarelo nr 17','45 3333-3333','F', '33333333333','Fornecedor');  ");
                    statement.executeUpdate("INSERT INTO pessoa (nome, endereco, telefone, tipoFiscal, documento, tipoPessoa) VALUES ('Gilvan', 'Rua Azul nr 98','45 3333-3333','F', '44444444444','Fornecedor');  ");
                    statement.executeUpdate("INSERT INTO pessoa (nome, endereco, telefone, tipoFiscal, documento, tipoPessoa) VALUES ('Marlova Bombardelli', 'Rua Vermelho nr 20','45 3333-3333','F', '55555555555','Fornecedor');  ");
                    statement.executeUpdate("INSERT INTO pessoa (nome, endereco, telefone, tipoFiscal, documento, tipoPessoa) VALUES ('Ronaldo', 'Rua Laranja nr 78','45 3333-3333','F', '66666666666','Fornecedor');  ");
                    statement.executeUpdate("INSERT INTO pessoa (nome, endereco, telefone, tipoFiscal, documento, tipoPessoa) VALUES ('Maike T. M. Montanhini', 'Rua Branca nr 54','45 3333-3333','F', '77777777777','Funcionário');  ");

                    //-- Populando tabela Atributo 
                    statement.executeUpdate("INSERT INTO atributo (nomeAtributo) VALUES ('pH'); ");
                    statement.executeUpdate("INSERT INTO atributo (nomeAtributo) VALUES ('Acidez'); ");
                    statement.executeUpdate("INSERT INTO atributo (nomeAtributo) VALUES ('Gordura'); ");
                    statement.executeUpdate("INSERT INTO atributo (nomeAtributo) VALUES ('Proteina'); ");

                    //-- Populando tabela Coleta 
                    statement.executeUpdate("INSERT INTO coletaleite (loteColeta,dtColeta,produtor_id,qtdLeite,funcionario_id, situacao) VALUES ('270619','2019-06-27',1,30,8,'Pago'); ");
                    statement.executeUpdate("INSERT INTO coletaleite (loteColeta,dtColeta,produtor_id,qtdLeite,funcionario_id, situacao) VALUES ('0207196D','2019-07-02',1,30,8,'Pago'); ");
                    statement.executeUpdate("INSERT INTO coletaleite (loteColeta,dtColeta,produtor_id,qtdLeite,funcionario_id, situacao) VALUES ('040719','2019-07-04',3,31,8,'Pendente'); ");
                    statement.executeUpdate("INSERT INTO coletaleite (loteColeta,dtColeta,produtor_id,qtdLeite,funcionario_id, situacao) VALUES ('090719MB','2019-07-09',3,30,8,'Pago'); ");
                    statement.executeUpdate("INSERT INTO coletaleite (loteColeta,dtColeta,produtor_id,qtdLeite,funcionario_id, situacao) VALUES ('110719','2019-07-11',1,30,8,'Pendente'); ");

                    //-- Populando tabela EntradaAtributo 
                    statement.executeUpdate("INSERT INTO entradaatributo (valor, atributo_id, coleta_id) VALUES ('6,88',1,1); ");
                    statement.executeUpdate("INSERT INTO entradaatributo (valor, atributo_id, coleta_id) VALUES ('16',2,1); ");
                    statement.executeUpdate("INSERT INTO entradaatributo (valor, atributo_id, coleta_id) VALUES ('4,37',3,1); ");
                    statement.executeUpdate("INSERT INTO entradaatributo (valor, atributo_id, coleta_id) VALUES ('3,32',4,1); ");
                    statement.executeUpdate("INSERT INTO entradaatributo (valor, atributo_id, coleta_id) VALUES ('6,78',1,2); ");
                    statement.executeUpdate("INSERT INTO entradaatributo (valor, atributo_id, coleta_id) VALUES ('17',2,2); ");
                    statement.executeUpdate("INSERT INTO entradaatributo (valor, atributo_id, coleta_id) VALUES ('4,39',3,2); ");
                    statement.executeUpdate("INSERT INTO entradaatributo (valor, atributo_id, coleta_id) VALUES ('3,30',4,2); ");
                    statement.executeUpdate("INSERT INTO entradaatributo (valor, atributo_id, coleta_id) VALUES ('6,82',1,3); ");
                    statement.executeUpdate("INSERT INTO entradaatributo (valor, atributo_id, coleta_id) VALUES ('18',2,3); ");
                    statement.executeUpdate("INSERT INTO entradaatributo (valor, atributo_id, coleta_id) VALUES ('4,49',3,3); ");
                    statement.executeUpdate("INSERT INTO entradaatributo (valor, atributo_id, coleta_id) VALUES ('3,59',4,3); ");
                    statement.executeUpdate("INSERT INTO entradaatributo (valor, atributo_id, coleta_id) VALUES ('6,83',1,4); ");
                    statement.executeUpdate("INSERT INTO entradaatributo (valor, atributo_id, coleta_id) VALUES ('18',2,4); ");
                    statement.executeUpdate("INSERT INTO entradaatributo (valor, atributo_id, coleta_id) VALUES ('4,56',3,4); ");
                    statement.executeUpdate("INSERT INTO entradaatributo (valor, atributo_id, coleta_id) VALUES ('3,68',4,4); ");
                    statement.executeUpdate("INSERT INTO entradaatributo (valor, atributo_id, coleta_id) VALUES ('6,81',1,5); ");
                    statement.executeUpdate("INSERT INTO entradaatributo (valor, atributo_id, coleta_id) VALUES ('15',2,5); ");
                    statement.executeUpdate("INSERT INTO entradaatributo (valor, atributo_id, coleta_id) VALUES ('4,11',3,5); ");
                    statement.executeUpdate("INSERT INTO entradaatributo (valor, atributo_id, coleta_id) VALUES ('3,24',4,5); ");

                    //-- Populando tabela FabricacaoQueijo 
                    statement.executeUpdate("INSERT INTO fabricacaoqueijo (receita_id, dataFabricacao, loteQueijo, coleta_id, qtdLeite, TipoProcessamento, tempoProcessamento, temperaturaProcessamento,temperaturaPreMaturacao, fermento_id, qtdFermento, tempoMaturacao, phMaturacao, temperaturaCoagulacao, qtdClCalcio, qtdCoagulante, tempoCoagulacao, phCorte,phEnformagem, phFinal, dessoragem, temperaturaDessoragem, tipoSalga, dataMaturacao, temperaturaMaturacao, dataLavagem, tipoTratamento, tempoTratamento, qtdPecas,pesoMPecas, observacoes) VALUES (1,'2019-06-27','270919SP',1,30,'Pasteurizado',30,63,36,1,1.5,60,6.81,0,14.4,21,40,6.87,0,0,0,0,'Salmora','2019-06-28',12,'2019-06-29','Outro',60,7,800,'Utilizado 10L de agua aquecida e retirado 15L de soro'); ");
                    statement.executeUpdate("INSERT INTO fabricacaoqueijo (receita_id, dataFabricacao, loteQueijo, coleta_id, qtdLeite, TipoProcessamento, tempoProcessamento, temperaturaProcessamento,temperaturaPreMaturacao, fermento_id, qtdFermento, tempoMaturacao, phMaturacao, temperaturaCoagulacao, qtdClCalcio, qtdCoagulante, tempoCoagulacao, phCorte,phEnformagem, phFinal, dessoragem, temperaturaDessoragem, tipoSalga, dataMaturacao, temperaturaMaturacao, dataLavagem, tipoTratamento, tempoTratamento, qtdPecas,pesoMPecas, observacoes) VALUES (2,'2019-07-02','0207196D',2,30,'Pasteurizado',30,65,36,1,1.5,60,6.71,34,14.5,21,40,6.68,6.69,0,0,0,'Nenhuma','2019-07-03',12,'2019-07-03','Outro',60,1,3000,''); ");
                    statement.executeUpdate("INSERT INTO fabricacaoqueijo (receita_id, dataFabricacao, loteQueijo, coleta_id, qtdLeite, TipoProcessamento, tempoProcessamento, temperaturaProcessamento,temperaturaPreMaturacao, fermento_id, qtdFermento, tempoMaturacao, phMaturacao, temperaturaCoagulacao, qtdClCalcio, qtdCoagulante, tempoCoagulacao, phCorte,phEnformagem, phFinal, dessoragem, temperaturaDessoragem, tipoSalga, dataMaturacao, temperaturaMaturacao, dataLavagem, tipoTratamento, tempoTratamento, qtdPecas,pesoMPecas, observacoes) VALUES (3,'2019-07-04','040719TOMME',3,31,'Leite Cru',0,0,38,2,1.5,60,6.53,0,0,18,40,6.54,0,0,0,0,'Nenhuma','2019-06-28',12,'2019-07-05','Outro',60,1,3100,'Corte com faca, adição de sal na superfície, colocado na cerveja dia 05/07'); ");
                    statement.executeUpdate("INSERT INTO fabricacaoqueijo (receita_id, dataFabricacao, loteQueijo, coleta_id, qtdLeite, TipoProcessamento, tempoProcessamento, temperaturaProcessamento,temperaturaPreMaturacao, fermento_id, qtdFermento, tempoMaturacao, phMaturacao, temperaturaCoagulacao, qtdClCalcio, qtdCoagulante, tempoCoagulacao, phCorte,phEnformagem, phFinal, dessoragem, temperaturaDessoragem, tipoSalga, dataMaturacao, temperaturaMaturacao, dataLavagem, tipoTratamento, tempoTratamento, qtdPecas,pesoMPecas, observacoes) VALUES (4,'2019-07-09','090719MB',3,30,'Pasteurizado',30,65,38,2,1.5,60,6.73,34,13.75,19.25,40,6.45,6.35,4.99,0,0,'Nenhuma','2019-07-10',12,'2019-07-11','Diário',60,3,980,'Utilização de leite de Jersey'); ");
                    statement.executeUpdate("INSERT INTO fabricacaoqueijo (receita_id, dataFabricacao, loteQueijo, coleta_id, qtdLeite, TipoProcessamento, tempoProcessamento, temperaturaProcessamento,temperaturaPreMaturacao, fermento_id, qtdFermento, tempoMaturacao, phMaturacao, temperaturaCoagulacao, qtdClCalcio, qtdCoagulante, tempoCoagulacao, phCorte,phEnformagem, phFinal, dessoragem, temperaturaDessoragem, tipoSalga, dataMaturacao, temperaturaMaturacao, dataLavagem, tipoTratamento, tempoTratamento, qtdPecas,pesoMPecas, observacoes) VALUES (5,'2019-07-11','110719',1,30,'Pasteurizado',30,65,36,3,1.5,60,6.69,34,14.5,21,40,6.72,6.7,6.52,0,0,'Salmora','2019-07-12',14,'2019-07-12','Outro',60,12,491,'10 peças de 290g + 2 peças de 1,5kg'); ");

                }

            }

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

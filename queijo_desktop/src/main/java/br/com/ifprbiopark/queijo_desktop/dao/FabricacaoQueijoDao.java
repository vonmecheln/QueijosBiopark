/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifprbiopark.queijo_desktop.dao;

import br.com.ifprbiopark.queijo_desktop.control.ControleReceitaQueijo;
import br.com.ifprbiopark.queijo_desktop.exception.db.DbException;
import br.com.ifprbiopark.queijo_desktop.exception.db.GeneratedKeysException;
import br.com.ifprbiopark.queijo_desktop.exception.db.NotExecuteInsertException;
import br.com.ifprbiopark.queijo_desktop.model.ColetaLeite;
import br.com.ifprbiopark.queijo_desktop.model.FabricacaoQueijo;
import br.com.ifprbiopark.queijo_desktop.model.Pessoa;
import br.com.ifprbiopark.queijo_desktop.model.Processamento;
import br.com.ifprbiopark.queijo_desktop.model.ReceitaQueijo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author jhona
 */
public class FabricacaoQueijoDao extends AbstractDao<FabricacaoQueijo>{
    
    @Override
    public void inserir(FabricacaoQueijo fq) throws DbException {
        try {
            
            String sql = "INSERT INTO FabricacaoQueijo( TipoQueijo_idTipoQueijo, " +
                                                        "dataFabricacao, " +
                                                        "loteQueijo, " +
                                                        "ColetaLeite_idColetaLeite, " +
                                                        "Processamento_idProcessamento, " +
                                                        "tempoProcessamento, " +
                                                        "temperaturaProcessamento, " +
                                                        "temperaturaPreMaturacao, " +
                                                        "Fermento_idFermento, " +
                                                        "qtdFermento, " +
                                                        "tempoMaturacao, " +
                                                        "phMaturacao, " +
                                                        "temperaturaCoagulacao, " +
                                                        "qtdClCalcio, " +
                                                        "qtdCoagulante, " +
                                                        "tempoCoagulacao, " +
                                                        "phCorte, " +
                                                        "phEnformagem, " +
                                                        "phFinal, " +
                                                        "dessoragem, " +
                                                        "temperaturaDessoragem, " +
                                                        "tipoSalga, " +
                                                        "dataMaturacao, " +
                                                        "temperaturaMaturacao, " +
                                                        "dataLavagem, " +
                                                        "tipoTratamento, " +
                                                        "tempoTratamento, " +
                                                        "qtdPecas, " +
                                                        "pesoMPecas, " +
                                                        "pesoTotal, " +
                                                        "observacoes, " +
                                                        "FabricacaoQueijocol, " +
                                                        "Responsavel_idResponsavel) " +
                                               "VALUES ( :TipoQueijo_idTipoQueijo, " +
                                                        ":dataFabricacao, " +
                                                        ":loteQueijo, " +
                                                        ":ColetaLeite_idColetaLeite, " +
                                                        ":Processamento_idProcessamento, " +
                                                        ":tempoProcessamento, " +
                                                        ":temperaturaProcessamento, " +
                                                        ":temperaturaPreMaturacao, " +
                                                        ":Fermento_idFermento, " +
                                                        ":qtdFermento, " +
                                                        ":tempoMaturacao, " +
                                                        ":phMaturacao, " +
                                                        ":temperaturaCoagulacao, " +
                                                        ":qtdClCalcio, " +
                                                        ":qtdCoagulante, " +
                                                        ":tempoCoagulacao, " +
                                                        ":phCorte, " +
                                                        ":phEnformagem, " +
                                                        ":phFinal, " +
                                                        ":dessoragem, " +
                                                        ":temperaturaDessoragem, " +
                                                        ":tipoSalga, " +
                                                        ":dataMaturacao, " +
                                                        ":temperaturaMaturacao, " +
                                                        ":dataLavagem, " +
                                                        ":tipoTratamento, " +
                                                        ":tempoTratamento, " +
                                                        ":qtdPecas, " +
                                                        ":pesoMPecas, " +
                                                        ":pesoTotal, " +
                                                        ":observacoes, " +
                                                        ":FabricacaoQueijocol, " +
                                                        ":Responsavel_idResponsavel) ";
            Conexao con = Conexao.getInstance();
            NamedParameterStatement nps = con.NamedParameterStatement(sql);
            nps.setInt("TipoQueijo_idTipoQueijo", fq.getTipoQueijo_idTipoQueijo().getIdTipoQueijo());
            nps.setDate("dataFabricacao", fq.getDataFabricacao());
            nps.setString("loteQueijo", fq.getLoteQueijo());
            nps.setInt("ColetaLeite_idColetaLeite", fq.getColetaLeite_idColetaLeite().getIdColetaLeite());
            nps.setInt("Processamento_idProcessamento", fq.getProcessamento_idProcessamento().getIdProcesamento());
            nps.setInt("tempoProcessamento", fq.getTempoProcessamento());
            nps.setInt("temperaturaProcessamento", fq.getTemperaturaProcessamento());
            nps.setInt("temperaturaPreMaturacao", fq.getTemperaturaPreMaturacao());
            nps.setString("Fermento_idFermento", fq.getFermento());
            nps.setDouble("qtdFermento", fq.getQtdFermento());
            nps.setInt("tempoMaturacao", fq.getTempoMaturacao());
            nps.setDouble("phMaturacao", fq.getPhMaturacao());
            nps.setInt("temperaturaCoagulacao", fq.getTemperaturaCoagulacao());
            nps.setDouble("qtdClCalcio", fq.getQtdClCalcio());
            nps.setDouble("qtdCoagulante", fq.getQtdCoagulante());
            nps.setInt("tempoCoagulacao", fq.getTempoCoagulacao());
            nps.setDouble("phCorte", fq.getPhCorte());
            nps.setDouble("phEnformagem", fq.getPhEnformagem());
            nps.setDouble("phFinal", fq.getPhFinal());
            nps.setInt("dessoragem", fq.getDessoragem()); 
            nps.setInt("temperaturaDessoragem", fq.getTemperaturaDessoragem()); 
            nps.setString("tipoSalga", fq.getTipoSalga()); 
            nps.setDate("dataMaturacao", fq.getDataMaturacao()); 
            nps.setInt("temperaturaMaturacao", fq.getTemperaturaMaturacao()); 
            nps.setDate("dataLavagem", fq.getDataLavagem()); 
            nps.setString("tipoTratamento", fq.getTipoTratamentoCasca()); 
            nps.setInt("tempoTratamento", fq.getTempoTratamento()); 
            nps.setInt("qtdPecas", fq.getQtdPecas()); 
            nps.setDouble("pesoMPecas", fq.getPesoMedioPecas()); 
            nps.setDouble("pesoTotal", fq.getPesoTotal()); 
            nps.setString("observacoes", fq.getObservacoes()); 
            nps.setString("FabricacaoQueijocol", fq.getFabricacaoQueijocol()); 
            nps.setInt("Responsavel_idResponsavel", fq.getResponsavel_idResponsavel().getIdPessoa()); 
            
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
            fq.setIdFabricacaoQueijo(key);

        } catch (SQLException ex) {
            throw new DbException(ex);
        }
    }

    @Override
    public boolean excluir(FabricacaoQueijo objeto) throws DbException {
        throw new UnsupportedOperationException("Não suportado ainda."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public FabricacaoQueijo consultar(FabricacaoQueijo objeto) throws DbException {
        throw new UnsupportedOperationException("Não suportado ainda."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public FabricacaoQueijo alterar(FabricacaoQueijo objeto) throws DbException {
        throw new UnsupportedOperationException("Não suportado ainda."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public FabricacaoQueijo consultar(int id) throws DbException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<FabricacaoQueijo> consultarListaTodos(boolean inativos) throws Exception{
        try {
            ControleReceitaQueijo crq = new ControleReceitaQueijo();

            List<FabricacaoQueijo> fabricacoes = new ArrayList<FabricacaoQueijo>();

            String sql = "SELECT idFabricacaoQueijo, " +
                                "TipoQueijo_idTipoQueijo, " +
                                "dataFabricacao, " +
                                "loteQueijo, " +
                                "ColetaLeite_idColetaLeite, " +
                                "Processamento_idProcessamento, " +
                                "tempoProcessamento, " +
                                "temperaturaProcessamento, " +
                                "temperaturaPreMaturacao, " +
                                "Fermento_idFermento, " +
                                "qtdFermento, " +
                                "tempoMaturacao, " +
                                "phMaturacao, " +
                                "temperaturaCoagulacao, " +
                                "qtdClCalcio, " +
                                "qtdCoagulante, " +
                                "tempoCoagulacao, " +
                                "phCorte, " +
                                "phEnformagem, " +
                                "phFinal, " +
                                "dessoragem, " +
                                "temperaturaDessoragem, " +
                                "tipoSalga, " +
                                "dataMaturacao, " +
                                "temperaturaMaturacao, " +
                                "dataLavagem, " +
                                "tipoTratamento, " +
                                "tempoTratamento, " +
                                "qtdPecas, " +
                                "pesoMPecas, " +
                                "pesoTotal, " +
                                "observacoes, " +
                                "FabricacaoQueijocol, " +
                                "Responsavel_idResponsavel " + 
                                "FROM fabricacaoqueijo";
            if(inativos){
                sql += " WHERE inativo = 1";
            }
            else{
                sql += " WHERE inativo = 0";
            }
            
            sql += " ORDER BY nome ASC";

            Conexao con = Conexao.getInstance();
            NamedParameterStatement nps = con.NamedParameterStatement(sql);

            ResultSet consulta = nps.executeQuery();
            while (consulta.next()) {
                FabricacaoQueijo fq = new FabricacaoQueijo();
                fq.setIdFabricacaoQueijo(consulta.getInt("idFabricacaoQueijo"));
                fq.setTipoQueijo_idTipoQueijo(crq.consultar((consulta.getInt("idFabricacaoQueijo"))));
                        

//    private String loteQueijo;
//    private ColetaLeite coletaLeite_idColetaLeite;
//    private double qtdLeiteUtilizada;
//    
//    //processamento;
//    private String tipoLeite;
//    private Integer tempoProcessamento;
//    private Integer temperaturaProcessamento;
//    private Integer temperaturaPreMaturacao;
//
//    //fermento;
//    private double qtdFermento;
//    private Integer tempoFermentacao;
//    private String fermento;
//    private String marcaFermento;
//    private Integer phPreMaturacao;
//    
//    //Coagulacao;
//    private Integer temperaturaCoagulacao;
//    private double qtdClCalcio;
//    private double qtdCoagulante;
//    private Integer tempoCoagulacao;
//    private double phCorte;
//    private double phEnformagem;
//    private Integer ph24;
//    private Integer dessoragem;
//    private Integer temperaturaDessoragem;
//    
//    //Salga;
//    private String dataSalga;
//    private String temperaturaSalga;
//    private String tempoTratamentoSalga;
//    
//    //Casca
//    private String dataTratamentoCasca;
//    private String tipoTratamentoCasca;
//    
//    
//    //Rendimento;
//    private Integer qtdPecas;
//    private double pesoTotal;
//    private double pesoMedioPecas;
//    private String LoteAcabado;
//    private Pessoa Responsavel_idResponsavel;
//    private String observacoes;
//    
//    private Integer tempoMaturacao;
//    private Date dataFabricacao;
//    private Processamento processamento_idProcessamento;
//    private double phMaturacao;
//    private double phFinal;
//    private String tipoSalga;
//    private Date dataMaturacao;
//    private Integer temperaturaMaturacao;
//    private Date dataLavagem;
//    private Integer tempoTratamento;
//    private String fabricacaoQueijocol;
//    private Integer inativo;
                        
                
                
                
                fabricacoes.add(fq);
            }
            return fabricacoes;

        } catch (Exception ex) {
            throw new Exception(ex);
        }
    }

    public List<FabricacaoQueijo> consultarTabela(int idTipoQueijo, boolean inativos) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

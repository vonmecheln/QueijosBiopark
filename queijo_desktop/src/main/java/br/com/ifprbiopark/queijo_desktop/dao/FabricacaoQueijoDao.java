/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifprbiopark.queijo_desktop.dao;

import br.com.ifprbiopark.queijo_desktop.exception.db.DbException;
import br.com.ifprbiopark.queijo_desktop.exception.db.GeneratedKeysException;
import br.com.ifprbiopark.queijo_desktop.exception.db.NotExecuteInsertException;
import br.com.ifprbiopark.queijo_desktop.model.FabricacaoQueijo;
import java.sql.ResultSet;
import java.sql.SQLException;

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
            nps.setInt("Fermento_idFermento", fq.getFermento_idFermento().getIdFermento());
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
            nps.setString("tipoTratamento", fq.getTipoTratamento()); 
            nps.setInt("tempoTratamento", fq.getTempoTratamento()); 
            nps.setInt("qtdPecas", fq.getQtdPecas()); 
            nps.setDouble("pesoMPecas", fq.getPesoMPecas()); 
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
    
}

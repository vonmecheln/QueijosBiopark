/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifprbiopark.queijo_desktop.dao;

import br.com.ifprbiopark.queijo_desktop.control.ControleColetaLeite;
import br.com.ifprbiopark.queijo_desktop.control.ControlePessoa;
import br.com.ifprbiopark.queijo_desktop.control.ControleProcessamento;
import br.com.ifprbiopark.queijo_desktop.control.ControleReceitaQueijo;
import br.com.ifprbiopark.queijo_desktop.exception.db.DbException;
import br.com.ifprbiopark.queijo_desktop.exception.db.GeneratedKeysException;
import br.com.ifprbiopark.queijo_desktop.exception.db.NotExecuteInsertException;
import br.com.ifprbiopark.queijo_desktop.model.FabricacaoQueijo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jhona
 */
public class FabricacaoQueijoDao extends AbstractDao<FabricacaoQueijo> {

    public FabricacaoQueijoDao() {
        super("fabricacaoqueijo");
    }

    @Override
    public void inserir(FabricacaoQueijo fq) throws DbException {
        try {

            String sql = "INSERT INTO FabricacaoQueijo( TipoQueijo_idTipoQueijo, "
                    + "dataFabricacao, "
                    + "loteQueijo, "
                    + "ColetaLeite_idColetaLeite, "
                    + "Processamento_idProcessamento, "
                    + "tempoProcessamento, "
                    + "temperaturaProcessamento, "
                    + "temperaturaPreMaturacao, "
                    + "Fermento_idFermento, "
                    + "qtdFermento, "
                    + "tempoMaturacao, "
                    + "phMaturacao, "
                    + "temperaturaCoagulacao, "
                    + "qtdClCalcio, "
                    + "qtdCoagulante, "
                    + "tempoCoagulacao, "
                    + "phCorte, "
                    + "phEnformagem, "
                    + "phFinal, "
                    + "dessoragem, "
                    + "temperaturaDessoragem, "
                    + "tipoSalga, "
                    + "dataMaturacao, "
                    + "temperaturaMaturacao, "
                    + "dataLavagem, "
                    + "tipoTratamento, "
                    + "tempoTratamento, "
                    + "qtdPecas, "
                    + "pesoMPecas, "
                    + "pesoTotal, "
                    + "observacoes, "
                    + "FabricacaoQueijocol, "
                    + "Responsavel_idResponsavel) "
                    + "VALUES ( :TipoQueijo_idTipoQueijo, "
                    + ":dataFabricacao, "
                    + ":loteQueijo, "
                    + ":ColetaLeite_idColetaLeite, "
                    + ":Processamento_idProcessamento, "
                    + ":tempoProcessamento, "
                    + ":temperaturaProcessamento, "
                    + ":temperaturaPreMaturacao, "
                    + ":Fermento_idFermento, "
                    + ":qtdFermento, "
                    + ":tempoMaturacao, "
                    + ":phMaturacao, "
                    + ":temperaturaCoagulacao, "
                    + ":qtdClCalcio, "
                    + ":qtdCoagulante, "
                    + ":tempoCoagulacao, "
                    + ":phCorte, "
                    + ":phEnformagem, "
                    + ":phFinal, "
                    + ":dessoragem, "
                    + ":temperaturaDessoragem, "
                    + ":tipoSalga, "
                    + ":dataMaturacao, "
                    + ":temperaturaMaturacao, "
                    + ":dataLavagem, "
                    + ":tipoTratamento, "
                    + ":tempoTratamento, "
                    + ":qtdPecas, "
                    + ":pesoMPecas, "
                    + ":pesoTotal, "
                    + ":observacoes, "
                    + ":FabricacaoQueijocol, "
                    + ":Responsavel_idResponsavel) ";
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

    public List<FabricacaoQueijo> consultarListaTodos(boolean inativos) throws Exception {
        try {
            ControleReceitaQueijo crq = new ControleReceitaQueijo();
            ControleColetaLeite ccl = new ControleColetaLeite();
            ControlePessoa cp = new ControlePessoa();
            ControleProcessamento cPros = new ControleProcessamento();

            List<FabricacaoQueijo> fabricacoes = new ArrayList<FabricacaoQueijo>();

            String sql = "SELECT idFabricacaoQueijo, "
                    + "TipoQueijo_idTipoQueijo, "
                    + "dataFabricacao, "
                    + "loteQueijo, "
                    + "ColetaLeite_idColetaLeite, "
                    + "Processamento_idProcessamento, "
                    + "tempoProcessamento, "
                    + "temperaturaProcessamento, "
                    + "temperaturaPreMaturacao, "
                    + "Fermento_idFermento, "
                    + "qtdFermento, "
                    + "tempoMaturacao, "
                    + "phMaturacao, "
                    + "temperaturaCoagulacao, "
                    + "qtdClCalcio, "
                    + "qtdCoagulante, "
                    + "tempoCoagulacao, "
                    + "phCorte, "
                    + "phEnformagem, "
                    + "phFinal, "
                    + "dessoragem, "
                    + "temperaturaDessoragem, "
                    + "tipoSalga, "
                    + "dataMaturacao, "
                    + "temperaturaMaturacao, "
                    + "dataLavagem, "
                    + "tipoTratamento, "
                    + "tempoTratamento, "
                    + "qtdPecas, "
                    + "pesoMPecas, "
                    + "pesoTotal, "
                    + "observacoes, "
                    + "FabricacaoQueijocol, "
                    + "Responsavel_idResponsavel "
                    + "FROM fabricacaoqueijo";
            if (inativos) {
                sql += " WHERE inativo = 1";
            } else {
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
                fq.setLoteQueijo(consulta.getString("loteQueijo"));
                fq.setColetaLeite_idColetaLeite(ccl.consultar(consulta.getInt("coletaLeite_idColetaLeite")));
                fq.setQtdLeiteUtilizada(consulta.getDouble("qtdLeiteUtilizada"));
                fq.setTipoLeite(consulta.getString("tipoLeite"));
                fq.setTempoProcessamento(consulta.getInt("tempoProcessamento"));
                fq.setTemperaturaProcessamento(consulta.getInt("temperaturaProcessamento"));
                fq.setTemperaturaPreMaturacao(consulta.getInt("temperaturaPreMaturacao"));
                fq.setQtdFermento(consulta.getDouble("qtdFermento"));
                fq.setTempoFermentacao(consulta.getInt("tempoFermentacao"));
                fq.setFermento(consulta.getString("fermento"));
                fq.setMarcaFermento(consulta.getString("marcaFermento"));
                fq.setPhPreMaturacao(consulta.getInt("phPreMaturacao"));
                fq.setTemperaturaCoagulacao(consulta.getInt("temperaturaCoagulacao"));
                fq.setQtdClCalcio(consulta.getDouble("qtdClCalcio"));
                fq.setQtdCoagulante(consulta.getDouble("qtdCoagulante"));
                fq.setTempoCoagulacao(consulta.getInt("tempoCoagulacao"));
                fq.setPhCorte(consulta.getDouble("phCorte"));
                fq.setPhEnformagem(consulta.getDouble("phEnformagem"));
                fq.setPh24(consulta.getInt("ph24"));
                fq.setDessoragem(consulta.getInt("dessoragem"));
                fq.setTemperaturaDessoragem(consulta.getInt("temperaturaDessoragem"));
                fq.setDataSalga(consulta.getString("dataSalga"));
                fq.setDataSalga(consulta.getString("temperaturaSalga"));
                fq.setTempoTratamentoSalga(consulta.getString("tempoTratamentoSalga"));
                fq.setDataTratamentoCasca(consulta.getString("dataTratamentoCasca"));
                fq.setTipoTratamentoCasca(consulta.getString("tipoTratamentoCasca"));
                fq.setQtdPecas(consulta.getInt("qtdPecas"));
                fq.setPesoTotal(consulta.getDouble("pesoTotal"));
                fq.setPesoMedioPecas(consulta.getDouble("pesoMedioPecas"));
                fq.setLoteAcabado(consulta.getString("LoteAcabado"));
                fq.setResponsavel_idResponsavel(cp.consultar(consulta.getInt("Responsavel_idResponsavel")));
                fq.setObservacoes(consulta.getString("observacoes"));
                fq.setTempoMaturacao(consulta.getInt("tempoMaturacao"));
                java.sql.Date d = java.sql.Date.valueOf(consulta.getString("dataFabricacao"));
                fq.setDataFabricacao(d);
                fq.setProcessamento_idProcessamento(cPros.consultar(consulta.getInt("processamento_idProcessamento")));
                fq.setPhMaturacao(consulta.getDouble("phMaturacao"));
                fq.setPhFinal(consulta.getDouble("phFinal"));
                fq.setTipoSalga(consulta.getString("tipoSalga"));
                java.sql.Date d2 = java.sql.Date.valueOf(consulta.getString("dataMaturacao"));
                fq.setDataMaturacao(d2);
                fq.setTemperaturaMaturacao(consulta.getInt("temperaturaMaturacao"));
                java.sql.Date d3 = java.sql.Date.valueOf(consulta.getString("dataLavagem"));
                fq.setDataLavagem(d3);
                fq.setTempoTratamento(consulta.getInt("tempoTratamento"));
                fq.setFabricacaoQueijocol(consulta.getString("fabricacaoQueijocol"));
                fq.setInativo(consulta.getInt("inativo"));

                fabricacoes.add(fq);
            }
            return fabricacoes;

        } catch (Exception ex) {
            throw new Exception(ex);
        }
    }

    public List<FabricacaoQueijo> consultarTabela(int idTipoQueijo, boolean inativos) throws Exception {
        try {
            ControleReceitaQueijo crq = new ControleReceitaQueijo();
            ControleColetaLeite ccl = new ControleColetaLeite();
            ControlePessoa cp = new ControlePessoa();
            ControleProcessamento cPros = new ControleProcessamento();

            List<FabricacaoQueijo> fabricacoes = new ArrayList<FabricacaoQueijo>();

            String sql = "SELECT idFabricacaoQueijo, "
                    + "TipoQueijo_idTipoQueijo, "
                    + "dataFabricacao, "
                    + "loteQueijo, "
                    + "ColetaLeite_idColetaLeite, "
                    + "Processamento_idProcessamento, "
                    + "tempoProcessamento, "
                    + "temperaturaProcessamento, "
                    + "temperaturaPreMaturacao, "
                    + "Fermento_idFermento, "
                    + "qtdFermento, "
                    + "tempoMaturacao, "
                    + "phMaturacao, "
                    + "temperaturaCoagulacao, "
                    + "qtdClCalcio, "
                    + "qtdCoagulante, "
                    + "tempoCoagulacao, "
                    + "phCorte, "
                    + "phEnformagem, "
                    + "phFinal, "
                    + "dessoragem, "
                    + "temperaturaDessoragem, "
                    + "tipoSalga, "
                    + "dataMaturacao, "
                    + "temperaturaMaturacao, "
                    + "dataLavagem, "
                    + "tipoTratamento, "
                    + "tempoTratamento, "
                    + "qtdPecas, "
                    + "pesoMPecas, "
                    + "pesoTotal, "
                    + "observacoes, "
                    + "FabricacaoQueijocol, "
                    + "Responsavel_idResponsavel "
                    + "FROM fabricacaoqueijo";
            if (inativos) {
                sql += " WHERE inativo = 1 AND TipoQueijo_idTipoQueijo = :id";
            } else {
                sql += " WHERE inativo = 0 AND TipoQueijo_idTipoQueijo = :id";
            }

            sql += " ORDER BY nome ASC";

            Conexao con = Conexao.getInstance();
            NamedParameterStatement nps = con.NamedParameterStatement(sql);

            nps.setInt("id", idTipoQueijo);

            ResultSet consulta = nps.executeQuery();
            while (consulta.next()) {
                FabricacaoQueijo fq = new FabricacaoQueijo();
                fq.setIdFabricacaoQueijo(consulta.getInt("idFabricacaoQueijo"));
                fq.setTipoQueijo_idTipoQueijo(crq.consultar((consulta.getInt("idFabricacaoQueijo"))));
                fq.setLoteQueijo(consulta.getString("loteQueijo"));
                fq.setColetaLeite_idColetaLeite(ccl.consultar(consulta.getInt("coletaLeite_idColetaLeite")));
                fq.setQtdLeiteUtilizada(consulta.getDouble("qtdLeiteUtilizada"));
                fq.setTipoLeite(consulta.getString("tipoLeite"));
                fq.setTempoProcessamento(consulta.getInt("tempoProcessamento"));
                fq.setTemperaturaProcessamento(consulta.getInt("temperaturaProcessamento"));
                fq.setTemperaturaPreMaturacao(consulta.getInt("temperaturaPreMaturacao"));
                fq.setQtdFermento(consulta.getDouble("qtdFermento"));
                fq.setTempoFermentacao(consulta.getInt("tempoFermentacao"));
                fq.setFermento(consulta.getString("fermento"));
                fq.setMarcaFermento(consulta.getString("marcaFermento"));
                fq.setPhPreMaturacao(consulta.getInt("phPreMaturacao"));
                fq.setTemperaturaCoagulacao(consulta.getInt("temperaturaCoagulacao"));
                fq.setQtdClCalcio(consulta.getDouble("qtdClCalcio"));
                fq.setQtdCoagulante(consulta.getDouble("qtdCoagulante"));
                fq.setTempoCoagulacao(consulta.getInt("tempoCoagulacao"));
                fq.setPhCorte(consulta.getDouble("phCorte"));
                fq.setPhEnformagem(consulta.getDouble("phEnformagem"));
                fq.setPh24(consulta.getInt("ph24"));
                fq.setDessoragem(consulta.getInt("dessoragem"));
                fq.setTemperaturaDessoragem(consulta.getInt("temperaturaDessoragem"));
                fq.setDataSalga(consulta.getString("dataSalga"));
                fq.setDataSalga(consulta.getString("temperaturaSalga"));
                fq.setTempoTratamentoSalga(consulta.getString("tempoTratamentoSalga"));
                fq.setDataTratamentoCasca(consulta.getString("dataTratamentoCasca"));
                fq.setTipoTratamentoCasca(consulta.getString("tipoTratamentoCasca"));
                fq.setQtdPecas(consulta.getInt("qtdPecas"));
                fq.setPesoTotal(consulta.getDouble("pesoTotal"));
                fq.setPesoMedioPecas(consulta.getDouble("pesoMedioPecas"));
                fq.setLoteAcabado(consulta.getString("LoteAcabado"));
                fq.setResponsavel_idResponsavel(cp.consultar(consulta.getInt("Responsavel_idResponsavel")));
                fq.setObservacoes(consulta.getString("observacoes"));
                fq.setTempoMaturacao(consulta.getInt("tempoMaturacao"));
                java.sql.Date d = java.sql.Date.valueOf(consulta.getString("dataFabricacao"));
                fq.setDataFabricacao(d);
                fq.setProcessamento_idProcessamento(cPros.consultar(consulta.getInt("processamento_idProcessamento")));
                fq.setPhMaturacao(consulta.getDouble("phMaturacao"));
                fq.setPhFinal(consulta.getDouble("phFinal"));
                fq.setTipoSalga(consulta.getString("tipoSalga"));
                java.sql.Date d2 = java.sql.Date.valueOf(consulta.getString("dataMaturacao"));
                fq.setDataMaturacao(d2);
                fq.setTemperaturaMaturacao(consulta.getInt("temperaturaMaturacao"));
                java.sql.Date d3 = java.sql.Date.valueOf(consulta.getString("dataLavagem"));
                fq.setDataLavagem(d3);
                fq.setTempoTratamento(consulta.getInt("tempoTratamento"));
                fq.setFabricacaoQueijocol(consulta.getString("fabricacaoQueijocol"));
                fq.setInativo(consulta.getInt("inativo"));

                fabricacoes.add(fq);
            }
            return fabricacoes;

        } catch (Exception ex) {
            throw new Exception(ex);
        }
    }
}

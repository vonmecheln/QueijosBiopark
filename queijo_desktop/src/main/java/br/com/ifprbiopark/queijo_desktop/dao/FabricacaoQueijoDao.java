package br.com.ifprbiopark.queijo_desktop.dao;

import br.com.ifprbiopark.queijo_desktop.control.ControleColetaLeite;
import br.com.ifprbiopark.queijo_desktop.control.ControleFermento;
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
import java.util.Arrays;
import java.util.List;

public class FabricacaoQueijoDao extends AbstractDao<FabricacaoQueijo> {

    public FabricacaoQueijoDao() throws DbException {
        super("fabricacaoqueijo", new ArrayList<>(Arrays.asList(
                "idFabricacaoQueijo",
                "receita_id",
                "dataFabricacao",
                "loteQueijo",
                "coleta_id",
                "qtdLeite",
                "tipoLeite",
                "tempoProcessamento",
                "temperaturaProcessamento",
                "temperaturaPreMaturacao",
                "phMaturacao",
                "fermento_id",
                "qtdFermento",
                "tempoFermentacao",
                "temperaturaCoagulacao",
                "qtdClCalcio",
                "qtdCoagulante",
                "tempoCoagulacao",
                "phCorte",
                "phEnformagem",
                "phFinal",
                "dessoragem",
                "temperaturaDessoragem",
                "tipoSalga",
                "dataMaturacao",
                "temperaturaMaturacao",
                "dataLavagem",
                "tipoTratamento",
                "tempoTratamento",
                "qtdPecas",
                "pesoMPecas",
                "observacoes",
                "loteAcabado",
                "responsavel_id",
                "inativo" 
        )));
    }

    @Override
    protected void confStantement(NamedParameterStatement nps, FabricacaoQueijo objeto) throws SQLException {

        nps.setInt("receita_id", nullId(objeto.getReceitaQueijo()));
        
        //informacoes basicas de processamento;
        nps.setDate("dataFabricacao", nullDate(objeto.getDataFabricacao()));
        nps.setString("loteQueijo", objeto.getLoteQueijo());
        nps.setInt("coleta_id", nullId(objeto.getColetaLeite()));        
        nps.setDouble("qtdLeite", nullDouble(objeto.getQtdLeite()));
        
        //processamento
        nps.setString("tipoLeite", objeto.getTipoLeite());
        nps.setInt("tempoProcessamento", nullInt(objeto.getTempoProcessamento()));
        nps.setInt("temperaturaProcessamento", nullInt(objeto.getTemperaturaProcessamento()));
        
        //Prematuração
        nps.setInt("temperaturaPreMaturacao", nullInt(objeto.getTemperaturaPreMaturacao()));
        nps.setDouble("phMaturacao", objeto.getPhPreMaturacao());
        
        //fermento
        nps.setInt("fermento_id", objeto.getFermento().getId());
        nps.setDouble("qtdFermento", objeto.getQtdFermento());
        nps.setDouble("tempoFermentacao", objeto.getTempoFermentacao());
        
        //caogulação
        nps.setInt("temperaturaCoagulacao", objeto.getTemperaturaCoagulacao());
        nps.setDouble("qtdClCalcio", objeto.getQtdClCalcio());
        nps.setDouble("qtdCoagulante", objeto.getQtdCoagulante());
        nps.setInt("tempoCoagulacao", objeto.getTempoCoagulacao());
        nps.setDouble("phCorte", objeto.getPhCorte());
        nps.setDouble("phEnformagem", objeto.getPhEnformagem());
        nps.setDouble("phFinal", objeto.getPh24());
        nps.setInt("dessoragem", objeto.getDessoragem());
        nps.setInt("temperaturaDessoragem", objeto.getTemperaturaDessoragem());
        
        //salga
        nps.setString("tipoSalga", objeto.getTipoSalga());
        
        //maturação
        nps.setDate("dataMaturacao", objeto.getDataMaturacao());
        nps.setInt("temperaturaMaturacao", objeto.getTemperaturaMaturacao());
        
        //tratamento da casca
        nps.setDate("dataLavagem", objeto.getDataLavagem());
        nps.setString("tipoTratamento", objeto.getTipoTratamento());
        nps.setInt("tempoTratamento", objeto.getTempoTratamento());
        
        //rendimento
        nps.setInt("qtdPecas", objeto.getQtdPecas());
        nps.setDouble("pesoMPecas", objeto.getPesoMedioPecas());
        nps.setDouble("pesoTotal", objeto.getPesoTotal());
        
        //observações
        nps.setString("observacoes", objeto.getObservacoes());
        
        //finalizção
        nps.setString("loteAcabado", objeto.getLoteAcabado());
        nps.setInt("responsavel_id", objeto.getResponsavel().getId());
        nps.setInt("inativo", objeto.getInativo());        
    }

    @Override
    public void inserir(FabricacaoQueijo fq) throws DbException {
        inserirDefault(fq);
    }

    public void inserir2(FabricacaoQueijo fq) throws DbException {
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

            NamedParameterStatement nps = con.NamedParameterStatement(sql);
            nps.setInt("TipoQueijo_idTipoQueijo", fq.getReceitaQueijo().getIdTipoQueijo());
            nps.setDate("dataFabricacao", fq.getDataFabricacao());
            nps.setString("loteQueijo", fq.getLoteQueijo());
            nps.setInt("ColetaLeite_idColetaLeite", fq.getColetaLeite().getIdColetaLeite());
            //nps.setInt("Processamento_idProcessamento", fq.getProcessamento_idProcessamento().getIdProcesamento());
            nps.setInt("tempoProcessamento", fq.getTempoProcessamento());
            nps.setInt("temperaturaProcessamento", fq.getTemperaturaProcessamento());
            nps.setInt("temperaturaPreMaturacao", fq.getTemperaturaPreMaturacao());
            //nps.setString("Fermento_idFermento", fq.getFermento());
            nps.setDouble("qtdFermento", fq.getQtdFermento());
            //nps.setInt("tempoMaturacao", fq.getTempoMaturacao());
            //nps.setDouble("phMaturacao", fq.getPhMaturacao());
            nps.setInt("temperaturaCoagulacao", fq.getTemperaturaCoagulacao());
            nps.setDouble("qtdClCalcio", fq.getQtdClCalcio());
            nps.setDouble("qtdCoagulante", fq.getQtdCoagulante());
            nps.setInt("tempoCoagulacao", fq.getTempoCoagulacao());
            nps.setDouble("phCorte", fq.getPhCorte());
            nps.setDouble("phEnformagem", fq.getPhEnformagem());
            //nps.setDouble("phFinal", fq.getPhFinal());
            nps.setInt("dessoragem", fq.getDessoragem());
            nps.setInt("temperaturaDessoragem", fq.getTemperaturaDessoragem());
            nps.setString("tipoSalga", fq.getTipoSalga());
            nps.setDate("dataMaturacao", fq.getDataMaturacao());
            nps.setInt("temperaturaMaturacao", fq.getTemperaturaMaturacao());
            nps.setDate("dataLavagem", fq.getDataLavagem());
            //nps.setString("tipoTratamento", fq.getTipoTratamentoCasca());
            nps.setInt("tempoTratamento", fq.getTempoTratamento());
            nps.setInt("qtdPecas", fq.getQtdPecas());
            nps.setDouble("pesoMPecas", fq.getPesoMedioPecas());
            nps.setDouble("pesoTotal", fq.getPesoTotal());
            nps.setString("observacoes", fq.getObservacoes());
            //nps.setString("FabricacaoQueijocol", fq.getFabricacaoQueijocol());
            nps.setInt("Responsavel_idResponsavel", fq.getResponsavel().getIdPessoa());

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
        return excluirDefault(objeto);
    }

    @Override
    public FabricacaoQueijo alterar(FabricacaoQueijo objeto) throws DbException {
        alterarDefault(objeto);
        return objeto;
    }

    @Override
    public FabricacaoQueijo consultar(FabricacaoQueijo objeto) throws DbException {
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
            ControleFermento cf = new ControleFermento();

            List<FabricacaoQueijo> fabricacoes = new ArrayList<FabricacaoQueijo>();

            String sql = "SELECT idFabricacaoQueijo,"
                    + " receita_id,"
                    + " dataFabricacao,"
                    + " loteQueijo,"
                    + " coleta_id,"
                    + " qtdLeite,"
                    + " tipoLeite,"
                    + " tempoProcessamento,"
                    + " temperaturaProcessamento,"
                    + " temperaturaPreMaturacao,"
                    + " phMaturacao,"
                    + " fermento_id,"
                    + " qtdFermento,"
                    + " tempoFermentacao,"
                    + " temperaturaCoagulacao,"
                    + " qtdClCalcio,"
                    + " qtdCoagulante,"
                    + " tempoCoagulacao,"
                    + " phCorte,"
                    + " phEnformagem,"
                    + " phFinal,"
                    + " dessoragem,"
                    + " temperaturaDessoragem,"
                    + " tipoSalga,"
                    + " dataMaturacao,"
                    + " temperaturaMaturacao,"
                    + " dataLavagem,"
                    + " tipoTratamento,"
                    + " tempoTratamento,"
                    + " qtdPecas,"
                    + " pesoMPecas,"
                    + " observacoes,"
                    + " loteAcabado,"
                    + " responsavel_id,"
                    + " inativo ";
            if (inativos) {
                sql += " WHERE inativo = 1";
            } else {
                sql += " WHERE inativo = 0";
            }

            NamedParameterStatement nps = con.NamedParameterStatement(sql);

            ResultSet consulta = nps.executeQuery();
            while (consulta.next()) {
                FabricacaoQueijo fq = new FabricacaoQueijo();
                fq.setIdFabricacaoQueijo(consulta.getInt("idFabricacaoQueijo"));
                //informacoes basicas de processamento;
                fq.setReceitaQueijo(crq.consultar((consulta.getInt("receita_id"))));
                fq.setDataFabricacao(consulta.getDate("dataFabricacao"));
                fq.setLoteQueijo(consulta.getString("loteQueijo"));
                fq.setColetaLeite(ccl.consultar(consulta.getInt("coleta_id")));
                fq.setQtdLeite(consulta.getDouble("qtdLeite"));
                //processamento                
                fq.setTipoLeite(consulta.getString("tipoLeite"));
                fq.setTempoProcessamento(consulta.getInt("tempoProcessamento"));
                fq.setTemperaturaProcessamento(consulta.getInt("temperaturaProcessamento"));
                //Prematuracao
                fq.setTemperaturaPreMaturacao(consulta.getInt("temperaturaPreMaturacao"));
                fq.setPhPreMaturacao(consulta.getDouble("phMaturacao"));
                //fermento
                fq.setFermento(cf.consultar(consulta.getInt("fermento_id")));
                fq.setQtdFermento(consulta.getDouble("qtdFermento"));
                fq.setTempoFermentacao(consulta.getInt("tempoFermentacao"));
                //coagulação
                fq.setTemperaturaCoagulacao(consulta.getInt("temperaturaCoagulacao"));
                fq.setQtdClCalcio(consulta.getDouble("qtdClCalcio"));
                fq.setQtdCoagulante(consulta.getDouble("qtdCoagulante"));
                fq.setTempoCoagulacao(consulta.getInt("tempoCoagulacao"));
                fq.setPhCorte(consulta.getDouble("phCorte"));
                fq.setPhEnformagem(consulta.getDouble("phEnformagem"));
                fq.setPh24(consulta.getInt("phFinal"));
                fq.setDessoragem(consulta.getInt("dessoragem"));
                fq.setTemperaturaDessoragem(consulta.getInt("temperaturaDessoragem"));
                //salga
                fq.setTipoSalga(consulta.getString("tipoSalga"));
                //maturação
                fq.setDataMaturacao(consulta.getDate("dataMaturacao"));
                fq.setTemperaturaMaturacao(consulta.getInt("temperaturaMaturacao"));
                //tratamento da casca
                fq.setDataLavagem(consulta.getDate("dataLavagem"));
                fq.setTipoTratamento(consulta.getString("tipoTratamento"));
                fq.setTempoTratamento(consulta.getInt("tempoTratamento"));
                //rendimento
                fq.setQtdPecas(consulta.getInt("qtdPecas"));
                fq.setPesoMedioPecas(consulta.getDouble("pesoMPecas"));
                fq.setPesoTotal(consulta.getDouble("pesoTotal"));
                //observações
                fq.setObservacoes(consulta.getString("observacoes"));
                //finalização
                fq.setLoteAcabado(consulta.getString("loteAcabado"));
                fq.setResponsavel(cp.consultar(consulta.getInt("responsavel_id")));
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
            ControleFermento cf = new ControleFermento();

            List<FabricacaoQueijo> fabricacoes = new ArrayList<FabricacaoQueijo>();

            String sql = "SELECT idFabricacaoQueijo,"
                    + " receita_id,"
                    + " dataFabricacao,"
                    + " loteQueijo,"
                    + " coleta_id,"
                    + " qtdLeite,"
                    + " tipoLeite,"
                    + " tempoProcessamento,"
                    + " temperaturaProcessamento,"
                    + " temperaturaPreMaturacao,"
                    + " phMaturacao,"
                    + " fermento_id,"
                    + " qtdFermento,"
                    + " tempoFermentacao,"
                    + " temperaturaCoagulacao,"
                    + " qtdClCalcio,"
                    + " qtdCoagulante,"
                    + " tempoCoagulacao,"
                    + " phCorte,"
                    + " phEnformagem,"
                    + " phFinal,"
                    + " dessoragem,"
                    + " temperaturaDessoragem,"
                    + " tipoSalga,"
                    + " dataMaturacao,"
                    + " temperaturaMaturacao,"
                    + " dataLavagem,"
                    + " tipoTratamento,"
                    + " tempoTratamento,"
                    + " qtdPecas,"
                    + " pesoMPecas,"
                    + " observacoes,"
                    + " loteAcabado,"
                    + " responsavel_id,"
                    + " inativo ";
            if (inativos) {
                sql += " WHERE inativo = 1 AND receita_id = :id";
            } else {
                sql += " WHERE inativo = 0 AND receita_id = :id";
            }

            NamedParameterStatement nps = con.NamedParameterStatement(sql);

            nps.setInt("id", idTipoQueijo);

            ResultSet consulta = nps.executeQuery();
            while (consulta.next()) {
                FabricacaoQueijo fq = new FabricacaoQueijo();
                fq.setIdFabricacaoQueijo(consulta.getInt("idFabricacaoQueijo"));
                //informacoes basicas de processamento;
                fq.setReceitaQueijo(crq.consultar((consulta.getInt("receita_id"))));
                fq.setDataFabricacao(consulta.getDate("dataFabricacao"));
                fq.setLoteQueijo(consulta.getString("loteQueijo"));
                fq.setColetaLeite(ccl.consultar(consulta.getInt("coleta_id")));
                fq.setQtdLeite(consulta.getDouble("qtdLeite"));
                //processamento                
                fq.setTipoLeite(consulta.getString("tipoLeite"));
                fq.setTempoProcessamento(consulta.getInt("tempoProcessamento"));
                fq.setTemperaturaProcessamento(consulta.getInt("temperaturaProcessamento"));
                //Prematuracao
                fq.setTemperaturaPreMaturacao(consulta.getInt("temperaturaPreMaturacao"));
                fq.setPhPreMaturacao(consulta.getDouble("phMaturacao"));
                //fermento
                fq.setFermento(cf.consultar(consulta.getInt("fermento_id")));
                fq.setQtdFermento(consulta.getDouble("qtdFermento"));
                fq.setTempoFermentacao(consulta.getInt("tempoFermentacao"));
                //coagulação
                fq.setTemperaturaCoagulacao(consulta.getInt("temperaturaCoagulacao"));
                fq.setQtdClCalcio(consulta.getDouble("qtdClCalcio"));
                fq.setQtdCoagulante(consulta.getDouble("qtdCoagulante"));
                fq.setTempoCoagulacao(consulta.getInt("tempoCoagulacao"));
                fq.setPhCorte(consulta.getDouble("phCorte"));
                fq.setPhEnformagem(consulta.getDouble("phEnformagem"));
                fq.setPh24(consulta.getInt("phFinal"));
                fq.setDessoragem(consulta.getInt("dessoragem"));
                fq.setTemperaturaDessoragem(consulta.getInt("temperaturaDessoragem"));
                //salga
                fq.setTipoSalga(consulta.getString("tipoSalga"));
                //maturação
                fq.setDataMaturacao(consulta.getDate("dataMaturacao"));
                fq.setTemperaturaMaturacao(consulta.getInt("temperaturaMaturacao"));
                //tratamento da casca
                fq.setDataLavagem(consulta.getDate("dataLavagem"));
                fq.setTipoTratamento(consulta.getString("tipoTratamento"));
                fq.setTempoTratamento(consulta.getInt("tempoTratamento"));
                //rendimento
                fq.setQtdPecas(consulta.getInt("qtdPecas"));
                fq.setPesoMedioPecas(consulta.getDouble("pesoMPecas"));
                fq.setPesoTotal(consulta.getDouble("pesoTotal"));
                //observações
                fq.setObservacoes(consulta.getString("observacoes"));
                //finalização
                fq.setLoteAcabado(consulta.getString("loteAcabado"));
                fq.setResponsavel(cp.consultar(consulta.getInt("responsavel_id")));
                fq.setInativo(consulta.getInt("inativo"));

                fabricacoes.add(fq);
            }
            return fabricacoes;

        } catch (Exception ex) {
            throw new Exception(ex);
        }
    }
}

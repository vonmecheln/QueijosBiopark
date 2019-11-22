
package br.com.ifprbiopark.queijo_desktop.model;

import java.util.Date;


public class FabricacaoQueijo {
    
    private Integer idFabricacaoQueijo;
    
    //informacoes basicas de processamento;
    private ReceitaQueijo tipoQueijo_idTipoQueijo;
    private String loteQueijo;
    private ColetaLeite coletaLeite_idColetaLeite;
    private double qtdLeiteUtilizada;
    
    //processamento;
    private String tipoLeite;
    private Integer tempoProcessamento;
    private Integer temperaturaProcessamento;
    private Integer temperaturaPreMaturacao;

    //fermento;
    private double qtdFermento;
    private Integer tempoFermentacao;
    private Fermento fermento_idFermento;
    private String marcaFermento;
    private Integer phPreMaturacao;
    
    private Integer tempoMaturacao;
    private Date dataFabricacao;
    private Processamento processamento_idProcessamento;
    private double phMaturacao;
    private Integer temperaturaCoagulacao;
    private double qtdClCalcio;
    private double qtdCoagulante;
    private Integer tempoCoagulacao;
    private double phCorte;
    private double phEnformagem;
    private double phFinal;
    private Integer dessoragem;
    private Integer temperaturaDessoragem;
    private String tipoSalga;
    private Date dataMaturacao;
    private Integer temperaturaMaturacao;
    private Date dataLavagem;
    private String tipoTratamento;
    private Integer tempoTratamento;
    private Integer qtdPecas;
    private double pesoMPecas;
    private double pesoTotal;
    private String observacoes;
    private String fabricacaoQueijocol;
    private Pessoa Responsavel_idResponsavel;

    public Pessoa getResponsavel_idResponsavel() {
        return Responsavel_idResponsavel;
    }

    public void setResponsavel_idResponsavel(Pessoa Responsavel_idResponsavel) {
        this.Responsavel_idResponsavel = Responsavel_idResponsavel;
    }

    public Integer getIdFabricacaoQueijo() {
        return idFabricacaoQueijo;
    }

    public void setIdFabricacaoQueijo(Integer idFabricacaoQueijo) {
        this.idFabricacaoQueijo = idFabricacaoQueijo;
    }

    public ReceitaQueijo getTipoQueijo_idTipoQueijo() {
        return tipoQueijo_idTipoQueijo;
    }

    public void setTipoQueijo_idTipoQueijo(ReceitaQueijo tipoQueijo_idTipoQueijo) {
        this.tipoQueijo_idTipoQueijo = tipoQueijo_idTipoQueijo;
    }

    public Date getDataFabricacao() {
        return dataFabricacao;
    }

    public void setDataFabricacao(Date dataFabricacao) {
        this.dataFabricacao = dataFabricacao;
    }

    public String getLoteQueijo() {
        return loteQueijo;
    }

    public void setLoteQueijo(String loteQueijo) {
        this.loteQueijo = loteQueijo;
    }

    public ColetaLeite getColetaLeite_idColetaLeite() {
        return coletaLeite_idColetaLeite;
    }

    public void setColetaLeite_idColetaLeite(ColetaLeite coletaLeite_idColetaLeite) {
        this.coletaLeite_idColetaLeite = coletaLeite_idColetaLeite;
    }

    public Processamento getProcessamento_idProcessamento() {
        return processamento_idProcessamento;
    }

    public void setProcessamento_idProcessamento(Processamento processamento_idProcessamento) {
        this.processamento_idProcessamento = processamento_idProcessamento;
    }

    public Integer getTempoProcessamento() {
        return tempoProcessamento;
    }

    public void setTempoProcessamento(Integer tempoProcessamento) {
        this.tempoProcessamento = tempoProcessamento;
    }

    public Integer getTemperaturaProcessamento() {
        return temperaturaProcessamento;
    }

    public void setTemperaturaProcessamento(Integer temperaturaProcessamento) {
        this.temperaturaProcessamento = temperaturaProcessamento;
    }

    public Integer getTemperaturaPreMaturacao() {
        return temperaturaPreMaturacao;
    }

    public void setTemperaturaPreMaturacao(Integer temperaturaPreMaturacao) {
        this.temperaturaPreMaturacao = temperaturaPreMaturacao;
    }

    public Fermento getFermento_idFermento() {
        return fermento_idFermento;
    }

    public void setFermento_idFermento(Fermento fermento_idFermento) {
        this.fermento_idFermento = fermento_idFermento;
    }

    public double getQtdFermento() {
        return qtdFermento;
    }

    public void setQtdFermento(double qtdFermento) {
        this.qtdFermento = qtdFermento;
    }

    public Integer getTempoMaturacao() {
        return tempoMaturacao;
    }

    public void setTempoMaturacao(Integer tempoMaturacao) {
        this.tempoMaturacao = tempoMaturacao;
    }

    public double getPhMaturacao() {
        return phMaturacao;
    }

    public void setPhMaturacao(double phMaturacao) {
        this.phMaturacao = phMaturacao;
    }

    public Integer getTemperaturaCoagulacao() {
        return temperaturaCoagulacao;
    }

    public void setTemperaturaCoagulacao(Integer temperaturaCoagulacao) {
        this.temperaturaCoagulacao = temperaturaCoagulacao;
    }

    public double getQtdClCalcio() {
        return qtdClCalcio;
    }

    public void setQtdClCalcio(double qtdClCalcio) {
        this.qtdClCalcio = qtdClCalcio;
    }

    public double getQtdCoagulante() {
        return qtdCoagulante;
    }

    public void setQtdCoagulante(double qtdCoagulante) {
        this.qtdCoagulante = qtdCoagulante;
    }

    public Integer getTempoCoagulacao() {
        return tempoCoagulacao;
    }

    public void setTempoCoagulacao(Integer tempoCoagulacao) {
        this.tempoCoagulacao = tempoCoagulacao;
    }

    public double getPhCorte() {
        return phCorte;
    }

    public void setPhCorte(double phCorte) {
        this.phCorte = phCorte;
    }

    public double getPhEnformagem() {
        return phEnformagem;
    }

    public void setPhEnformagem(double phEnformagem) {
        this.phEnformagem = phEnformagem;
    }

    public double getPhFinal() {
        return phFinal;
    }

    public void setPhFinal(double phFinal) {
        this.phFinal = phFinal;
    }

    public Integer getDessoragem() {
        return dessoragem;
    }

    public void setDessoragem(Integer dessoragem) {
        this.dessoragem = dessoragem;
    }

    public Integer getTemperaturaDessoragem() {
        return temperaturaDessoragem;
    }

    public void setTemperaturaDessoragem(Integer temperaturaDessoragem) {
        this.temperaturaDessoragem = temperaturaDessoragem;
    }

    public String getTipoSalga() {
        return tipoSalga;
    }

    public void setTipoSalga(String tipoSalga) {
        this.tipoSalga = tipoSalga;
    }

    public Date getDataMaturacao() {
        return dataMaturacao;
    }

    public void setDataMaturacao(Date dataMaturacao) {
        this.dataMaturacao = dataMaturacao;
    }

    public Integer getTemperaturaMaturacao() {
        return temperaturaMaturacao;
    }

    public void setTemperaturaMaturacao(Integer temperaturaMaturacao) {
        this.temperaturaMaturacao = temperaturaMaturacao;
    }

    public Date getDataLavagem() {
        return dataLavagem;
    }

    public void setDataLavagem(Date dataLavagem) {
        this.dataLavagem = dataLavagem;
    }

    public String getTipoTratamento() {
        return tipoTratamento;
    }

    public void setTipoTratamento(String tipoTratamento) {
        this.tipoTratamento = tipoTratamento;
    }

    public Integer getTempoTratamento() {
        return tempoTratamento;
    }

    public void setTempoTratamento(Integer tempoTratamento) {
        this.tempoTratamento = tempoTratamento;
    }

    public Integer getQtdPecas() {
        return qtdPecas;
    }

    public void setQtdPecas(Integer qtdPecas) {
        this.qtdPecas = qtdPecas;
    }

    public double getPesoMPecas() {
        return pesoMPecas;
    }

    public void setPesoMPecas(double pesoMPecas) {
        this.pesoMPecas = pesoMPecas;
    }

    public double getPesoTotal() {
        return pesoTotal;
    }

    public void setPesoTotal(double pesoTotal) {
        this.pesoTotal = pesoTotal;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public String getFabricacaoQueijocol() {
        return fabricacaoQueijocol;
    }

    public void setFabricacaoQueijocol(String fabricacaoQueijocol) {
        this.fabricacaoQueijocol = fabricacaoQueijocol;
    }

    public double getQtdLeiteUtilizada() {
        return qtdLeiteUtilizada;
    }

    public void setQtdLeiteUtilizada(double qtdLeiteUtilizada) {
        this.qtdLeiteUtilizada = qtdLeiteUtilizada;
    }

    public String getTipoLeite() {
        return tipoLeite;
    }

    public void setTipoLeite(String tipoLeite) {
        this.tipoLeite = tipoLeite;
    }

    public Integer getTempoFermentacao() {
        return tempoFermentacao;
    }

    public void setTempoFermentacao(Integer tempoFermentacao) {
        this.tempoFermentacao = tempoFermentacao;
    }

    public String getMarcaFermento() {
        return marcaFermento;
    }

    public void setMarcaFermento(String marcaFermento) {
        this.marcaFermento = marcaFermento;
    }

    public Integer getPhPreMaturacao() {
        return phPreMaturacao;
    }

    public void setPhPreMaturacao(Integer phPreMaturacao) {
        this.phPreMaturacao = phPreMaturacao;
    }
    
    
    
}

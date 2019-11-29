package br.com.ifprbiopark.queijo_desktop.model;

import java.util.Date;

public class FabricacaoQueijo extends AbstractModel {

    private Integer idFabricacaoQueijo;

    //informacoes basicas de processamento;
    private ReceitaQueijo receitaQueijo;
    private Date dataFabricacao;
    private String loteQueijo;
    private ColetaLeite coletaLeite;
    private Double qtdLeite;

    //processamento;
    private String tipoLeite;
    private Integer tempoProcessamento;
    private Integer temperaturaProcessamento;

    //Prematuração
    private Integer temperaturaPreMaturacao;
    private Double phPreMaturacao;
        //fermento;
        private Fermento fermento;
        private Double qtdFermento;
        private Integer tempoFermentacao;    

    //Coagulacao;
    private Integer temperaturaCoagulacao;
    private Double qtdClCalcio;
    private Double qtdCoagulante;
    private Integer tempoCoagulacao;
    private Double phCorte;
    private Double phEnformagem;
    private Integer ph24;
    private Integer dessoragem;
    private Integer temperaturaDessoragem;
    //Salga
    private String tipoSalga;

    //Maturação    
    private Date dataMaturacao;
    private Integer temperaturaMaturacao;
    //Tratamento da casca    
    private Date dataLavagem;
    private String tipoTratamento;
    private Integer tempoTratamento;

    //Rendimento;
    private Integer qtdPecas;
    private Double pesoMedioPecas;
    private Double pesoTotal;

    //Obeservações
    private String observacoes;

    //Finalização
    private String loteAcabado;
    private Pessoa responsavel;
    private Integer inativo;

    public Integer getInativo() {
        return inativo;
    }

    public void setInativo(Integer inativo) {
        this.inativo = inativo;
    }

    public Integer getIdFabricacaoQueijo() {
        return idFabricacaoQueijo;
    }

    public void setIdFabricacaoQueijo(Integer idFabricacaoQueijo) {
        this.idFabricacaoQueijo = idFabricacaoQueijo;
    }

    public ReceitaQueijo getReceitaQueijo() {
        return receitaQueijo;
    }

    public void setReceitaQueijo(ReceitaQueijo receitaQueijo) {
        this.receitaQueijo = receitaQueijo;
    }

    public String getLoteQueijo() {
        return loteQueijo;
    }

    public void setLoteQueijo(String loteQueijo) {
        this.loteQueijo = loteQueijo;
    }

    public ColetaLeite getColetaLeite() {
        return coletaLeite;
    }

    public void setColetaLeite(ColetaLeite coletaLeite) {
        this.coletaLeite = coletaLeite;
    }

    public Double getQtdLeite() {
        return qtdLeite;
    }

    public void setQtdLeite(Double qtdLeite) {
        this.qtdLeite = qtdLeite;
    }

    public String getTipoLeite() {
        return tipoLeite;
    }

    public void setTipoLeite(String tipoLeite) {
        this.tipoLeite = tipoLeite;
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

    public Double getQtdFermento() {
        return qtdFermento;
    }

    public void setQtdFermento(Double qtdFermento) {
        this.qtdFermento = qtdFermento;
    }

    public Integer getTempoFermentacao() {
        return tempoFermentacao;
    }

    public void setTempoFermentacao(Integer tempoFermentacao) {
        this.tempoFermentacao = tempoFermentacao;
    }

    public Double getPhPreMaturacao() {
        return phPreMaturacao;
    }

    public void setPhPreMaturacao(Double phPreMaturacao) {
        this.phPreMaturacao = phPreMaturacao;
    }

    public Integer getTemperaturaCoagulacao() {
        return temperaturaCoagulacao;
    }

    public void setTemperaturaCoagulacao(Integer temperaturaCoagulacao) {
        this.temperaturaCoagulacao = temperaturaCoagulacao;
    }

    public Double getQtdClCalcio() {
        return qtdClCalcio;
    }

    public void setQtdClCalcio(Double qtdClCalcio) {
        this.qtdClCalcio = qtdClCalcio;
    }

    public Double getQtdCoagulante() {
        return qtdCoagulante;
    }

    public void setQtdCoagulante(Double qtdCoagulante) {
        this.qtdCoagulante = qtdCoagulante;
    }

    public Integer getTempoCoagulacao() {
        return tempoCoagulacao;
    }

    public void setTempoCoagulacao(Integer tempoCoagulacao) {
        this.tempoCoagulacao = tempoCoagulacao;
    }

    public Double getPhCorte() {
        return phCorte;
    }

    public void setPhCorte(Double phCorte) {
        this.phCorte = phCorte;
    }

    public Double getPhEnformagem() {
        return phEnformagem;
    }

    public void setPhEnformagem(Double phEnformagem) {
        this.phEnformagem = phEnformagem;
    }

    public Integer getPh24() {
        return ph24;
    }

    public void setPh24(Integer ph24) {
        this.ph24 = ph24;
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

    public Pessoa getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(Pessoa responsavel) {
        this.responsavel = responsavel;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public Date getDataFabricacao() {
        return dataFabricacao;
    }

    public void setDataFabricacao(Date dataFabricacao) {
        this.dataFabricacao = dataFabricacao;
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

    public Integer getTempoTratamento() {
        return tempoTratamento;
    }

    public void setTempoTratamento(Integer tempoTratamento) {
        this.tempoTratamento = tempoTratamento;
    }

    @Override
    public Integer getId() {
        return getIdFabricacaoQueijo() != null ? getIdFabricacaoQueijo() : 0;
    }

    @Override
    public void setId(Integer id) {
        setIdFabricacaoQueijo(id);
    }

    public Fermento getFermento() {
        return fermento;
    }

    public void setFermento(Fermento fermento) {
        this.fermento = fermento;
    }

    public String getTipoTratamento() {
        return tipoTratamento;
    }

    public void setTipoTratamento(String tipoTratamento) {
        this.tipoTratamento = tipoTratamento;
    }

    public Integer getQtdPecas() {
        return qtdPecas;
    }

    public void setQtdPecas(Integer qtdPecas) {
        this.qtdPecas = qtdPecas;
    }

    public Double getPesoMedioPecas() {
        return pesoMedioPecas;
    }

    public void setPesoMedioPecas(Double pesoMedioPecas) {
        this.pesoMedioPecas = pesoMedioPecas;
    }

    public Double getPesoTotal() {
        return pesoTotal;
    }

    public void setPesoTotal(Double pesoTotal) {
        this.pesoTotal = pesoTotal;
    }

    public String getLoteAcabado() {
        return loteAcabado;
    }

    public void setLoteAcabado(String loteAcabado) {
        this.loteAcabado = loteAcabado;
    }

}

package br.com.ifprbiopark.queijo_desktop.model;

import java.util.Date;

public class EntregaLeite extends AbstractModel {

    private Integer idEntregaLeite;
    private Date data;
    private double litros;
    private double gordura;
    private double proteina;
    private double ph;
    private double acidez;
    private String situacao;
    private Pessoa fornecedor;

    public Integer getIdEntregaLeite() {
        return idEntregaLeite;
    }

    public void setIdEntregaLeite(Integer idEntregaLeite) {
        this.idEntregaLeite = idEntregaLeite;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public double getLitros() {
        return litros;
    }

    public void setLitros(double litros) {
        this.litros = litros;
    }

    public double getGordura() {
        return gordura;
    }

    public void setGordura(double gordura) {
        this.gordura = gordura;
    }

    public double getProteina() {
        return proteina;
    }

    public void setProteina(double proteina) {
        this.proteina = proteina;
    }

    public double getPh() {
        return ph;
    }

    public void setPh(double ph) {
        this.ph = ph;
    }

    public double getAcidez() {
        return acidez;
    }

    public void setAcidez(double acidez) {
        this.acidez = acidez;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public Pessoa getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Pessoa fornecedor) {
        this.fornecedor = fornecedor;
    }

    @Override
    public Integer getId() {
        return getIdEntregaLeite() != null ? getIdEntregaLeite() : 0;
    }

    @Override
    public void setId(Integer id) {
        setIdEntregaLeite(id);
    }
}

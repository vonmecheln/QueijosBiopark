
package br.com.ifprbiopark.queijo_desktop.model;

import java.util.Date;


public class ColetaLeite {
    
    private Integer idColetaLeite;
    private String loteColeta;
    private Date dtColeta;
    private Pessoa produtor_idProdutor;
    private Pessoa Pessoa_idPessoa;
    private double qtdLeite;
    private String situacao;

    public Pessoa getPessoa_idPessoa() {
        return Pessoa_idPessoa;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public void setPessoa_idPessoa(Pessoa Pessoa_idPessoa) {
        this.Pessoa_idPessoa = Pessoa_idPessoa;
    }
    
    

    public Integer getIdColetaLeite() {
        return idColetaLeite;
    }

    public void setIdColetaLeite(Integer idColetaLeite) {
        this.idColetaLeite = idColetaLeite;
    }

    public String getLoteColeta() {
        return loteColeta;
    }

    public void setLoteColeta(String loteColeta) {
        this.loteColeta = loteColeta;
    }

    public Date getDtColeta() {
        return dtColeta;
    }

    public void setDtColeta(Date dtColeta) {
        this.dtColeta = dtColeta;
    }

    public Pessoa getProdutor_idProdutor() {
        return produtor_idProdutor;
    }

    public void setProdutor_idProdutor(Pessoa Produtor_idProdutor) {
        this.produtor_idProdutor = Produtor_idProdutor;
    }

    public double getQtdLeite() {
        return qtdLeite;
    }

    public void setQtdLeite(double qtdLeite) {
        this.qtdLeite = qtdLeite;
    }
    
    
    
}

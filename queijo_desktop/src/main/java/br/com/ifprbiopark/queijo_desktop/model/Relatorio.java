/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifprbiopark.queijo_desktop.model;

/**
 *
 * @author macbook
 */
public class Relatorio {
    private int idColetaLeite;
    private String dtColeta;
    private String loteColeta;
    private String produtor_id;
    private String qtdLeite;
    private String situacao;

    public int getIdColetaLeite() {
        return idColetaLeite;
    }

    public void setIdColetaLeite(int idColetaLeite) {
        this.idColetaLeite = idColetaLeite;
    }

    public String getDtColeta() {
        return dtColeta;
    }

    public void setDtColeta(String dtColeta) {
        this.dtColeta = dtColeta;
    }

    public String getLoteColeta() {
        return loteColeta;
    }

    public void setLoteColeta(String loteColeta) {
        this.loteColeta = loteColeta;
    }

    public String getProdutor_id() {
        return produtor_id;
    }

    public void setProdutor_id(String produtor_id) {
        this.produtor_id = produtor_id;
    }

    public String getQtdLeite() {
        return qtdLeite;
    }

    public void setQtdLeite(String qtdLeite) {
        this.qtdLeite = qtdLeite;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }
    
    

}

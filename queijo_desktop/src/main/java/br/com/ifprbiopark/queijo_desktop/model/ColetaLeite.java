package br.com.ifprbiopark.queijo_desktop.model;

import java.util.Date;

public class ColetaLeite extends AbstractModel {

    private Integer idColetaLeite;
    private String loteColeta;
    private Date dtColeta;
    private Pessoa produtor;
    private Pessoa funcionario;
    private Double qtdLeite;
    private String situacao;

    public Pessoa getFuncionario_idPessoa() {
        return funcionario;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public void setFuncionario(Pessoa funcionario) {
        this.funcionario = funcionario;
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

    public Pessoa getProdutor() {
        return produtor;
    }

    public void setProdutor(Pessoa produtor) {
        this.produtor = produtor;
    }

    public Double getQtdLeite() {
        return qtdLeite;
    }

    public void setQtdLeite(Double qtdLeite) {
        this.qtdLeite = qtdLeite;
    }

    @Override
    public Integer getId() {
        return getIdColetaLeite() != null ? getIdColetaLeite() : 0;
    }

    @Override
    public void setId(Integer id) {
        setIdColetaLeite(id);
    }

}

package br.com.ifprbiopark.queijo_desktop.model;

import java.util.Date;

public class ColetaLeite extends AbstractModel {

    private Integer idColetaLeite;
    private String loteColeta;
    private Date dtColeta;
    private Pessoa produtor_idPessoa;
    private Pessoa funcionario_idPessoa;
    private Double qtdLeite;
    private String situacao;

    public Pessoa getFuncionario_idPessoa() {
        return funcionario_idPessoa;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public void setFuncionario_idPessoa(Pessoa funcionarioIdPessoa) {
        this.funcionario_idPessoa = funcionarioIdPessoa;
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

    public Pessoa getProdutor_idPessoa() {
        return produtor_idPessoa;
    }

    public void setProdutor_idPessoa(Pessoa produtorIdPessoa) {
        this.produtor_idPessoa = produtorIdPessoa;
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

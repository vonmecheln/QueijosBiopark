package br.com.ifprbiopark.queijo_desktop.model;

public class EntregaAtributo {

    private Integer idEntregaAtributo;
    private String valor;
    private Atributos atributo_idAtributo;
    private ColetaLeite coletaLeite_idColetaLeite;

    public Integer getIdEntregaAtributo() {
        return idEntregaAtributo;
    }

    public void setIdEntregaAtributo(Integer idEntregaAtributo) {
        this.idEntregaAtributo = idEntregaAtributo;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public Atributos getAtributo_idAtributo() {
        return atributo_idAtributo;
    }

    public void setAtributo_idAtributo(Atributos Atributo_idAtributo) {
        this.atributo_idAtributo = Atributo_idAtributo;
    }

    public ColetaLeite getColetaLeite_idColetaLeite() {
        return coletaLeite_idColetaLeite;
    }

    public void setColetaLeite_idColetaLeite(ColetaLeite ColetaLeite_idColetaLeite) {
        this.coletaLeite_idColetaLeite = ColetaLeite_idColetaLeite;
    }

}

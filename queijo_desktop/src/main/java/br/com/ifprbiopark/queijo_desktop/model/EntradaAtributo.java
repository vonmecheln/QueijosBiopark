package br.com.ifprbiopark.queijo_desktop.model;

public class EntradaAtributo extends AbstractModel {

    private Integer idEntregaAtributo;
    private String valor;
    private Atributos atributo;
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

    public Atributos getAtributo() {
        return atributo;
    }

    public void setAtributo(Atributos atributo) {
        this.atributo = atributo;
    }

    public ColetaLeite getColetaLeite_idColetaLeite() {
        return coletaLeite_idColetaLeite;
    }

    public void setColetaLeite_idColetaLeite(ColetaLeite ColetaLeite_idColetaLeite) {
        this.coletaLeite_idColetaLeite = ColetaLeite_idColetaLeite;
    }

    @Override
    public Integer getId() {
        return getIdEntregaAtributo() != null ? getIdEntregaAtributo() : 0;
    }

    @Override
    public void setId(Integer id) {
        setIdEntregaAtributo(id);
    }

}


package br.com.ifprbiopark.queijo_desktop.model;


public class EntregaAtributo {
    
    private Integer idEntregaAtributo;
    private String valor;
    private Atributo Atributo_idAtributo;
    private ColetaLeite ColetaLeite_idColetaLeite;

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

    public Atributo getAtributo_idAtributo() {
        return Atributo_idAtributo;
    }

    public void setAtributo_idAtributo(Atributo Atributo_idAtributo) {
        this.Atributo_idAtributo = Atributo_idAtributo;
    }

    public ColetaLeite getColetaLeite_idColetaLeite() {
        return ColetaLeite_idColetaLeite;
    }

    public void setColetaLeite_idColetaLeite(ColetaLeite ColetaLeite_idColetaLeite) {
        this.ColetaLeite_idColetaLeite = ColetaLeite_idColetaLeite;
    }
    
    
    
}

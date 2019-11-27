package br.com.ifprbiopark.queijo_desktop.model;

public class Atributos extends AbstractModel {

    private Integer idAtributo;
    private String nomeAtributo;

    public Integer getIdAtributo() {
        return idAtributo;
    }

    public void setIdAtributo(Integer idAtributo) {
        this.idAtributo = idAtributo;
    }

    public String getNomeAtributo() {
        return nomeAtributo;
    }

    public void setNomeAtributo(String nomeAtributo) {
        this.nomeAtributo = nomeAtributo;
    }

    @Override
    public Integer getId() {
        return getIdAtributo();
    }

    @Override
    public void setId(Integer id) {
        setIdAtributo(id);
    }

}

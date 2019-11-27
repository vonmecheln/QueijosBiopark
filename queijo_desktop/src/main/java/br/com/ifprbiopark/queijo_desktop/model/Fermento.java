package br.com.ifprbiopark.queijo_desktop.model;

public class Fermento extends AbstractModel {

    private Integer idFermento;
    private String tipoFermento;
    private String marca;

    public Integer getIdFermento() {
        return idFermento;
    }

    public void setIdFermento(Integer idFermento) {
        this.idFermento = idFermento;
    }

    public String getTipoFermento() {
        return tipoFermento;
    }

    public void setTipoFermento(String tipoFermento) {
        this.tipoFermento = tipoFermento;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    @Override
    public int getId() {
        return getIdFermento();
    }

    @Override
    public void setId(int id) {
        setIdFermento(id);
    }

}

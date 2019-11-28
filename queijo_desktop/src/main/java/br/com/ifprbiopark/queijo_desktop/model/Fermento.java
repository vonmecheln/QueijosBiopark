package br.com.ifprbiopark.queijo_desktop.model;

public class Fermento extends AbstractModel {

    private Integer idFermento;
    private String nome;
    private String marca;

    public Integer getIdFermento() {
        return idFermento;
    }

    public void setIdFermento(Integer idFermento) {
        this.idFermento = idFermento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    @Override
    public Integer getId() {
        return getIdFermento() != null ? getIdFermento() : 0;
    }

    @Override
    public void setId(Integer id) {
        setIdFermento(id);
    }

}

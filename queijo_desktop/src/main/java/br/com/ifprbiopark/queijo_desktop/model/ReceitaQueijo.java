package br.com.ifprbiopark.queijo_desktop.model;

public class ReceitaQueijo extends AbstractModel {

    private Integer idTipoQueijo;
    private String nomeTipo;

    public Integer getIdTipoQueijo() {
        return idTipoQueijo;
    }

    public void setIdTipoQueijo(Integer idTipoQueijo) {
        this.idTipoQueijo = idTipoQueijo;
    }

    public String getNomeTipo() {
        return nomeTipo;
    }

    public void setNomeTipo(String nomeTipo) {
        this.nomeTipo = nomeTipo;
    }

    @Override
    public Integer getId() {
        return getIdTipoQueijo() != null ? getIdTipoQueijo() : 0;
    }

    @Override
    public void setId(Integer id) {
        setIdTipoQueijo(id);
    }

}

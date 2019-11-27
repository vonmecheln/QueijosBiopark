package br.com.ifprbiopark.queijo_desktop.model;

public class Processamento extends AbstractModel {

    private Integer idProcesamento;
    private String tipoProcessamento;

    public Integer getIdProcesamento() {
        return idProcesamento;
    }

    public void setIdProcesamento(Integer idProcesamento) {
        this.idProcesamento = idProcesamento;
    }

    public String getTipoProcessamento() {
        return tipoProcessamento;
    }

    public void setTipoProcessamento(String tipoProcessamento) {
        this.tipoProcessamento = tipoProcessamento;
    }

    @Override
    public int getId() {
        return getIdProcesamento();
    }

    @Override
    public void setId(int id) {
        setIdProcesamento(id);
    }

}

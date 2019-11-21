/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifprbiopark.queijo_desktop.model;

/**
 *
 * @author macbook
 */
public class Relatorio {

    private int idRelatorio;
    private String loteSa;
    private String lotePa;
    private String tipoQueijo;

    /**
     * @return int return the id
     */
    public int getIdRelatorio() {
        return idRelatorio;
    }

    /**
     * @param id the id to set
     */
    public void setId(int idRelatorio) {
        this.idRelatorio = idRelatorio;
    }

    /**
     * @return String return the loteSa
     */
    public String getLoteSa() {
        return loteSa;
    }

    /**
     * @param loteSa the loteSa to set
     */
    public void setLoteSa(String loteSa) {
        this.loteSa = loteSa;
    }

    /**
     * @return String return the lotePa
     */
    public String getLotePa() {
        return lotePa;
    }

    /**
     * @param lotePa the lotePa to set
     */
    public void setLotePa(String lotePa) {
        this.lotePa = lotePa;
    }

    /**
     * @return String return the tipoQueijo
     */
    public String getTipoQueijo() {
        return tipoQueijo;
    }

    /**
     * @param tipoQueijo the tipoQueijo to set
     */
    public void setTipoQueijo(String tipoQueijo) {
        this.tipoQueijo = tipoQueijo;
    }
}

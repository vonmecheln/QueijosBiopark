package br.com.ifprbiopark.queijo_desktop.exception;

public class ColetaLeiteException extends BasicException {

    public ColetaLeiteException(Exception ex) {
        super("Coleta de Leite: " + ex.getMessage());
    }

    public ColetaLeiteException(String ex) {
        super("Coleta de Leite: " + ex);
    }

}

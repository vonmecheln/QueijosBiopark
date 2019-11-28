package br.com.ifprbiopark.queijo_desktop.exception;

public class EntregaAtributoException extends BasicException {

    public EntregaAtributoException(Exception ex) {
        super("Atributo da Entrega: " + ex.getMessage());
    }

    public EntregaAtributoException(String ex) {
        super("Atributo da Entrega: " + ex);
    }

}

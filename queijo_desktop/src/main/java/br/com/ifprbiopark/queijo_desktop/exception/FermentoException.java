package br.com.ifprbiopark.queijo_desktop.exception;

public class FermentoException extends BasicException {

    public FermentoException(Exception ex) {
        super("Fermento: " + ex.getMessage());
    }
    
    public FermentoException(String ex) {
        super("Fermento: " + ex);
    }

}

package br.com.ifprbiopark.queijo_desktop.exception;

public class ReceitaQueijoException extends BasicException {

    public ReceitaQueijoException(Exception ex) {
        super("Receita Queijo: " + ex.getMessage());
    }

    public ReceitaQueijoException(String ex) {
        super("Receita Queijo: " + ex);
    }

}

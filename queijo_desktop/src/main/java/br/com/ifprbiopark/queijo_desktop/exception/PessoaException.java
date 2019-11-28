package br.com.ifprbiopark.queijo_desktop.exception;

public class PessoaException extends BasicException {

    public PessoaException(Exception ex) {
        super("Pessoa: " + ex.getMessage());
    }

    public PessoaException(String ex) {
        super("Pessoa: " + ex);
    }

}

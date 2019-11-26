package br.com.ifprbiopark.queijo_desktop.exception;

public class PessoaException extends BasicException {

    public PessoaException(Exception ex) {
        super("Fornecedor: " + ex.getMessage());
    }

}

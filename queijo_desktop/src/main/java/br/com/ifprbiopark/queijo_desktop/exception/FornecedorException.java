package br.com.ifprbiopark.queijo_desktop.exception;

public class FornecedorException extends BasicException {

    

    public FornecedorException(Exception ex) {
        super("Fornecedor: " + ex.getMessage());
    }

    

    
}

package br.com.ifprbiopark.queijo_desktop.exception;

import br.com.ifprbiopark.queijo_desktop.exception.BasicException;

public class RequiredFieldException extends BasicException {

    public RequiredFieldException(String campo) {
        super("campo obrigatório: "+ campo);
    }
    
}

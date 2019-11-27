package br.com.ifprbiopark.queijo_desktop.exception;

public class RequiredFieldException extends BasicException {

    public RequiredFieldException(String campo) {
        super("campo obrigatório: " + campo);
    }

}

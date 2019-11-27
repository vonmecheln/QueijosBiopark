package br.com.ifprbiopark.queijo_desktop.exception;

public class UniqueRegisterException extends BasicException {

    public UniqueRegisterException(String key) {
        super("Registro duplicado: " + key);
    }

}

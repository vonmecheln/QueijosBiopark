package br.com.ifprbiopark.queijo_desktop.exception;

public class FabricacaoException extends BasicException {

    public FabricacaoException(Exception ex) {
        super("Fabricação: " + ex.getMessage());
    }

    public FabricacaoException(String ex) {
        super("Fabricação: " + ex);
    }

}

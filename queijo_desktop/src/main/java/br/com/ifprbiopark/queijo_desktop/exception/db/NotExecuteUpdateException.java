package br.com.ifprbiopark.queijo_desktop.exception.db;

public class NotExecuteUpdateException extends DbException {

    public NotExecuteUpdateException() {
        super("Não foi possível atualizar");
    }

}

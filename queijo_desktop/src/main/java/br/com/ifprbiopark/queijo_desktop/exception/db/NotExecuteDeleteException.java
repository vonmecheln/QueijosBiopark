package br.com.ifprbiopark.queijo_desktop.exception.db;

public class NotExecuteDeleteException extends DbException {

    public NotExecuteDeleteException() {
        super("Não foi possível deletar");
    }

}

package br.com.ifprbiopark.queijo_desktop.exception.db;

public class NotExecuteInsertException extends DbException {

    public NotExecuteInsertException() {
        super("Não foi possível inserir");
    }

}

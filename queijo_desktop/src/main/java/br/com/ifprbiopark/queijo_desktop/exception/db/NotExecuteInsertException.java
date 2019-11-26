package br.com.ifprbiopark.queijo_desktop.exception.db;

import br.com.ifprbiopark.queijo_desktop.exception.BasicException;

public class NotExecuteInsertException extends DbException {

    public NotExecuteInsertException() {
        super("Não foi possível inserir");
    }

}

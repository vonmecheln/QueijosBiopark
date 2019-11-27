package br.com.ifprbiopark.queijo_desktop.exception.db;

public class NotColumnNamesDefinedException extends DbException {

    public NotColumnNamesDefinedException() {
        super("Lista de Columnas da Tabela não foi definada");
    }

}

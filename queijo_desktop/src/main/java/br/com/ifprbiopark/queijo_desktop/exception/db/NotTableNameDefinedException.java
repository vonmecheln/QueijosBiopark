package br.com.ifprbiopark.queijo_desktop.exception.db;

public class NotTableNameDefinedException extends DbException {

    public NotTableNameDefinedException() {
        super("Nome de Tabela não definada");
    }
    
}

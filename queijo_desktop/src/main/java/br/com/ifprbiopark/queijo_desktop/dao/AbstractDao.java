package br.com.ifprbiopark.queijo_desktop.dao;

import br.com.ifprbiopark.queijo_desktop.exception.db.DbException;

/**
 *
 * @param <T>
 */
public abstract class AbstractDao<T> {
    
    private String tableName;

    public AbstractDao(String tableName) {
        this.tableName = tableName;
    }
    
    public abstract void inserir(T objeto) throws DbException;

    public abstract boolean excluir(T objeto) throws DbException;

    public abstract T consultar(T objeto) throws DbException;

    public abstract T alterar(T objeto) throws DbException;

    public abstract T consultar(int id) throws DbException;
}

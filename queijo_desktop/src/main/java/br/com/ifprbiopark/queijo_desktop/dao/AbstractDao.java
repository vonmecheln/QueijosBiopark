package br.com.ifprbiopark.queijo_desktop.dao;

import br.com.ifprbiopark.queijo_desktop.exception.db.NotColumnNamesDefinedException;
import br.com.ifprbiopark.queijo_desktop.exception.db.NotTableNameDefinedException;
import br.com.ifprbiopark.queijo_desktop.exception.db.DbException;
import br.com.ifprbiopark.queijo_desktop.exception.db.NotExecuteInsertException;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @param <T>
 */
public abstract class AbstractDao<T> {

    private final String tableName;
    private final List<String> columnNames;
    protected Conexao con;

    public AbstractDao(String tableName, List<String> columnNames) throws DbException {
        this.tableName = tableName;
        this.columnNames = columnNames;
        
        if (tableName == null || tableName.isEmpty()) {
            throw new NotTableNameDefinedException();
        }
        
        if (columnNames == null || columnNames.isEmpty()) {
            throw new NotColumnNamesDefinedException();
        }


        this.con = Conexao.getInstance();
    }

    public abstract void inserir(T objeto) throws DbException;

    public abstract boolean excluir(T objeto) throws DbException;

    public abstract T consultar(T objeto) throws DbException;

    public abstract T alterar(T objeto) throws DbException;

    public abstract T consultar(int id) throws DbException;

    protected void InserirDefault(T objeto) throws DbException, SQLException {

        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO ");
        sql.append(this.tableName);
        sql.append(" ( ");
        sql.append("nomeAtributo");
        sql.append(" ) VALUES( ");
        sql.append(":nomeAtributo");
        sql.append(" )");

        NamedParameterStatement nps = con.NamedParameterStatement(sql.toString());
        confStantementInsert(nps, objeto);

        int exec = nps.executeUpdate();
        if (exec == 0) {
            throw new NotExecuteInsertException();
        }

    }

    protected void confStantementInsert(NamedParameterStatement nps, T objeto) throws SQLException {

    }
}

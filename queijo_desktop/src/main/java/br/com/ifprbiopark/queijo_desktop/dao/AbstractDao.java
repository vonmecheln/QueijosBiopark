package br.com.ifprbiopark.queijo_desktop.dao;

import br.com.ifprbiopark.queijo_desktop.exception.db.NotExecuteDeleteException;
import br.com.ifprbiopark.queijo_desktop.exception.db.NotColumnNamesDefinedException;
import br.com.ifprbiopark.queijo_desktop.exception.db.NotTableNameDefinedException;
import br.com.ifprbiopark.queijo_desktop.exception.db.DbException;
import br.com.ifprbiopark.queijo_desktop.exception.db.GeneratedKeysException;
import br.com.ifprbiopark.queijo_desktop.exception.db.NotExecuteInsertException;
import br.com.ifprbiopark.queijo_desktop.exception.db.NotExecuteUpdateException;
import br.com.ifprbiopark.queijo_desktop.model.AbstractModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @param <T>
 */
public abstract class AbstractDao<T extends AbstractModel> {

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

    public void inserirDefault(T objeto) throws DbException {

        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO ");
        sql.append(this.tableName);
        sql.append(" ( ");
        //começa em 1 para não pegar o id
        for (int i = 1; i < columnNames.size(); i++) {
            sql.append(columnNames.get(i));
            if (i < columnNames.size() - 1) {
                sql.append(", ");
            }
        }
        sql.append(" ) VALUES( ");
        for (int i = 1; i < columnNames.size(); i++) {
            sql.append(":");
            sql.append(columnNames.get(i));
            if (i < columnNames.size() - 1) {
                sql.append(", ");
            }
        }
        sql.append(" )");

        try {
            NamedParameterStatement nps = con.NamedParameterStatement(sql.toString());
            confStantement(nps, objeto);

            int exec = nps.executeUpdate();
            if (exec == 0) {
                throw new NotExecuteInsertException();
            }

            int key = 0;
            ResultSet retorno = nps.getGeneratedKeys();
            if (retorno != null && retorno.next()) {
                key = retorno.getInt(1);
            } else {
                throw new GeneratedKeysException();
            }

            objeto.setId(key);

        } catch (SQLException ex) {
            System.out.println(sql.toString());
            throw new DbException(ex);
        }

    }

    public void alterarDefault(T objeto) throws DbException {

        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE ");
        sql.append(this.tableName);
        sql.append(" SET ");
        //começa em 1 para não pegar o id
        for (int i = 1; i < columnNames.size(); i++) {
            sql.append(columnNames.get(i));
            sql.append(" = :");
            sql.append(columnNames.get(i));
            if (i < columnNames.size() - 1) {
                sql.append(", ");
            }
        }
        sql.append(" WHERE ");
        sql.append(this.columnNames.get(0));
        sql.append(" = :id");

        try {
            NamedParameterStatement nps = con.NamedParameterStatement(sql.toString());
            confStantement(nps, objeto);
            nps.setInt("id", objeto.getId());

            int exec = nps.executeUpdate();
            if (exec == 0) {
                throw new NotExecuteUpdateException();
            }

        } catch (SQLException ex) {
            System.out.println(sql.toString());
            throw new DbException(ex);
        }

    }

    public boolean excluirDefault(T objeto) throws DbException {

        StringBuilder sql = new StringBuilder();
        try {

            sql.append("DELETE ");
            sql.append(this.tableName);
            sql.append(" WHERE ");
            sql.append(this.columnNames.get(0));
            sql.append(" = :id");

            NamedParameterStatement nps = con.NamedParameterStatement(sql.toString());
            nps.setInt("id", objeto.getId());

            boolean exec = nps.execute();
            if (!exec) {
                throw new NotExecuteDeleteException();
            } else {
                return exec;
            }

        } catch (SQLException ex) {
            System.out.println(sql.toString());
            throw new DbException(ex);
        }

    }

    protected void confStantement(NamedParameterStatement nps, T objeto) throws SQLException {
        // TODO: ao converter todas as DAOs para insertDefaul tornar este método abstrato
    }
}

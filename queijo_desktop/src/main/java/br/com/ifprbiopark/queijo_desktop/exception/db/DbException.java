package br.com.ifprbiopark.queijo_desktop.exception.db;

import br.com.ifprbiopark.queijo_desktop.exception.BasicException;
import java.sql.SQLException;

public class DbException extends BasicException {

    public DbException(String message) {
        super(message);
    }

    public DbException(SQLException ex) {
        super(ex);
    }
    
    
}

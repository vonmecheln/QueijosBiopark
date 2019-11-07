package br.com.ifprbiopark.queijo_desktop.dao;

import br.com.ifprbiopark.queijo_desktop.exception.db.DbException;
import br.com.ifprbiopark.queijo_desktop.exception.db.GeneratedKeysException;
import br.com.ifprbiopark.queijo_desktop.exception.db.NotExecuteInsertException;
import br.com.ifprbiopark.queijo_desktop.model.Fornecedor;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FornecedorDao {

    public void inserir(Fornecedor f) throws DbException {

        try {
            
            String sql = "INSERT INTO fornecedor( NOME ) VALUES (:nome)";
            Conexao con = Conexao.getInstance();
            NamedParameterStatement nps = con.NamedParameterStatement(sql);
            nps.setString("nome", f.getNome());

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
            f.setId(key);

        } catch (SQLException ex) {
            throw new DbException(ex);
        } 
        
    }

    public boolean excluir(Fornecedor f) {

        return false;
    }

    public Fornecedor alterar(Fornecedor f) {

        return f;
    }

    public List<Fornecedor> selecionarPeloNome(String n) {
        List<Fornecedor> listaFornecedores = new ArrayList<Fornecedor>();

        return listaFornecedores;
    }
}

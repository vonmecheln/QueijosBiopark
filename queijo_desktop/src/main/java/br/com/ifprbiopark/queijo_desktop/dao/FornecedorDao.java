package br.com.ifprbiopark.queijo_desktop.dao;

import br.com.ifprbiopark.queijo_desktop.model.Fornecedor;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FornecedorDao {

    public Fornecedor inserir(Fornecedor f) {

        try {
            String sql = "INSERT INTO fornecedor( NOME ) VALUES (:nome)";
            Conexao con = Conexao.getInstance();
            NamedParameterStatement nps = con.NamedParameterStatement(sql, Statement.RETURN_GENERATED_KEYS);
            nps.setString("nome", f.getNome());

            int exec = nps.executeUpdate();
            if (exec == 0) {
                throw new Exception("Não executou");
            }

            int key = 0;
            ResultSet retorno = nps.getGeneratedKeys();
            if (retorno != null && retorno.next()) {
                key = retorno.getInt(1);
            } else {
                throw new Exception("Não retornou nada");
            }
            f.setId(key);

        } catch (SQLException ex) {
            Logger.getLogger(FornecedorDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(FornecedorDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return f;
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

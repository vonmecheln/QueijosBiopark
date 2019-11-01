package br.com.ifprbiopark.queijo_desktop.dao;

import br.com.ifprbiopark.queijo_desktop.model.Fornecedor;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FornecedorDao {

    public Fornecedor inserir(Fornecedor f) {

        String sql = "INSERT INTO fornecedor( NOME ) VALUES (':nome')";

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

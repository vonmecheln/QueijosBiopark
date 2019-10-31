package br.com.ifprbiopark.queijo_desktop.dao;

import br.com.ifprbiopark.queijo_desktop.model.Fornecedor;
import java.util.ArrayList;
import java.util.List;

public class FornecedorDao {

    public Fornecedor inserir(Fornecedor f) {
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

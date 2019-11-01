package br.com.ifprbiopark.queijo_desktop.control;

import br.com.ifprbiopark.queijo_desktop.dao.FornecedorDao;
import br.com.ifprbiopark.queijo_desktop.model.Fornecedor;

public class ControleFornecedor {

    public void salvar(Fornecedor f){
        FornecedorDao dao = new FornecedorDao();
        
        if (f.getId() == 0) {
            f = dao.inserir(f);
        } else {
            f = dao.alterar(f);
        }
        
    }
}

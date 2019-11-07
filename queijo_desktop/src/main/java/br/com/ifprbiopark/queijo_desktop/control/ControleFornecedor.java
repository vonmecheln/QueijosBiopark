package br.com.ifprbiopark.queijo_desktop.control;

import br.com.ifprbiopark.queijo_desktop.dao.FornecedorDao;
import br.com.ifprbiopark.queijo_desktop.exception.FornecedorException;
import br.com.ifprbiopark.queijo_desktop.exception.RequiredFieldException;
import br.com.ifprbiopark.queijo_desktop.model.Fornecedor;

public class ControleFornecedor {

    public void salvar(Fornecedor f) throws FornecedorException {

        if (f.getNome().trim().isEmpty()) {
            throw new FornecedorException(new RequiredFieldException("nome"));
        }

        FornecedorDao dao = new FornecedorDao();

        try {

            if (f.getId() == 0) {
                dao.inserir(f);
            } else {
                dao.alterar(f);
            }

        } catch (Exception ex) {
            throw new FornecedorException(ex);
        }
        
    }
}

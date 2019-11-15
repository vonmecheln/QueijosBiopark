package br.com.ifprbiopark.queijo_desktop.control;

import br.com.ifprbiopark.queijo_desktop.dao.PessoaDao;
import br.com.ifprbiopark.queijo_desktop.exception.PessoaException;
import br.com.ifprbiopark.queijo_desktop.exception.RequiredFieldException;
import br.com.ifprbiopark.queijo_desktop.model.Pessoa;

public class ControlePessoa {

    public void salvar(Pessoa p) throws PessoaException {

        if (p.getNome().trim().isEmpty()) {
            throw new PessoaException(new RequiredFieldException("nome"));
        }

        PessoaDao dao = new PessoaDao();

        try {

            if (p.getIdPessoa() == 0) {
                dao.inserir(p);
            } else {
                dao.alterar(p);
            }

        } catch (Exception ex) {
            throw new PessoaException(ex);
        }
        
    }
}

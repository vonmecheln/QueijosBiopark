package br.com.ifprbiopark.queijo_desktop.control;

import br.com.ifprbiopark.queijo_desktop.dao.FabricacaoQueijoDao;
import br.com.ifprbiopark.queijo_desktop.exception.db.DbException;
import br.com.ifprbiopark.queijo_desktop.model.FabricacaoQueijo;
import java.util.List;

public class ControleFabricacaoQueijo {
    
    //inserir a instancia dao correspondente;
    FabricacaoQueijoDao dao = new FabricacaoQueijoDao();
    
    public void salvar(FabricacaoQueijo c) throws DbException{
        dao.inserir(c);
    }
    
    public void excluir (FabricacaoQueijo c) throws DbException{
        dao.excluir(c);
    }
    
    public void alterar(FabricacaoQueijo c) throws DbException {
        dao.alterar(c);
    }
    
    public List<FabricacaoQueijo> listaColeta(FabricacaoQueijo c) throws DbException{
        return null;

}
    
}

package br.com.ifprbiopark.queijo_desktop.control;

import br.com.ifprbiopark.queijo_desktop.dao.FabricacaoQueijoDao;
import br.com.ifprbiopark.queijo_desktop.exception.db.DbException;
import br.com.ifprbiopark.queijo_desktop.model.FabricacaoQueijo;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControleFabricacaoQueijo {

    FabricacaoQueijoDao dao;

    public ControleFabricacaoQueijo() {
        try {
            this.dao = new FabricacaoQueijoDao();
        } catch (DbException ex) {
            Logger.getLogger(ControleFabricacaoQueijo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void salvar(FabricacaoQueijo c) throws DbException {
        dao.inserir(c);
    }

    public void excluir(FabricacaoQueijo c) throws DbException {
        dao.excluir(c);
    }

    public void alterar(FabricacaoQueijo c) throws DbException {
        dao.alterar(c);
    }

    public List<FabricacaoQueijo> listaColeta(FabricacaoQueijo c) throws DbException {
        return null;

    }

    public List<FabricacaoQueijo> consultarTabela(int idTipoQueijo, boolean inativos) throws Exception {
        try {
            if (idTipoQueijo == 0) {
                return dao.consultarListaTodos(inativos);
            } else {
                return dao.consultarTabela(idTipoQueijo, inativos);
            }
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }

    public FabricacaoQueijo consultar(int parseInt) {
        throw new UnsupportedOperationException("Não suportado ainda."); //To change body of generated methods, choose Tools | Templates.
    }

}

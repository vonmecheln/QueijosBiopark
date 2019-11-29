package br.com.ifprbiopark.queijo_desktop.control;

import br.com.ifprbiopark.queijo_desktop.dao.FabricacaoQueijoDao;
import br.com.ifprbiopark.queijo_desktop.exception.ColetaLeiteException;
import br.com.ifprbiopark.queijo_desktop.exception.FabricacaoException;
import br.com.ifprbiopark.queijo_desktop.exception.RequiredFieldException;
import br.com.ifprbiopark.queijo_desktop.exception.db.DbException;
import br.com.ifprbiopark.queijo_desktop.model.FabricacaoQueijo;
import com.google.common.base.Strings;
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

    public void salvar(FabricacaoQueijo f) throws FabricacaoException {

        if (Strings.isNullOrEmpty(f.getLoteQueijo())) {
            throw new FabricacaoException(new RequiredFieldException("Lote Queijo"));
        }

        if (f.getDataFabricacao() == null) {
            throw new FabricacaoException(new RequiredFieldException("Data de Fabricação"));
        }

        if (f.getQtdLeite() == null || f.getQtdLeite() == 0) {
            throw new FabricacaoException(new RequiredFieldException("Quantidade Utilizada"));
        }

        if (f.getReceitaQueijo() == null) {
            throw new FabricacaoException(new RequiredFieldException("Receita"));
        }

        if (f.getColetaLeite() == null) {
            throw new FabricacaoException(new RequiredFieldException("Coleta"));
        }

        try {
            if (f.getId() == 0) {
                dao.inserir(f);
            } else {
                dao.alterar(f);
            }

        } catch (DbException ex) {
            throw new FabricacaoException(ex);
        }
    }

    public void excluir(FabricacaoQueijo c) throws FabricacaoException {
        try {
            dao.excluir(c);
        } catch (DbException ex) {
            throw new FabricacaoException(ex);
        }
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

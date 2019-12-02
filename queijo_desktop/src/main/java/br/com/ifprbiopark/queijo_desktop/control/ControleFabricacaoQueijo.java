package br.com.ifprbiopark.queijo_desktop.control;

import br.com.ifprbiopark.queijo_desktop.dao.FabricacaoQueijoDao;
import br.com.ifprbiopark.queijo_desktop.exception.FabricacaoException;
import br.com.ifprbiopark.queijo_desktop.exception.RequiredFieldException;
import br.com.ifprbiopark.queijo_desktop.exception.db.DbException;
import br.com.ifprbiopark.queijo_desktop.model.ColetaLeite;
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
                if (verificaColeta(f))
                    dao.inserir(f);
            } else {
                dao.alterar(f);
            }

        } catch (DbException | FabricacaoException ex) {
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
    
    private boolean verificaColeta(FabricacaoQueijo c) throws FabricacaoException{
        try {
            List<FabricacaoQueijo> lista = dao.consultarColetas(c.getColetaLeite().getId());
            double quantidadeSalva = 0;
            double novaQuantidade = 0;
            ColetaLeite cl = c.getColetaLeite();
            
            if (lista != null){
                for (FabricacaoQueijo fq : lista){
                    quantidadeSalva += fq.getQtdLeite();                    
                }
                
                novaQuantidade = quantidadeSalva + c.getQtdLeite();
                
                if (novaQuantidade > cl.getQtdLeite()){
                    
                    double leiteDisponivel = (cl.getQtdLeite() - quantidadeSalva < 0 ) ? 0 : cl.getQtdLeite() - quantidadeSalva;
                    throw new FabricacaoException("Não é possível adicionar a nova fabricação pois ultrapassa a quantidade de leite disponível. A quantidade disponível é " + leiteDisponivel + " Litros.");
                }
                else{
                    return true;
                }
            }
            else{
                throw new FabricacaoException("(ControleFabricacaoDao.verificaColeta) Não foi possível recuperar os dados.");
            }
            
            
        } catch (Exception ex) {
            throw new FabricacaoException(ex.getMessage());
        }        
    }
}

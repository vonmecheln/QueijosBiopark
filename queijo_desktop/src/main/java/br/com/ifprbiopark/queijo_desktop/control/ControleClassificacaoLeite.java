/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifprbiopark.queijo_desktop.control;

/**
 *
 * @author UnioestePROEX
 */
public class ControleClassificacaoLeite {
    
    ClassificacaoLeiteDao c = new ClassificacaoLeiteDao();
    
    public void salvar(ColetaLeite c) throws DbException{
        coleta.inserir(c);
    }
    
    public void excluir (ColetaLeite c) throws DbException{
        coleta.excluir(c);
    }
    
    public void alterar(ColetaLeite c) throws DbException {
        coleta.alterar(c);
    }
    
    public List<ColetaLeite> listaColeta(ColetaLeite c) throws DbException{
        return coleta.listarColetas();

}
}

package br.com.ifprbiopark.queijo_desktop.control;

public class ControleFabricacaoQueijo {
    
    //inserir a instancia dao correspondente;
    
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

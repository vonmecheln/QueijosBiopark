import br.com.ifprbiopark.queijo_desktop.dao.ColetaLeiteDao;
import br.com.ifprbiopark.queijo_desktop.exception.RequiredFieldException;
import br.com.ifprbiopark.queijo_desktop.exception.db.DbException;
import br.com.ifprbiopark.queijo_desktop.model.ColetaLeite;
import java.util.List;

public class ControllerColetaLeite {
    
    ColetaLeiteDao coleta = new ColetaLeiteDao();

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

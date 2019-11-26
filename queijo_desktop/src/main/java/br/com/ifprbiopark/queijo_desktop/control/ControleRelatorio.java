package br.com.ifprbiopark.queijo_desktop.control;

import br.com.ifprbiopark.queijo_desktop.dao.RelatorioDao;
import br.com.ifprbiopark.queijo_desktop.model.Relatorio;
import java.sql.SQLException;
import java.util.ArrayList;

public class ControleRelatorio {

    RelatorioDao dao = new RelatorioDao();

    public ArrayList<Relatorio> pesquisar(String filtro) throws SQLException {
        return dao.pesquisar(filtro);
    }
}

package br.com.ifprbiopark.queijo_desktop.dao;

import br.com.ifprbiopark.queijo_desktop.exception.db.DbException;
import br.com.ifprbiopark.queijo_desktop.model.ColetaLeite;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ColetaLeiteDao extends AbstractDao<ColetaLeite> {

    public ColetaLeiteDao() throws DbException {
        super("coletaleite", new ArrayList<>(Arrays.asList(
                "idColetaLeite",
                "loteColeta",
                "dtColeta",
                "qtdLeite",
                "produtor_id",
                "funcionario_id",
                "situacao")));
    }

    @Override
    protected void confStantement(NamedParameterStatement nps, ColetaLeite objeto) throws SQLException {
        nps.setString("loteColeta", objeto.getLoteColeta());
        nps.setDate("dtColeta", objeto.getDtColeta() != null ? new java.sql.Date(objeto.getDtColeta().getTime()) : null);
        nps.setDouble("qtdLeite", objeto.getQtdLeite() != null ? objeto.getQtdLeite() : 0);

        nps.setInt("produtor_id",
                (objeto.getProdutor_idPessoa() != null
                && objeto.getProdutor_idPessoa().getId() != null)
                ? objeto.getProdutor_idPessoa().getId() : 0);

        nps.setInt("funcionario_id",
                (objeto.getFuncionario_idPessoa() != null
                && objeto.getFuncionario_idPessoa().getId() != null)
                ? objeto.getFuncionario_idPessoa().getId() : 0);

        nps.setString("situacao", objeto.getSituacao());
    }

    @Override
    public void inserir(ColetaLeite c) throws DbException {
        inserirDefault(c);
    }

    @Override
    public boolean excluir(ColetaLeite objeto) throws DbException {
        return excluirDefault(objeto);
    }

    @Override
    public ColetaLeite consultar(ColetaLeite objeto) throws DbException {
        throw new UnsupportedOperationException("Não suportado ainda."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ColetaLeite alterar(ColetaLeite objeto) throws DbException {
        alterarDefault(objeto);
        return objeto;
    }

    public List<ColetaLeite> listarColetas() {
        try {
            List<ColetaLeite> coletas = new ArrayList<>();

            //String SQL;
            String sql = "SELECT idColetaLeite, loteColeta, dtColeta, produtor_id, qtdLeite, situacao, "
                    + "funcionario_id FROM coletaleite";

            NamedParameterStatement nps = con.NamedParameterStatement(sql);

            PessoaDao pessoaDao = new PessoaDao();

            ResultSet consulta = nps.executeQuery();
            while (consulta.next()) {
                ColetaLeite coleta = new ColetaLeite();
                coleta.setIdColetaLeite(consulta.getInt("idColetaLeite"));
                coleta.setLoteColeta(consulta.getString("loteColeta"));
                java.sql.Date d = java.sql.Date.valueOf(consulta.getString("dtColeta"));
                coleta.setDtColeta(d);

//                //seta funcionario;
//                Pessoa f = new Pessoa();
//                f.setIdPessoa(consulta.getInt("Pessoa_idPessoa"));
//                coleta.setPessoa_idPessoa(f);
//
//                //seta produtor;
//                Pessoa p = new Pessoa();
//                p.setIdPessoa(consulta.getInt("Produtor_idProdutor"));
//                coleta.setProdutor_idProdutor(p);
                //
                coleta.setProdutor_idPessoa(pessoaDao.consultar(consulta.getInt("produtor_id")));

                coleta.setFuncionario_idPessoa(pessoaDao.consultar(consulta.getInt("funcionario_id")));
                coleta.setQtdLeite(consulta.getDouble("qtdLeite"));
                coleta.setSituacao(consulta.getString("situacao"));

                coletas.add(coleta);

            }
            return coletas;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    /**
     *
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    public ColetaLeite consultar(int id) throws DbException {
        try {
            PessoaDao pessoaDao = new PessoaDao();
            String sql = "SELECT idColetaLeite, loteColeta, dtColeta, produtor_id, qtdLeite, situacao, "
                    + "funcionario_id FROM coletaleite WHERE idColetaLeite = :id";

            NamedParameterStatement nps = con.NamedParameterStatement(sql);

            nps.setInt("id", id);

            ResultSet consulta = nps.executeQuery();
            while (consulta.next()) {
                ColetaLeite coleta = new ColetaLeite();
                coleta.setIdColetaLeite(consulta.getInt("idColetaLeite"));
                coleta.setLoteColeta(consulta.getString("loteColeta"));
                java.sql.Date d = java.sql.Date.valueOf(consulta.getString("dtColeta"));
                coleta.setDtColeta(d);

//                //seta funcionario;
//                Pessoa f = new Pessoa();
//                f.setIdPessoa(consulta.getInt("Pessoa_idPessoa"));
//                coleta.setPessoa_idPessoa(f);
//
//                //seta produtor;
//                Pessoa p = new Pessoa();
//                p.setIdPessoa(consulta.getInt("Produtor_idProdutor"));
//                coleta.setProdutor_idProdutor(p);
                //
                coleta.setProdutor_idPessoa(pessoaDao.consultar(consulta.getInt("produtor_id")));

                coleta.setFuncionario_idPessoa(pessoaDao.consultar(consulta.getInt("funcionario_id")));
                coleta.setQtdLeite(consulta.getDouble("qtdLeite"));
                coleta.setSituacao(consulta.getString("situacao"));

                return coleta;
            }
            return null;
        } catch (Exception ex) {
            throw new DbException(ex.getMessage());
        }
    }
}

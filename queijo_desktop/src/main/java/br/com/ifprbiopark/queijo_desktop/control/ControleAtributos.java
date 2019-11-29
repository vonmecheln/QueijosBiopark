/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifprbiopark.queijo_desktop.control;

import br.com.ifprbiopark.queijo_desktop.dao.AtributosDao;
import br.com.ifprbiopark.queijo_desktop.dao.NamedParameterStatement;

import br.com.ifprbiopark.queijo_desktop.exception.RequiredFieldException;
import br.com.ifprbiopark.queijo_desktop.exception.db.DbException;
import br.com.ifprbiopark.queijo_desktop.model.Atributos;
import java.sql.ResultSet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import static jdk.nashorn.internal.runtime.Debug.id;

/**
 *
 * @author macbook
 */
public class ControleAtributos {
    AtributosDao dao;

    public ControleAtributos() {
        try {
            this.dao = new AtributosDao();
        } catch (DbException ex) {
            Logger.getLogger(ControleAtributos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Atributos> listaColeta() throws DbException {
        return dao.listarColetas();
    }

//    public Atributos consultar(int aInt) {
//        
//      String sql = "SELECT idAtributo, nomeAtributo FROM atributo WHERE idAtributo = :id";
//
//            NamedParameterStatement nps = con.NamedParameterStatement(sql);
//
//            nps.setInt("id", id);
//
//            ResultSet consulta = nps.executeQuery();
//            while (consulta.next()) {
//                Pessoa pessoa = new Pessoa();
//                pessoa.setIdPessoa(consulta.getInt("idPessoa"));
//                pessoa.setNome(consulta.getString("nome"));
//                pessoa.setEndereco(consulta.getString("endereco"));
//                pessoa.setTipoFiscal(consulta.getString("tipoFiscal"));
//                pessoa.setDocumento(consulta.getString("documento"));
//                pessoa.setTipoPessoa(consulta.getString("tipoPessoa"));
//                pessoa.setTelefone(consulta.getString("telefone"));
//
//                return pessoa;  
//      // fazer os imports e ajustar esssa consulta, além da coletaLeite.  
//        
//        
// }
    
        public Atributos consultar(int id) {
        try {
            return dao.consultar(id);
        } catch (DbException ex) {
            Logger.getLogger(ControleAtributos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
   return null;
}
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifprbiopark.queijo_desktop.dao;

import br.com.ifprbiopark.queijo_desktop.model.Relatorio;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author macbook
 */
public class RelatorioDao {

    public ArrayList<Relatorio> pesquisar(String filtro) throws SQLException {
        ArrayList<Relatorio> retorno = new ArrayList<>();
        //﻿SELECT idColetaLeite, dtColeta, loteColeta, produtor_id, qtdLeite, situacao FROM coletaleite;
        String sql = "Select idColetaLeite, dtColeta, loteColeta, produtor_id, qtdLeite, situacao FROM coletaleite";
        if (filtro != null && filtro.length() > 0) {
            sql += " where Lower(loteColeta) like '%" + filtro.toLowerCase() + "%'";
        }

        Conexao con = Conexao.getInstance();
        NamedParameterStatement nps = con.NamedParameterStatement(sql);
        ResultSet resultadoConsulta = nps.executeQuery();

        while (resultadoConsulta.next()) {
            Relatorio relatorio = new Relatorio();
              relatorio.setIdColetaLeite(resultadoConsulta.getInt("idColetaLeite"));
              relatorio.setDtColeta(resultadoConsulta.getString("dtColeta"));
              relatorio.setLoteColeta(resultadoConsulta.getString("loteColeta"));
              relatorio.setProdutor_id(resultadoConsulta.getString("produtor_id"));
              relatorio.setQtdLeite(resultadoConsulta.getString("qtdLeite"));
              relatorio.setSituacao(resultadoConsulta.getString("situacao"));
            retorno.add(relatorio);
        }

        return retorno;
    }
}

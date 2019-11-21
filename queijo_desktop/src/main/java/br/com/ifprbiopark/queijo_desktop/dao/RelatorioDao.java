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

        String sql = "Select * from receitaqueijo where Lower(:nomeReceita)";
        //String sql = "SELECT * FROM viewRelatorio WHERE lower(tipoQueijo) like ?";
        //ResultSet resultadoConsulta = executarConsultaSQL(sql, "%" + filtro.trim().toLowerCase() + "%");

        Conexao con = Conexao.getInstance();
        NamedParameterStatement nps = con.NamedParameterStatement(sql);
        nps.setString("nomeReceita", filtro);
        ResultSet resultadoConsulta = nps.executeQuery();

        while (resultadoConsulta.next()) {
            Relatorio relatorio = new Relatorio();
            relatorio.setId(resultadoConsulta.getInt("idReceita"));
            relatorio.setLoteSa(resultadoConsulta.getString("nomeReceita"));
            //relatorio.setLotePa(resultadoConsulta.getString("﻿loteQueijo"));
            //relatorio.setTipoQueijo(resultadoConsulta.getString("﻿TipoQueijo_idTipoQueijo"));

            retorno.add(relatorio);
        }

        return retorno;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifprbiopark.queijo_desktop.dao;

import br.com.ifprbiopark.queijo_desktop.exception.db.DbException;

/**
 *
 * @author jhona
 * @param <T>
 */
public abstract class AbstractDao<T> {
    
    public abstract void inserir(T objeto) throws DbException;
     
    public abstract boolean excluir(T objeto) throws DbException;
    
    public abstract T consultar(T objeto) throws DbException;  

    public abstract T alterar(T objeto) throws DbException;   
    
    public abstract T consultar(int id) throws DbException; 
}

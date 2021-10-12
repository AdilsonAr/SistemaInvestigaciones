/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ar.sistemainvestigaciones.dao;

import com.ar.sistemainvestigaciones.model.Pais;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author KGB
 */
@Stateless
public class Dao {
    @PersistenceContext(unitName = "investigaciones_persistence_unit")
    protected EntityManager entityManager;
    public String helloWorld(){
         Query q = entityManager.createQuery("select c from Pais c");
        List<Pais> result=q.getResultList();
        return "Hello world..."+result.size();
    }
}

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
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author KGB
 */
@Stateless 
public class Dao {
     
    public String helloWorld(){
        EntityManagerFactory emf = null;
        EntityManager entityManager = null;
        try {
            emf = Persistence.createEntityManagerFactory("investigaciones_persistence_unit");
            entityManager = emf.createEntityManager();
            
            Query q = entityManager.createQuery("select s from Pais s");
            List<Pais> resultList = q.getResultList();
            return "paises: "+resultList.size();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if(entityManager!=null && emf!=null){
                entityManager.close();
                emf.close();
            }
            
        }
        return null;
        
    }
    
}

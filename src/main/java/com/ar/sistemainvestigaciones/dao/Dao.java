/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ar.sistemainvestigaciones.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author KGB
 */ 

public class Dao {
     
    protected EntityManagerFactory emf;
    protected EntityManager entityManager;

    public Dao() {
        emf = Persistence.createEntityManagerFactory("investigaciones_persistence_unit");
        entityManager = emf.createEntityManager();
    }
    
}

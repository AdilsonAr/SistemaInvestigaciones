/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ar.sistemainvestigaciones.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author KGB
 */
public class Dao {
    @PersistenceContext(unitName = "investigaciones_persistence_unit")
    protected EntityManager entityManager;
}

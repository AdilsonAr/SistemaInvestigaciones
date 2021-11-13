/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ar.sistemainvestigaciones.dao;

import com.ar.sistemainvestigaciones.model.Pais;
import java.util.List;
import javax.persistence.TypedQuery;

/**
 *
 * @author KGB
 */
public class PaisDao  extends Dao {
    public List<Pais> readAll() {
        entityManager.clear();
        TypedQuery<Pais> q = entityManager.createQuery("select s from Pais s", Pais.class);
        List<Pais> resultList = q.getResultList();
        return resultList;
    }
}

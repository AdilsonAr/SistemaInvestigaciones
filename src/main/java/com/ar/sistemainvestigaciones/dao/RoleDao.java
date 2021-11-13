/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ar.sistemainvestigaciones.dao;

import com.ar.sistemainvestigaciones.model.Role;
import java.util.List;
import javax.persistence.TypedQuery;

/**
 *
 * @author KGB
 */
public class RoleDao extends Dao {

    public List<Role> readAll() {
        entityManager.clear();
        TypedQuery<Role> q = entityManager.createQuery("select s from Role s where s.id != 1", Role.class);
        List<Role> resultList = q.getResultList();
        return resultList;
    }
}

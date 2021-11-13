/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ar.sistemainvestigaciones.dao;

import com.ar.sistemainvestigaciones.model.Administrador;
import com.ar.sistemainvestigaciones.model.Usuario;
import java.util.List;
import javax.persistence.TypedQuery;

/**
 *
 * @author KGB
 */
public class AdministradorDao extends Dao {
    public void create(Administrador a) {
        entityManager.getTransaction().begin();
        entityManager.persist(a);
        entityManager.getTransaction().commit();
    }
    
    public List<Administrador> readAll() {
        entityManager.clear();  
        TypedQuery<Administrador> q = entityManager.createQuery("select s from Administrador s", Administrador.class);
        List<Administrador> resultList = q.getResultList();
        return resultList;
    }
    
    public Administrador findByUsuario(Usuario user){
        Administrador u=null;
        try{
            TypedQuery<Administrador> q = entityManager.createQuery("select s from Administrador s where s.usuario.id=:id", Administrador.class);
            q.setParameter("id", user.getId());
            if(q.getResultList().size()!=0){
                u=q.getResultList().get(0);
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return u;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ar.sistemainvestigaciones.dao;

import com.ar.sistemainvestigaciones.model.Usuario;
import javax.persistence.Query;

/**
 *
 * @author KGB
 */
public class UsuarioDao extends Dao {
    public Usuario authenticate(String correo, String clave){
        Usuario u=null;
        try{
            entityManager.clear();
            Query q =entityManager.createQuery("select u from Usuario u where u.correo=:correo and u.clave=:clave");
            q.setParameter("correo", correo);
            q.setParameter("clave", clave);
            if(q.getResultList().size()!=0){
                u=(Usuario) q.getResultList().get(0);
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return u;
    }
    
    public Usuario readById(int id) {
        Usuario usuario = entityManager.find(Usuario.class, id);
        return usuario;
    }

    public void update(Usuario u) {
        entityManager.getTransaction().begin();
        entityManager.merge(u);
        entityManager.getTransaction().commit();
    }

    public Usuario create(Usuario u) {
        entityManager.getTransaction().begin();
        entityManager.persist(u);
        entityManager.getTransaction().commit();
        return u;
    }
}

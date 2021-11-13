/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ar.sistemainvestigaciones.dao;

import com.ar.sistemainvestigaciones.model.Investigador;
import com.ar.sistemainvestigaciones.model.Usuario;
import java.util.List;
import javax.persistence.TypedQuery;

/**
 *
 * @author KGB
 */
public class InvestigadorDao extends Dao {
    public void create(Investigador a) {
        entityManager.getTransaction().begin();
        entityManager.persist(a);
        entityManager.getTransaction().commit();
    }
    
    public List<Investigador> readAll() {
        entityManager.clear();  
        TypedQuery<Investigador> q = entityManager.createQuery("select s from Investigador s", Investigador.class);
        List<Investigador> resultList = q.getResultList();
        return resultList;
    }
    
    public Investigador findByUsuario(Usuario user){
        entityManager.clear();  
        Investigador u=null;
        try{
            TypedQuery<Investigador> q = entityManager.createQuery("select s from Investigador s where s.usuario.id=:id", Investigador.class);
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

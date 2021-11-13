/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ar.sistemainvestigaciones.dao;

import com.ar.sistemainvestigaciones.model.Investigacion;
import com.ar.sistemainvestigaciones.model.Investigador;
import com.ar.sistemainvestigaciones.model.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.TypedQuery;

/**
 *
 * @author KGB
 */
public class InvestigacionDao extends Dao {
    public void create(Investigacion a) {
        entityManager.getTransaction().begin();
        entityManager.persist(a);
        entityManager.getTransaction().commit();
    }
    
    public List<Investigacion> findByInvestigador(Investigador user){
        entityManager.clear();  
        List<Investigacion> list=new ArrayList<>();
        try{
            TypedQuery<Investigacion> q = entityManager.createQuery("select s from Investigacion s where s.investigador.id=:id", Investigacion.class);
            q.setParameter("id", user.getId());
            list=q.getResultList();
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return list;
    }
    
    public Investigacion findByUuid(String uuid){
        entityManager.clear();  
        Investigacion in=null;
        try{
            TypedQuery<Investigacion> q = entityManager.createQuery("select s from Investigacion s where s.documentUuid=:uuid", Investigacion.class);
            q.setParameter("uuid", uuid);
            if(q.getResultList().size()>0){
                in=q.getResultList().get(0);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return in;
    }
}

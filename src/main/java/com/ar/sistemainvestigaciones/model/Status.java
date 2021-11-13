/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ar.sistemainvestigaciones.model;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

/**
 *
 * @author KGB
 */
@Entity
public class Status {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String status;
    @OneToMany(mappedBy = "status", cascade = CascadeType.ALL)
    private List<Investigacion> investigaciones;

    public Status() {
    }

    public Status(int id, String status, List<Investigacion> investigaciones) {
        this.id = id;
        this.status = status;
        this.investigaciones = investigaciones;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Investigacion> getInvestigaciones() {
        return investigaciones;
    }

    public void setInvestigaciones(List<Investigacion> investigaciones) {
        this.investigaciones = investigaciones;
    }
    
}

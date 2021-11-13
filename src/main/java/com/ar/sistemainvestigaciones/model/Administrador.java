/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ar.sistemainvestigaciones.model;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author KGB
 */
@Entity
public class Administrador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="usuarioId")
    private Usuario usuario;
    @OneToMany(mappedBy = "administrador", cascade = CascadeType.ALL)
    private List<Investigador> investigadores;
    @OneToMany(mappedBy = "administrador", cascade = CascadeType.ALL)
    private List<ObservacionAdministrador> observaciones;

    public Administrador(int id, Usuario usuario, List<Investigador> investigadores, List<ObservacionAdministrador> observaciones) {
        this.id = id;
        this.usuario = usuario;
        this.investigadores = investigadores;
        this.observaciones = observaciones;
    }

    public Administrador() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Investigador> getInvestigadores() {
        return investigadores;
    }

    public void setInvestigadores(List<Investigador> investigadores) {
        this.investigadores = investigadores;
    }

    public List<ObservacionAdministrador> getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(List<ObservacionAdministrador> observaciones) {
        this.observaciones = observaciones;
    }
    
    
}

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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author KGB
 */
@Entity
public class Investigador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="usuarioId")
    private Usuario usuario;
    @OneToMany(mappedBy = "investigador", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Investigacion> investigaciones;
    @ManyToOne
    @JoinColumn(name="administradorId")
    private Administrador administrador;

    public Investigador(int id, Usuario usuario, List<Investigacion> investigaciones, Administrador administrador) {
        this.id = id;
        this.usuario = usuario;
        this.investigaciones = investigaciones;
        this.administrador = administrador;
    }

    public Investigador() {
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

    public List<Investigacion> getInvestigaciones() {
        return investigaciones;
    }

    public void setInvestigaciones(List<Investigacion> investigaciones) {
        this.investigaciones = investigaciones;
    }

    public Administrador getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }
    
    
}

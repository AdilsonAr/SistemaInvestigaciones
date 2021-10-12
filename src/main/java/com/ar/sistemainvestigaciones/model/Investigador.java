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
    @OneToOne
    @JoinColumn(name="usuarioId")
    private Usuario usuario;
    @OneToMany(mappedBy = "investigador", cascade = CascadeType.ALL)
    private List<Investigacion> investigaciones;
    @ManyToOne
    @JoinColumn(name="administradorId")
    private Administrador administrador;
}

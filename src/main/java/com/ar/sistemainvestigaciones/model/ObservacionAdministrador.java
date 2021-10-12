/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ar.sistemainvestigaciones.model;

import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author KGB
 */
@Entity
public class ObservacionAdministrador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name="administradorId")
    private Administrador administrador;
    @ManyToOne
    @JoinColumn(name="investigacionId")
    private Investigacion investigacion;
    private LocalDateTime fechaCreacion;
    @Column(columnDefinition = "TEXT")
    private String observacion;
}

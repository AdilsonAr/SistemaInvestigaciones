/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ar.sistemainvestigaciones.model;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author KGB
 */
@Entity
public class ObservacionSuperAdministrador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name="superAdministradorId")
    private SuperAdministrador superAdministrador;
    @ManyToOne
    @JoinColumn(name="investigacionId")
    private Investigacion investigacion;
    private LocalDateTime fechaCreacion;
    @Column(columnDefinition = "TEXT")
    private String observacion;
}

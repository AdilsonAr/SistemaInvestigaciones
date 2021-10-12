/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ar.sistemainvestigaciones.model;

import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author KGB
 */
@Entity
public class Investigacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaPrimeraAceptacion;
    private LocalDateTime fechaSegundaAceptacion;
    @ManyToOne
    @JoinColumn(name="investigadorId")
    private Investigador investigador;
    @OneToMany(mappedBy = "investigacion", cascade = CascadeType.ALL)
    private List<ObservacionAdministrador> observacionesAdministrador;
    @OneToMany(mappedBy = "investigacion", cascade = CascadeType.ALL)
    private List<ObservacionSuperAdministrador> observacionSuperAdministrador;
    @ManyToMany
    @JoinTable(name = "investigacion-tag", joinColumns = @JoinColumn(name="investigacionId"),
            inverseJoinColumns = @JoinColumn(name="tagId"))
    private List<Tag> tags;
    @ManyToOne
    @JoinColumn(name="statusId")
    private Status status;
}

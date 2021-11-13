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
    @JoinTable(name = "investigacionTag", joinColumns = @JoinColumn(name="investigacionId"),
            inverseJoinColumns = @JoinColumn(name="tagId"))
    private List<Tag> tags;
    @ManyToOne
    @JoinColumn(name="statusId")
    private Status status;
    private int estado;
    private String documentUuid;
    private String nombre;

    public Investigacion() {
    }

    public Investigacion(int id, LocalDateTime fechaCreacion, LocalDateTime fechaPrimeraAceptacion, LocalDateTime fechaSegundaAceptacion, Investigador investigador, List<ObservacionAdministrador> observacionesAdministrador, List<ObservacionSuperAdministrador> observacionSuperAdministrador, List<Tag> tags, Status status, int estado, String documentUuid, String nombre) {
        this.id = id;
        this.fechaCreacion = fechaCreacion;
        this.fechaPrimeraAceptacion = fechaPrimeraAceptacion;
        this.fechaSegundaAceptacion = fechaSegundaAceptacion;
        this.investigador = investigador;
        this.observacionesAdministrador = observacionesAdministrador;
        this.observacionSuperAdministrador = observacionSuperAdministrador;
        this.tags = tags;
        this.status = status;
        this.estado = estado;
        this.documentUuid = documentUuid;
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public LocalDateTime getFechaPrimeraAceptacion() {
        return fechaPrimeraAceptacion;
    }

    public void setFechaPrimeraAceptacion(LocalDateTime fechaPrimeraAceptacion) {
        this.fechaPrimeraAceptacion = fechaPrimeraAceptacion;
    }

    public LocalDateTime getFechaSegundaAceptacion() {
        return fechaSegundaAceptacion;
    }

    public void setFechaSegundaAceptacion(LocalDateTime fechaSegundaAceptacion) {
        this.fechaSegundaAceptacion = fechaSegundaAceptacion;
    }

    public Investigador getInvestigador() {
        return investigador;
    }

    public void setInvestigador(Investigador investigador) {
        this.investigador = investigador;
    }

    public List<ObservacionAdministrador> getObservacionesAdministrador() {
        return observacionesAdministrador;
    }

    public void setObservacionesAdministrador(List<ObservacionAdministrador> observacionesAdministrador) {
        this.observacionesAdministrador = observacionesAdministrador;
    }

    public List<ObservacionSuperAdministrador> getObservacionSuperAdministrador() {
        return observacionSuperAdministrador;
    }

    public void setObservacionSuperAdministrador(List<ObservacionSuperAdministrador> observacionSuperAdministrador) {
        this.observacionSuperAdministrador = observacionSuperAdministrador;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String getDocumentUuid() {
        return documentUuid;
    }

    public void setDocumentUuid(String documentUuid) {
        this.documentUuid = documentUuid;
    }
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ar.sistemainvestigaciones.file;

/**
 *
 * @author KGB
 */
public enum Properties {
    DOCUMENTS_URL("C:\\documentos_investigaciones_json\\");
    private String value;

    public String getValue() {
        return value;
    }

    private Properties(String value) {
        this.value = value;
    }
    
}

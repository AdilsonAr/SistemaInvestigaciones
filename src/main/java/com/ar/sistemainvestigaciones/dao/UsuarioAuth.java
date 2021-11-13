/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ar.sistemainvestigaciones.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author KGB
 */
public class UsuarioAuth  extends Conexion{
    public int authenticate(String correo, String clave) throws Exception{
        ResultSet rs;
        int foundId=0;
        try{
           this.conectar();
           String sql="select * from usuario where correo=? and clave=?";
           PreparedStatement pst = this.getCon().prepareStatement(sql);
           pst.setString(1, correo);
           pst.setString(2, clave);
           rs=pst.executeQuery();
           while(rs.next()){
               foundId=rs.getInt("id");
           }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            this.desconectar();
        }
        return foundId;
    }
}

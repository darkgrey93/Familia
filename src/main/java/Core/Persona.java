/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Core;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Darkgrey93
 */
public class Persona {
    private Integer cedula;
    private String nombre;
    private String edad;
    private Map<Integer,Persona> mapa=new HashMap<Integer,Persona>();
    

    public Persona(Integer cedula, String nombre, String edad) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.edad = edad;
    }
    
    public Integer getCedula() {
        return cedula;
    }

    public void setCedula(Integer cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public Map<Integer, Persona> getMapa() {
        return mapa;
    }

    public void setMapa(Map<Integer, Persona> mapa) {
        this.mapa = mapa;
    }
    public void mostrarDatos(){
        System.out.println(nombre+edad);
    }
    
    
}

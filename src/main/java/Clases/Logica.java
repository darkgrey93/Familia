/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import Core.Persona;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Darkgrey93
 */
public class Logica {
    private Map<Integer,Persona> abuelos=new HashMap<Integer,Persona>();
    public static BufferedReader entrada=new BufferedReader(new InputStreamReader(System.in));
    static Integer i=6;
    Persona abuelo = new Persona(1,"Miguel","60");
    Persona abuelo2 = new Persona(2,"Diego","60");
    Persona padre = new Persona(3,"Alberto","40");
    Persona padre2 = new Persona(4,"Orlando","40");
    Persona hijo = new Persona(5,"Andres","20");
    Persona hijo2 = new Persona(6,"Jonathan","20");
    Persona hijo3 = new Persona(7,"Andres","20");
    
    public Logica() {
        agregarAbuelos(abuelo.getCedula(),abuelo);
        agregarAbuelos(abuelo2.getCedula(),abuelo2);
        abuelo.getMapa().put(padre.getCedula(), padre);
        abuelo2.getMapa().put(padre2.getCedula(), padre2);
        abuelo.getMapa().get(3).getMapa().put(hijo.getCedula(), hijo);
        abuelo.getMapa().get(3).getMapa().put(hijo2.getCedula(), hijo2);
        abuelo2.getMapa().get(4).getMapa().put(hijo3.getCedula(), hijo3);
        //agregarBastagos(abuelo.getCedula(), padre);
        //agregarBastagos(abuelo2.getCedula(), padre2);
        //agregarBastagos(padre.getCedula(), hijo);
        //agregarBastagos(padre.getCedula(), hijo2);
        //agregarBastagos(padre2.getCedula(), hijo3);
        System.out.println("fin de agregar");
    }
    public void arrancar(){
        if(abuelos.containsKey(i)){
            System.out.println(abuelos.get(i).getNombre());
            recursiveExploreI((HashMap<Integer, Persona>) abuelos.get(i).getMapa(), 2);            
        }else explore((HashMap<Integer, Persona>) abuelos);
    }
    
    public void agregarAbuelos(Integer cedula,Persona persona){
        abuelos.put(cedula,persona);
    }
    public void agregarBastagos(Integer numPadre,Persona descendencia){
        boolean bandera = false;
        for(int i=1;i<=abuelos.size();i++){
            Persona persona = abuelos.get(i);
            if(persona.getCedula().equals(numPadre)){
                persona.getMapa().put(descendencia.getCedula(),descendencia);
                bandera=true;
            }
        }
        if(bandera == false)
            for(int i=1;i<=abuelos.size();i++){
                Persona persona = abuelos.get(i);
                    for(int j=1;j<=persona.getMapa().size();i++){
                        Persona padreAdd = persona.getMapa().get(j);
                            if(padreAdd.getCedula().equals(numPadre)){
                                padreAdd.getMapa().put(descendencia.getCedula(),descendencia);
                                break;
                            }
                    }
                }
    }
    public String buscar(Integer key){
        String resultado="";
        boolean bandera = false;
        bandera = abuelos.containsKey(key);
        if (bandera==true){
            Persona persona = abuelos.get(key);
            resultado=("los hijos y nietos de: "+persona.getNombre()+"\n");
            for (Map.Entry<Integer, Persona> entry : persona.getMapa().entrySet()) {
                Integer key1 = entry.getKey();
                Persona value = entry.getValue();
                resultado+=(value.getNombre()+",");
                for (Map.Entry<Integer, Persona> entry1 : value.getMapa().entrySet()) {
                    Integer key2 = entry1.getKey();
                    Persona value1 = entry1.getValue();
                    resultado+=(value1.getNombre()+",");
                    
                }
            }
        }
        else if (bandera==false){
            
            for (Map.Entry<Integer, Persona> entry : abuelos.entrySet()) {
                Integer key1 = entry.getKey();
                Persona value = entry.getValue();
                bandera=value.getMapa().containsKey(key);
                if(bandera==true){
                    resultado=("su nombre es: " + value.getMapa().get(key).getNombre()+"\n");
                    resultado+=("su padre es: "+value.getNombre()+"\n");
                    resultado+=("sus hijos son:");
                    for (Map.Entry<Integer, Persona> entry1 : value.getMapa().get(key).getMapa().entrySet()) {
                    Integer key2 = entry1.getKey(); 
                    Persona value1 = entry1.getValue();
                    resultado+=(value1.getNombre()+",");
                   
                    }
                }
            }
        }
        if(bandera==false){
            for (Map.Entry<Integer, Persona> entry : abuelos.entrySet()) {
                Integer key1 = entry.getKey();
                Persona value = entry.getValue();
                for (Map.Entry<Integer, Persona> entry1 : value.getMapa().entrySet()) {
                    Integer key2 = entry1.getKey();
                    Persona value1 = entry1.getValue();
                    bandera=value1.getMapa().containsKey(key);
                    if(bandera==true){
                        resultado=("su nombre es: " + value1.getMapa().get(key).getNombre()+"\n");
                        resultado+=("su padre es: " + value1.getNombre()+"\n");
                        resultado+=("su abuelo es: " + value.getNombre()+"\n");
                        
                    }
                }
                
                
            }
        }
        
         return resultado;
    }
    
    private  void recursiveExplore(HashMap<Integer, Persona> categories, int depth) {
        
        if (depth == 0) return;
        for (Persona c1 : categories.values()) { 
            if(c1.getMapa().containsKey(i)){
                System.out.println(c1.getNombre());
                System.out.println(c1.getMapa().get(i).getNombre());
                if(true){
                    recursiveExploreI((HashMap<Integer, Persona>) c1.getMapa().get(i).getMapa(),10);
                }                
                return;
            }
            recursiveExplore((HashMap<Integer, Persona>) c1.getMapa(), depth - 1);
        }
    }
    
    private void recursiveExploreI(HashMap<Integer, Persona> categories, int depth) {
        
        if (depth == 0) return;
        for (Persona c1 : categories.values()) {            
           
            System.out.println(c1.getNombre());  
            
            recursiveExploreI((HashMap<Integer, Persona>) c1.getMapa(), depth - 1);
        }
    }
    
    public  void explore(HashMap<Integer,Persona> categories) {
        recursiveExplore(categories, 1);
    }
    
    
    public void menu(){
        System.out.println("escriba la cedula de la persona que desea buscar");
        Integer key=null;
        try {
           key=Integer.parseInt((entrada.readLine()));; 
        } catch (Exception ex) {
            Logger.getLogger(Logica.class.getName()).log(Level.SEVERE, null, ex);
        }
        String resultado=buscar(key);
        System.out.println(resultado);
        
    }
}



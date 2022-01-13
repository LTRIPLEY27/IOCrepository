/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package newpackage.Prove.UF2.UF5;

import java.util.List;

/**
 *
 * @author isabe
 */
public class Port {
    private String nom;
/*TODO heu de crear un atribut anomenat port que sigui un List que ipmlementareu
    mitjançant un ArrayList per guardar vaixells.
     */    
    //list <tipoObjeto> nombre -- sintáxis básica de arraylist--
    private List<Vaixell> port; // ATRIBUTO ANOMEDADO "LIST" DEL TIPO VAIXELL


public Port(String nom) {
    this.nom = nom;
}

    public String getNom() {
        return this.nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    
    
    // SETTER DE UNA COLECCION, RESPETAR SIEMPRE
    public void setPort(List<Vaixell> port) {
        this.port = port;
    }
    
    // GETTER DE LA COLECCION
    public List<Vaixell> getPort() {
        return port;
    }
    
    public void afegirVaixell(Vaixell vaixell){
/*TODO
Heu d'afegir al final de l'atribut creat el vaixell passat per paràmetre. */
        
       port.add(vaixell); // ADHIERE AL FINAL DE LA LISTA EL OBJETO
        
    }
    public void eliminarVaixell(Vaixell vaixell){
    /*TODO
    Heu d'eliminar el vaixell passat per paràmetre si aquest està en el port.*/
    
        //for(Vaixell vaixell : port) {
        for( int i = 0; i < port.size(); i++) {
            if(vaixell.getMatricula().contains(port.get(i).getMatricula())) {//VERIFICA LA MATRICULA DEL PARAMETRO CON LA DEL LIST
                port.remove(vaixell);
            }
        }
    }

    public void mostrarMatricula(){
    /*TODO
    Heu d'imprimir per pantalla la matrícula dels vaixells que hi ha al port amb una eslora
    de més de 20 metres.

    */
           for(Vaixell vaix : port) {
               if(vaix.getEslora() >= 20) {
                   System.out.println(vaix.getMatricula());
               }
           }
    }
    }


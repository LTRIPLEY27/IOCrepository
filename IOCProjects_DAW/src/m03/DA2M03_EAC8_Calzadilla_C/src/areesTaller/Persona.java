/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package areesTaller;

import java.util.Scanner;
import principal.Component;

/**
 *
 * @author Isabel Calzadilla
 */


// CLASE PERSONA CON TODOS LOS ATRIBUTOS Y METODOS DE ACCESO QUE HEREDARAN CLIENTS Y MECANICS

public abstract class Persona implements Component{
    
    
    
    private String nif;
    private String nom;
    private String telefon;
    private String correu;
    
    protected Persona(String nif, String nom, String telefon, String correu) {
        this.nif = nif;
        this.nom = nom;
        this.telefon = telefon;
        this.correu = correu;
    }
    
    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getCorreu() {
        return correu;
    }

    public void setCorreu(String correu) {
        this.correu = correu;
    }
    
    
    // METODOS A IMPLEMENTAR POR LAS CLASES HEREDADAS YA QUE SON GENERICOS Y CUMPLEN CON EL MISMO PROPOSITO
    
       @Override
    public void updateComponent() {
      String nif, nom, telefon, correu;
        System.out.println("\nNIF , por favor" + this.nif);
        System.out.println("\nEntra el nou nif:");
        nif = DADES.next();
        this.setNif(nif);
        
        DADES.nextLine(); //Neteja buffer
        
        System.out.println("\nNom, por favor: " + this.nom);
        System.out.println("\nEntra el nou nom:");
        nom = DADES.nextLine();
        this.setNom(nom);
        
        System.out.println("\nTelèfon, por favor: " + this.telefon);
        System.out.println("\nEntra el nou telèfon:");
        telefon = DADES.next();
        this.setTelefon(telefon);
        
        System.out.println("\nCorreu, por favor: " + this.correu);
        System.out.println("\nEntra el nou correu electrònic:");
        correu = DADES.next();
        this.setCorreu(correu);
    }

    @Override
    public void showComponent() {
       System.out.println("\nLes dades del sujeto  amb NIF " + this.nif + " són:");
        System.out.println("\nNom: " + this.nom);
        System.out.println("\nTelèfon: " + this.telefon);
        System.out.println("\nCorreu electrònic: " + this.correu);
    }
    
}

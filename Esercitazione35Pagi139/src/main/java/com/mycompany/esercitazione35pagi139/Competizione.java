/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.esercitazione35pagi139;

/**
 *
 * @author NICOLASDAGOSTINI
 */
public class Competizione {
    String campo;
    String giudice;
    String squadra;
    String ora;
    String punteggio_percorso;
    String punteggio_difficolta;
    String tempo;
    
    
        
     public Competizione(String campo, String giudice, String squadra, String tempo, String punteggio_percorso, String punteggio_difficolta, String ora) {
        this.campo = campo;
        this.giudice = giudice;
        this.squadra = squadra;
        this.ora = ora;
        this.punteggio_percorso = punteggio_percorso;
        this.punteggio_difficolta = punteggio_difficolta;
        this.tempo = tempo;
    }
    
    
     
     
    public String getCampo() {
        return campo;
    }
    public void setCampo(String campo) {
        this.campo = campo;
    }

    
    
    public String getGiudice() {
        return giudice;
    }
    public void setGiudice(String giudice) {
        this.giudice = giudice;
    }

    
    
    public String getSquadra() {
        return squadra;
    }
    public void setSquadra(String squadra) {
        this.squadra = squadra;
    }

    
   
    public String getOra() {
        return ora;
    }
    public void setOra(String ora) {
        this.ora = ora;
    }

    
    
    public String getPunteggio_percorso() {
        return punteggio_percorso;
    }
    public void setPunteggio_percorso(String punteggio_percorso) {
        this.punteggio_percorso = punteggio_percorso;
    }

    
    
    public String getPunteggio_difficolta() {
        return punteggio_difficolta;
    }
    public void setPunteggio_difficolta(String punteggio_difficolta) {
        this.punteggio_difficolta = punteggio_difficolta;
    }
    
    
    
    public String getTempo() {
        return tempo;
    }
    public void setTempo(String tempo) {
        this.tempo = tempo;
    }

    
      
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public String toString() {
        return "Campo: " + campo + " - Giudice: " + giudice + " - Squadra: " + squadra + " - Campo: " + campo + " - Punteggio percorso: " + punteggio_percorso + " - Punteggio difficoltà: " + punteggio_difficolta + " - Tempo: " + tempo;
    }    
}
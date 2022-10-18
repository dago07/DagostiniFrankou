/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package esercizio20;

import java.time.Duration;
import java.time.LocalDateTime;

/**
 *
 * @author NICOLASDAGOSTINI
 * @author UladzislauFrankou
 */
public class Tessere {
    private int id_utente;
    private boolean val;
    private LocalDateTime ultimaapertura;
    
    public Tessere(int id_utente) {   
        val = true;
        this.id_utente = id_utente;
        ultimaapertura = LocalDateTime.now();
    }
    
    public boolean isVal() {
        Duration differ = Duration.between(getUltimaapertura(), LocalDateTime.now());
        
        if (val) {
            return true;
        } else return differ.toHours() >= 72;
    }



   public void setVal(boolean val) {
        this.val = val;
    }



   public int getId_utente() {
        return id_utente;
    }



   public void setId_utente(int id_utente) {
        this.id_utente = id_utente;
    }



   public LocalDateTime getUltimaapertura() {
        return ultimaapertura;
    }



   public void setUltimaapertura(LocalDateTime ultimaapertura) {
        this.ultimaapertura = ultimaapertura;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.esercitazione35pagi139;


import com.google.gson.Gson;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author NICOLASDAGOSTINI
 */
public class Esercitazione35Pagi139 {
    
    private static String readStringFromFile(String filepath) throws IOException {
    byte[] content = Files.readAllBytes(Paths.get(filepath));
    return new String(content);
}

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) throws IOException {
        Set<String> squadre = new HashSet<>();
        Gson gson = new Gson();
        String json;
        json = readStringFromFile("Gare.json");
        int conta = 1;
        Competizione[] comp = gson.fromJson(json, Competizione[].class);
        for (Competizione c : comp) {
            squadre.add(c.squadra);
            conta++;
            System.out.println(c);
        }

        
        
        int[] pSquadre = new int[squadre.size()]; 
        int[] tSquadre = new int[squadre.size()]; 
        String[] nomi = squadre.toArray(new String[0]);
        for (Competizione c : comp) {
            for (int i = 0; i < nomi.length; i++) {
                if (c.squadra.equals(nomi[i])) { 
                    pSquadre[i] += Integer.parseInt(c.punteggio_percorso) + Integer.parseInt(c.punteggio_difficolta);
                    tSquadre[i] += Integer.parseInt(c.tempo); 
                }
            }
        }
        System.out.println("\n--RISULTATI--");
        for (int i = 0; i < nomi.length; i++) {
            System.out.println(nomi[i] + " ha realizzato in " + tSquadre[i] + " secondi un totale di " + pSquadre[i] + " punti.\nLa somma dei punti ottenuti è di " + (pSquadre[i] + tSquadre[i]) + " punti.\n");
        }
    }
}
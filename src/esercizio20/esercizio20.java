/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package esercizio20;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author NICOLASDAGOSTINI
 * @author UladzislauFrankou
 */
public class esercizio20 extends Thread{

    private ServerSocket server20;
    
    //Creazione ArreyList reg
    private ArrayList<Tessere> reg = new ArrayList<>();
    
    public static void main(String[] args) {



       try {
            esercizio20 ser20 = new esercizio20();
            ser20.start();
            ser20.join();
        } catch (IOException | InterruptedException ex) {
        }
    }
    
    public esercizio20() throws IOException {
        server20 = new ServerSocket(13);
        
        //inserimento di un timeout di 10000000 millisecondi = 10000 secondi
        server20.setSoTimeout(10000000); 
    }
    
    public void run() {
        Socket connessione = null;

        try {
            connessione = server20.accept();
            DataOutputStream out = new DataOutputStream(connessione.getOutputStream());
            DataInputStream in = new DataInputStream(connessione.getInputStream());
            int id_utente, risp, scelta;

            while (!Thread.interrupted()) {
                scelta = in.readInt();

                switch (scelta) {
                    case 1:
                        id_utente = in.readInt();
                        risp = aprire(id_utente);
                        out.writeInt(risp);
                        break;
                    case 2:
                        id_utente = in.readInt();
                        risp = eliminare(id_utente);
                        out.writeInt(risp);
                        break;
                    case 3:
                        risp = registrare();
                        out.writeInt(risp);
                         break;
                    case 4:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("La scelta eseguita non risulta valida!");
                }
            }
        } catch (IOException ex) {
        }
        try {
            server20.close();
        } catch (IOException ex) {
            Logger.getLogger(esercizio20.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private int aprire(int id_utente) {
        for (int i = 0; i < reg.size(); i++) {
            if (reg.get(i).getId_utente() == id_utente) {
                if (reg.get(i).isVal()) {
                    reg.get(i).setVal(false);
                    reg.get(i).setUltimaapertura(LocalDateTime.now());
                    return 1;
                } else {
                    return -2;
                }
            }
        }
        return -1;
    }
    
    private int eliminare(int id_utente) {
        for (int i = 0; i < reg.size(); i++) {
            if (reg.get(i).getId_utente() == id_utente) {
                reg.remove(i);
                return 1;
            }
        }
        return -1;
    }

   private int registrare() {
        Tessere t = new Tessere(reg.size() + 1);
        reg.add(t);
        return t.getId_utente();
    }
    
}

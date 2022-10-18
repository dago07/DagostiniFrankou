/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esercizio21;

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
 * @author UladzislauFrankou
 */
public class Esercizio21 extends Thread {

    private ServerSocket server;
    int voto=0;
    int v[]=new int[5];
    int counter=0;

    public Esercizio21() throws IOException {
        server = new ServerSocket(13);
        server.setSoTimeout(10000000);
    }

    @Override
    public void run() {
        Socket connection = null;

        try {
            connection = server.accept();
            DataInputStream in = new DataInputStream(connection.getInputStream());
            DataOutputStream out = new DataOutputStream(connection.getOutputStream());
            int id, voto, risposta, scelta;

            while (!Thread.interrupted()) {
                for(int i=0;i<5;i++){
                    voto = in.readInt();
                System.out.println("voto="+voto);
                registraVoto(voto);
                out.writeInt(v[counter-1]);
                }
                apri();
                out.writeInt(v[counter]);
                System.exit(0);
                
            }
        } catch (IOException ex) {
        }
        try {
            server.close();
        } catch (IOException ex) {
            Logger.getLogger(Esercizio21.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void apri() {
        for (int i = 0; i < counter; i++) {
                System.out.println("voto: "+v[i]);
                
        }
    }
    
    private void registraVoto(int voto){
        if(counter<5){
            v[counter]=voto;
            counter++;
        }
        else
            System.out.println("MAX");
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        try {
            Esercizio21 server = new Esercizio21();
            server.start();
            server.join();
        } catch (IOException | InterruptedException ex) {
        }
    }

}

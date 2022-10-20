/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package esercizio21client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author NICOLASDAGOSTINI
 * @author UladzislauFrankou
 */
public class Esercizio21client {

    /**
     * @param args the command line arguments
     */
    
    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;
    int vm=0;

    public Esercizio21client() throws IOException {
        socket = new Socket("127.0.0.1", 13);
        socket.setSoTimeout(1000000);
        out = new DataOutputStream(socket.getOutputStream());
        in = new DataInputStream(socket.getInputStream());
    }

    public void inviaScelta(int scelta) throws IOException {
        out.writeInt(scelta);
    }
    
    public void inviaRicevi(int scelta) throws IOException {
        out.writeInt(scelta);
        
    }
    public void riceviVoto() throws IOException {
        
        for(int i=0;i<5;i++){
            int voto = in.readInt();
            System.out.println("voto del "+ (i+1) +" caffe: " + voto);
            vm+=voto;
        }
        System.out.println("voto media: " + vm/5);
    }
    
    public static void main(String[] args) {
        int scelta = 0;
        int voto;
        Scanner input = new Scanner(System.in);
        try {
            Esercizio21client client = new Esercizio21client();
            while (true) {
                for(int i=0;i<5;i++){
                    System.out.println("vota del "+ (i+1) +" caffe: ");
                    voto = input.nextInt();
                    client.inviaScelta(voto);
                }
                client.inviaRicevi(scelta);
                client.riceviVoto();
                
                System.exit(0);
                
            }
        } catch (IOException ex) {
        }
    }
    
}

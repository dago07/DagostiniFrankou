/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package client20;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author NICOLASDAGOSTINI
 */
public class Client20 {

    private DataInputStream input;
    private DataOutputStream output;
    private Socket socket;
    
    
    public static void main(String[] args) {
        int scelta = 0;
        int id_utente;
        Scanner input = new Scanner(System.in);
        try {
            Client20 client = new Client20();
            while (true) {
                System.out.println("1. Registra della tessera");
                System.out.println("2. Denuncia della tessera");
                System.out.println("3. Apertura del cassonetto");
                System.out.println("4. Escita dal programma\n");
                System.out.print("Digitare la tua scelta: ");
                scelta = input.nextInt();
                client.inviaScelta(scelta);

                switch (scelta) {
                    case 1:
                        client.riIdutente();
                        break;
                    case 2:
                        System.out.print("Inserire id utente: ");
                        id_utente = input.nextInt();
                        client.Ricevi(scelta, id_utente);
                        break;
                    case 3:
                        System.out.print("Inserire il tuo id utente: ");
                        id_utente = input.nextInt();
                        client.Ricevi(scelta, id_utente);
                        break;
                    case 4:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Scelta non corretta!");
                }
            }
        } catch (IOException ex) {
        }
    }

    public Client20() throws IOException {
        
        socket = new Socket("127.0.0.1", 13);
        //127.0.0.1 indirizzo ip
        //13 porta 
        
        
        //inserimento di un timeout di 10000000 millisecondi = 10000 secondi
        socket.setSoTimeout(1000000);
        
        input = new DataInputStream(socket.getInputStream());
        output = new DataOutputStream(socket.getOutputStream());
    }
    
    public void inviaScelta(int scelta) throws IOException {
        output.writeInt(scelta);
    }
    
    public void riIdutente() throws IOException {
        int id_utente = input.readInt();
        System.out.println("Registrazione avvenuta correttamente!\n");
        System.out.println("Id Utente: " + id_utente);
    }

    public void Ricevi(int scelta, int id_utente) throws IOException {
        output.writeInt(id_utente);
        int risp = input.readInt();
        if (scelta == 1) {
            if (risp == 1) {
                System.out.println("Cassonetto aperto");
            } else if (risp == -1) {
                System.out.println("La tessera non e' presente");
            } else if (risp == -2) {
                System.out.println("Apertura non autorizzata");
            }
        } else if (scelta == 3) {
            if (risp == 1) {
                System.out.println("La tessera e' stata eliminata ");
            }else {
                System.out.println("La tessera non e' presente");
            }   
        }
    }
    
}

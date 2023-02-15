/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package gsonreader;

/**
 *
 * @author UladzislauFrankou
 */
import java.io.FileReader;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class JsonReader {
    public static void main(String[] args) {
        JsonParser parser = new JsonParser();
        try {
            JsonElement jsonElement = parser.parse(new FileReader("patienti.json"));
            JsonArray jsonArray = jsonElement.getAsJsonArray();

            for (JsonElement element : jsonArray) {
                JsonObject jsonObject = element.getAsJsonObject();

                // Get paziente object
                JsonObject paziente = jsonObject.get("paziente").getAsJsonObject();
                String nome = paziente.get("nome").getAsString();
                String cognome = paziente.get("cognome").getAsString();
                String codiceFiscale = paziente.get("codice fiscale").getAsString();
                String sesso = paziente.get("sesso").getAsString();
                int eta = paziente.get("età").getAsInt();

                // Get esame object
                JsonObject esame = jsonObject.get("esame").getAsJsonObject();
                String data = esame.get("data").getAsString();
                String codice = esame.get("codice").getAsString();
                String numeroMatricolo = esame.get("numero di matricolo").getAsString();
                String denominazioneAnalisi = esame.get("denominazione dell'analisi").getAsString();
                int valoreNumUnitaMisura = esame.get("valore numero e unità di misura del risultato").getAsInt();
                int valoreMinimo = esame.get("valore minimo").getAsInt();
                int valoreMassimo = esame.get("valore massimo").getAsInt();

                // Get prilievo sangue and luogo
                String prilievoSangue = jsonObject.get("prilievo sangue").getAsString();
                
                JsonObject luogo = jsonObject.get("luogo").getAsJsonObject();
                String centroTerritoriale = luogo.get("centro territoriale").getAsString();
                String repartoOspedaliero = luogo.get("reparto ospedaliero").getAsString();
                String domicilioDelPaziente = luogo.get("domicilio del paziente").getAsString();
                String prontoSocarsoOAmbulazione = luogo.get("pronto socarso o ambulazione").getAsString();
                

                // Print out the extracted data
                System.out.println("Nome: " + nome);
                System.out.println("Cognome: " + cognome);
                System.out.println("Codice fiscale: " + codiceFiscale);
                System.out.println("Sesso: " + sesso);
                System.out.println("Età: " + eta);
                System.out.println("Data: " + data);
                System.out.println("Codice: " + codice);
                System.out.println("Numero di matricolo: " + numeroMatricolo);
                System.out.println("Denominazione dell'analisi: " + denominazioneAnalisi);
                System.out.println("Valore numero e unità di misura del risultato: " + valoreNumUnitaMisura);
                System.out.println("Valore minimo: " + valoreMinimo);
                System.out.println("Valore massimo: " + valoreMassimo);
                // parse the string into a LocalDateTime object
                //LocalDateTime prilievoSangueDateTime = LocalDateTime.parse(prilievoSangue, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

                // format the LocalDateTime object
                //System.out.println("Prilievo sangue: " + prilievoSangueDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));

                //System.out.println("Prilievo sangue: " + prilievoSangue.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
                System.out.println("Prilievo sangue: " + prilievoSangue);
                System.out.println("Luogo: " + luogo);
            }
            LocalDateTime startDateTime = LocalDateTime.parse("2022-01-01 00:00:00",
                    DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            LocalDateTime endDateTime = LocalDateTime.parse("2023-12-31 23:59:59",
                    DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

            // Iterate through the JSON array and check if the blood tests were done within the specified time frame
            for (JsonElement element : jsonArray) {
                JsonObject jsonObject = element.getAsJsonObject();

                // Get the date and time of the blood test
                //String prilievoSangue = jsonObject.get("prilievo sangue").getAsString();
                String dateTimeString = (String) jsonObject.get("prilievo sangue").getAsString();
                LocalDateTime dateTime = LocalDateTime.parse(dateTimeString,
                        DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

                // Check if the blood test was done within the specified time frame
                if (dateTime.isAfter(startDateTime) && dateTime.isBefore(endDateTime)) {
                    System.out.println("L'esame del sangue è stato effettuato entro il periodo di tempo specificato.");
                } else {
                    System.out.println("La prova del sangue non è stata effettuata entro il periodo specificato.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
}
}
}

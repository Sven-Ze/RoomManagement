package ch.bzz.room.util;

import ch.bzz.room.model.Reservation;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * short description
 * <p>
 * RoomManagement
 *
 * @author Tizian
 * @version 1.0
 * @since 12.04.21
 */
public class TextFileCreator {
    public void write(Reservation reservation) {
        try {
            File myObj = new File("filename.txt");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
                FileWriter myWriter = new FileWriter("reservation.txt");
                myWriter.write("Reservation: "+reservation.getReservationId());
                myWriter.write("Von: "+reservation.getVon());
                myWriter.write("Bis: "+reservation.getBis());
                myWriter.write("RaumId: "+reservation.getRoom().getRoomId());
                myWriter.write("RaumName: "+reservation.getRoom().getRaumName());
                myWriter.write("Zusatzstruktur: "+reservation.getZusatzStruktur());
                myWriter.write("MieterId: "+reservation.getMieter().getMieterId());
                myWriter.write("Mieter Vorname: "+reservation.getMieter().getMieterVorname());
                myWriter.write("Mieter Nachname: "+reservation.getMieter().getMieterNachname());
                myWriter.write("Mieter Telefon: "+reservation.getMieter().getTelefon());
                myWriter.close();
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}

package ch.bzz.room.util;

import ch.bzz.room.model.Mieter;
import ch.bzz.room.model.Reservation;
import ch.bzz.room.model.Room;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

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
    public static void write(Reservation reservation) {
        try {
            File myObj = new File("/home/bzz/data/Mietvertraege/reservation"+reservation.getReservationId()+".txt");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
                FileWriter myWriter = new FileWriter("/home/bzz/data/Mietvertraege/reservation"+reservation.getReservationId()+".txt");
                myWriter.write("Reservation: "+reservation.getReservationId()+"\n");
                myWriter.write("Von: "+reservation.getVon()+"\n");
                myWriter.write("Bis: "+reservation.getBis()+"\n");
                myWriter.write("RaumId: "+reservation.getRoom().getRoomId()+"\n");
                myWriter.write("RaumName: "+reservation.getRoom().getRaumName()+"\n");
                myWriter.write("Zusatzstruktur: "+reservation.getZusatzStruktur()+"\n");
                myWriter.write("MieterId: "+reservation.getMieter().getMieterId()+"\n");
                myWriter.write("Mieter Vorname: "+reservation.getMieter().getMieterVorname()+"\n");
                myWriter.write("Mieter Nachname: "+reservation.getMieter().getMieterNachname()+"\n");
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

    public static void main(String[] args) {
        Reservation reservation = new Reservation();
        reservation.setReservationId(13);
        reservation.setVon(LocalDate.of(2021,5,6));
        reservation.setBis(LocalDate.of(2021,5,7));
        reservation.setRoom(new Room("blabla"));
        reservation.setZusatzStruktur("tesgt");
        reservation.setMieter(new Mieter("Drin","Muslija","0738838"));
        write(reservation);
    }
}

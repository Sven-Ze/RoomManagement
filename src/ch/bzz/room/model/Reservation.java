package ch.bzz.room.model;

import com.sun.xml.internal.messaging.saaj.packaging.mime.util.LineInputStream;

import java.time.LocalDate;
import java.util.List;

/**
 * Reservation Data Class
 * <p>
 * RoomManagement
 *
 * @author Tizian
 * @version 1.0
 * @since 01.03.21
 */
public class Reservation implements Comparable<Reservation> {
    private int reservationId;
    private Mieter mieter;
    private Room room;
    private LocalDate von;
    private LocalDate bis;
    private String zusatzStruktur;
    private boolean reinigtMieter;
    private String status;

    public Reservation(Mieter mieter, Room room, LocalDate von, LocalDate bis, String zusatzStruktur, boolean reinigtMieter, String status) {
        this.mieter = mieter;
        this.room = room;
        this.von = von;
        this.bis = bis;
        this.zusatzStruktur = zusatzStruktur;
        this.reinigtMieter = reinigtMieter;
        this.status = status;
    }

    public Reservation() {

    }


    /**
     * Gets the mieter
     *
     * @return value of mieter
     */
    public Mieter getMieter() {
        return mieter;
    }

    /**
     * Sets the mieter
     *
     * @param mieter the value to set
     */

    public void setMieter(Mieter mieter) {
        this.mieter = mieter;
    }

    /**
     * Gets the room
     *
     * @return value of room
     */
    public Room getRoom() {
        return room;
    }

    /**
     * Sets the room
     *
     * @param room the value to set
     */

    public void setRoom(Room room) {
        this.room = room;
    }

    /**
     * Gets the reservationId
     *
     * @return value of reservationId
     */
    public int getReservationId() {
        return reservationId;
    }

    /**
     * Sets the reservationId
     *
     * @param reservationId the value to set
     */

    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }

    /**
     * Gets the von
     *
     * @return value of von
     */
    public LocalDate getVon() {
        return von;
    }

    /**
     * Sets the von
     *
     * @param von the value to set
     */

    public void setVon(LocalDate von) {
        this.von = von;
    }

    /**
     * Gets the bis
     *
     * @return value of bis
     */
    public LocalDate getBis() {
        return bis;
    }

    /**
     * Sets the bis
     *
     * @param bis the value to set
     */

    public void setBis(LocalDate bis) {
        this.bis = bis;
    }

    /**
     * Gets the zusatzStruktur
     *
     * @return value of zusatzStruktur
     */
    public String getZusatzStruktur() {
        return zusatzStruktur;
    }

    /**
     * Sets the zusatzStruktur
     *
     * @param zusatzStruktur the value to set
     */

    public void setZusatzStruktur(String zusatzStruktur) {
        this.zusatzStruktur = zusatzStruktur;
    }

    /**
     * Gets the reinigtMieter
     *
     * @return value of reinigtMieter
     */
    public boolean isReinigtMieter() {
        return reinigtMieter;
    }

    /**
     * Sets the reinigtMieter
     *
     * @param reinigtMieter the value to set
     */

    public void setReinigtMieter(boolean reinigtMieter) {
        this.reinigtMieter = reinigtMieter;
    }

    /**
     * Gets the status
     *
     * @return value of status
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the status
     *
     * @param status the value to set
     */
    public void setStatus(String status) {
        this.status = status;
      
    @Override
    public int compareTo(Reservation reservation) {
        if (getVon() == null || reservation.getVon() == null)
            return 0;
        return getVon().compareTo(reservation.getVon());
    }
}

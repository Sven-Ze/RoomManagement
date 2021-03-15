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
public class Reservation {
    private int reservationId;
    private List<Mieter> mieterList;
    private List<Room> roomList;
    private LocalDate von;
    private LocalDate bis;
    private String zusatzStruktur;
    private boolean reinigtMieter;

    public Reservation( List<Mieter> mieterList, List<Room> roomList, LocalDate von, LocalDate bis, String zusatzStruktur, boolean reinigtMieter) {
        this.mieterList = mieterList;
        this.roomList = roomList;
        this.von = von;
        this.bis = bis;
        this.zusatzStruktur = zusatzStruktur;
        this.reinigtMieter = reinigtMieter;
    }

    public Reservation() {

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
     * Gets the mieterList
     *
     * @return value of mieterList
     */
    public List<Mieter> getMieterList() {
        return mieterList;
    }

    /**
     * Sets the mieterList
     *
     * @param mieterList the value to set
     */

    public void setMieterList(List<Mieter> mieterList) {
        this.mieterList = mieterList;
    }

    /**
     * Gets the roomList
     *
     * @return value of roomList
     */
    public List<Room> getRoomList() {
        return roomList;
    }

    /**
     * Sets the roomList
     *
     * @param roomList the value to set
     */

    public void setRoomList(List<Room> roomList) {
        this.roomList = roomList;
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
}

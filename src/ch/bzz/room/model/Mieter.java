package ch.bzz.room.model;

/**
 * short description
 * <p>
 * RoomManagement
 *
 * @author TODO
 * @version 1.0
 * @since 15.03.21
 */
public class Mieter {
    private int mieterId;
    private String mieterVorname;
    private String mieterNachname;
    private String telefon;

    public Mieter( String mieterVorname, String mieterNachname, String telefon) {
        this.mieterVorname = mieterVorname;
        this.mieterNachname = mieterNachname;
        this.telefon = telefon;
    }

    public Mieter() {
    }

    /**
     * Gets the mieterId
     *
     * @return value of mieterId
     */
    public int getMieterId() {
        return mieterId;
    }

    /**
     * Sets the mieterId
     *
     * @param mieterId the value to set
     */

    public void setMieterId(int mieterId) {
        this.mieterId = mieterId;
    }

    /**
     * Gets the mieterVorname
     *
     * @return value of mieterVorname
     */
    public String getMieterVorname() {
        return mieterVorname;
    }

    /**
     * Sets the mieterVorname
     *
     * @param mieterVorname the value to set
     */

    public void setMieterVorname(String mieterVorname) {
        this.mieterVorname = mieterVorname;
    }

    /**
     * Gets the mieterNachname
     *
     * @return value of mieterNachname
     */
    public String getMieterNachname() {
        return mieterNachname;
    }

    /**
     * Sets the mieterNachname
     *
     * @param mieterNachname the value to set
     */

    public void setMieterNachname(String mieterNachname) {
        this.mieterNachname = mieterNachname;
    }

    /**
     * Gets the telefon
     *
     * @return value of telefon
     */
    public String getTelefon() {
        return telefon;
    }

    /**
     * Sets the telefon
     *
     * @param telefon the value to set
     */

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }
}

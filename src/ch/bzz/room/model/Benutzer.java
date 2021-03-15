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
public class Benutzer {
    private int benutzerId;
    private String benutzerName;
    private String passwort;
    private String rolle;

    public Benutzer() {
    }

    public Benutzer(String benutzerName, String passwort, String rolle) {
        this.benutzerName = benutzerName;
        this.passwort = passwort;
        this.rolle = rolle;
    }

    /**
     * Gets the benutzerId
     *
     * @return value of benutzerId
     */
    public int getBenutzerId() {
        return benutzerId;
    }

    /**
     * Sets the benutzerId
     *
     * @param benutzerId the value to set
     */

    public void setBenutzerId(int benutzerId) {
        this.benutzerId = benutzerId;
    }

    /**
     * Gets the benutzerName
     *
     * @return value of benutzerName
     */
    public String getBenutzerName() {
        return benutzerName;
    }

    /**
     * Sets the benutzerName
     *
     * @param benutzerName the value to set
     */

    public void setBenutzerName(String benutzerName) {
        this.benutzerName = benutzerName;
    }

    /**
     * Gets the passwort
     *
     * @return value of passwort
     */
    public String getPasswort() {
        return passwort;
    }

    /**
     * Sets the passwort
     *
     * @param passwort the value to set
     */

    public void setPasswort(String passwort) {
        this.passwort = passwort;
    }

    /**
     * Gets the rolle
     *
     * @return value of rolle
     */
    public String getRolle() {
        return rolle;
    }

    /**
     * Sets the rolle
     *
     * @param rolle the value to set
     */

    public void setRolle(String rolle) {
        this.rolle = rolle;
    }
}

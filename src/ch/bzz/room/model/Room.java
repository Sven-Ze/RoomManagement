package ch.bzz.room.model;

/**
 * short description
 * <p>
 * 426_RoomManagement
 *
 * @author Tizian
 * @version 1.0
 * @since 01.03.21
 */
public class Room {
    private int roomId;
    private int grundflaeche;
    private boolean hasProjector;
    private boolean hasVideo;
    private boolean hasSound;
    private boolean hasLavabo;
    private String besonderheiten;

    /**
     * Gets the roomId
     *
     * @return value of roomId
     */
    public int getRoomId() {
        return roomId;
    }

    /**
     * Sets the roomId
     *
     * @param roomId the value to set
     */

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    /**
     * Gets the grundflaeche
     *
     * @return value of grundflaeche
     */
    public int getGrundflaeche() {
        return grundflaeche;
    }

    /**
     * Sets the grundflaeche
     *
     * @param grundflaeche the value to set
     */

    public void setGrundflaeche(int grundflaeche) {
        this.grundflaeche = grundflaeche;
    }

    /**
     * Gets the hasProjector
     *
     * @return value of hasProjector
     */
    public boolean isHasProjector() {
        return hasProjector;
    }

    /**
     * Sets the hasProjector
     *
     * @param hasProjector the value to set
     */

    public void setHasProjector(boolean hasProjector) {
        this.hasProjector = hasProjector;
    }

    /**
     * Gets the hasVideo
     *
     * @return value of hasVideo
     */
    public boolean isHasVideo() {
        return hasVideo;
    }

    /**
     * Sets the hasVideo
     *
     * @param hasVideo the value to set
     */

    public void setHasVideo(boolean hasVideo) {
        this.hasVideo = hasVideo;
    }

    /**
     * Gets the hasSound
     *
     * @return value of hasSound
     */
    public boolean isHasSound() {
        return hasSound;
    }

    /**
     * Sets the hasSound
     *
     * @param hasSound the value to set
     */

    public void setHasSound(boolean hasSound) {
        this.hasSound = hasSound;
    }

    /**
     * Gets the hasLavabo
     *
     * @return value of hasLavabo
     */
    public boolean isHasLavabo() {
        return hasLavabo;
    }

    /**
     * Sets the hasLavabo
     *
     * @param hasLavabo the value to set
     */

    public void setHasLavabo(boolean hasLavabo) {
        this.hasLavabo = hasLavabo;
    }

    /**
     * Gets the besonderheiten
     *
     * @return value of besonderheiten
     */
    public String getBesonderheiten() {
        return besonderheiten;
    }

    /**
     * Sets the besonderheiten
     *
     * @param besonderheiten the value to set
     */

    public void setBesonderheiten(String besonderheiten) {
        this.besonderheiten = besonderheiten;
    }
}

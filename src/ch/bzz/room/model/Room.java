package ch.bzz.room.model;

/**
 * Room Data Class
 * <p>
 * 426_RoomManagement
 *
 * @author Tizian
 * @version 1.0
 * @since 01.03.21
 */
public class Room {
    private int roomId;
    private String raumName;

    public Room(String raumName) {
        this.raumName = raumName;
    }

    public Room() {
    }

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
     * Gets the raumName
     *
     * @return value of raumName
     */
    public String getRaumName() {
        return raumName;
    }

    /**
     * Sets the raumName
     *
     * @param raumName the value to set
     */

    public void setRaumName(String raumName) {
        this.raumName = raumName;
    }
}

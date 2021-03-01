package ch.bzz.room.util;

/**
 * short description
 * <p>
 * RoomManagement
 *
 * @author TODO
 * @version 1.0
 * @since 01.03.21
 */
public enum Result {
    SUCCESS(0), // command was successfully executed
    NOACTION(1), // nothing to be done
    DUPLICATE(4), // duplicate entry in database
    ERROR(9); // there was an error => throw exception

    private int code;

    Result(int code) {
        this.setCode(code);
    }

    /**
     * @param code
     *            the code to set
     */
    public void setCode(int code) {
        this.code = code;
    }

}

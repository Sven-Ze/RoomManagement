package ch.bzz.room.model;

/**
 * short description
 * <p>
 * 426_RoomManagement
 *
 * @author TODO
 * @version 1.0
 * @since 15.03.21
 */
public class User {

    private Integer userId;
    private String username;
    private String password;
    private String userRole;

    public User(){setUserRole("guest");}
    /**
     * Gets the userId
     *
     * @return value of userId
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * Sets the userId
     *
     * @param userId the value to set
     */

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * Gets the username
     *
     * @return value of username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the username
     *
     * @param username the value to set
     */

    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Gets the password
     *
     * @return value of password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password
     *
     * @param password the value to set
     */

    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets the userRole
     *
     * @return value of userRole
     */
    public String getUserRole() {
        return userRole;
    }

    /**
     * Sets the userRole
     *
     * @param userRole the value to set
     */

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }
}

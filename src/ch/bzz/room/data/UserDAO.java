package ch.bzz.room.data;

import ch.bzz.room.model.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * short description
 * <p>
 * 426_RoomManagement
 *
 * @author TODO
 * @version 1.0
 * @since 15.03.21
 */
public class UserDAO implements DAO<User, String> {

    @Override
    public List<User> getAll() {
        ResultSet resultSet;
        List<User> userList = new ArrayList<>();
        String sqlQuery =
                "SELECT benutzerId, benutzername, rolle, passwort from Benutzer;";
        try {
            resultSet = MySqlDB.sqlSelect(sqlQuery);
            while (resultSet.next()) {
                User user = new User();
                setValues(resultSet, user);
                userList.add(user);
            }

        } catch (SQLException sqlEx) {

            sqlEx.printStackTrace();
            throw new RuntimeException();
        } finally {

            MySqlDB.sqlClose();
        }
        return userList;
    }

    /**
     * reads a benutzer from the table "benutzer" identified by the benutzerId
     *
     * @param username the primary key
     * @return benutzer object
     */
    public User getEntity(String username, String password) {
        ResultSet resultSet;
        User benutzer = new User();

        String sqlQuery =
                "SELECT benutzerId, benutzername, rolle, passwort from Benutzer" +
                        " WHERE benutzername=? AND passwort=?";
        try {
            HashMap<Integer, String> map = new HashMap<>();
            map.put(1, username);
            map.put(2, password);
            resultSet = MySqlDB.sqlSelect(sqlQuery, map);
            if (resultSet.next()) {
                setValues(resultSet, benutzer);
            }
        } catch (SQLException sqlEx) {

            sqlEx.printStackTrace();
            throw new RuntimeException();
        } finally {
            MySqlDB.sqlClose();
        }
        return benutzer;
    }

    private void setValues(ResultSet resultSet, User user) throws SQLException {
        user.setUserId(resultSet.getInt("benutzerId"));
        user.setUsername(resultSet.getString("benutzername"));
        user.setPassword(resultSet.getString("passwort"));
        user.setUserRole(resultSet.getString("rolle"));
    }
}

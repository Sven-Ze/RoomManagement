package ch.bzz.room.data;

import ch.bzz.room.model.Room;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * short description
 * <p>
 * RoomManagement
 *
 * @author Endrit Kukalaj
 * @version 1.0
 * @since 01.03.21
 */
public class RoomDAO implements DAO<Room, String>{

    /**
     * reads all rooms in the table "room"
     * @return list of room
     */
    @Override
    public List<Room> getAll() {
        ResultSet resultSet;
        List<Room> roomList = new ArrayList<>();
        String sqlQuery = "SELECT `Room`.`roomId`,\n" +
                "    `Room`.`grundflaeche`,\n" +
                "    `Room`.`hasProjector`,\n" +
                "    `Room`.`hasSound`,\n" +
                "    `Room`.`hasLavabo`,\n" +
                "    `Room`.`hasVideo`,\n" +
                "    `Room`.`kosten`,\n" +
                "    `Room`.`besonderheiten`\n" +
                "FROM `RoomDB`.`Room`;";
        try {
            resultSet = MySqlDB.sqlSelect(sqlQuery);
            while (resultSet.next()) {
                Room room = new Room();
                setValues(resultSet, room);
                roomList.add(room);
            }
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
            throw new RuntimeException();
        } finally {
            MySqlDB.sqlClose();
        }
        return roomList;
    }

    /**
     * reads a room from the table "room" identified by the roomID
     * @param id the primary key
     * @return room object
     */
    public Room getEntity(String id) {
        ResultSet resultSet;
        Room room = new Room();
        String sqlQuery = "SELECT `Room`.`roomId`,\n" +
                "    `Room`.`grundflaeche`,\n" +
                "    `Room`.`hasProjector`,\n" +
                "    `Room`.`hasSound`,\n" +
                "    `Room`.`hasLavabo`,\n" +
                "    `Room`.`hasVideo`,\n" +
                "    `Room`.`kosten`,\n" +
                "    `Room`.`besonderheiten`\n" +
                "FROM `RoomDB`.`Room`;" + " WHERE roomId=?";
        try {
            HashMap<Integer, String> map = new HashMap<>();
            map.put(1, id);
            resultSet = MySqlDB.sqlSelect(sqlQuery, map);
            if (resultSet.next()) {
                setValues(resultSet, room);
            }
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
            throw new RuntimeException();
        } finally {
            MySqlDB.sqlClose();
        }
        return room;
    }

    private void setValues(ResultSet resultSet, Room room) throws SQLException {
        room.setRoomId(resultSet.getInt("roomId"));
        room.setGrundflaeche(resultSet.getInt("grundflaeche"));
        room.setHasProjector(resultSet.getBoolean("hasProjector"));
        room.setHasVideo(resultSet.getBoolean("hasVideo"));
        room.setHasSound(resultSet.getBoolean("hasSound"));
        room.setHasLavabo(resultSet.getBoolean("hasLavabo"));
        room.setBesonderheiten(resultSet.getString("besonderheiten"));
        room.setKosten(resultSet.getDouble("kosten"));
    }
}

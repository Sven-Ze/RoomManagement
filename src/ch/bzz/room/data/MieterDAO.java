package ch.bzz.room.data;

import ch.bzz.room.model.Mieter;

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
 * @since 21.03.21
 */
public class MieterDAO implements DAO<Mieter, String>{

    /**
     * reads all mieters in the table "mieter"
     * @return list of mieter
     */
    @Override
    public List<Mieter> getAll() {
        ResultSet resultSet;
        List<Mieter> mieterList = new ArrayList<>();
        String sqlQuery = "SELECT `Mieter`.`mieterId`,\n" +
                "    `Mieter`.`mieterVorname`,\n" +
                "    `Mieter`.`mieterNachname`,\n" +
                "    `Mieter`.`mieterTelefon`\n" +
                "FROM `RoomDB`.`Mieter`;";
        try {
            resultSet = MySqlDB.sqlSelect(sqlQuery);
            while (resultSet.next()) {
                Mieter mieter = new Mieter();
                setValues(resultSet, mieter);
                mieterList.add(mieter);
            }
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
            throw new RuntimeException();
        } finally {
            MySqlDB.sqlClose();
        }
        return mieterList;
    }

    /**
     * reads a mieter from the table "mieter" identified by the mieterID
     * @param id the primary key
     * @return mieter object
     */
    @Override
    public Mieter getEntity(String id) {
        ResultSet resultSet;
        Mieter mieter = new Mieter();
        String sqlQuery = "SELECT `Mieter`.`mieterId`,\n" +
                "    `Mieter`.`mieterVorname`,\n" +
                "    `Mieter`.`mieterNachname`,\n" +
                "    `Mieter`.`mieterTelefon`\n" +
                "FROM `RoomDB`.`Mieter`" + " WHERE mieterId=?";
        try {
            HashMap<Integer, String> map = new HashMap<>();
            map.put(1, id);
            resultSet = MySqlDB.sqlSelect(sqlQuery, map);
            if (resultSet.next()) {
                setValues(resultSet, mieter);
            }
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
            throw new RuntimeException();
        } finally {
            MySqlDB.sqlClose();
        }
        return mieter;
    }

    private void setValues(ResultSet resultSet, Mieter mieter) throws SQLException {

        mieter.setMieterId(resultSet.getInt("mieterId"));
        mieter.setMieterVorname(resultSet.getString("mieterVorname"));
        mieter.setMieterNachname(resultSet.getString("mieterNachname"));
        mieter.setTelefon(resultSet.getString("mieterTelefon"));

    }
}

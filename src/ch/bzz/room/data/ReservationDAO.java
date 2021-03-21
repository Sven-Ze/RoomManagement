package ch.bzz.room.data;


import ch.bzz.room.model.Reservation;

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
public class ReservationDAO implements DAO<Reservation, String>{

    /**
     * reads all reservations in the table "reservation"
     * @return list of reservation room
     */
    @Override
    public List<Reservation> getAll() {
        ResultSet resultSet;
        List<Reservation> reservationList = new ArrayList<>();
        String sqlQuery = "SELECT `Reservation`.`reservationId`,\n" +
                "`Reservation`.`von`,\n" +
                "`Reservation`.`bis`,\n" +
                "`Reservation`.`zusatzinfrastruktur`,\n" +
                "`Reservation`.`vomMieterReinigung`,\n" +
                "`Reservation`.`Mieter_mieterId`,\n" +
                "`Reservation`.`Room_roomId`\n" +
                "FROM `RoomDB`.`Reservation`;";
        try {
            resultSet = MySqlDB.sqlSelect(sqlQuery);
            while (resultSet.next()) {
                Reservation reservation = new Reservation();
                setValues(resultSet, reservation);
                reservationList.add(reservation);
            }
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
            throw new RuntimeException();
        } finally {
            MySqlDB.sqlClose();
        }
        return reservationList;
    }

    /**
     * reads a reservation from the table "reservation" identified by the reservationID
     * @param id the primary key
     * @return reservation object
     */
    @Override
    public Reservation getEntity(String id) {
        ResultSet resultSet;
        Reservation reservation = new Reservation();
        String sqlQuery = "SELECT `Reservation`.`reservationId`,\n" +
                "`Reservation`.`von`,\n" +
                "`Reservation`.`bis`,\n" +
                "`Reservation`.`zusatzinfrastruktur`,\n" +
                "`Reservation`.`vomMieterReinigung`,\n" +
                "`Reservation`.`Mieter_mieterId`,\n" +
                "`Reservation`.`Room_roomId`\n" +
                "FROM `RoomDB`.`Reservation`" + " WHERE reservationId=?";
        try {
            HashMap<Integer, String> map = new HashMap<>();
            map.put(1, id);
            resultSet = MySqlDB.sqlSelect(sqlQuery, map);
            if (resultSet.next()) {
                setValues(resultSet, reservation);
            }
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
            throw new RuntimeException();
        } finally {
            MySqlDB.sqlClose();
        }
        return reservation;
    }

    private void setValues(ResultSet resultSet, Reservation reservation) throws SQLException {
        reservation.setReservationId(resultSet.getInt("reservationId"));
        reservation.setVon(resultSet.getDate("von").toLocalDate());
        reservation.setBis(resultSet.getDate("bis").toLocalDate());
        reservation.setZusatzStruktur(resultSet.getString("zusatzinfrastruktur"));
        reservation.setReinigtMieter(resultSet.getBoolean("vomMieterReinigung"));
        reservation.setMieter(new MieterDAO().getEntity(resultSet.getString("Mieter_mieterId")));
        reservation.setRoom(new RoomDAO().getEntity(resultSet.getString("Room_roomId")));


    }
}

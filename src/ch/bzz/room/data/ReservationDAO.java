package ch.bzz.room.data;

import ch.bzz.room.model.Reservation;
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
public class ReservationDAO implements DAO<Reservation, String>{

    /**
     * reads all reservations in the table "reservation"
     * @return list of rreservation oom
     */
    @Override
    public List<Reservation> getAll() {
        ResultSet resultSet;
        List<Reservation> reservationList = new ArrayList<>();
        String sqlQuery = "SELECT reservationID, flaeche, hasProjector, hasVideo, hasSound, hasLavabo, besonderheiten, kosten from Reservation;";
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
        String sqlQuery = "SELECT `Reservation`.`idReservation`,\n" +
                "    `Reservation`.`name`,\n" +
                "    `Reservation`.`surname`,\n" +
                "    `Reservation`.`contact`,\n" +
                "    `Reservation`.`phoneNr`,\n" +
                "    `Reservation`.`mail`,\n" +
                "    `Reservation`.`startDate`,\n" +
                "    `Reservation`.`endDate`,\n" +
                "    `Reservation`.`giveKey`,\n" +
                "    `Reservation`.`receiveKey`,\n" +
                "    `Reservation`.`willBeCleaned`,\n" +
                "    `Reservation`.`wish`,\n" +
                "    `Reservation`.`note`\n" +
                "FROM `RoomDB`.`Reservation`;" + " WHERE idReservation=?";
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
        reservation.setName(resultSet.getString("name"));
        reservation.setSurname(resultSet.getString("surname"));
        reservation.setContact(resultSet.getString("contact"));
        reservation.setPhoneNr(resultSet.getString("phoneNr"));
        reservation.setMail(resultSet.getString("mail"));
        reservation.setStartDate(resultSet.getDate("startDate").toLocalDate());
        reservation.setEndDate(resultSet.getDate("endDate").toLocalDate());
        reservation.setGiveKey(resultSet.getDate("giveKey").toLocalDate());
        reservation.setReceiveKey(resultSet.getDate("receiveKey").toLocalDate());
        reservation.setWillBeCleaned(resultSet.getBoolean("willBeCleaned"));
        reservation.setWish(resultSet.getString("wish"));
        reservation.setNote(resultSet.getString("note"));


    }
}

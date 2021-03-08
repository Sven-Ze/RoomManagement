package ch.bzz.room.service;

import ch.bzz.room.data.DAO;
import ch.bzz.room.data.ReservationDAO;
import ch.bzz.room.data.RoomDAO;
import ch.bzz.room.model.Reservation;
import ch.bzz.room.model.Room;

import javax.ejb.Local;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * short description
 * <p>
 * RoomManagement
 *
 * @author TODO
 * @version 1.0
 * @since 01.03.21
 */

@Path("reservation")
public class ReservationService {

    @GET
    @Path("list")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listRooms() {
        int httpStatus = 200;

        DAO<Reservation, String> projectDao = new ReservationDAO();
        //List<Reservation> reservationList = projectDao.getAll();
        List<Reservation> reservationList = new ArrayList<>();

        Room room = new Room();
        room.setRoomId(1);
        room.setRoomType("Turnhalle");

        Room room1 = new Room();
        room1.setRoomId(2);
        room1.setRoomType("Küche");

        Room room2 = new Room();
        room2.setRoomId(3);
        room2.setRoomType("Sitzungszimmer");

        Reservation reservation1 = new Reservation();
        reservation1.setName("Zeindler");
        reservation1.setSurname("Sven");
        reservation1.setContact("Drin");
        reservation1.setPhoneNr("078 923 22 23");
        reservation1.setMail("sven.zeindler@me.com");
        reservation1.setStartDate(LocalDate.now());
        reservation1.setEndDate(LocalDate.now());
        reservation1.setReceiveKey(LocalDate.now());
        reservation1.setWillBeCleaned(true);
        reservation1.setWish("Kein Wunsch");
        reservation1.setNote("Der Schlüssel wird unter dem Teppich deponiert");
        reservation1.setRoom(room);

        Reservation reservation2 = new Reservation();
        reservation2.setName("Muslija");
        reservation2.setSurname("Drin");
        reservation2.setContact("Endrit");
        reservation2.setPhoneNr("078 923 22 24");
        reservation2.setMail("drin.muslija@me.com");
        reservation2.setStartDate(LocalDate.now());
        reservation2.setEndDate(LocalDate.now());
        reservation2.setReceiveKey(LocalDate.now());
        reservation2.setWillBeCleaned(true);
        reservation2.setWish("Kein Wunsch");
        reservation2.setNote("Nichts");
        reservation2.setRoom(room1);


        Reservation reservation3 = new Reservation();
        reservation3.setName("Klincov");
        reservation3.setSurname("Kristijan");
        reservation3.setContact("Fadri");
        reservation3.setPhoneNr("078 923 22 26");
        reservation3.setMail("kristijan.klincov@me.com");
        reservation3.setStartDate(LocalDate.now());
        reservation3.setEndDate(LocalDate.now());
        reservation3.setReceiveKey(LocalDate.now());
        reservation3.setWillBeCleaned(true);
        reservation3.setWish("Kein Wunsch");
        reservation3.setNote("Nichts");
        reservation3.setRoom(room2);

        reservationList.add(reservation1);
        reservationList.add(reservation2);
        reservationList.add(reservation3);


        if (reservationList.isEmpty()) {
            return Response
                    .status(404)
                    .entity("{\"error\":\"Keine Reservationen gefunden\"}")
                    .build();
        } else {
            return Response
                    .status(httpStatus)
                    .entity(reservationList)
                    .build();
        }
    }
}

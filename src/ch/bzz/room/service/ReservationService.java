package ch.bzz.room.service;

import ch.bzz.room.data.DAO;
import ch.bzz.room.data.ReservationDAO;
import ch.bzz.room.data.RoomDAO;
import ch.bzz.room.model.Reservation;
import ch.bzz.room.model.Room;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
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
        List<Reservation> reservationList = projectDao.getAll();

        if (reservationList.isEmpty()) {
            return Response
                    .status(404)
                    .entity("{\"error\":\"Keine Projekte gefunden\"}")
                    .build();
        } else {
            return Response
                    .status(httpStatus)
                    .entity(reservationList)
                    .build();
        }
    }
}

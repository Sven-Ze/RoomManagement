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
import java.time.Duration;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * short description
 * <p>
 * RoomManagement
 *
 * @author Tizian
 * @version 1.0
 * @since 01.03.21
 */

@Path("reservation")
public class ReservationService {
    private final int ONEWEEK = 7;

    @GET
    @Path("list")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listRooms() {
        int httpStatus = 200;

        DAO<Reservation, String> projectDao = new ReservationDAO();
        List<Reservation> reservationList = projectDao.getAll();
        List<Reservation> filteredList = new ArrayList<>();

        for(Reservation r : reservationList) {
            long daysBetween = getDaysBetween(r.getVon());
            if(daysBetween <= ONEWEEK) {
                filteredList.add(r);
            }
        }

        Collections.sort(filteredList);

        if (filteredList.isEmpty()) {
            return Response
                    .status(404)
                    .entity("{\"error\":\"Keine Reservationen gefunden\"}")
                    .build();
        } else {
            return Response
                    .status(httpStatus)
                    .entity(filteredList)
                    .build();
        }
    }

    public static long getDaysBetween(LocalDate startDate) {
        LocalDate now = LocalDate.now();

        long numOfDaysBetween = Duration.between(now, startDate).toDays();
        return numOfDaysBetween;
    }
}

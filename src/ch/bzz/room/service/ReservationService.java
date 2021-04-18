package ch.bzz.room.service;

import ch.bzz.room.data.DAO;
import ch.bzz.room.data.ReservationDAO;
import ch.bzz.room.data.RoomDAO;
import ch.bzz.room.model.Reservation;
import ch.bzz.room.model.Room;
import ch.bzz.room.util.TextFileCreator;

import javax.ejb.Local;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static ch.bzz.room.util.TextFileCreator.write;

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
    @Path("listAccepted")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listAcceptedReservations() {
        int httpStatus = 200;

        DAO<Reservation, String> projectDao = new ReservationDAO();
        List<Reservation> reservationList = projectDao.getAll();
        List<Reservation> filteredList = new ArrayList<>();

        for(Reservation r : reservationList) {
            long daysBetween = getDaysBetween(r.getVon());
            if(daysBetween <= ONEWEEK && r.getVon().isAfter(LocalDate.now())) {
                if(r.getStatus().equalsIgnoreCase("accepted")) {
                    filteredList.add(r);
                }
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

    @GET
    @Path("listPending")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listPendingReservations() {
        int httpStatus = 200;

        DAO<Reservation, String> projectDao = new ReservationDAO();
        List<Reservation> reservationList = projectDao.getAll();
        List<Reservation> filteredList = new ArrayList<>();

        for(Reservation r : reservationList) {
            long daysBetween = getDaysBetween(r.getVon());
            if(daysBetween <= ONEWEEK && r.getVon().isAfter(LocalDate.now())) {
                if(r.getStatus().equalsIgnoreCase("pending")) {
                    filteredList.add(r);
                }
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

    @GET
    @Path("read")
    @Produces(MediaType.APPLICATION_JSON)
    public Response readReservation(
            @QueryParam("reservationId")
            @NotEmpty String id,
            @CookieParam("userRole") String userRole

    ){
        Reservation reservation = null;
        int httpStatus;
        if (userRole == null || userRole.equals("gast")){
            httpStatus = 403;
        } else {
            reservation = new ReservationDAO().getEntity(id);
            if (reservation != null) {
                httpStatus = 200;
            } else {
                httpStatus = 404;
            }
        }
        Response response = Response
                .status(httpStatus)
                .entity(reservation)
                .build();
        return response;
    }

    @Path("delete")
    @DELETE
    @Produces(MediaType.TEXT_PLAIN)
    public Response deleteReservation(
            @QueryParam("reservationId") Integer id,
            @CookieParam("userRole") String userRole){
        int httpStatus;
        if (userRole != null && userRole.equals("verwaltung")) {
            new ReservationDAO().delete(id);
            httpStatus = 200;

        } else {
            httpStatus = 403;
        }
        Response response = Response
                .status(httpStatus)
                .entity("")
                .build();
        return response;
    }

    @Path("update")
    @PUT
    @Produces(MediaType.TEXT_PLAIN)
    public Response updateReservation(
            Reservation reservation,
            @CookieParam("userRole") String userRole){
        int httpStatus;
        DAO<Reservation, String> projectDao = new ReservationDAO();
        List<Reservation> reservationList = projectDao.getAll();

        if (userRole != null && userRole.equals("verwaltung")) {
            for(Reservation r : reservationList) {
                if (r.getReservationId() == reservation.getReservationId()) {
                    projectDao.save(reservation);
                }
            }
            httpStatus = 200;

        } else {
            httpStatus = 403;
        }
        Response response = Response
                .status(httpStatus)
                .entity("")
                .build();
        return response;
    }

    @Path("save")
    @POST
    @Produces(MediaType.TEXT_PLAIN)
    public Response saveReservation(
            Reservation reservation,
            @CookieParam("userRole") String userRole){
        int httpStatus;
        if (userRole != null && userRole.equals("verwaltung")) {
            new ReservationDAO().save(reservation);
            httpStatus = 200;

        } else {
            httpStatus = 403;
        }
        Response response = Response
                .status(httpStatus)
                .entity("")
                .build();
        return response;
    }

    @Path("getFile")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Response createMietvertrag(
            @QueryParam("reservationId")
            @NotEmpty String id,
            @CookieParam("userRole") String userRole

    ){
        int httpStatus = 200;
        ReservationDAO projectDao = new ReservationDAO();
        Reservation reservation = projectDao.getEntity(id);


        write(reservation);

        Response response = Response
                .status(httpStatus)
                .entity(reservation)
                .build();
        return response;
    }


    public static long getDaysBetween(LocalDate startDate) {
        LocalDateTime now = LocalDate.now().atStartOfDay();

        long numOfDaysBetween = Duration.between(now, startDate.atStartOfDay()).toDays();
        return numOfDaysBetween;
    }
}

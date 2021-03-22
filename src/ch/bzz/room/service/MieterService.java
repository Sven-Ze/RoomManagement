package ch.bzz.room.service;

import ch.bzz.room.data.DAO;
import ch.bzz.room.data.MieterDAO;
import ch.bzz.room.data.ReservationDAO;
import ch.bzz.room.model.Mieter;
import ch.bzz.room.model.Reservation;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * short description
 * <p>
 * 426_RoomManagement
 *
 * @author TODO
 * @version 1.0
 * @since 22.03.21
 */
@Path("mieter")
public class MieterService {

    @GET
    @Path("list")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listMieter() {
        int httpStatus = 200;

        DAO<Mieter, String> mieterDao = new MieterDAO();
        List<Mieter> mieterList = mieterDao.getAll();

        if (mieterList.isEmpty()) {
            return Response
                    .status(404)
                    .entity("{\"error\":\"Keine Mieter gefunden\"}")
                    .build();
        } else {
            return Response
                    .status(httpStatus)
                    .entity(mieterList)
                    .build();
        }
    }
}

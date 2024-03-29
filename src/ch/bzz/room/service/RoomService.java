package ch.bzz.room.service;

import ch.bzz.room.data.DAO;
import ch.bzz.room.data.RoomDAO;
import ch.bzz.room.model.Room;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
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

@Path("room")
public class RoomService {

    @GET
    @Path("list")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listRooms() {
        int httpStatus = 200;

        DAO<Room, String> projectDao = new RoomDAO();
        List<Room> roomList = projectDao.getAll();

        if (roomList.isEmpty()) {
            return Response
                    .status(404)
                    .entity("{\"error\":\"Keine Projekte gefunden\"}")
                    .build();
        } else {
            return Response
                    .status(httpStatus)
                    .entity(roomList)
                    .build();
        }
    }
}

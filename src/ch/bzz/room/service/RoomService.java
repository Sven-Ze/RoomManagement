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
        //List<Room> roomList = projectDao.getAll();
        List<Room> roomList = new ArrayList<>();

        Room room1 = new Room();

        room1.setRoomId(1);
        room1.setRoomType("Turnhalle");
        room1.setBesonderheiten("3 Turnhallen nebeneinander, die auch als 3fach Turnhalle genutzt werden können");
        room1.setGrundflaeche(500);
        room1.setKosten(450);

        Room room2 = new Room();

        room2.setRoomId(2);
        room2.setRoomType("Küche ");
        room2.setBesonderheiten("Industrieküche für ca. 200 Personen, Kochplatte, Kipper, Steamer, Backofen, Kühlschränke, kein Geschirr");
        room2.setGrundflaeche(100);
        room2.setKosten(300);

        Room room3 = new Room();

        room3.setRoomId(3);
        room3.setRoomType("Sitzungs");
        room3.setBesonderheiten("Projektor, Verstärker, Whiteboard, Lavabo  ");
        room3.setGrundflaeche(50);
        room3.setKosten(75);

        roomList.add(room1);
        roomList.add(room2);
        roomList.add(room3);
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

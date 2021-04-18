package ch.bzz.room.service;

import ch.bzz.room.data.UserDAO;
import ch.bzz.room.model.User;

import javax.validation.constraints.Size;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;

/**
 * short description
 * <p>
 * 426_RoomManagement
 *
 * @author TODO
 * @version 1.0
 * @since 15.03.21
 */
@Path("user")
public class UserService {

    @POST
    @Path("login")
    @Produces(MediaType.TEXT_PLAIN)
    public Response login (
            @FormParam("username")
            @Size(min=2, max=20) String username,
            @FormParam("password")
            @Size(min=2, max=20) String password
    ){
        int httpStatus;
        User user = new UserDAO().getEntity(username, password);
        if (user.getUserRole().equals("guest")) {
            httpStatus = 404;
        } else {
            httpStatus = 200;
        }
        NewCookie cookie = new NewCookie(
                "userRole",
                user.getUserRole(),
                "/",
                "",
                "Login-Cookie",
                600,
                false
        );
        Response response = Response
                .status(httpStatus)
                .entity("")
                .cookie(cookie)
                .build();
        return response;

    }

    @DELETE
    @Path("logout")
    @Produces(MediaType.TEXT_PLAIN)
    public Response logout() {
        NewCookie cookie = new NewCookie(
                "userRole",
                "guest",
                "/",
                "",
                "Login-Cookie",
                1,
                false
        );
        Response response = Response
                .status(200)
                .cookie(cookie)
                .entity("")
                .build();
        return response;
    }
}

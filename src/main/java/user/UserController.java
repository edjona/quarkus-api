package user;

import user.model.User;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.util.List;

import static javax.ws.rs.core.Response.noContent;
import static javax.ws.rs.core.Response.ok;

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserController {
    private final UserService userService;

    @Inject
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GET
    public Response getUser() {
        List<User> userList = userService.getUsers();

        if(userList.isEmpty()) return noContent().build();

        return ok(userList).build();
    }

    @POST
    public Response addUser(User user) {
        userService.createUser(user);

        return ok().build();
    }
}

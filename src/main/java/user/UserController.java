package user;

import io.vertx.core.json.JsonObject;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.resteasy.annotations.jaxrs.PathParam;
import proxy.UserProxy;

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
    @Inject
    @RestClient
    UserProxy userProxy;

    private final UserService userService;

    @Inject
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GET
    public Response getUsers() {
        List<User> userList = userService.getUsers();

        if (userList.isEmpty()) return noContent().build();

        return ok(userList).build();
    }

    @GET
    @Path("/proxy/responses/{id}")
    public Response getResponseFromProxy(@PathParam String id) {
        return userProxy.getResponse(id);
    }

    @GET
    @Path("/proxy/{id}")
    public Response getUserFromProxy(@PathParam String id) {
        Response response = userProxy.getResponse(id);
        JsonObject object = new JsonObject(response.readEntity(String.class));
        User user = object.getJsonObject("data").mapTo(User.class);

        return ok(user).build();
    }

    @POST
    public Response createUser(User user) {
        userService.createUser(user);
        return ok().build();
    }
}

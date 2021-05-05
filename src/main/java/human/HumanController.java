package human;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

import static javax.ws.rs.core.Response.noContent;
import static javax.ws.rs.core.Response.ok;

@Path("/humans")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class HumanController {
    private final HumanService humanService;

    @Inject
    public HumanController(HumanService humanService) {
        this.humanService = humanService;
    }

    @POST
    public Response createHuman(Human human) {
        humanService.createHuman(human);

        return ok().build();
    }

    @GET
    public Response getUser() {
        List<Human> humanList = humanService.getHumans();

        if(humanList.isEmpty()) return noContent().build();

        return ok(humanList).build();
    }
}

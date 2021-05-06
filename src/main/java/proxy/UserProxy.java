package proxy;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/api")
@Produces(MediaType.APPLICATION_JSON)
@RegisterRestClient(baseUri = "https://reqres.in")
public interface UserProxy {
    @GET
    @Path("/users/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    Response getResponse(@PathParam String id);
}

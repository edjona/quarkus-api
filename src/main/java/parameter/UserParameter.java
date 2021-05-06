package parameter;

import lombok.Data;
import org.jboss.resteasy.annotations.jaxrs.QueryParam;

@Data
public class UserParameter {
    @QueryParam
    private int id;

    @QueryParam
    private String fullName;

    @QueryParam()
    private String lastName;
}

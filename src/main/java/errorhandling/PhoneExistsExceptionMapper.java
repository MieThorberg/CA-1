package errorhandling;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PhoneExistsExceptionMapper implements ExceptionMapper<PhoneExistsException>
{
    static Gson gson = new GsonBuilder().setPrettyPrinting().create();
    @Override
    public Response toResponse(PhoneExistsException ex)
    {
        Logger.getLogger(PhoneExistsExceptionMapper.class.getName())
                .log(Level.SEVERE, null, ex);
        ExceptionDTO err = new ExceptionDTO(400,ex.getMessage());
        return Response
                .status(400)
                .entity(gson.toJson(err))
                .type(MediaType.APPLICATION_JSON)
                .build();
    }
}

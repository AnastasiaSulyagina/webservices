package itmo.webservices.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * Created by anastasia.sulyagina
 */
@Provider
public class CameraServiceExceptionMapper implements ExceptionMapper<CameraServiceException> {
    @Override
    public Response toResponse(CameraServiceException e) {
        return Response.status(Response.Status.BAD_REQUEST)
                .entity(e.getMessage() + ": " + e.getMessage())
                .build();
    }
}


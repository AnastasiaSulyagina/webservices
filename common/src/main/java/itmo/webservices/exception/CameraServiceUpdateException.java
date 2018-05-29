package itmo.webservices.exception;

import javax.xml.ws.WebFault;

/**
 * Created by anastasia.sulyagina
 */
@WebFault(faultBean = "itmo.webservices.CameraServiceException.Detail")
public class CameraServiceUpdateException extends CameraServiceException {
    public CameraServiceUpdateException(String nullField) {
        super("Unable to update camera record",
                new Detail("Null field: " + nullField));
    }
}

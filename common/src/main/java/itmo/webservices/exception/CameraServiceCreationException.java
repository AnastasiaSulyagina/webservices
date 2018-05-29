package itmo.webservices.exception;

import javax.xml.ws.WebFault;

/**
 * Created by anastasia.sulyagina
 */
@WebFault(faultBean = "itmo.webservices.CameraServiceException.Detail")
public class CameraServiceCreationException extends CameraServiceException {
    public CameraServiceCreationException(String nullField) {
        super("Unable to create camera record",
                new Detail("Null field: " + nullField));
    }
}

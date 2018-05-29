package itmo.webservices.exception;

/**
 * Created by anastasia.sulyagina
 */

import javax.xml.ws.WebFault;

@WebFault(faultBean = "itmo.webservices.CameraServiceException.Detail")
public class CameraServiceException extends RuntimeException {
    private final Detail faultDetails;

    public CameraServiceException(String message, Detail faultDetail) {
        super(message);
        this.faultDetails = faultDetail;
    }

    public CameraServiceException(String message, Detail faultDetail, Throwable cause) {
        super(message, cause);
        this.faultDetails = faultDetail;
    }

    public Detail getFaultDetails() {
        return faultDetails;
    }

    public String getMessage() {
        return faultDetails.getDetailMessage();
    }

    public static class Detail {
        private final String detailMessage;

        public Detail(String detailMessage) {
            this.detailMessage = detailMessage;
        }

        public String getDetailMessage() {
            return detailMessage;
        }
    }
}

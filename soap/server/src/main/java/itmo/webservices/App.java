package itmo.webservices;

import javax.xml.ws.Endpoint;

/**
 * Created by anastasia.sulyagina
 */
public class App {
    public static void main(String... args) {
        //System.setProperty("com.sun.xml.ws.fault.SOAPFaultBuilder.disableCaptureStackTrace", "false");
        Utils.initDB();
        Endpoint.publish("http://0.0.0.0:8080/CameraService", new CameraWebService());
    }
}

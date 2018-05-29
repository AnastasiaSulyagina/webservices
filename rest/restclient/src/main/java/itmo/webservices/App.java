package itmo.webservices;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import itmo.webservices.models.Camera;

import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by anastasia.sulyagina
 */
public class App {
    private static final String URL = "http://localhost:8080/cameras";

    public static void main(String[] args) {
        CameraClient client = new CameraClient(URL);
        List<Camera> cams = client.findAll();
        cams.forEach(cam -> System.out.println(cam.getModel()));
    }
}


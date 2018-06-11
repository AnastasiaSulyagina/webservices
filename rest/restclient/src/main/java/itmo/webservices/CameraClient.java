package itmo.webservices;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;
import itmo.webservices.models.Camera;
import sun.misc.BASE64Encoder;

import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by anastasia.sulyagina
 */
public class CameraClient {
    private final Client client;
    private final String url;
    private static final String USERNAME = "user";
    private static final String PASS = "password";

    public CameraClient(String url) {
        this.url = url;
        ClientConfig clientConfig = new DefaultClientConfig();
        clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, true);
        client = Client.create(clientConfig);
    }

    public Client getClient() {
        return client;
    }

    public List<Camera> findByBrand(String brand) {
        WebResource webResource = client.resource(url);
        if (brand != null) {
            webResource = webResource.queryParam("brand", brand);
        }

        final ClientResponse response = webResource
                .header("Authorization", "Basic " + encryptAuth())
                .accept(MediaType.APPLICATION_JSON_TYPE)
                .get(ClientResponse.class);

        final GenericType<List<Camera>> type = new GenericType<List<Camera>>() {};

        if (response.getStatus() != ClientResponse.Status.OK.getStatusCode()) {
            throw new IllegalStateException("Find request failed");
        }

        return response.getEntity(type);
    }

    public List<Camera> findAll() {
        WebResource webResource = client.resource(url);
        final ClientResponse response = webResource
                .header("Authorization", "Basic " + encryptAuth())
                .accept(MediaType.APPLICATION_JSON_TYPE)
                .get(ClientResponse.class);

        final GenericType<List<Camera>> type = new GenericType<List<Camera>>() {};

        if (response.getStatus() != ClientResponse.Status.OK.getStatusCode()) {
            throw new IllegalStateException("Find request failed");
        }

        return response.getEntity(type);
    }

    public void create(String model, String brand, String fullframe, String cameraType, String fixedLens) {
        WebResource resource = client.resource(url)
                .queryParam("model", model)
                .queryParam("brand", brand)
                .queryParam("fullframe", fullframe)
                .queryParam("cameraType", cameraType)
                .queryParam("fixedLens", fixedLens);

        ClientResponse response = resource
                .header("Authorization", "Basic " + encryptAuth())
                .accept(MediaType.APPLICATION_JSON_TYPE)
                .post(ClientResponse.class);

        if (response.getStatus() != ClientResponse.Status.OK.getStatusCode()) {
            throw new IllegalStateException("Create request failed");
        }
    }

    public void update(String id, String model, String brand, String fullframe, String cameraType, String fixedLens) {
        WebResource resource = client.resource(url)
                .queryParam("id", id)
                .queryParam("model", model)
                .queryParam("brand", brand)
                .queryParam("fullframe", fullframe)
                .queryParam("cameraType", cameraType)
                .queryParam("fixedLens", fixedLens);

        ClientResponse response = resource
                .header("Authorization", "Basic " + encryptAuth())
                .accept(MediaType.APPLICATION_JSON_TYPE)
                .put(ClientResponse.class);

        if (response.getStatus() != ClientResponse.Status.OK.getStatusCode()) {
            throw new IllegalStateException("Update request failed");
        }
    }

    public void delete(String id) {
        WebResource resource = client.resource(url)
                .queryParam("id", id);

        ClientResponse response = resource
                .header("Authorization", "Basic " + encryptAuth())
                .accept(MediaType.APPLICATION_JSON_TYPE)
                .delete(ClientResponse.class);

        if (response.getStatus() != ClientResponse.Status.OK.getStatusCode()) {
            throw new IllegalStateException("Delete request failed");
        }
    }

    private String encryptAuth() {
        String authString = USERNAME + ":" + PASS;
        return new BASE64Encoder().encode(authString.getBytes());
    }
}


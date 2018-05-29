package itmo.webservices;


import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

/**
 * Created by anastasia.sulyagina
 */
public class CameraClient {
    private CameraService cs;
    private CameraWebService ws;

    public CameraClient() {
        try {
            cs = new CameraService(new URL("http://localhost:8080/CameraService?wsdl"));
            ws = cs.getCameraWebServicePort();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public List<Camera> find(String model, Brand brand, Boolean fullframe, CameraType cameraType, Boolean fixedLens) {
        return ws.findCameras(model, brand, fullframe, cameraType, fixedLens);
    }

    public Integer create(String model, Brand brand, Boolean fullframe, CameraType cameraType, Boolean fixedLens) {
        Integer id = ws.createCamera(model, brand, fullframe, cameraType, fixedLens);
        return id;
    }

    public void update(Integer id, String model, Brand brand, Boolean fullframe, CameraType cameraType, Boolean fixedLens) {
        OperationStatus status = ws.updateCamera(id, model, brand, fullframe, cameraType, fixedLens);
        if (status != OperationStatus.SUCCESS) {
            throw new IllegalStateException("Delete request failed");
        }
    }

    public void delete(Integer id) {
        OperationStatus status = ws.deleteCamera(id);

        if (status != OperationStatus.SUCCESS) {
            throw new IllegalStateException("Delete request failed");
        }
    }
}

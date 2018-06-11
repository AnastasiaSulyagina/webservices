import itmo.webservices.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.xml.ws.BindingProvider;
import javax.xml.ws.ProtocolException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Created by anastasia.sulyagina
 */
public class CameraServiceTest {

    private CameraService cs;
    private CameraWebService ws;

    @BeforeEach
    protected void init() throws MalformedURLException  {
        cs = new CameraService(new URL("http://localhost:8080/CameraService?wsdl"));
        ws = cs.getCameraWebServicePort();
        BindingProvider p = (BindingProvider) ws;
        p.getRequestContext().put(BindingProvider.USERNAME_PROPERTY, "user");
        p.getRequestContext().put(BindingProvider.PASSWORD_PROPERTY, "password");
    }

    @Test
    protected void testFind(){
        List<Camera> result = ws.findCameras(null, null, null, null, null);
        assertEquals(4, result.size());
    }

    @Test
    protected void testFindByBrand(){
        List<Camera> result = ws.findCameras(null, Brand.NIKON, null, null, null);
        assertEquals(1, result.size());
        assertEquals("D5600", result.get(0).getModel());
    }

    @Test
    protected void testCreateDeleteCamera(){
        Integer id = ws.createCamera("Test", Brand.CANON, true, CameraType.MIRROR, false);
        List<Camera> result = ws.findCameras("Test", null, null, null, null);
        assertEquals(1, result.size());

        OperationStatus status = ws.deleteCamera(id);
        assertEquals(OperationStatus.SUCCESS, status);
        List<Camera> newResult = ws.findCameras("Test", null, null, null, null);
        assertEquals(0, newResult.size());
    }

    @Test
    protected void testUpdateCamera() {
        Integer id = ws.createCamera("Test", Brand.CANON, true, CameraType.MIRROR, false);

        OperationStatus status = ws.updateCamera(
                id,
                "TestTest", //change here
                Brand.CANON,
                false,
                CameraType.MIRROR,
                false);

        assertEquals(OperationStatus.SUCCESS, status);

        List<Camera> result = ws.findCameras("TestTest", null, null, null, null);
        assertEquals(1, result.size());
        ws.deleteCamera(id);
    }

    @Test
    protected void testCreateCarException() {

        ProtocolException e1 = assertThrows(ProtocolException.class, () -> {
            ws.createCamera(null, null, null, null, null);
        });
        assertTrue(e1.getMessage().contains("Null field: model"));
    }

    @Test
    protected void testDeleteCarException() {

        ProtocolException e1 = assertThrows(ProtocolException.class, () -> {
            ws.deleteCamera(null);
        });
        assertTrue(e1.getMessage().contains("Null field: id"));
    }
}

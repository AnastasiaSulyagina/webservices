package itmo.webservices;


import itmo.webservices.dao.CameraDao;
import itmo.webservices.dao.CameraDaoImpl;
import itmo.webservices.exception.CameraServiceCreationException;
import itmo.webservices.exception.CameraServiceException;
import itmo.webservices.exception.CameraServiceUpdateException;
import itmo.webservices.models.Brand;
import itmo.webservices.models.Camera;
import itmo.webservices.models.CameraType;

import javax.annotation.Resource;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;
import java.util.Base64;
import java.util.List;
import java.util.Map;

/**
 * Created by anastasia.sulyagina
 */
@WebService(serviceName = "CameraService")
public class CameraWebService {
    private final CameraDao cameraDao = new CameraDaoImpl();
    private static final String USERNAME = "user";
    private static final String PASS = "password";

    @Resource
    WebServiceContext wsctx;

    @WebMethod(operationName = "findCameras")
    public List<Camera> find(@WebParam(name = "model") String model,
                             @WebParam(name = "brand") Brand brand,
                             @WebParam(name = "full_frame") Boolean fullFrame,
                             @WebParam(name = "camera_type") CameraType cameraType,
                             @WebParam(name = "fixed_lens") Boolean fixedLens) {
        checkAuth();
        return cameraDao.find(model, brand, fullFrame, cameraType, fixedLens);
    }

    @WebMethod(operationName = "createCamera")
    public int create(@WebParam(name = "model") String model,
                       @WebParam(name = "brand") Brand brand,
                       @WebParam(name = "full_frame") Boolean fullFrame,
                       @WebParam(name = "camera_type") CameraType cameraType,
                       @WebParam(name = "fixed_lens") Boolean fixedLens) {
        checkAuth();
        if (model == null) {
            throw new CameraServiceCreationException("model");
        }
        if (brand == null) {
            throw new CameraServiceCreationException("brand");
        }
        if (fullFrame == null) {
            throw new CameraServiceCreationException("full frame");
        }
        if (cameraType == null) {
            throw new CameraServiceCreationException("camera type");
        }
        if (fixedLens == null) {
            throw new CameraServiceCreationException("fixed lens");
        }
        return cameraDao.create(model, brand, fullFrame, cameraType, fixedLens);
    }

    @WebMethod(operationName = "updateCamera")
    public OperationStatus update(@WebParam(name = "id") Integer id,
                                  @WebParam(name = "model") String model,
                                  @WebParam(name = "brand") Brand brand, 
                                  @WebParam(name = "full_frame") Boolean fullFrame,
                                  @WebParam(name = "camera_type") CameraType cameraType,
                                  @WebParam(name = "fixed_lens") Boolean fixedLens) {
        checkAuth();
        if (id == null) {
            throw new CameraServiceUpdateException("id");
        }
        if (model == null) {
            throw new CameraServiceUpdateException("model");
        }
        if (brand == null) {
            throw new CameraServiceUpdateException("brand");
        }
        if (fullFrame == null) {
            throw new CameraServiceUpdateException("full frame");
        }
        if (cameraType == null) {
            throw new CameraServiceUpdateException("camera type");
        }
        if (fixedLens == null) {
            throw new CameraServiceUpdateException("fixed lens");
        }
        return cameraDao.update(id, model, brand, fullFrame, cameraType, fixedLens) ? 
                OperationStatus.SUCCESS : 
                OperationStatus.FAILURE;
    }
    
    @WebMethod(operationName = "deleteCamera")
    public OperationStatus delete(@WebParam(name = "id") Integer id) {
        checkAuth();
        if (id == null) {
            throw new CameraServiceException("Unable to delete camera record", 
                    new CameraServiceException.Detail("Null field: id"));
        }
        return cameraDao.delete(id) ? OperationStatus.SUCCESS : OperationStatus.FAILURE;
    }

    private void checkAuth() throws CameraServiceException {
        List auth = (List)((Map)wsctx.getMessageContext().get(MessageContext.HTTP_REQUEST_HEADERS)).get("Authorization");

        if (auth != null && !auth.isEmpty()) {
            String[] authParts = ((String) auth.get(0)).split(" ");
            if (authParts.length > 1) {
                String decodedAuth = new String(Base64.getDecoder().decode(authParts[1]));
                String[] loginPass = decodedAuth.split(":");
                if (USERNAME.equals(loginPass[0]) && PASS.equals(loginPass[1])) {
                    return;
                }
            }

        }
        throw new CameraServiceException("Authorisation failed",
                new CameraServiceException.Detail("Login-password pair does not match"));
    }
}

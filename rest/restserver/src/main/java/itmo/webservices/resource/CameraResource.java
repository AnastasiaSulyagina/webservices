package itmo.webservices.resource;

/**
 * Created by anastasia.sulyagina
 */

import itmo.webservices.OperationStatus;
import itmo.webservices.dao.CameraDao;
import itmo.webservices.dao.CameraDaoImpl;
import itmo.webservices.exception.CameraServiceCreationException;
import itmo.webservices.exception.CameraServiceException;
import itmo.webservices.exception.CameraServiceUpdateException;
import itmo.webservices.models.Brand;
import itmo.webservices.models.Camera;
import itmo.webservices.models.CameraType;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/cameras")
@Produces(MediaType.APPLICATION_JSON)
public class CameraResource {
    private final CameraDao cameraDao = new CameraDaoImpl();

    @GET
    public List<Camera> find(@QueryParam("model") String model,
                             @QueryParam("brand") Brand brand,
                             @QueryParam("fullFrame") Boolean fullFrame,
                             @QueryParam("cameraType") CameraType cameraType,
                             @QueryParam("fixedLens") Boolean fixedLens) {
        return cameraDao.find(model, brand, fullFrame, cameraType, fixedLens);
    }

    @POST
    public long create(@QueryParam("model") String model,
                       @QueryParam("brand") Brand brand,
                       @QueryParam("fullFrame") Boolean fullFrame,
                       @QueryParam("cameraType") CameraType cameraType,
                       @QueryParam("fixedLens") Boolean fixedLens) {
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

    @PUT
    public OperationStatus update(@QueryParam("id") Integer id,
                           @QueryParam("model") String model,
                           @QueryParam("brand") Brand brand,
                           @QueryParam("fullFrame") Boolean fullFrame,
                           @QueryParam("cameraType") CameraType cameraType,
                           @QueryParam("fixedLens") Boolean fixedLens) {
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

    @DELETE
    public OperationStatus delete(@QueryParam("id") Integer id) {
        if (id == null) {
            throw new CameraServiceException("Unable to delete camera record",
                    new CameraServiceException.Detail("Null field: id"));
        }
        return cameraDao.delete(id) ?
                OperationStatus.SUCCESS :
                OperationStatus.FAILURE;
    }
}


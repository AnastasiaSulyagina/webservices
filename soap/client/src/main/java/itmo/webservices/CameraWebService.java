
package itmo.webservices;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "CameraWebService", targetNamespace = "http://webservices.itmo/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface CameraWebService {


    /**
     * 
     * @param fullFrame
     * @param fixedLens
     * @param model
     * @param id
     * @param brand
     * @param cameraType
     * @return
     *     returns itmo.webservices.OperationStatus
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "updateCamera", targetNamespace = "http://webservices.itmo/", className = "itmo.webservices.UpdateCamera")
    @ResponseWrapper(localName = "updateCameraResponse", targetNamespace = "http://webservices.itmo/", className = "itmo.webservices.UpdateCameraResponse")
    @Action(input = "http://webservices.itmo/CameraWebService/updateCameraRequest", output = "http://webservices.itmo/CameraWebService/updateCameraResponse")
    public OperationStatus updateCamera(
        @WebParam(name = "id", targetNamespace = "")
        Integer id,
        @WebParam(name = "model", targetNamespace = "")
        String model,
        @WebParam(name = "brand", targetNamespace = "")
        Brand brand,
        @WebParam(name = "full_frame", targetNamespace = "")
        Boolean fullFrame,
        @WebParam(name = "camera_type", targetNamespace = "")
        CameraType cameraType,
        @WebParam(name = "fixed_lens", targetNamespace = "")
        Boolean fixedLens);

    /**
     * 
     * @param fullFrame
     * @param fixedLens
     * @param model
     * @param brand
     * @param cameraType
     * @return
     *     returns java.util.List<itmo.webservices.Camera>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "findCameras", targetNamespace = "http://webservices.itmo/", className = "itmo.webservices.FindCameras")
    @ResponseWrapper(localName = "findCamerasResponse", targetNamespace = "http://webservices.itmo/", className = "itmo.webservices.FindCamerasResponse")
    @Action(input = "http://webservices.itmo/CameraWebService/findCamerasRequest", output = "http://webservices.itmo/CameraWebService/findCamerasResponse")
    public List<Camera> findCameras(
        @WebParam(name = "model", targetNamespace = "")
        String model,
        @WebParam(name = "brand", targetNamespace = "")
        Brand brand,
        @WebParam(name = "full_frame", targetNamespace = "")
        Boolean fullFrame,
        @WebParam(name = "camera_type", targetNamespace = "")
        CameraType cameraType,
        @WebParam(name = "fixed_lens", targetNamespace = "")
        Boolean fixedLens);

    /**
     * 
     * @param id
     * @return
     *     returns itmo.webservices.OperationStatus
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "deleteCamera", targetNamespace = "http://webservices.itmo/", className = "itmo.webservices.DeleteCamera")
    @ResponseWrapper(localName = "deleteCameraResponse", targetNamespace = "http://webservices.itmo/", className = "itmo.webservices.DeleteCameraResponse")
    @Action(input = "http://webservices.itmo/CameraWebService/deleteCameraRequest", output = "http://webservices.itmo/CameraWebService/deleteCameraResponse")
    public OperationStatus deleteCamera(
        @WebParam(name = "id", targetNamespace = "")
        Integer id);

    /**
     * 
     * @param fullFrame
     * @param fixedLens
     * @param model
     * @param brand
     * @param cameraType
     * @return
     *     returns int
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "createCamera", targetNamespace = "http://webservices.itmo/", className = "itmo.webservices.CreateCamera")
    @ResponseWrapper(localName = "createCameraResponse", targetNamespace = "http://webservices.itmo/", className = "itmo.webservices.CreateCameraResponse")
    @Action(input = "http://webservices.itmo/CameraWebService/createCameraRequest", output = "http://webservices.itmo/CameraWebService/createCameraResponse")
    public int createCamera(
        @WebParam(name = "model", targetNamespace = "")
        String model,
        @WebParam(name = "brand", targetNamespace = "")
        Brand brand,
        @WebParam(name = "full_frame", targetNamespace = "")
        Boolean fullFrame,
        @WebParam(name = "camera_type", targetNamespace = "")
        CameraType cameraType,
        @WebParam(name = "fixed_lens", targetNamespace = "")
        Boolean fixedLens);

}

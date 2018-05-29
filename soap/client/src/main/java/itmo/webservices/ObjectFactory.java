
package itmo.webservices;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the itmo.webservices package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _CreateCamera_QNAME = new QName("http://webservices.itmo/", "createCamera");
    private final static QName _CreateCameraResponse_QNAME = new QName("http://webservices.itmo/", "createCameraResponse");
    private final static QName _DeleteCameraResponse_QNAME = new QName("http://webservices.itmo/", "deleteCameraResponse");
    private final static QName _Camera_QNAME = new QName("http://webservices.itmo/", "camera");
    private final static QName _UpdateCameraResponse_QNAME = new QName("http://webservices.itmo/", "updateCameraResponse");
    private final static QName _DeleteCamera_QNAME = new QName("http://webservices.itmo/", "deleteCamera");
    private final static QName _FindCamerasResponse_QNAME = new QName("http://webservices.itmo/", "findCamerasResponse");
    private final static QName _UpdateCamera_QNAME = new QName("http://webservices.itmo/", "updateCamera");
    private final static QName _FindCameras_QNAME = new QName("http://webservices.itmo/", "findCameras");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: itmo.webservices
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link FindCameras }
     * 
     */
    public FindCameras createFindCameras() {
        return new FindCameras();
    }

    /**
     * Create an instance of {@link DeleteCamera }
     * 
     */
    public DeleteCamera createDeleteCamera() {
        return new DeleteCamera();
    }

    /**
     * Create an instance of {@link FindCamerasResponse }
     * 
     */
    public FindCamerasResponse createFindCamerasResponse() {
        return new FindCamerasResponse();
    }

    /**
     * Create an instance of {@link UpdateCamera }
     * 
     */
    public UpdateCamera createUpdateCamera() {
        return new UpdateCamera();
    }

    /**
     * Create an instance of {@link UpdateCameraResponse }
     * 
     */
    public UpdateCameraResponse createUpdateCameraResponse() {
        return new UpdateCameraResponse();
    }

    /**
     * Create an instance of {@link Camera }
     * 
     */
    public Camera createCamera() {
        return new Camera();
    }

    /**
     * Create an instance of {@link DeleteCameraResponse }
     * 
     */
    public DeleteCameraResponse createDeleteCameraResponse() {
        return new DeleteCameraResponse();
    }

    /**
     * Create an instance of {@link CreateCamera }
     * 
     */
    public CreateCamera createCreateCamera() {
        return new CreateCamera();
    }

    /**
     * Create an instance of {@link CreateCameraResponse }
     * 
     */
    public CreateCameraResponse createCreateCameraResponse() {
        return new CreateCameraResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateCamera }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices.itmo/", name = "createCamera")
    public JAXBElement<CreateCamera> createCreateCamera(CreateCamera value) {
        return new JAXBElement<CreateCamera>(_CreateCamera_QNAME, CreateCamera.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateCameraResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices.itmo/", name = "createCameraResponse")
    public JAXBElement<CreateCameraResponse> createCreateCameraResponse(CreateCameraResponse value) {
        return new JAXBElement<CreateCameraResponse>(_CreateCameraResponse_QNAME, CreateCameraResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteCameraResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices.itmo/", name = "deleteCameraResponse")
    public JAXBElement<DeleteCameraResponse> createDeleteCameraResponse(DeleteCameraResponse value) {
        return new JAXBElement<DeleteCameraResponse>(_DeleteCameraResponse_QNAME, DeleteCameraResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Camera }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices.itmo/", name = "camera")
    public JAXBElement<Camera> createCamera(Camera value) {
        return new JAXBElement<Camera>(_Camera_QNAME, Camera.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateCameraResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices.itmo/", name = "updateCameraResponse")
    public JAXBElement<UpdateCameraResponse> createUpdateCameraResponse(UpdateCameraResponse value) {
        return new JAXBElement<UpdateCameraResponse>(_UpdateCameraResponse_QNAME, UpdateCameraResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteCamera }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices.itmo/", name = "deleteCamera")
    public JAXBElement<DeleteCamera> createDeleteCamera(DeleteCamera value) {
        return new JAXBElement<DeleteCamera>(_DeleteCamera_QNAME, DeleteCamera.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindCamerasResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices.itmo/", name = "findCamerasResponse")
    public JAXBElement<FindCamerasResponse> createFindCamerasResponse(FindCamerasResponse value) {
        return new JAXBElement<FindCamerasResponse>(_FindCamerasResponse_QNAME, FindCamerasResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateCamera }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices.itmo/", name = "updateCamera")
    public JAXBElement<UpdateCamera> createUpdateCamera(UpdateCamera value) {
        return new JAXBElement<UpdateCamera>(_UpdateCamera_QNAME, UpdateCamera.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindCameras }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices.itmo/", name = "findCameras")
    public JAXBElement<FindCameras> createFindCameras(FindCameras value) {
        return new JAXBElement<FindCameras>(_FindCameras_QNAME, FindCameras.class, null, value);
    }

}

package itmo.webservices.models;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by anastasia.sulyagina
 */
@XmlRootElement
public class Camera {
    private String model;
    private Brand brand;
    private Boolean fullFrame;
    private CameraType cameraType;
    private Boolean fixedLens;


    public Camera(String model, Brand brand, Boolean fullFrame, CameraType cameraType, Boolean fixedLens) {
        this.model = model;
        this.brand = brand;
        this.fullFrame = fullFrame;
        this.cameraType = cameraType;
        this.fixedLens = fixedLens;
    }

    public Camera() {}

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public void setBrandString(String s) {
        if (s.equals("CANON")) {
            this.brand = Brand.CANON;
        } else {
            this.brand = Brand.NIKON;
        }
    }

    public Boolean getFullFrame() {
        return fullFrame;
    }

    public void setFullFrame(Boolean fullFrame) {
        this.fullFrame = fullFrame;
    }

    public CameraType getCameraType() {
        return cameraType;
    }

    public void setCameraType(CameraType cameraType) {
        this.cameraType = cameraType;
    }

    public void setCameraTypeString(String s) {
        if (s.equals("MIRROR")) {
            this.cameraType = CameraType.MIRROR;
        } else {
            this.cameraType = CameraType.OPTICAL;
        }
    }

    public Boolean getFixedLens() {
        return fixedLens;
    }

    public void setFixedLens(Boolean fixedLens) {
        this.fixedLens = fixedLens;
    }
}

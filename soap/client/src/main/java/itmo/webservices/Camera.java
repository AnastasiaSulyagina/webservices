
package itmo.webservices;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for camera complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="camera">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="brand" type="{http://webservices.itmo/}brand" minOccurs="0"/>
 *         &lt;element name="cameraType" type="{http://webservices.itmo/}cameraType" minOccurs="0"/>
 *         &lt;element name="fixedLens" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="fullFrame" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="model" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "camera", propOrder = {
    "brand",
    "cameraType",
    "fixedLens",
    "fullFrame",
    "model"
})
public class Camera {

    @XmlSchemaType(name = "string")
    protected Brand brand;
    @XmlSchemaType(name = "string")
    protected CameraType cameraType;
    protected Boolean fixedLens;
    protected Boolean fullFrame;
    protected String model;

    /**
     * Gets the value of the brand property.
     * 
     * @return
     *     possible object is
     *     {@link Brand }
     *     
     */
    public Brand getBrand() {
        return brand;
    }

    /**
     * Sets the value of the brand property.
     * 
     * @param value
     *     allowed object is
     *     {@link Brand }
     *     
     */
    public void setBrand(Brand value) {
        this.brand = value;
    }

    /**
     * Gets the value of the cameraType property.
     * 
     * @return
     *     possible object is
     *     {@link CameraType }
     *     
     */
    public CameraType getCameraType() {
        return cameraType;
    }

    /**
     * Sets the value of the cameraType property.
     * 
     * @param value
     *     allowed object is
     *     {@link CameraType }
     *     
     */
    public void setCameraType(CameraType value) {
        this.cameraType = value;
    }

    /**
     * Gets the value of the fixedLens property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isFixedLens() {
        return fixedLens;
    }

    /**
     * Sets the value of the fixedLens property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setFixedLens(Boolean value) {
        this.fixedLens = value;
    }

    /**
     * Gets the value of the fullFrame property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isFullFrame() {
        return fullFrame;
    }

    /**
     * Sets the value of the fullFrame property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setFullFrame(Boolean value) {
        this.fullFrame = value;
    }

    /**
     * Gets the value of the model property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getModel() {
        return model;
    }

    /**
     * Sets the value of the model property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setModel(String value) {
        this.model = value;
    }

}

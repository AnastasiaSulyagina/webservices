
package itmo.webservices;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for updateCamera complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="updateCamera">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="model" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="brand" type="{http://webservices.itmo/}brand" minOccurs="0"/>
 *         &lt;element name="full_frame" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="camera_type" type="{http://webservices.itmo/}cameraType" minOccurs="0"/>
 *         &lt;element name="fixed_lens" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "updateCamera", propOrder = {
    "id",
    "model",
    "brand",
    "fullFrame",
    "cameraType",
    "fixedLens"
})
public class UpdateCamera {

    protected Integer id;
    protected String model;
    @XmlSchemaType(name = "string")
    protected Brand brand;
    @XmlElement(name = "full_frame")
    protected Boolean fullFrame;
    @XmlElement(name = "camera_type")
    @XmlSchemaType(name = "string")
    protected CameraType cameraType;
    @XmlElement(name = "fixed_lens")
    protected Boolean fixedLens;

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setId(Integer value) {
        this.id = value;
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

}

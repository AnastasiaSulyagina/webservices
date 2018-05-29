
package itmo.webservices;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for cameraType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="cameraType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="MIRROR"/>
 *     &lt;enumeration value="OPTICAL"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "cameraType")
@XmlEnum
public enum CameraType {

    MIRROR,
    OPTICAL;

    public String value() {
        return name();
    }

    public static CameraType fromValue(String v) {
        return valueOf(v);
    }

}

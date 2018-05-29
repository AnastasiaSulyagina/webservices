
package itmo.webservices;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for brand.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="brand">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="CANON"/>
 *     &lt;enumeration value="NIKON"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "brand")
@XmlEnum
public enum Brand {

    CANON,
    NIKON;

    public String value() {
        return name();
    }

    public static Brand fromValue(String v) {
        return valueOf(v);
    }

}

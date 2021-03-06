
package ws.crossnet.apn.vuce.mediador.esquema.apn004;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for FundingTypeCodeContentType.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="FundingTypeCodeContentType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token">
 *     &lt;enumeration value="INC"/>
 *     &lt;enumeration value="MYR"/>
 *     &lt;enumeration value="SYR"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 *
 */
@XmlType(name = "FundingTypeCodeContentType",
         namespace = "urn:un:unece:uncefact:codelist:standard:UNECE:FundingTypeCode:D08B")
@XmlEnum
public enum FundingTypeCodeContentType {


    /**
     *
     * <pre>
     * &lt;?xml version = '1.0' encoding = 'UTF-8'?&gt;
     * &lt;ccts:Name xmlns:ccts="urn:un:unece:uncefact:documentation:standard:CoreComponentsTechnicalSpecification:2"&gt;Incremental&lt;/ccts:Name&gt;
     * </pre>
     *
     * <pre>
     * &lt;?xml version = '1.0' encoding = 'UTF-8'?&gt;
     * &lt;ccts:Description xmlns:ccts="urn:un:unece:uncefact:documentation:standard:CoreComponentsTechnicalSpecification:2"&gt;Funded in arbitrary increments&lt;/ccts:Description&gt;
     * </pre>
     *
     *
     */
    INC,

    /**
     *
     * <pre>
     * &lt;?xml version = '1.0' encoding = 'UTF-8'?&gt;
     * &lt;ccts:Name xmlns:ccts="urn:un:unece:uncefact:documentation:standard:CoreComponentsTechnicalSpecification:2"&gt;Multi-year&lt;/ccts:Name&gt;
     * </pre>
     *
     * <pre>
     * &lt;?xml version = '1.0' encoding = 'UTF-8'?&gt;
     * &lt;ccts:Description xmlns:ccts="urn:un:unece:uncefact:documentation:standard:CoreComponentsTechnicalSpecification:2"&gt;Funded over multiple years.&lt;/ccts:Description&gt;
     * </pre>
     *
     *
     */
    MYR,

    /**
     *
     * <pre>
     * &lt;?xml version = '1.0' encoding = 'UTF-8'?&gt;
     * &lt;ccts:Name xmlns:ccts="urn:un:unece:uncefact:documentation:standard:CoreComponentsTechnicalSpecification:2"&gt;Single year&lt;/ccts:Name&gt;
     * </pre>
     *
     * <pre>
     * &lt;?xml version = '1.0' encoding = 'UTF-8'?&gt;
     * &lt;ccts:Description xmlns:ccts="urn:un:unece:uncefact:documentation:standard:CoreComponentsTechnicalSpecification:2"&gt;Funded for a single year.&lt;/ccts:Description&gt;
     * </pre>
     *
     *
     */
    SYR;

    public String value() {
        return name();
    }

    public static FundingTypeCodeContentType fromValue(String v) {
        return valueOf(v);
    }

}

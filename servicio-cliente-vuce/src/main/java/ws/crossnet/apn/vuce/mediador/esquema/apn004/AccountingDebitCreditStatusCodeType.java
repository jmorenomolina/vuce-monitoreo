
package ws.crossnet.apn.vuce.mediador.esquema.apn004;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 *
 * <pre>
 * &lt;?xml version = '1.0' encoding = 'UTF-8'?&gt;
 * &lt;ccts:UniqueID xmlns:ccts="urn:un:unece:uncefact:documentation:standard:CoreComponentsTechnicalSpecification:2"&gt;UN02000103&lt;/ccts:UniqueID&gt;
 * </pre>
 *
 * <pre>
 * &lt;?xml version = '1.0' encoding = 'UTF-8'?&gt;
 * &lt;ccts:Acronym xmlns:ccts="urn:un:unece:uncefact:documentation:standard:CoreComponentsTechnicalSpecification:2"&gt;DT&lt;/ccts:Acronym&gt;
 * </pre>
 *
 * <pre>
 * &lt;?xml version = '1.0' encoding = 'UTF-8'?&gt;
 * &lt;ccts:DictionaryEntryName xmlns:ccts="urn:un:unece:uncefact:documentation:standard:CoreComponentsTechnicalSpecification:2"&gt;Accounting Debit Credit_ Status_ Code. Type&lt;/ccts:DictionaryEntryName&gt;
 * </pre>
 *
 * <pre>
 * &lt;?xml version = '1.0' encoding = 'UTF-8'?&gt;
 * &lt;ccts:Version xmlns:ccts="urn:un:unece:uncefact:documentation:standard:CoreComponentsTechnicalSpecification:2"&gt;1.0&lt;/ccts:Version&gt;
 * </pre>
 *
 * <pre>
 * &lt;?xml version = '1.0' encoding = 'UTF-8'?&gt;
 * &lt;ccts:Definition xmlns:ccts="urn:un:unece:uncefact:documentation:standard:CoreComponentsTechnicalSpecification:2"&gt;A character string used to represent the accounting debit or credit sign.&lt;/ccts:Definition&gt;
 * </pre>
 *
 * <pre>
 * &lt;?xml version = '1.0' encoding = 'UTF-8'?&gt;
 * &lt;ccts:PrimaryRepresentationTerm xmlns:ccts="urn:un:unece:uncefact:documentation:standard:CoreComponentsTechnicalSpecification:2"&gt;Code&lt;/ccts:PrimaryRepresentationTerm&gt;
 * </pre>
 *
 * <pre>
 * &lt;?xml version = '1.0' encoding = 'UTF-8'?&gt;
 * &lt;ccts:PrimitiveType xmlns:ccts="urn:un:unece:uncefact:documentation:standard:CoreComponentsTechnicalSpecification:2"&gt;String&lt;/ccts:PrimitiveType&gt;
 * </pre>
 *
 * <pre>
 * &lt;?xml version = '1.0' encoding = 'UTF-8'?&gt;
 * &lt;ccts:DataTypeQualifierTerm xmlns:ccts="urn:un:unece:uncefact:documentation:standard:CoreComponentsTechnicalSpecification:2"&gt;Accounting Debit Credit&lt;/ccts:DataTypeQualifierTerm&gt;
 * </pre>
 *
 * <pre>
 * &lt;?xml version = '1.0' encoding = 'UTF-8'?&gt;
 * &lt;ccts:DataTypeQualifierTerm xmlns:ccts="urn:un:unece:uncefact:documentation:standard:CoreComponentsTechnicalSpecification:2"&gt;Status&lt;/ccts:DataTypeQualifierTerm&gt;
 * </pre>
 *
 *
 * <p>Java class for AccountingDebitCreditStatusCodeType complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="AccountingDebitCreditStatusCodeType">
 *   &lt;simpleContent>
 *     &lt;extension base="&lt;urn:un:unece:uncefact:codelist:standard:UNECE:StatusDescriptionCodeAccountingDebitCredit:D08B>StatusDescriptionCodeAccountingDebitCreditContentType">
 *       &lt;attribute name="listID" type="{http://www.w3.org/2001/XMLSchema}token" fixed="4405_Accounting Debit Credit" />
 *       &lt;attribute name="listAgencyID" type="{urn:un:unece:uncefact:codelist:standard:6:3055:D08B}AgencyIdentificationCodeContentType" fixed="6" />
 *       &lt;attribute name="listVersionID" type="{http://www.w3.org/2001/XMLSchema}token" fixed="D08B" />
 *       &lt;attribute name="listURI" type="{http://www.w3.org/2001/XMLSchema}anyURI" />
 *     &lt;/extension>
 *   &lt;/simpleContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AccountingDebitCreditStatusCodeType", propOrder = { "value" })
public class AccountingDebitCreditStatusCodeType {

    @XmlValue
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String value;
    @XmlAttribute(name = "listID")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String listID;
    @XmlAttribute(name = "listAgencyID")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String listAgencyID;
    @XmlAttribute(name = "listVersionID")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String listVersionID;
    @XmlAttribute(name = "listURI")
    @XmlSchemaType(name = "anyURI")
    protected String listURI;

    /**
     * Gets the value of the value property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * Gets the value of the listID property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getListID() {
        if (listID == null) {
            return "4405_Accounting Debit Credit";
        } else {
            return listID;
        }
    }

    /**
     * Sets the value of the listID property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setListID(String value) {
        this.listID = value;
    }

    /**
     * Gets the value of the listAgencyID property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getListAgencyID() {
        if (listAgencyID == null) {
            return "6";
        } else {
            return listAgencyID;
        }
    }

    /**
     * Sets the value of the listAgencyID property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setListAgencyID(String value) {
        this.listAgencyID = value;
    }

    /**
     * Gets the value of the listVersionID property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getListVersionID() {
        if (listVersionID == null) {
            return "D08B";
        } else {
            return listVersionID;
        }
    }

    /**
     * Sets the value of the listVersionID property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setListVersionID(String value) {
        this.listVersionID = value;
    }

    /**
     * Gets the value of the listURI property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getListURI() {
        return listURI;
    }

    /**
     * Sets the value of the listURI property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setListURI(String value) {
        this.listURI = value;
    }

}


package project.feukora.webservice.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java-Klasse für rapport complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="rapport">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="additionalsteps" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="carbonmonoxide" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="comments" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="exhaustgaslost" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="measuringdate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="nitrogendioxide" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="results" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="transgression_oilpart" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="transgression_smokenumber" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "rapport", propOrder = {
    "additionalsteps",
    "carbonmonoxide",
    "comments",
    "exhaustgaslost",
    "measuringdate",
    "nitrogendioxide",
    "results",
    "transgressionOilpart",
    "transgressionSmokenumber"
})
public class Rapport {

    protected Boolean additionalsteps;
    protected Boolean carbonmonoxide;
    protected String comments;
    protected Boolean exhaustgaslost;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar measuringdate;
    protected Boolean nitrogendioxide;
    protected Boolean results;
    @XmlElement(name = "transgression_oilpart")
    protected Boolean transgressionOilpart;
    @XmlElement(name = "transgression_smokenumber")
    protected Boolean transgressionSmokenumber;

    /**
     * Ruft den Wert der additionalsteps-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isAdditionalsteps() {
        return additionalsteps;
    }

    /**
     * Legt den Wert der additionalsteps-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setAdditionalsteps(Boolean value) {
        this.additionalsteps = value;
    }

    /**
     * Ruft den Wert der carbonmonoxide-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isCarbonmonoxide() {
        return carbonmonoxide;
    }

    /**
     * Legt den Wert der carbonmonoxide-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setCarbonmonoxide(Boolean value) {
        this.carbonmonoxide = value;
    }

    /**
     * Ruft den Wert der comments-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getComments() {
        return comments;
    }

    /**
     * Legt den Wert der comments-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setComments(String value) {
        this.comments = value;
    }

    /**
     * Ruft den Wert der exhaustgaslost-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isExhaustgaslost() {
        return exhaustgaslost;
    }

    /**
     * Legt den Wert der exhaustgaslost-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setExhaustgaslost(Boolean value) {
        this.exhaustgaslost = value;
    }

    /**
     * Ruft den Wert der measuringdate-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getMeasuringdate() {
        return measuringdate;
    }

    /**
     * Legt den Wert der measuringdate-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setMeasuringdate(XMLGregorianCalendar value) {
        this.measuringdate = value;
    }

    /**
     * Ruft den Wert der nitrogendioxide-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isNitrogendioxide() {
        return nitrogendioxide;
    }

    /**
     * Legt den Wert der nitrogendioxide-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setNitrogendioxide(Boolean value) {
        this.nitrogendioxide = value;
    }

    /**
     * Ruft den Wert der results-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isResults() {
        return results;
    }

    /**
     * Legt den Wert der results-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setResults(Boolean value) {
        this.results = value;
    }

    /**
     * Ruft den Wert der transgressionOilpart-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isTransgressionOilpart() {
        return transgressionOilpart;
    }

    /**
     * Legt den Wert der transgressionOilpart-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setTransgressionOilpart(Boolean value) {
        this.transgressionOilpart = value;
    }

    /**
     * Ruft den Wert der transgressionSmokenumber-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isTransgressionSmokenumber() {
        return transgressionSmokenumber;
    }

    /**
     * Legt den Wert der transgressionSmokenumber-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setTransgressionSmokenumber(Boolean value) {
        this.transgressionSmokenumber = value;
    }

}

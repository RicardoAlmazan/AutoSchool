
package profesor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para modificaProfe complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="modificaProfe"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="xid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="apePat" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="apeMat" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="xhuella" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="xUsr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="xPswd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="xEmail" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "modificaProfe", propOrder = {
    "xid",
    "name",
    "apePat",
    "apeMat",
    "xhuella",
    "xUsr",
    "xPswd",
    "xEmail"
})
public class ModificaProfe {

    protected String xid;
    protected String name;
    protected String apePat;
    protected String apeMat;
    protected String xhuella;
    protected String xUsr;
    protected String xPswd;
    protected String xEmail;

    /**
     * Obtiene el valor de la propiedad xid.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getXid() {
        return xid;
    }

    /**
     * Define el valor de la propiedad xid.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setXid(String value) {
        this.xid = value;
    }

    /**
     * Obtiene el valor de la propiedad name.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Define el valor de la propiedad name.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Obtiene el valor de la propiedad apePat.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApePat() {
        return apePat;
    }

    /**
     * Define el valor de la propiedad apePat.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApePat(String value) {
        this.apePat = value;
    }

    /**
     * Obtiene el valor de la propiedad apeMat.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApeMat() {
        return apeMat;
    }

    /**
     * Define el valor de la propiedad apeMat.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApeMat(String value) {
        this.apeMat = value;
    }

    /**
     * Obtiene el valor de la propiedad xhuella.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getXhuella() {
        return xhuella;
    }

    /**
     * Define el valor de la propiedad xhuella.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setXhuella(String value) {
        this.xhuella = value;
    }

    /**
     * Obtiene el valor de la propiedad xUsr.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getXUsr() {
        return xUsr;
    }

    /**
     * Define el valor de la propiedad xUsr.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setXUsr(String value) {
        this.xUsr = value;
    }

    /**
     * Obtiene el valor de la propiedad xPswd.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getXPswd() {
        return xPswd;
    }

    /**
     * Define el valor de la propiedad xPswd.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setXPswd(String value) {
        this.xPswd = value;
    }

    /**
     * Obtiene el valor de la propiedad xEmail.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getXEmail() {
        return xEmail;
    }

    /**
     * Define el valor de la propiedad xEmail.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setXEmail(String value) {
        this.xEmail = value;
    }

}

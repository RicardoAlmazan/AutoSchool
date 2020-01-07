
package profesor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para getGrupos complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="getGrupos"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="usr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getGrupos", propOrder = {
    "usr"
})
public class GetGrupos {

    protected String usr;

    /**
     * Obtiene el valor de la propiedad usr.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUsr() {
        return usr;
    }

    /**
     * Define el valor de la propiedad usr.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUsr(String value) {
        this.usr = value;
    }

}

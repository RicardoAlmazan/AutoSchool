
package acceso;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the acceso package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _AccesoProfesor_QNAME = new QName("http://acceso/", "accesoProfesor");
    private final static QName _AccesoProfesorResponse_QNAME = new QName("http://acceso/", "accesoProfesorResponse");
    private final static QName _ActivaUsr_QNAME = new QName("http://acceso/", "activaUsr");
    private final static QName _ActivaUsrResponse_QNAME = new QName("http://acceso/", "activaUsrResponse");
    private final static QName _GetDatosProfesor_QNAME = new QName("http://acceso/", "getDatosProfesor");
    private final static QName _GetDatosProfesorResponse_QNAME = new QName("http://acceso/", "getDatosProfesorResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: acceso
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AccesoProfesor }
     * 
     */
    public AccesoProfesor createAccesoProfesor() {
        return new AccesoProfesor();
    }

    /**
     * Create an instance of {@link AccesoProfesorResponse }
     * 
     */
    public AccesoProfesorResponse createAccesoProfesorResponse() {
        return new AccesoProfesorResponse();
    }

    /**
     * Create an instance of {@link ActivaUsr }
     * 
     */
    public ActivaUsr createActivaUsr() {
        return new ActivaUsr();
    }

    /**
     * Create an instance of {@link ActivaUsrResponse }
     * 
     */
    public ActivaUsrResponse createActivaUsrResponse() {
        return new ActivaUsrResponse();
    }

    /**
     * Create an instance of {@link GetDatosProfesor }
     * 
     */
    public GetDatosProfesor createGetDatosProfesor() {
        return new GetDatosProfesor();
    }

    /**
     * Create an instance of {@link GetDatosProfesorResponse }
     * 
     */
    public GetDatosProfesorResponse createGetDatosProfesorResponse() {
        return new GetDatosProfesorResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AccesoProfesor }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://acceso/", name = "accesoProfesor")
    public JAXBElement<AccesoProfesor> createAccesoProfesor(AccesoProfesor value) {
        return new JAXBElement<AccesoProfesor>(_AccesoProfesor_QNAME, AccesoProfesor.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AccesoProfesorResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://acceso/", name = "accesoProfesorResponse")
    public JAXBElement<AccesoProfesorResponse> createAccesoProfesorResponse(AccesoProfesorResponse value) {
        return new JAXBElement<AccesoProfesorResponse>(_AccesoProfesorResponse_QNAME, AccesoProfesorResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ActivaUsr }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://acceso/", name = "activaUsr")
    public JAXBElement<ActivaUsr> createActivaUsr(ActivaUsr value) {
        return new JAXBElement<ActivaUsr>(_ActivaUsr_QNAME, ActivaUsr.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ActivaUsrResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://acceso/", name = "activaUsrResponse")
    public JAXBElement<ActivaUsrResponse> createActivaUsrResponse(ActivaUsrResponse value) {
        return new JAXBElement<ActivaUsrResponse>(_ActivaUsrResponse_QNAME, ActivaUsrResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetDatosProfesor }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://acceso/", name = "getDatosProfesor")
    public JAXBElement<GetDatosProfesor> createGetDatosProfesor(GetDatosProfesor value) {
        return new JAXBElement<GetDatosProfesor>(_GetDatosProfesor_QNAME, GetDatosProfesor.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetDatosProfesorResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://acceso/", name = "getDatosProfesorResponse")
    public JAXBElement<GetDatosProfesorResponse> createGetDatosProfesorResponse(GetDatosProfesorResponse value) {
        return new JAXBElement<GetDatosProfesorResponse>(_GetDatosProfesorResponse_QNAME, GetDatosProfesorResponse.class, null, value);
    }

}

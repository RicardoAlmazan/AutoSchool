
package wsequipos;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the wsequipos package. 
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

    private final static QName _PrendeApagaResponse_QNAME = new QName("http://WSEquipos/", "prendeApagaResponse");
    private final static QName _Ejecutar_QNAME = new QName("http://WSEquipos/", "ejecutar");
    private final static QName _ConsultaEquiposResponse_QNAME = new QName("http://WSEquipos/", "consultaEquiposResponse");
    private final static QName _ConsultaEquipos_QNAME = new QName("http://WSEquipos/", "consultaEquipos");
    private final static QName _EjecutarResponse_QNAME = new QName("http://WSEquipos/", "ejecutarResponse");
    private final static QName _PrendeApaga_QNAME = new QName("http://WSEquipos/", "prendeApaga");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: wsequipos
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link PrendeApaga }
     * 
     */
    public PrendeApaga createPrendeApaga() {
        return new PrendeApaga();
    }

    /**
     * Create an instance of {@link EjecutarResponse }
     * 
     */
    public EjecutarResponse createEjecutarResponse() {
        return new EjecutarResponse();
    }

    /**
     * Create an instance of {@link ConsultaEquipos }
     * 
     */
    public ConsultaEquipos createConsultaEquipos() {
        return new ConsultaEquipos();
    }

    /**
     * Create an instance of {@link PrendeApagaResponse }
     * 
     */
    public PrendeApagaResponse createPrendeApagaResponse() {
        return new PrendeApagaResponse();
    }

    /**
     * Create an instance of {@link ConsultaEquiposResponse }
     * 
     */
    public ConsultaEquiposResponse createConsultaEquiposResponse() {
        return new ConsultaEquiposResponse();
    }

    /**
     * Create an instance of {@link Ejecutar }
     * 
     */
    public Ejecutar createEjecutar() {
        return new Ejecutar();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PrendeApagaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WSEquipos/", name = "prendeApagaResponse")
    public JAXBElement<PrendeApagaResponse> createPrendeApagaResponse(PrendeApagaResponse value) {
        return new JAXBElement<PrendeApagaResponse>(_PrendeApagaResponse_QNAME, PrendeApagaResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Ejecutar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WSEquipos/", name = "ejecutar")
    public JAXBElement<Ejecutar> createEjecutar(Ejecutar value) {
        return new JAXBElement<Ejecutar>(_Ejecutar_QNAME, Ejecutar.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConsultaEquiposResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WSEquipos/", name = "consultaEquiposResponse")
    public JAXBElement<ConsultaEquiposResponse> createConsultaEquiposResponse(ConsultaEquiposResponse value) {
        return new JAXBElement<ConsultaEquiposResponse>(_ConsultaEquiposResponse_QNAME, ConsultaEquiposResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConsultaEquipos }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WSEquipos/", name = "consultaEquipos")
    public JAXBElement<ConsultaEquipos> createConsultaEquipos(ConsultaEquipos value) {
        return new JAXBElement<ConsultaEquipos>(_ConsultaEquipos_QNAME, ConsultaEquipos.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EjecutarResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WSEquipos/", name = "ejecutarResponse")
    public JAXBElement<EjecutarResponse> createEjecutarResponse(EjecutarResponse value) {
        return new JAXBElement<EjecutarResponse>(_EjecutarResponse_QNAME, EjecutarResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PrendeApaga }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WSEquipos/", name = "prendeApaga")
    public JAXBElement<PrendeApaga> createPrendeApaga(PrendeApaga value) {
        return new JAXBElement<PrendeApaga>(_PrendeApaga_QNAME, PrendeApaga.class, null, value);
    }

}


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

    private final static QName _GetxId_QNAME = new QName("http://acceso/", "getxId");
    private final static QName _GetxIdResponse_QNAME = new QName("http://acceso/", "getxIdResponse");
    private final static QName _RegistroUsr_QNAME = new QName("http://acceso/", "registroUsr");
    private final static QName _RegistroUsrResponse_QNAME = new QName("http://acceso/", "registroUsrResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: acceso
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetxId }
     * 
     */
    public GetxId createGetxId() {
        return new GetxId();
    }

    /**
     * Create an instance of {@link GetxIdResponse }
     * 
     */
    public GetxIdResponse createGetxIdResponse() {
        return new GetxIdResponse();
    }

    /**
     * Create an instance of {@link RegistroUsr }
     * 
     */
    public RegistroUsr createRegistroUsr() {
        return new RegistroUsr();
    }

    /**
     * Create an instance of {@link RegistroUsrResponse }
     * 
     */
    public RegistroUsrResponse createRegistroUsrResponse() {
        return new RegistroUsrResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetxId }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://acceso/", name = "getxId")
    public JAXBElement<GetxId> createGetxId(GetxId value) {
        return new JAXBElement<GetxId>(_GetxId_QNAME, GetxId.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetxIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://acceso/", name = "getxIdResponse")
    public JAXBElement<GetxIdResponse> createGetxIdResponse(GetxIdResponse value) {
        return new JAXBElement<GetxIdResponse>(_GetxIdResponse_QNAME, GetxIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RegistroUsr }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://acceso/", name = "registroUsr")
    public JAXBElement<RegistroUsr> createRegistroUsr(RegistroUsr value) {
        return new JAXBElement<RegistroUsr>(_RegistroUsr_QNAME, RegistroUsr.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RegistroUsrResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://acceso/", name = "registroUsrResponse")
    public JAXBElement<RegistroUsrResponse> createRegistroUsrResponse(RegistroUsrResponse value) {
        return new JAXBElement<RegistroUsrResponse>(_RegistroUsrResponse_QNAME, RegistroUsrResponse.class, null, value);
    }

}

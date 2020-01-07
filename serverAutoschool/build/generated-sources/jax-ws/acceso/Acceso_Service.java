
package acceso;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.6-1b01 
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "acceso", targetNamespace = "http://acceso/", wsdlLocation = "http://localhost:8080/wsAutoSchool/acceso?wsdl")
public class Acceso_Service
    extends Service
{

    private final static URL ACCESO_WSDL_LOCATION;
    private final static WebServiceException ACCESO_EXCEPTION;
    private final static QName ACCESO_QNAME = new QName("http://acceso/", "acceso");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8080/wsAutoSchool/acceso?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        ACCESO_WSDL_LOCATION = url;
        ACCESO_EXCEPTION = e;
    }

    public Acceso_Service() {
        super(__getWsdlLocation(), ACCESO_QNAME);
    }

    public Acceso_Service(WebServiceFeature... features) {
        super(__getWsdlLocation(), ACCESO_QNAME, features);
    }

    public Acceso_Service(URL wsdlLocation) {
        super(wsdlLocation, ACCESO_QNAME);
    }

    public Acceso_Service(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, ACCESO_QNAME, features);
    }

    public Acceso_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public Acceso_Service(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns Acceso
     */
    @WebEndpoint(name = "accesoPort")
    public Acceso getAccesoPort() {
        return super.getPort(new QName("http://acceso/", "accesoPort"), Acceso.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns Acceso
     */
    @WebEndpoint(name = "accesoPort")
    public Acceso getAccesoPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://acceso/", "accesoPort"), Acceso.class, features);
    }

    private static URL __getWsdlLocation() {
        if (ACCESO_EXCEPTION!= null) {
            throw ACCESO_EXCEPTION;
        }
        return ACCESO_WSDL_LOCATION;
    }

}
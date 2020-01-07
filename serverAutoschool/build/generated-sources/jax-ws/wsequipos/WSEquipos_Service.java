
package wsequipos;

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
@WebServiceClient(name = "WSEquipos", targetNamespace = "http://WSEquipos/", wsdlLocation = "http://localhost:8080/wsAutoSchool/WSEquipos?wsdl")
public class WSEquipos_Service
    extends Service
{

    private final static URL WSEQUIPOS_WSDL_LOCATION;
    private final static WebServiceException WSEQUIPOS_EXCEPTION;
    private final static QName WSEQUIPOS_QNAME = new QName("http://WSEquipos/", "WSEquipos");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8080/wsAutoSchool/WSEquipos?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        WSEQUIPOS_WSDL_LOCATION = url;
        WSEQUIPOS_EXCEPTION = e;
    }

    public WSEquipos_Service() {
        super(__getWsdlLocation(), WSEQUIPOS_QNAME);
    }

    public WSEquipos_Service(WebServiceFeature... features) {
        super(__getWsdlLocation(), WSEQUIPOS_QNAME, features);
    }

    public WSEquipos_Service(URL wsdlLocation) {
        super(wsdlLocation, WSEQUIPOS_QNAME);
    }

    public WSEquipos_Service(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, WSEQUIPOS_QNAME, features);
    }

    public WSEquipos_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public WSEquipos_Service(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns WSEquipos
     */
    @WebEndpoint(name = "WSEquiposPort")
    public WSEquipos getWSEquiposPort() {
        return super.getPort(new QName("http://WSEquipos/", "WSEquiposPort"), WSEquipos.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns WSEquipos
     */
    @WebEndpoint(name = "WSEquiposPort")
    public WSEquipos getWSEquiposPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://WSEquipos/", "WSEquiposPort"), WSEquipos.class, features);
    }

    private static URL __getWsdlLocation() {
        if (WSEQUIPOS_EXCEPTION!= null) {
            throw WSEQUIPOS_EXCEPTION;
        }
        return WSEQUIPOS_WSDL_LOCATION;
    }

}

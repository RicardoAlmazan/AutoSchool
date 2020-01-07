
package administrador;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the administrador package. 
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

    private final static QName _BuscarUsr_QNAME = new QName("http://administrador/", "buscarUsr");
    private final static QName _BuscarUsrResponse_QNAME = new QName("http://administrador/", "buscarUsrResponse");
    private final static QName _ConsultaEquipos_QNAME = new QName("http://administrador/", "consultaEquipos");
    private final static QName _ConsultaEquiposResponse_QNAME = new QName("http://administrador/", "consultaEquiposResponse");
    private final static QName _GetApeMaterno_QNAME = new QName("http://administrador/", "getApeMaterno");
    private final static QName _GetApeMaternoResponse_QNAME = new QName("http://administrador/", "getApeMaternoResponse");
    private final static QName _GetApePaterno_QNAME = new QName("http://administrador/", "getApePaterno");
    private final static QName _GetApePaternoResponse_QNAME = new QName("http://administrador/", "getApePaternoResponse");
    private final static QName _GetGrupo_QNAME = new QName("http://administrador/", "getGrupo");
    private final static QName _GetGrupoResponse_QNAME = new QName("http://administrador/", "getGrupoResponse");
    private final static QName _GetIdUsr_QNAME = new QName("http://administrador/", "getIdUsr");
    private final static QName _GetIdUsrResponse_QNAME = new QName("http://administrador/", "getIdUsrResponse");
    private final static QName _GetNombre_QNAME = new QName("http://administrador/", "getNombre");
    private final static QName _GetNombreResponse_QNAME = new QName("http://administrador/", "getNombreResponse");
    private final static QName _GetTipoUsr_QNAME = new QName("http://administrador/", "getTipoUsr");
    private final static QName _GetTipoUsrResponse_QNAME = new QName("http://administrador/", "getTipoUsrResponse");
    private final static QName _GetTodosLosDatosAlumno_QNAME = new QName("http://administrador/", "getTodosLosDatosAlumno");
    private final static QName _GetTodosLosDatosAlumnoResponse_QNAME = new QName("http://administrador/", "getTodosLosDatosAlumnoResponse");
    private final static QName _GetUsr_QNAME = new QName("http://administrador/", "getUsr");
    private final static QName _GetUsrResponse_QNAME = new QName("http://administrador/", "getUsrResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: administrador
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link BuscarUsr }
     * 
     */
    public BuscarUsr createBuscarUsr() {
        return new BuscarUsr();
    }

    /**
     * Create an instance of {@link BuscarUsrResponse }
     * 
     */
    public BuscarUsrResponse createBuscarUsrResponse() {
        return new BuscarUsrResponse();
    }

    /**
     * Create an instance of {@link ConsultaEquipos }
     * 
     */
    public ConsultaEquipos createConsultaEquipos() {
        return new ConsultaEquipos();
    }

    /**
     * Create an instance of {@link ConsultaEquiposResponse }
     * 
     */
    public ConsultaEquiposResponse createConsultaEquiposResponse() {
        return new ConsultaEquiposResponse();
    }

    /**
     * Create an instance of {@link GetApeMaterno }
     * 
     */
    public GetApeMaterno createGetApeMaterno() {
        return new GetApeMaterno();
    }

    /**
     * Create an instance of {@link GetApeMaternoResponse }
     * 
     */
    public GetApeMaternoResponse createGetApeMaternoResponse() {
        return new GetApeMaternoResponse();
    }

    /**
     * Create an instance of {@link GetApePaterno }
     * 
     */
    public GetApePaterno createGetApePaterno() {
        return new GetApePaterno();
    }

    /**
     * Create an instance of {@link GetApePaternoResponse }
     * 
     */
    public GetApePaternoResponse createGetApePaternoResponse() {
        return new GetApePaternoResponse();
    }

    /**
     * Create an instance of {@link GetGrupo }
     * 
     */
    public GetGrupo createGetGrupo() {
        return new GetGrupo();
    }

    /**
     * Create an instance of {@link GetGrupoResponse }
     * 
     */
    public GetGrupoResponse createGetGrupoResponse() {
        return new GetGrupoResponse();
    }

    /**
     * Create an instance of {@link GetIdUsr }
     * 
     */
    public GetIdUsr createGetIdUsr() {
        return new GetIdUsr();
    }

    /**
     * Create an instance of {@link GetIdUsrResponse }
     * 
     */
    public GetIdUsrResponse createGetIdUsrResponse() {
        return new GetIdUsrResponse();
    }

    /**
     * Create an instance of {@link GetNombre }
     * 
     */
    public GetNombre createGetNombre() {
        return new GetNombre();
    }

    /**
     * Create an instance of {@link GetNombreResponse }
     * 
     */
    public GetNombreResponse createGetNombreResponse() {
        return new GetNombreResponse();
    }

    /**
     * Create an instance of {@link GetTipoUsr }
     * 
     */
    public GetTipoUsr createGetTipoUsr() {
        return new GetTipoUsr();
    }

    /**
     * Create an instance of {@link GetTipoUsrResponse }
     * 
     */
    public GetTipoUsrResponse createGetTipoUsrResponse() {
        return new GetTipoUsrResponse();
    }

    /**
     * Create an instance of {@link GetTodosLosDatosAlumno }
     * 
     */
    public GetTodosLosDatosAlumno createGetTodosLosDatosAlumno() {
        return new GetTodosLosDatosAlumno();
    }

    /**
     * Create an instance of {@link GetTodosLosDatosAlumnoResponse }
     * 
     */
    public GetTodosLosDatosAlumnoResponse createGetTodosLosDatosAlumnoResponse() {
        return new GetTodosLosDatosAlumnoResponse();
    }

    /**
     * Create an instance of {@link GetUsr }
     * 
     */
    public GetUsr createGetUsr() {
        return new GetUsr();
    }

    /**
     * Create an instance of {@link GetUsrResponse }
     * 
     */
    public GetUsrResponse createGetUsrResponse() {
        return new GetUsrResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BuscarUsr }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://administrador/", name = "buscarUsr")
    public JAXBElement<BuscarUsr> createBuscarUsr(BuscarUsr value) {
        return new JAXBElement<BuscarUsr>(_BuscarUsr_QNAME, BuscarUsr.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BuscarUsrResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://administrador/", name = "buscarUsrResponse")
    public JAXBElement<BuscarUsrResponse> createBuscarUsrResponse(BuscarUsrResponse value) {
        return new JAXBElement<BuscarUsrResponse>(_BuscarUsrResponse_QNAME, BuscarUsrResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConsultaEquipos }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://administrador/", name = "consultaEquipos")
    public JAXBElement<ConsultaEquipos> createConsultaEquipos(ConsultaEquipos value) {
        return new JAXBElement<ConsultaEquipos>(_ConsultaEquipos_QNAME, ConsultaEquipos.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConsultaEquiposResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://administrador/", name = "consultaEquiposResponse")
    public JAXBElement<ConsultaEquiposResponse> createConsultaEquiposResponse(ConsultaEquiposResponse value) {
        return new JAXBElement<ConsultaEquiposResponse>(_ConsultaEquiposResponse_QNAME, ConsultaEquiposResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetApeMaterno }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://administrador/", name = "getApeMaterno")
    public JAXBElement<GetApeMaterno> createGetApeMaterno(GetApeMaterno value) {
        return new JAXBElement<GetApeMaterno>(_GetApeMaterno_QNAME, GetApeMaterno.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetApeMaternoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://administrador/", name = "getApeMaternoResponse")
    public JAXBElement<GetApeMaternoResponse> createGetApeMaternoResponse(GetApeMaternoResponse value) {
        return new JAXBElement<GetApeMaternoResponse>(_GetApeMaternoResponse_QNAME, GetApeMaternoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetApePaterno }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://administrador/", name = "getApePaterno")
    public JAXBElement<GetApePaterno> createGetApePaterno(GetApePaterno value) {
        return new JAXBElement<GetApePaterno>(_GetApePaterno_QNAME, GetApePaterno.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetApePaternoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://administrador/", name = "getApePaternoResponse")
    public JAXBElement<GetApePaternoResponse> createGetApePaternoResponse(GetApePaternoResponse value) {
        return new JAXBElement<GetApePaternoResponse>(_GetApePaternoResponse_QNAME, GetApePaternoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetGrupo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://administrador/", name = "getGrupo")
    public JAXBElement<GetGrupo> createGetGrupo(GetGrupo value) {
        return new JAXBElement<GetGrupo>(_GetGrupo_QNAME, GetGrupo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetGrupoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://administrador/", name = "getGrupoResponse")
    public JAXBElement<GetGrupoResponse> createGetGrupoResponse(GetGrupoResponse value) {
        return new JAXBElement<GetGrupoResponse>(_GetGrupoResponse_QNAME, GetGrupoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetIdUsr }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://administrador/", name = "getIdUsr")
    public JAXBElement<GetIdUsr> createGetIdUsr(GetIdUsr value) {
        return new JAXBElement<GetIdUsr>(_GetIdUsr_QNAME, GetIdUsr.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetIdUsrResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://administrador/", name = "getIdUsrResponse")
    public JAXBElement<GetIdUsrResponse> createGetIdUsrResponse(GetIdUsrResponse value) {
        return new JAXBElement<GetIdUsrResponse>(_GetIdUsrResponse_QNAME, GetIdUsrResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetNombre }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://administrador/", name = "getNombre")
    public JAXBElement<GetNombre> createGetNombre(GetNombre value) {
        return new JAXBElement<GetNombre>(_GetNombre_QNAME, GetNombre.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetNombreResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://administrador/", name = "getNombreResponse")
    public JAXBElement<GetNombreResponse> createGetNombreResponse(GetNombreResponse value) {
        return new JAXBElement<GetNombreResponse>(_GetNombreResponse_QNAME, GetNombreResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetTipoUsr }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://administrador/", name = "getTipoUsr")
    public JAXBElement<GetTipoUsr> createGetTipoUsr(GetTipoUsr value) {
        return new JAXBElement<GetTipoUsr>(_GetTipoUsr_QNAME, GetTipoUsr.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetTipoUsrResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://administrador/", name = "getTipoUsrResponse")
    public JAXBElement<GetTipoUsrResponse> createGetTipoUsrResponse(GetTipoUsrResponse value) {
        return new JAXBElement<GetTipoUsrResponse>(_GetTipoUsrResponse_QNAME, GetTipoUsrResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetTodosLosDatosAlumno }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://administrador/", name = "getTodosLosDatosAlumno")
    public JAXBElement<GetTodosLosDatosAlumno> createGetTodosLosDatosAlumno(GetTodosLosDatosAlumno value) {
        return new JAXBElement<GetTodosLosDatosAlumno>(_GetTodosLosDatosAlumno_QNAME, GetTodosLosDatosAlumno.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetTodosLosDatosAlumnoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://administrador/", name = "getTodosLosDatosAlumnoResponse")
    public JAXBElement<GetTodosLosDatosAlumnoResponse> createGetTodosLosDatosAlumnoResponse(GetTodosLosDatosAlumnoResponse value) {
        return new JAXBElement<GetTodosLosDatosAlumnoResponse>(_GetTodosLosDatosAlumnoResponse_QNAME, GetTodosLosDatosAlumnoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUsr }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://administrador/", name = "getUsr")
    public JAXBElement<GetUsr> createGetUsr(GetUsr value) {
        return new JAXBElement<GetUsr>(_GetUsr_QNAME, GetUsr.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUsrResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://administrador/", name = "getUsrResponse")
    public JAXBElement<GetUsrResponse> createGetUsrResponse(GetUsrResponse value) {
        return new JAXBElement<GetUsrResponse>(_GetUsrResponse_QNAME, GetUsrResponse.class, null, value);
    }

}

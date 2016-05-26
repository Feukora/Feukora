
package project.feukora.webservice.model;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the project.feukora.webservice.model package. 
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

    private final static QName _CreateRapportResponse_QNAME = new QName("http://model.webservice.feukora.project/", "createRapportResponse");
    private final static QName _Login_QNAME = new QName("http://model.webservice.feukora.project/", "login");
    private final static QName _CreateRapport_QNAME = new QName("http://model.webservice.feukora.project/", "createRapport");
    private final static QName _GetCustomers_QNAME = new QName("http://model.webservice.feukora.project/", "getCustomers");
    private final static QName _SaveRapport_QNAME = new QName("http://model.webservice.feukora.project/", "saveRapport");
    private final static QName _GetCustomersResponse_QNAME = new QName("http://model.webservice.feukora.project/", "getCustomersResponse");
    private final static QName _SaveRapportResponse_QNAME = new QName("http://model.webservice.feukora.project/", "saveRapportResponse");
    private final static QName _LoginResponse_QNAME = new QName("http://model.webservice.feukora.project/", "loginResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: project.feukora.webservice.model
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SaveRapport }
     * 
     */
    public SaveRapport createSaveRapport() {
        return new SaveRapport();
    }

    /**
     * Create an instance of {@link GetCustomersResponse }
     * 
     */
    public GetCustomersResponse createGetCustomersResponse() {
        return new GetCustomersResponse();
    }

    /**
     * Create an instance of {@link SaveRapportResponse }
     * 
     */
    public SaveRapportResponse createSaveRapportResponse() {
        return new SaveRapportResponse();
    }

    /**
     * Create an instance of {@link LoginResponse }
     * 
     */
    public LoginResponse createLoginResponse() {
        return new LoginResponse();
    }

    /**
     * Create an instance of {@link CreateRapport }
     * 
     */
    public CreateRapport createCreateRapport() {
        return new CreateRapport();
    }

    /**
     * Create an instance of {@link GetCustomers }
     * 
     */
    public GetCustomers createGetCustomers() {
        return new GetCustomers();
    }

    /**
     * Create an instance of {@link CreateRapportResponse }
     * 
     */
    public CreateRapportResponse createCreateRapportResponse() {
        return new CreateRapportResponse();
    }

    /**
     * Create an instance of {@link Login }
     * 
     */
    public Login createLogin() {
        return new Login();
    }

    /**
     * Create an instance of {@link Rapport }
     * 
     */
    public Rapport createRapport() {
        return new Rapport();
    }

    /**
     * Create an instance of {@link Customer }
     * 
     */
    public Customer createCustomer() {
        return new Customer();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateRapportResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://model.webservice.feukora.project/", name = "createRapportResponse")
    public JAXBElement<CreateRapportResponse> createCreateRapportResponse(CreateRapportResponse value) {
        return new JAXBElement<CreateRapportResponse>(_CreateRapportResponse_QNAME, CreateRapportResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Login }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://model.webservice.feukora.project/", name = "login")
    public JAXBElement<Login> createLogin(Login value) {
        return new JAXBElement<Login>(_Login_QNAME, Login.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateRapport }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://model.webservice.feukora.project/", name = "createRapport")
    public JAXBElement<CreateRapport> createCreateRapport(CreateRapport value) {
        return new JAXBElement<CreateRapport>(_CreateRapport_QNAME, CreateRapport.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCustomers }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://model.webservice.feukora.project/", name = "getCustomers")
    public JAXBElement<GetCustomers> createGetCustomers(GetCustomers value) {
        return new JAXBElement<GetCustomers>(_GetCustomers_QNAME, GetCustomers.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SaveRapport }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://model.webservice.feukora.project/", name = "saveRapport")
    public JAXBElement<SaveRapport> createSaveRapport(SaveRapport value) {
        return new JAXBElement<SaveRapport>(_SaveRapport_QNAME, SaveRapport.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCustomersResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://model.webservice.feukora.project/", name = "getCustomersResponse")
    public JAXBElement<GetCustomersResponse> createGetCustomersResponse(GetCustomersResponse value) {
        return new JAXBElement<GetCustomersResponse>(_GetCustomersResponse_QNAME, GetCustomersResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SaveRapportResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://model.webservice.feukora.project/", name = "saveRapportResponse")
    public JAXBElement<SaveRapportResponse> createSaveRapportResponse(SaveRapportResponse value) {
        return new JAXBElement<SaveRapportResponse>(_SaveRapportResponse_QNAME, SaveRapportResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoginResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://model.webservice.feukora.project/", name = "loginResponse")
    public JAXBElement<LoginResponse> createLoginResponse(LoginResponse value) {
        return new JAXBElement<LoginResponse>(_LoginResponse_QNAME, LoginResponse.class, null, value);
    }

}

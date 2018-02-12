package RemoteReg;
import Contact.Contact;
import Contact.ContactDetails;


public class RemoteContact extends ContactDetails implements Contact {

    private String id;

    public RemoteContact(String id, String firstName, String lastName, String email) {
        this.id = id;
       setFirstName(firstName);
        setLastName(lastName);
        setEmail(email);

    }
    public String getId() { return id;}
}

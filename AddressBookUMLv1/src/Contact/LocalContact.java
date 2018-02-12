package Contact;

import java.io.Serializable;
import java.util.UUID;

public class LocalContact extends ContactDetails implements Contact, Serializable {

    private UUID id;

    public LocalContact(String firstName, String lastName, String email) {
        setFirstName(firstName);
        setLastName(lastName);
        setEmail(email);
    }

    public void setId(UUID id) {
        this.id = id;
    }           //Inte enligt design //this is needed to set private UUID in Registry according to design: it's not generated here, but in registry as it should, if not make this setters here we would need to change UUID field to protected. But I try to avoid protected, because private is usually safer.//NZ

    public String getId() {
        return String.valueOf(id);
    }

}
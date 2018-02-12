package Command;

import Contact.Contact;

public class ContactFormatter {

    public String format(Contact c) {
        return  "First name:  " + c.getFirstName()+ "\n"+
                "Second name: " + c.getLastName()+ "\n"+
                "Email:       " + c.getEmailAddress()+ "\n"+
                "ID:          " + c.getId()+ "\n";

    }
}

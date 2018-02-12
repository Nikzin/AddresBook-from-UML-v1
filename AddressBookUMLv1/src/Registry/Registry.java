package Registry;


import Contact.Contact;
import Contact.LocalContact;

import java.util.ArrayList;
import java.util.List;


public class Registry  {

    public List<Contact> contacts = new ArrayList<>();

    public void addContact(String firstName, String lastName, String email ){
        LocalContact contact = new LocalContact(firstName, lastName, email);
        contact.setId(new UniqueIdGenerator().idGenrator()); //here the UUID is set
        contacts.add (contact);
    }

    public List<Contact> getContacts() {
       return contacts;
    }

    public void deleteContact(String id) {

            for (Contact contact : contacts) {

                if (contact.getId().equals(id)) {

                    contacts.remove(contact);
                    break;
                }
            }


    }
    public List <Contact> search(String term) {
        List<Contact> tempList = new ArrayList<Contact>();
        for (Contact contact : contacts) {

            if (contact.getFirstName().toLowerCase().startsWith(term.toLowerCase())) {
                tempList.add(contact);
            } else if (contact.getLastName().toLowerCase().startsWith(term.toLowerCase())) {
                tempList.add(contact);
            }
        }
        return tempList;
    }
    public void load(List<Contact>contacts){ this.contacts= contacts;// varför är den tom? //fixed //NZ

    }
}

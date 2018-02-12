package RemoteReg;

import java.util.*;

import Contact.*;

public class RemoteRegistry  {

    private List<Contact> remoteContacts = new ArrayList<Contact>();

    private List<Contact> getContacts() {
        return remoteContacts;
    }

    public List<Contact> getRemoteContacts() {
        return remoteContacts;
    }

    public List <Contact> search(String term) {
        List<Contact> foundList = new ArrayList<Contact>();
        for (Contact contact : remoteContacts) {
            if (contact.getFirstName().toLowerCase().startsWith(term.toLowerCase())) {
                foundList.add(contact);
            } else if (contact.getLastName().toLowerCase().startsWith(term.toLowerCase())) {
                foundList.add(contact);
            }
        }
        return foundList;
    }




    public void add(String id, String firtName, String lastName, String email) {
        RemoteContact rContact = new RemoteContact(id, firtName, lastName, email);
        remoteContacts.add(rContact);
    }
}

package Command;
import Contact.Contact;

import java.util.ArrayList;
import java.util.Collections;
import java.util.*;
import java.util.List;


public class ContactListSorter {

    public List<Contact> sorter(List<Contact> c) {

        List<Contact> tempSortedList = new ArrayList<Contact>();

        tempSortedList.addAll(c);

        Collections.sort(tempSortedList, contactComparator);

        return tempSortedList;
    }





    public static Comparator<Contact> contactComparator = new Comparator<Contact>() {

        public int compare(Contact c1, Contact c2) {
            String contactName1 = c1.getFirstName().toLowerCase();
            String contactName2 = c2.getFirstName().toLowerCase();
            return contactName1.compareToIgnoreCase(contactName2);
        }};
}

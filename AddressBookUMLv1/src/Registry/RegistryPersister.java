package Registry;


import Contact.Contact;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class RegistryPersister {
    private File filePath;



    private ArrayList<Contact> persistedRegisrer;

    public ArrayList<Contact> getPersistedRegisrer() {
        return persistedRegisrer;
    }

    public void save(){
        try {
            FileOutputStream storeToFile = new FileOutputStream(filePath);
            ObjectOutputStream register = new ObjectOutputStream(storeToFile);
        }catch (IOException ex){
            ex.printStackTrace();
        }

    }
    public void load(){
        try {
            ArrayList<Contact> tempRegister = new ArrayList<Contact>();
            FileInputStream getFromFile = new FileInputStream(filePath);
            ObjectInputStream register = new ObjectInputStream(getFromFile);
            try {
                tempRegister =(ArrayList<Contact>)register.readObject();
                persistedRegisrer = tempRegister;
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package Registry;

import Contact.Contact;

import java.io.*;

import Console.ConsolePrinter;

import java.util.ArrayList;
import java.util.List;

import Console.Console;

public class RegistryPersisterAntonReMake {

    private String filePath = "adressbokclient.csv";

    private Registry registry;

    public Registry getRegistry() {
        return registry;
    }

    private ConsolePrinter consolePrinter = new Console();

    public RegistryPersisterAntonReMake(Registry registry) {
        this.registry = registry;
        load(); // done NZ
        //this.registry = new Registry(); System.out.println("new reg");
    }


    public void save() {

        try {
            FileOutputStream storeToFile = new FileOutputStream(filePath);
            ObjectOutputStream register = new ObjectOutputStream(storeToFile);
            register.writeObject(registry.getContacts());


        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    public void load() {
        try {
            if ((new File(filePath).length() == 0)) {
                registry.load(new ArrayList<Contact>());
            } else {
                FileInputStream getFromFile = new FileInputStream(filePath);
                ObjectInputStream register = new ObjectInputStream(getFromFile);
                try {
                    registry.load((ArrayList<Contact>) register.readObject());

                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

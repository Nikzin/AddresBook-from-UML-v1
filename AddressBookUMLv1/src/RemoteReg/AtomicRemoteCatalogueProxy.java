package RemoteReg;

import Contact.Contact;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AtomicRemoteCatalogueProxy implements RemoteCatalogueProxy {

    private CatalogueClient catalogueclient;

    public AtomicRemoteCatalogueProxy(String host, int port) {
        catalogueclient = new CatalogueClient(host, port);
    }

    public List<String> getContacts() {
        catalogueclient.connect();
        catalogueclient.sendRequest("getAll");//Osäker på om det är här getAll ska skrivas.

        List<String> tempServerContacts = new ArrayList<>();
        String responsContacts = catalogueclient.waitForResponse();
        Scanner scanner = new Scanner(responsContacts);

        while (scanner.hasNextLine()) {
            String tempLine[] = scanner.nextLine().split(",");
           // tempServerContacts.add(new RemoteContact(tempLine[0], tempLine[1], tempLine[2], tempLine[3]));
        }

        catalogueclient.disconnect("exit");
        return tempServerContacts;

    }
}

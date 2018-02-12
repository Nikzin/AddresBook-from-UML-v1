package Registry;

import Contact.Contact;

import java.util.List;

public class AutoSave implements Runnable{

    private RegistryPersisterAntonReMake registryPersister;
    public AutoSave(RegistryPersisterAntonReMake registryPersister) {
        this.registryPersister=registryPersister;
    }

    public void run() {
        while(true) {

            safeThis(registryPersister);

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public  synchronized void safeThis (RegistryPersisterAntonReMake registryPersister){
        registryPersister= this.registryPersister;
        registryPersister.save();
    }
}

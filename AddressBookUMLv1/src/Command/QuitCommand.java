package Command;


import RemoteReg.RemoteRegistry;
import Registry.Registry;
import Registry.RegistryPersisterAntonReMake;
import Console.*;
import Contact.Contact;

public class QuitCommand implements Command {

    private RegistryPersisterAntonReMake registryPersister;

    public QuitCommand(RegistryPersisterAntonReMake registryPersister) {
        this.registryPersister=registryPersister;
        registryPersister.save();
        System.exit(0);

    }

    public QuitCommand() {

    }

    @Override
    public String getName() {
        return "quit";
    }

    @Override
    public String getDescription() {
        return "Type: quit to exit application";
    }

    @Override
    public void execute() throws InvalidCommandParameterException {
        registryPersister.save();
    }
}

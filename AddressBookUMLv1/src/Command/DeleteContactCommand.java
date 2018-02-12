package Command;

import Console.*;
import Contact.Contact;
import Registry.Registry;
import RemoteReg.RemoteRegistry;

import java.util.List;

public class DeleteContactCommand implements Command {

    private List<String> parameters;
    private Registry registry;
    private RemoteRegistry remoteregistry;
    private ConsolePrinter consolePrinter = new Console();

    public DeleteContactCommand(Registry registry, RemoteRegistry remoteregistry, List<String> parameters) {
        this.registry = registry;
        this.parameters = parameters;
        this.remoteregistry = remoteregistry;
    }

    public DeleteContactCommand() {

    }


    boolean validate() {
        boolean isValid = true;
        if (parameters.size() != 1) {
            throw new InvalidCommandParameterException();
        }
        return isValid;
    }

    @Override
    public String getName() {
        return "delete";
    }

    @Override
    public String getDescription() {
        return "Type: delete followed by";
    }

    public void execute() throws InvalidCommandParameterException {
        if (validate()) {

            for (Contact c : registry.getContacts()) {
                if (c.getId().equals(parameters.get(0))) {
                    registry.deleteContact(parameters.get(0));
                    consolePrinter.print("Contact deleated");
                    return;
                }
            }
            for (Contact c : remoteregistry.getRemoteContacts()) {
                if (c.getId().equals(parameters.get(0))) {
                    consolePrinter.print("You can not delete remote contats");
                    return;
                }
            }
            consolePrinter.print("no contact by given id was found");


        }
        }
}

package Command;

import Console.Console;
import Console.ConsolePrinter;
import Contact.Contact;
import Registry.Registry;
import RemoteReg.RemoteRegistry;

import java.util.ArrayList;
import java.util.List;

public class SearchCommand implements Command {
    private Registry registry;
    private ConsolePrinter consolePrinter = new Console();
    private RemoteRegistry remoteRegistry;
    private List<String> parameters;

    public SearchCommand(Registry registry, RemoteRegistry remoteRegistry, List<String> parameters) {
        this.registry = registry;
        this.remoteRegistry = remoteRegistry;
        this.parameters = parameters;
    }

    public SearchCommand() {}

    boolean validate() {
        boolean isValid = true;
        if (parameters.size() != 1) {
            throw new InvalidCommandParameterException();
        }
        return isValid;
    }

    @Override
    public String getName() {
        return "Search";
    }

    @Override
    public String getDescription() {
        return "Type: search followed by the first letter/letters in first or second name";
    }

    public void execute() throws InvalidCommandParameterException {
        if (validate()) {

            List<Contact> searchRes = new ArrayList<>();

            searchRes.addAll(registry.search(parameters.get(0)));


            searchRes.addAll(remoteRegistry.search(parameters.get(0)));
            if (searchRes.isEmpty()){
                consolePrinter.print("nothing like "+parameters.get(0)+" is found");}
            else{
            for (Contact c : searchRes) {
                consolePrinter.print(new ContactFormatter().format(c));}
            }
        }
    }

}
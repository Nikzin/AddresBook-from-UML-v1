package Console;

import Registry.*;
import RemoteReg.*;
import Registry.RegistryPersisterAntonReMake;
import Command.*;

public class CommandInterpreter {
    private Application app;
    private Registry registry;
    private RegistryPersisterAntonReMake registrypersister;
    private RemoteRegistry remoteregistry;

    public CommandInterpreter(Registry registry, RemoteRegistry remoteregestry, RegistryPersisterAntonReMake registrypersister) {
        this.registry = registry;
        this.remoteregistry = remoteregestry;
        this.registrypersister = registrypersister;
        this.app = app;

    }

    public Command interpret(CommandLine commandline) {

            switch (commandline.getCommand()) {
                case "add":
                    return new AddContactCommand(registry, commandline.getParameters());
                case "list":
                    return new ListCommand(registry, remoteregistry);
                case "delete":
                    return new DeleteContactCommand(registry, remoteregistry, commandline.getParameters());
                case "search":
                    return new SearchCommand(registry, remoteregistry, commandline.getParameters());
                case "help":
                     return new HelpCommand();
                case "quit":
                    return new QuitCommand(registrypersister);
                default:
                    throw new InvalidCommandException();

            }


    }
}

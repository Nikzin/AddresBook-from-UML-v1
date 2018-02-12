package Console;

import Registry.*;
import RemoteReg.CatalogueLoaderNZ;
import RemoteReg.RemoteRegistry;
import Command.*;

public class CommandLineInterface implements InputHandler{

    private Registry registry = new Registry();
    private RegistryPersisterAntonReMake registrypersister = new RegistryPersisterAntonReMake(registry);
    private RemoteRegistry remoteregistry = new RemoteRegistry();
    private CatalogueLoaderNZ catalogueloader = new CatalogueLoaderNZ(remoteregistry);

    private Console console = new Console();
    private AutoSave autosave = new AutoSave(registrypersister); //kan behöva göras så autosave tar in registrypersister som parameter //yes:NZ, did it as parameter//
    private CommandInterpreter comandinterpreter;

    public CommandLineInterface(){
        comandinterpreter = new CommandInterpreter(registry, remoteregistry, registrypersister);

         new Thread (autosave).start();
        catalogueloader.runLoader(); //thread is inside runLoader

        console.registerInputHandler(this);


    }

    @Override
    public void handle(CommandLine commandLine) {
        try {
            Command command = comandinterpreter.interpret(commandLine);

            command.execute();

        } catch (InvalidCommandException | InvalidCommandParameterException e) {
            console.print(e.getMessage());
        }
    }
}


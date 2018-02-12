package Command;

public enum Commands {

    LIST(new ListCommand().getName(), new ListCommand().getDescription()),
    ADD(new AddContactCommand().getName(), new AddContactCommand().getDescription()),
    QUIT(new QuitCommand().getName(), new QuitCommand().getDescription()),
    DELETE(new DeleteContactCommand().getName(), new DeleteContactCommand().getDescription()),
    SEARCH(new SearchCommand().getName(), new SearchCommand().getDescription()),
    HELP(new HelpCommand().getName(), new HelpCommand().getDescription());

    public final String commandName;
    public final String commandDesc;

    Commands(String cName, String cDesc){
        commandName = cName;
        commandDesc = cDesc;
    }

    public String getCommandInfo(){
        return String.format("--%s-- %s", commandName,commandDesc);
    }
}

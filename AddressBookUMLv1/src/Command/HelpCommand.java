package Command;

import Console.Console;
import java.util.List;

public class HelpCommand  implements Command{

    private HelpMeny helpMeny;
    private Console console;


    public String format() {
        helpMeny = new HelpMeny();

        List<Commands> tempList;
        String temp = "";
        tempList = helpMeny.getCommands();
        for (Commands c : tempList) {
            temp +=  c.getCommandInfo() +"\n";

        }
        return temp;
    }

    @Override
    public String getName() {
        return "help";
    }

    @Override
    public String getDescription() {
        return "Type: help to see all valid commands";
    }

    @Override
    public void execute() throws InvalidCommandParameterException {
        console = new Console();
        console.print(format());
    }
}

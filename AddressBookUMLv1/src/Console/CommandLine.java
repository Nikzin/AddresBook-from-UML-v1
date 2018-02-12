package Console;

import java.util.ArrayList;
import java.util.List;

public class CommandLine {
    private String command;
    private List<String> parameters;

    public CommandLine(){}
    private CommandLine(String c, List<String> p){
        this.command = c;
        this.parameters = p;
    }

    public String getCommand() {
        return command;
    }

    public List<String> getParameters() {
        return parameters;
    }

    public CommandLine parse(String text) { //Nikolay påpekar outofband exception

        String[] temp = text.split(" ");
        String theCommand = temp[0];

        List<String> theParameters = new ArrayList<>();
        for (int i = 1; i < temp.length; i++) {
            theParameters.add(temp[i]);
        }
        CommandLine commandline = new CommandLine(theCommand, theParameters);
        return commandline;
    }
}
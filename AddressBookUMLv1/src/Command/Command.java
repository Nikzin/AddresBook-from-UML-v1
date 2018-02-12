package Command;

public interface Command {

    String getName();
    String getDescription();
    void execute() throws InvalidCommandParameterException;

}

package Command;

public class InvalidCommandException extends RuntimeException {
    public InvalidCommandException (){
        super("Invalid Command");
    }
}

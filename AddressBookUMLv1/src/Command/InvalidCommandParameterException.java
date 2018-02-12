package Command;

public class InvalidCommandParameterException extends RuntimeException{

    public InvalidCommandParameterException(){
        super("Wrong numbers of parametes");
    }

}

package Command;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

public class HelpMeny {
    private List<Commands> commands;

    public HelpMeny(){
        build();
    }

    private void build() {
        commands  =  new ArrayList<Commands>(EnumSet.allOf(Commands.class));
    }

    public List<Commands> getCommands() {
        return commands;
    }
}

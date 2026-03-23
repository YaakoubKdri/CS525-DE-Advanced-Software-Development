package counter;

import java.util.ArrayList;
import java.util.List;

public class HistoryList {
    private List<Command> commandList = new ArrayList<>();
    private List<Command> undoList = new ArrayList<>();

    public void addCommand(Command command){
        commandList.add(command);
    }

    public void undo(){
        if(commandList.size() > 0){
            Command command = commandList.get(commandList.size() - 1);
            commandList.remove(command);
            command.unExecute();
            undoList.add(command);
        }
    }

    public void redo(){
        if(undoList.size() > 0){
            Command command = undoList.get(undoList.size() - 1);
            undoList.remove(command);
            command.execute();
            commandList.add(command);
        }
    }
}

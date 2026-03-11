package bank.command;

import java.util.ArrayList;
import java.util.Collection;

public class HistoryList {

    private Collection<Command> commandList = new ArrayList<>();
    private Collection<Command> undoList = new ArrayList<>();

    public void addCommand(Command command) {
        commandList.add(command);
    }

    public void undo(){
        if(commandList.size() > 0){
            ArrayList<Command> list = (ArrayList<Command>) commandList;
            Command commandObject = list.get(list.size() - 1);
            list.remove(commandObject);
            commandObject.unExecute();
            undoList.add(commandObject);
        }
    }

    public void redo(){
        if(undoList.size() > 0){
            ArrayList<Command> list = (ArrayList<Command>) undoList;
            Command commandObject = list.get(list.size() - 1);
            commandObject.execute();
            list.remove(commandObject);
            commandList.add(commandObject);
        }
    }
}

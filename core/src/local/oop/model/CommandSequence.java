package local.oop.model;

import local.oop.model.player.PlayerId;

import java.util.ArrayList;
import java.util.List;

public class CommandSequence {
    private List<Command> commands;
    private PlayerId playerId;

    public CommandSequence(List<Command> commands, PlayerId playerId) {
        this.commands = commands;
        this.playerId = playerId;
    }

    public List<Command> getCommands() {
        return commands;
    }

    public PlayerId getPlayerId() {
        return playerId;
    }

    public void addCommand(Command command){
        if(this.commands==null){
            this.commands = new ArrayList<>();
        }
        this.commands.add(command);
    }
}

package net.sgysoft.thegame;

import net.sgysoft.thegame.actions.Action;
import net.sgysoft.thegame.actions.MoveForwardAction;
import net.sgysoft.thegame.actions.TurnLeftAction;
import net.sgysoft.thegame.actions.TurnRightAction;
import net.sgysoft.thegame.exceptions.InvalidValueException;

import java.util.LinkedList;
import java.util.List;

/**
 * Enum containing all possible commands that can be executed on specific piece position
 */
public enum Commands {
    MOVE_FORWARD("M", new MoveForwardAction()),
    TURN_RIGHT("R", new TurnRightAction()),
    TURN_LEFT("L", new TurnLeftAction());

    private final String code;
    private final Action action;

    Commands(String code, Action action) {
        this.code = code;
        this.action = action;
    }

    public String getCode() {
        return code;
    }

    /**
     * Execute command on specific piece position, returns new position of the piece
     */
    public PiecePosition executeCommand(PiecePosition position) {
        return this.action.executeAction(position);
    }

    public static Commands parse(String s) {
        for (Commands c : Commands.values()) {
            if (c.getCode().equals(s)) {
                return c;
            }
        }
        throw new InvalidValueException("Unknown command: [%s]", s);
    }

    public static Commands[] parseCommands(String s) {
        List<Commands> commands = new LinkedList<>();
        for (Integer index = 0; index < s.length(); index++) {
            commands.add(
                    Commands.parse(
                            String.valueOf(s.charAt(index))
                    )
            );
        }
        return commands.toArray(new Commands[commands.size()]);
    }

}

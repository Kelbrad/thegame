package net.sgysoft.thegame.actions;

import net.sgysoft.thegame.PiecePosition;

public class TurnLeftAction implements Action {

    @Override
    public PiecePosition executeAction(PiecePosition currentPosition) {
        return new PiecePosition(
                currentPosition.getSquare(),
                currentPosition.getOrientation().turnLeft()
        );
    }

}

package net.sgysoft.thegame.actions;

import net.sgysoft.thegame.PiecePosition;

public class MoveForwardAction implements Action {

    @Override
    public PiecePosition executeAction(PiecePosition currentPosition) {
        return new PiecePosition(
                currentPosition.getSquare().nextSquare(currentPosition.getOrientation()),
                currentPosition.getOrientation()
        );
    }

}

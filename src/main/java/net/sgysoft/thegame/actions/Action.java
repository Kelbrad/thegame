package net.sgysoft.thegame.actions;

import net.sgysoft.thegame.PiecePosition;

public interface Action {

    PiecePosition executeAction(PiecePosition currentPosition);

}

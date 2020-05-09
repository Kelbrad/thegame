package net.sgysoft.thegame.actions;

import net.sgysoft.thegame.Coordinate;
import net.sgysoft.thegame.Orientations;
import net.sgysoft.thegame.PiecePosition;
import net.sgysoft.thegame.Square;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TurnLeftActionTest {

    private TurnLeftAction action;

    @Before
    public void setup() {
        this.action = new TurnLeftAction();
    }

    @Test
    public void executeActionTest() {

        Square square = new Square(new Coordinate(1, 1));
        PiecePosition position = new PiecePosition(square, Orientations.NORTH);

        PiecePosition result = this.action.executeAction(position);
        Assert.assertEquals(square, result.getSquare());
        Assert.assertEquals(Orientations.WEST, result.getOrientation());

    }

}

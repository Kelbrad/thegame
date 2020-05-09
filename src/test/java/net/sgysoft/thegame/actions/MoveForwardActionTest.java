package net.sgysoft.thegame.actions;

import net.sgysoft.thegame.Coordinate;
import net.sgysoft.thegame.Orientations;
import net.sgysoft.thegame.PiecePosition;
import net.sgysoft.thegame.Square;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class MoveForwardActionTest {

    private MoveForwardAction action;

    @Mock
    private Square squareMock;

    @Before
    public void setup() {
        this.action = new MoveForwardAction();
    }

    @Test
    public void executeActionTest() {

        PiecePosition position = new PiecePosition(this.squareMock, Orientations.NORTH);
        Square nextSquare = new Square(new Coordinate(1, 1));

        Mockito.when(this.squareMock.nextSquare(Orientations.NORTH)).thenReturn(nextSquare);

        PiecePosition result = this.action.executeAction(position);
        Assert.assertEquals(nextSquare, result.getSquare());
        Assert.assertEquals(Orientations.NORTH, result.getOrientation());

    }

}

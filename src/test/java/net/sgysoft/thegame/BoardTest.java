package net.sgysoft.thegame;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BoardTest {

    private Board board;

    @Before
    public void setup() {
        this.board = new Board(5);
    }

    @Test
    public void testCase1() {

        Commands[] commands = Commands.parseCommands("MRMLMRM");
        PiecePosition position = this.board.executeCommands(commands);

        Assert.assertEquals(new Coordinate(2, 2), position.getSquare().getCoordinate());
        Assert.assertEquals(Orientations.EAST, position.getOrientation());

    }

    @Test
    public void testCase2() {

        Commands[] commands = Commands.parseCommands("RMMMLMM");
        PiecePosition position = this.board.executeCommands(commands);

        Assert.assertEquals(new Coordinate(3, 2), position.getSquare().getCoordinate());
        Assert.assertEquals(Orientations.NORTH, position.getOrientation());

    }

    @Test
    public void testCase3() {

        Commands[] commands = Commands.parseCommands("MMMMM");
        PiecePosition position = this.board.executeCommands(commands);

        Assert.assertEquals(new Coordinate(0, 4), position.getSquare().getCoordinate());
        Assert.assertEquals(Orientations.NORTH, position.getOrientation());

    }

}

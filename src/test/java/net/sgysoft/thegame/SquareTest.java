package net.sgysoft.thegame;

import org.junit.Assert;
import org.junit.Test;

public class SquareTest {

    @Test
    public void nextSquareTest() {

        Square left = new Square(new Coordinate(0, 1));
        Square right = new Square(new Coordinate(2, 1));
        Square top = new Square(new Coordinate(1, 2));
        Square bottom = new Square(new Coordinate(1, 0));

        Square square = new Square(new Coordinate(1, 1));
        square.initSiblings(left, right, top, bottom);

        Square result = square.nextSquare(Orientations.NORTH);
        Assert.assertEquals(top, result);

        result = square.nextSquare(Orientations.EAST);
        Assert.assertEquals(right, result);

        result = square.nextSquare(Orientations.SOUTH);
        Assert.assertEquals(bottom, result);

        result = square.nextSquare(Orientations.WEST);
        Assert.assertEquals(left, result);

    }

    @Test
    public void nextSquareBorderTest() {

        Square right = new Square(new Coordinate(1, 0));
        Square top = new Square(new Coordinate(0, 1));

        Square square = new Square(new Coordinate(0, 0));
        square.initSiblings(null, right, top, null);

        Square result = square.nextSquare(Orientations.NORTH);
        Assert.assertEquals(top, result);

        result = square.nextSquare(Orientations.EAST);
        Assert.assertEquals(right, result);

        result = square.nextSquare(Orientations.SOUTH);
        Assert.assertEquals(square, result);

        result = square.nextSquare(Orientations.WEST);
        Assert.assertEquals(square, result);

    }

}

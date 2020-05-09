package net.sgysoft.thegame;

import org.junit.Assert;
import org.junit.Test;

public class OrientationsTest {

    @Test
    public void turnLeftTest() {

        Assert.assertEquals(
                Orientations.NORTH.turnLeft(),
                Orientations.WEST
        );
        Assert.assertEquals(
                Orientations.EAST.turnLeft(),
                Orientations.NORTH
        );

    }

    @Test
    public void turnRightTest() {

        Assert.assertEquals(
                Orientations.NORTH.turnRight(),
                Orientations.EAST
        );
        Assert.assertEquals(
                Orientations.WEST.turnRight(),
                Orientations.NORTH
        );

    }

}

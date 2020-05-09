package net.sgysoft.thegame;

import org.junit.Assert;
import org.junit.Test;

public class CommandsTest {

    @Test
    public void parseCommandsTest() {

        Commands[] result = Commands.parseCommands("MLR");
        Assert.assertEquals(3, result.length);
        Assert.assertSame(result[0], Commands.MOVE_FORWARD);
        Assert.assertSame(result[1], Commands.TURN_LEFT);
        Assert.assertSame(result[2], Commands.TURN_RIGHT);

    }

}

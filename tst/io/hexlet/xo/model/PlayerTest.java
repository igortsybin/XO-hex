package io.hexlet.xo.model;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by igorts on 16.03.2017.
 */
public class PlayerTest {
    @Test
    public void getName() throws Exception {
        final String inputValue = "Slava";
        final String expectValue = inputValue;
        final Player player = new Player(inputValue, null);

        final String actualValue = player.getName();
        assertEquals(expectValue, actualValue);

    }

    @Test
    public void getFigure() throws Exception {
        final Figure inputValue = Figure.X;
        final Figure expectValue = inputValue;

        final Player player = new Player(null, inputValue);

        final Figure actualValue = player.getFigure();
        assertEquals(expectValue, actualValue);

    }

}
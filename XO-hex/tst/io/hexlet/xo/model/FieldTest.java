package io.hexlet.xo.model;

import io.hexlet.xo.model.exceptions.AlreadyOccupiedException;
import io.hexlet.xo.model.exceptions.InvalidPointException;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;


public class FieldTest {
    @Test
    public void testGetSize() throws Exception {
        final Field field = new Field();
        assertEquals(3 , field.getSize());
    }

    @Test
    public void testGetFigure() throws Exception {
        final Field field = new Field ();
        final Point inputPoint = new Point(0, 0);
        final Figure inputFigure = Figure.O;
        field.setFigure(inputPoint, inputFigure);
        final Figure actualFigure = field.getFigure(inputPoint);
        assertEquals(inputFigure, actualFigure);
    }

    @Test
    public void testGetFigureWhenFigureIsNotSet() throws Exception {
        final Field field = new Field ();
        final Point inputPoint = new Point(0, 0);
        final Figure actualFigure = field.getFigure(inputPoint);

        assertNull (actualFigure);
    }

    @Test
    public void testGetFigureWhenAlreadyOccupied() throws Exception {
        final Field field = new Field ();
        final Point inputPoint = new Point(0, 0);
        final Figure inputFigure = Figure.O;
        field.setFigure(inputPoint, inputFigure);
        try {
            field.setFigure(inputPoint, inputFigure);
            fail(); //if test achieves string 45, the string 46 will not be done

        } catch (final AlreadyOccupiedException e) {}
    }

    @Test
    public void testGetFigureWhenXIsLessThenZero() throws Exception {
        final Field field = new Field ();
        final Point inputPoint = new Point(-1, 0);
        try {
            final Figure actualFigure = field.getFigure(inputPoint);
            fail(); //if test achieves string 45, the string 46 will not be done

        } catch (final InvalidPointException e) {}

    }
    @Test
    public void testGetFigureWhenXIsMoreThenSize() throws Exception {
        final Field field = new Field();
        final Point inputPoint = new Point(field.getSize() + 1, 0);
        try {
            final Figure actualFigure = field.getFigure(inputPoint);
            fail();

            } catch (final InvalidPointException e) {
        }
    }

    @Test
    public void testGetFigureWhenYIsLessThenZero() throws Exception {
        final Field field = new Field ();
        final Point inputPoint = new Point(0, -1);
        try {
            final Figure actualFigure = field.getFigure(inputPoint);
            fail();

        } catch (final InvalidPointException e) {}

    }

    @Test
    public void testGetFigureWhenYIsMoreThenSize() throws Exception {
        final Field field = new Field();
        final Point inputPoint = new Point(0, field.getSize() + 1);
        try {
            final Figure actualFigure = field.getFigure(inputPoint);
            fail();

        } catch (final InvalidPointException e) {
        }
    }

}
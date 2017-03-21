package io.hexlet.xo.controllers;

import io.hexlet.xo.model.Field;
import io.hexlet.xo.model.Figure;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class WinnerControllerTest {
    @Test
    public void getWinner() throws Exception {
        final int FIELD_SIZE = 4;
        final Field field = new Field(FIELD_SIZE);
        Point p1 = new Point(0, 0);
        Point p2 = new Point(1, 0);
        Point p3 = new Point(2, 0);

        field.setFigure(p1, Figure.X);
        field.setFigure(p2, Figure.X);
        field.setFigure(p3, Figure.X);


        WinnerController winnerController = new WinnerController();
        Figure winner = winnerController.getWinner(field);


        assertEquals(Figure.X, winner);


    }

    @Test
    public void check() throws Exception {

    }

}
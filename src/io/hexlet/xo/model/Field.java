package io.hexlet.xo.model;

import java.awt.*;

/**
 * Created by igorts on 16.03.2017.
 */
public class Field {
    private static int FIELD_SIZE = 3;

    private final Figure [][] field = new Figure[FIELD_SIZE][FIELD_SIZE];

    public int getSize () {
        return FIELD_SIZE;
    }

    public Figure getFigure (final Point point) {
        return field[point.x][point.y];
    }

    public void setFugure (final Point point, final Figure figure) {
        field[point.x][point.y] = figure;


    }



}

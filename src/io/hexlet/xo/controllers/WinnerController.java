package io.hexlet.xo.controllers;


import io.hexlet.xo.model.Field;
import io.hexlet.xo.model.Figure;
import io.hexlet.xo.model.exceptions.InvalidPointException;

import java.awt.*;

public class WinnerController {

    public Figure getWinner (final Field field) throws InvalidPointException {
        try {
            //vertical
            for (int i = 0; i < 3; i++) {
                if (check(field, new Point(i, 0), new IChangeTheRule() {
                    @Override
                    public Point change(Point p) {
                        return new Point(p.x, p.y + 1);
                    }
                })) {
                    return field.getFigure(new Point(i, 0));
                }
            }

            //alternative realisation

            for (int i = 0; i < 3; i++) {
                if (check(field, new Point(i, 0), p -> new Point(p.x + 1, p.y))) {
                    return field.getFigure(new Point(i, 0));
                }
            }


            //horizontal
            for (int i = 0; i < 3; i++) {
                if (check(field, new Point(i, 0), new IChangeTheRule() {
                    @Override
                    public Point change(Point p) {
                        return new Point(p.x, p.y + 1);
                    }
                })) {
                    return field.getFigure(new Point(i, 0));
                }
            }

            if (check(field, new Point(0, 0), new IChangeTheRule() {
                @Override
                public Point change(Point p) {
                    return new Point(p.x + 1, p.y + 1);
                }
            })) {
                return field.getFigure(new Point(0, 0));
            }


            //diagonal second side
            if (check(field, new Point(0, 2), new IChangeTheRule() {
                @Override
                public Point change(Point p) {
                    return new Point(p.x, p.y - 1);
                }
            })) {
                return field.getFigure(new Point(0, 2));
            }


        }   catch (InvalidPointException e) {
                e.printStackTrace();}

        return null;
    }

    public boolean check(final Field field, Point startPoint, IChangeTheRule changeTheRule) throws InvalidPointException {
        try {

            final Point p1 = startPoint;
            final Point p2 = changeTheRule.change(p1);
            final Point p3 = changeTheRule.change(p2);


            if (field.getFigure(p1) == null) {

            }
               return (field.getFigure(p1) == field.getFigure(p2) && field.getFigure(p1)== field.getFigure(p3));
        } catch (InvalidPointException e) {e.printStackTrace();}
        return false;
    }

    private interface IChangeTheRule  {
        Point change (final Point p);
    }



}

package io.hexlet.xo.controllers;


import io.hexlet.xo.model.Field;
import io.hexlet.xo.model.Figure;
import io.hexlet.xo.model.exceptions.InvalidPointException;

import java.awt.*;

public class WinnerController {

    public Figure getWinner (final Field field) throws InvalidPointException {
        try {


//            for (int i = 0; i < 3; i++) {
//                if (check(field, new Point(i, 0), p -> new Point(p.x, p.y + 1))) { //p - argument, after - the body
//                    return field.getFigure(new Point(i, 0));
//                }
//            }
            for (int i = 0; i < 3; i++) {
                if (check(field, new Point(i, 0), new IPointGenerator() {
                    @Override
                    public Point next(Point p) {
                        return new Point(p.x, p.y + 1);
                    }
                })) {
                    return field.getFigure(new Point(i, 0));
                }
            }

            //horizontal

            for (int i = 0; i < 3; i++) {
                if (check(field, new Point(0, i), p -> new Point(p.x + 1 , p.y))) { //p - argument, after - the body
                    return field.getFigure(new Point(0, i));
                }
            }


            //diagonal first side
            if (check(field, new Point(0, 0), p -> new Point(p.x + 1, p.y + 1))){

                return field.getFigure(new Point(0, 0));
            }


            //diagonal second side
            if (check(field, new Point(0, 2), p -> new Point(p.x + 1, p.y - 1)))
                return field.getFigure(new Point(1, 1));



        }   catch (InvalidPointException e) {
                e.printStackTrace();}

        return null;
    }

//    public boolean check(final Field field,
//                         Point currentPoint,
//                         IChangeTheRule changeTheRule) throws InvalidPointException {
//
//
//
//
//        try {
//
//            final Point p1 = currentPoint;
//            final Point p2 = changeTheRule.change(p1);
//            final Point p3 = changeTheRule.change(p2);
//
//
//            if (field.getFigure(p1) == null) {
//                return false;
//            } else
//                return (field.getFigure(p1) == field.getFigure(p2) && field.getFigure(p1)== field.getFigure(p3));
//        } catch (InvalidPointException e) {e.printStackTrace();}
//        return false;
//    }

    private boolean check(final Field field,
                          final Point currentPoint,
                          final IPointGenerator pointGenerator) {
        final Figure currentFigure;
        final Figure nextFigure;
        final Point nextPoint = pointGenerator.next(currentPoint);
        try {
            currentFigure = field.getFigure(currentPoint);

            if (currentFigure == null)
                return false;

            nextFigure = field.getFigure(nextPoint);
        } catch (final InvalidPointException e) {
            return true;
        }

        if (currentFigure != nextFigure)
            return false;

        return check(field, nextPoint, pointGenerator);
    }

    private interface IPointGenerator  {
        Point next (final Point p);
    }



}


//            for (int i = 0; i < 3; i++) {
//                if (check(field, new Point(i, 0), new IPointGenerator() {
//                    @Override
//                    public Point change(Point p) {
//                        return new Point(p.x, p.y + 1);
//                    }
//                })) {
//                    return field.getFigure(new Point(i, 0));
//                }
//            }
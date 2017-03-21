package io.hexlet.xo.controllers;


import io.hexlet.xo.model.Field;
import io.hexlet.xo.model.Figure;
import io.hexlet.xo.model.exceptions.InvalidPointException;

import java.awt.*;

public class CurrentMoveController {

    public Figure currentMove (final Field field){

//        int countX = 0;
//        int countO = 0;
        //if the number is even;


        if (countFiguresinTheField(field) == field.getSize() * field.getSize()) {
            return null;
        }


        if (countFiguresinTheField(field) % 2 == 0) { // refuse after separate
                return Figure.X;
            }


        return Figure.O; //else

    }

    private int countFiguresinTheField (Field field) {
        int countFigure = 0;
        for (int x = 0 ; x < field.getSize(); x++) {
            for (int y = 0 ; y < field.getSize(); y++) {
                try {
                    if (field.getFigure(new Point(x, y)) != null) {
                        countFigure ++;
                    }

                    //                    switch (field.getFigure(new Point(x, y))) {
//                        case X:
//                            countX++;
//                            break;
//
//
//                        case O:
//                            countO++;
//                            break;
//
//                    }


                } catch (InvalidPointException e) {};
            }

        }
        return countFigure;

    }




}

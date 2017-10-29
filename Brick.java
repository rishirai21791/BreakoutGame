package edu.macalester.comp124.breakout;

import comp124graphics.GraphicsGroup;
import comp124graphics.GraphicsObject;
import comp124graphics.Rectangle;

import java.awt.*;
import java.awt.geom.Point2D;

/**
 * This Brick class is a rectangle, and it represents a single brick.
 * Created by Lisa on 19/03/17.
 * Acknowledgments: Own work
 */
public class Brick extends Rectangle {

    public static final int BRICK_WIDTH = 70;
    public static final int BRICK_HEIGHT = 20;

    /**
     * The constructor for Brick: takes in the x, y and color of the brick. It creates a rectangle with the given inputs.
     * @param x The x coordinate of where the brick is to be placed on the canvas
     * @param y The y coordinate of where the brick is to be placed on the canvas
     * @param col The color of the brick
     */
    public Brick(double x, double y, Color col) {
        super(x, y, BRICK_WIDTH, BRICK_HEIGHT);
        this.setFilled(true);
        this.setFillColor(col);
        this.setStroked(true);
        this.setStrokeColor(col);
    }

    @Override
    public String toString() {
        return "Brick{ Brick width = " + BRICK_WIDTH + "Brick height = " + BRICK_HEIGHT + " }";
    }
}


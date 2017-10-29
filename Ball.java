package edu.macalester.comp124.breakout;

import comp124graphics.Ellipse;
import java.awt.*;

/**
 * Created by Lisa on 19/03/17.
 * This class is the ball class, which is an Ellipse (a graphics object). It sets up the graphics object (sets the size and color of the ball).
 * Acknowledgements: COMP124, Daniel Kluver
 */
public class Ball extends Ellipse {

    public static final int BALL_RADIUS = 10;

    /**
     * The constructor for Ball
     * @param x The x coordinate where it is to be placed on the canvas.
     * @param y The y coordinate where it is to be placed ont he canvas.
     * @param col The color of the ball.
     */
    public Ball(double x, double y, Color col) {
        super(x, y, BALL_RADIUS, BALL_RADIUS);
        this.setFilled(true);
        this.setFillColor(col);
        this.setStroked(true);
        this.setStrokeColor(col);
    }

    @Override
    public String toString() {
        return "Ball{ Radius of the ball = " + BALL_RADIUS + " }";
    }
}


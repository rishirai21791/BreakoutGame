package edu.macalester.comp124.breakout;
import comp124graphics.GraphicsGroup;
import comp124graphics.Rectangle;
import java.awt.*;

/**
 * This Paddle class is a rectangle, and it represents the paddle in the BreakoutGame. It will be instantiated in the
 * BreakoutGame.
 * Created by Lisa on 19/03/17.
 * Acknowledgments: Giang
 */
public class Paddle extends Rectangle {

    private static final int PADDLE_WIDTH = 80;
    private static final int PADDLE_HEIGHT = 20;

    /**
     * The constructor for Paddle: takes in the x, y and color of the paddle, and sets up the paddle
     * @param x The x coordinate of where the paddle is to be placed on the canvas
     * @param y The y coordinate of where the paddle is to be placed on the canas
     * @param color The color of the paddle
     */
    public Paddle(double x, double y, Color color) {
        super(x, y, PADDLE_WIDTH, PADDLE_HEIGHT);
        this.setFilled(true);
        this.setFillColor(color);
        this.setStroked(true);
        this.setStrokeColor(color);
    }

    @Override
    public String toString() {
        return "Paddle{ Width = " + PADDLE_WIDTH + "Height = " + PADDLE_HEIGHT + "}";
    }
}


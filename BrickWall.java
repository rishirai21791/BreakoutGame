package edu.macalester.comp124.breakout;
import comp124graphics.GraphicsGroup;
import comp124graphics.GraphicsObject;
import java.awt.*;

/**
 * Created by Lisa on 23/03/17.
 * This class is a GraphicsGroup, comprising of many Bricks (rectangles). This sets up the wall of bricks for the game.
 * There are methods which check if a brick is touched by a ball (then removes that brick). It is used in the BreakoutGame
 * class.
 * Acknowledgements: Giang, Daniel Kluver
 */
public class BrickWall extends GraphicsGroup{

    int brickCount;

    /**
     * Constructor for BrickWall: Uses a for loop to keep instantiating and adding bricks to the graphics group, and
     * increases the brickCount every time.
     */
    public BrickWall() {
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 8; j++) {
                Brick brick = new Brick(((j * (Brick.BRICK_WIDTH + 3))), ((i * (Brick.BRICK_HEIGHT + 3))), Color.BLACK);
                add(brick);
                brickCount++;
            }
        }
    }

    /**
     * Getter for the brickCount
     * @return the number of bricks in the brickwall
     */
    public int getBrickCount() {
        return brickCount;
    }

    /**
     * This method checks to see if a ball has touched the side of a brick. It does this by getting the x and y positions
     * of the ball (the two sides), and checking if there is another element (a graphics group) in that position.
     * If there is a graphics object, it removes it (as it is a brick), and reduces the count for the number of bricks.
     * @param ball The ball in the game which moves and touches the brick
     * @return boolean (true if it touches a brick, false if not).
     */
    public boolean touchesBrickSide(Ball ball) {

        double ballRX = ball.getX();
        double ballRY = ball.getY() + (0.5 * ball.getHeight());

        double ballLX = ball.getX() + (ball.getWidth());
        double ballLY = ball.getY() + (0.5 * ball.getHeight());

        GraphicsObject gob1 = getElementAt(ballLX, ballLY);
        GraphicsObject gob2 = getElementAt(ballRX, ballRY);

        if (((gob1 != null) && (gob1 instanceof Brick))) {
            remove(gob1);
            brickCount--;
            return true;
        }
        if ((gob2 != null) && (gob2 instanceof Brick)) {
            remove(gob2);
            brickCount--;
            return true;
        } else {
            return false;
        }
    }


    /**
     * This method checks to see if a ball has touched the top or bottom of a brick. It does this by  getting the x and y positions
     * of the ball (the two sides), and checking if there is another element (a graphics group) in that position.
     * If there is a graphics object, it removes it (as it is a brick), and reduces the count for the number of bricks.
     * @param ball The ball in the game which moves and touches the brick
     * @return boolean (true if it touches a brick, false if not).
     */
    public boolean touchesBrickUpDown(Ball ball) {
        double ballUX = ball.getX()+(0.5*ball.getWidth());
        double ballUY = ball.getY();

        double ballDX = ball.getX()+(0.5*ball.getWidth());
        double ballDY = ball.getY()+(ball.getHeight());

        GraphicsObject gob3 = getElementAt(ballUX, ballUY);
        GraphicsObject gob4 = getElementAt(ballDX, ballDY);

        if (((gob3!=null)&&(gob3 instanceof Brick))) {
            remove(gob3);
            brickCount--;
            return true;
        } if ((gob4!=null)&&(gob4 instanceof Brick)) {
            remove(gob4);
            brickCount--;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "BrickWall{" +
                "Number of bricks = " + brickCount + '}';
    }
}

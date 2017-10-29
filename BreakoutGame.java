package edu.macalester.comp124.breakout;
import comp124graphics.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.Random;

/**
 * Created by Lisa on 30/3/2017
 * This class it he main program for the breakout game, and it extends the CanvasWindow. It instantiates objects such
 * as the ball, paddle and brickwall objects, and adds them to the canvas window. There are methods which are written
 * and invoked to move those graphics objects and set up the game.
 * Acknowledgements: COMP 124, Giang, Daniel Kluver, Jonathan Scott
 */
public class BreakoutGame extends CanvasWindow implements MouseMotionListener {

    private static final int CANVAS_WIDTH = 600;
    private static final int CANVAS_HEIGHT = 650;
    int numLives;
    int level = 15;
    Paddle paddle1;
    Ball ball1;
    BrickWall brickwall;
    Random random = new Random();

    /**
     * Constructor for the BreakoutGame
     */
    public BreakoutGame() {
        super("Breakout!", CANVAS_WIDTH, CANVAS_HEIGHT);
        this.brickwall = new BrickWall();
        add(brickwall, 10, 60);
        this.numLives = 3;
        this.ball1 = new Ball(300, 400, Color.BLACK);
        this.paddle1 = new Paddle(0, 500, Color.BLACK);
        add(paddle1);
        add(ball1);
        addMouseMotionListener(this);

        while (numLives > 0) {
            this.run(ball1);
            if (isLost()) {
                numLives--;
            } else if (won()) {
                System.out.println("You win!!!");
                break;
            }
        }
        if (numLives == 0) {
            System.out.println("You lost :(");
        }
    }

    /**
     * This method sets the ball on the canvas and the direction angle at which the ball is first going to be dropped using
     * a random boolean generator. It then uses a while loop to keep moving/bouncing the ball, as long as the game is
     * not won or lost.
     * @param ball2 The ball (graphics object) that will move on the canvas.
     */
    public void run(Ball ball2) {

        int dx;
        boolean signx = random.nextBoolean();

        if (signx) {
            dx = 5;
        } else {
            dx = -5;
        }
        int dy = 5;

        ball2.setPosition(300, 250);
        this.pause(3000);

        while (!isLost()&&(!won())) {
            ball2.move(dx, dy);
            this.pause(level);

            if (needsToBounceHorizontally()) {
                dx = -dx;
            }
            if (needsToBounceVertically()) {
                dy = -dy;
            }
            if (brickwall.touchesBrickSide(ball2)) {
                dx = -dx;
            }
            if (brickwall.touchesBrickUpDown(ball2)) {
                dy = -dy;
            }
        }
    }

    /**
     * This method checks to see whether the ball has fallen off the canvas.
     * @return boolean (true if the ball fell and is out of the canvas, false if the ball is still above the canvas).
     */
    public boolean isLost() {
        return (ball1.getBounds().getY()>=CANVAS_HEIGHT);
    }

    /**
     * This method checks to see if the game is won by checking if there are any bricks left.
     * @return boolean (true if there are no more bricks (the game is won), false if there are still bricks left).
     */
    public boolean won() {
        return (brickwall.getBrickCount()==0);
    }

    /**
     * This method checks to see if the ball has to bounce horizontally (if it hits the vertical walls of the canvas).
     * @return boolean (true if the ball's position is less than zero (where the canvas starts), or if the ball's position
     * exceeds the right hand edge of the canvas; false if neither).
     */
    private boolean needsToBounceHorizontally() {
        double ballWidth = ball1.getWidth();
        double ballX = ball1.getX();
        if (ballX < 0) {
            return true;
        } else if (ballX + ballWidth > CANVAS_WIDTH) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * This method checks to see if the ball has to bounce vertically (if it hits the paddle or the top edge of the canvas).
     * @return boolean (true if the ball's y position is less than that of the canvas top edge, or if the ball's y position
     * is greater than that of the paddle's).
     */
    private boolean needsToBounceVertically() {
        double ballWidth = ball1.getWidth();
        double ballHeight = ball1.getHeight();
        double ballX = ball1.getBounds().getX();
        double ballY = ball1.getBounds().getY();
        double paddleY = paddle1.getBounds().getY();
        double paddleX = paddle1.getBounds().getX();
        double paddleWidth = paddle1.getWidth();

        if (((ballY+ballHeight)==(paddleY))&&
                (ballX+(ballWidth)>=paddleX)&&
                (ballX-(ballWidth)<=paddleX+paddleWidth)){
            return true;
        } else if (ballY<=0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * We do not implement and use this method in this program.
     * @param e
     */
    @Override
    public void mouseDragged(MouseEvent e) {
    }

    /**
     * Implement the mouseMoved method; this moves the x-position of the paddle with the movement of the mouse.
     * @param e
     */
    @Override
    public void mouseMoved(MouseEvent e) {
        double x = e.getX();
        if ((x<CANVAS_WIDTH-(0.5*paddle1.getWidth()))&&(x>(0.5*paddle1.getWidth()))) {
            paddle1.setPosition(x-(paddle1.getWidth()/2), paddle1.getY());
        }
    }

    /**
     * Main method for the BreakoutGame. It instantiates a new BreakoutGame.
     * @param args
     */
    public static void main(String[] args) {
        BreakoutGame prog = new BreakoutGame();
    }

    @Override
    public String toString() {
        return ("BreakoutGame {" +
                "Number of lives = " + numLives +
                ", Level =" + level +
                ", Number of bricks left = " + brickwall.getBrickCount() +
                '}');
    }
}


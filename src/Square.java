import javax.swing.*;
import java.awt.*;

/**
 * A class written to support the TicTacToe Game.
 *
 * Each Square object is one position of the TicTacToe
 * board. It maintains information on the marker, its
 * location on the board, and whether it is part
 * of the winning set.
 *
 * @author: Nandhini Namasivayam
 * @version: Jan 2023
 */

public class Square {

    private String marker;
    private int row;
    private int col;
    private boolean isWinningSquare;
    private final int IMAGE_DIMENSION = 160;

    /**
     * Constructor to initialize one Square of the
     * TicTacToe board
     * @param row the row the square is in
     * @param col the column the square is in
     */
    public Square(int row, int col) {
        this.row = row;
        this.col = col;
        this.marker = TicTacToe.BLANK;
        this.isWinningSquare = false;
    }

    /******************** Getters and Setters ********************/
    public String getMarker() {
        return this.marker;
    }

    public void setMarker(String marker) {
        this.marker = marker;
    }

    public void setWinningSquare() {
        this.isWinningSquare = true;
    }

    /**
     * Checks if the square has the BLANK marker
     * @return True if the square is empty, False otherwise
     */
    public boolean isEmpty() {
        return this.marker.equals(TicTacToe.BLANK);
    }

    // Is draw method where we distinguish between X, O, and blank squares? Then prints
    public void draw(Graphics g, TicTacToeViewer t){
        Image[] tokens = t.getPlayerTokens();
        int increment = t.getINCREMENT();
        g.setColor(Color.black);
        //if it is an x, print box + x image
        if (this.getMarker().equals("X")){
            g.drawRect(increment * (col + 1), increment * (row + 1), increment, increment);
            //If winning, fill box to be green
            // CREATE A SEPARATE METHOD FOR THIS
            if (isWinningSquare)
            {
                g.setColor(Color.green);
                g.fillRect(increment * (col + 1), increment * (row + 1), increment, increment);
                g.setColor(Color.black);
            }
            g.drawImage(tokens[1], t.getINCREMENT() * (col+ 1), t.getINCREMENT() * (row + 1), IMAGE_DIMENSION, IMAGE_DIMENSION, t);
        }
        // if it's a y, print y image
        else if (this.getMarker().equals("O")){
            if (isWinningSquare)
            {
                g.setColor(Color.green);
                g.fillRect(increment * (col + 1), increment * (row + 1), increment, increment);
                g.setColor(Color.black);
            }
            g.drawImage(tokens[0], t.getINCREMENT() * (col + 1), t.getINCREMENT() * (row + 1), IMAGE_DIMENSION, IMAGE_DIMENSION, t);
        }
        //if it is empty, print empty rectangle
        else if (isEmpty()){
            g.drawRect(increment * (col + 1), increment * (row + 1), increment, increment);
        }

    }
    /**
     * @return the marker for the square
     */
    public String toString() {
        return this.marker;
    }
}

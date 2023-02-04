import javax.swing.*;
import java.awt.*;

/** By Kate Little, 2/3/23 **/

public class TicTacToeViewer extends JFrame {
    // TODO: Complete this class
    private final int WINDOW_WIDTH = 800;
    private final int WINDOW_HEIGHT = 800;
    //I have divided my window into a grid of 5 * 5 squares. INCREMENT represents the l/w of each square.
    private final int INCREMENT = WINDOW_WIDTH / 5;
    private Image[] playerTokens;
    private TicTacToe t;
    private Square[][] board;
    public TicTacToeViewer(TicTacToe t){
        // Initialize instance variables
        this.t = t;
        board = t.getBoard();
        // Create image objects
        playerTokens = new Image[2];
        playerTokens[0] = new ImageIcon("Resources/O.png").getImage();
        playerTokens[1] = new ImageIcon("Resources/X.png").getImage();

        // Set up the window
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("TicTacToe");
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setVisible(true);
    }

    public Image[] getPlayerTokens() {
        return playerTokens;
    }

    public int getINCREMENT() {
        return INCREMENT;
    }

    public void paint(Graphics g){
        g.setFont(new Font("SansSerif", Font.BOLD, 50));
        g.setColor(Color.red);
        // Print x-axis labels
        for (int i = 0; i < 3; i++){
            String number = i + "";
            g.drawString(number, INCREMENT/2 + INCREMENT * (i+1), INCREMENT * 3/4);
        }
        // Print y-axis labels
        for (int i = 0; i < 3; i++){
            String number = i + "";
            g.drawString(number, INCREMENT * 1/2, INCREMENT/2 + INCREMENT * (i+1));
        }
        // Print each square in board
        for (Square[] row: board){
            for (Square each: row){
                each.draw(g, this);
            }
        }
        // If game is over, print winning/tie message
        g.setColor(Color.black);
        g.setFont(new Font("SansSerif", Font.BOLD, 80));
        if (t.getGameOver())
        {
            if (t.checkTie()){
                g.drawString("It's a Tie!", INCREMENT * 3/2, INCREMENT * 18/4);
            }
            else{
                g.drawString(t.getWinner() + " Wins", INCREMENT * 3/2, INCREMENT * 18/4);
            }
        }

    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package compsci.tictactoe;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
/**
 *
 * @author aireneahuja
 */
public class TicTacToe extends JFrame {
    Button[][] buttonGrid;
    //generally, constants are static and variables are not
    //not a strict rule though
    public static int ROWS = 3;
    public static int COLS = 3; 
    //removed X,O constants since its in enum
    private Player currentPlayer;
    boolean gameOver;
    JLabel message;
    
    /*
    //getter method to give indirect access
    //to the currentPlayer variable
    public int getCurrentPlayer() {
        return currentPlayer;
    }
    
    //setter method to give indirect access 
    //to changing the value of the currentPlayer
    public void setCurrentPlayer(int newPlayer) {
        currentPlayer = newPlayer;
    }
    */
    
    public TicTacToe() {
        super("Tic Tac Toe");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        JPanel messagePanel = new JPanel();
        message = new JLabel("X's turn!");
        message.setFont(new Font(Font.SERIF,Font.ITALIC,36));
        messagePanel.add(message, BorderLayout.NORTH);
        this.add(messagePanel);
        
        GridLayout lm = new GridLayout(ROWS,COLS);
        JPanel buttonPanel = new JPanel(lm);
        buttonGrid = new Button[ROWS][COLS];
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++){
                Button b = new Button();
                TileClickHandler tch = new TileClickHandler(this);
                b.addActionListener(tch);
                buttonGrid[i][j] = b;
                buttonPanel.add(b);
            }
        }
        this.add(buttonPanel, BorderLayout.SOUTH);
        this.pack();
        currentPlayer = Player.X;
        gameOver = false;
    }

    public void move(Button tile) {
        if (!tile.claimed && !gameOver) {
            tile.claim(currentPlayer);
            currentPlayer = (currentPlayer == Player.X) ? Player.O : Player.X;
            
            String p = (currentPlayer == Player.X) ? "X" : "O";
            message.setText(p + "'s turn!");
            
            Player winner = checkWin();
            if (winner != null){
                gameOver = true;
                String w = (winner == Player.X) ? "X" : "O";
                message.setText(w +" won!!!");
            }
        }
    }
    
    public Player checkWin() {
        Player winner = null;
        //Check each row for 3 of the same
        for (int r = 0; r < ROWS; r++){
            boolean cond1 = buttonGrid[r][0].owner == buttonGrid[r][1].owner;
            boolean cond2 = buttonGrid[r][1].owner == buttonGrid[r][2].owner;
            boolean cond3 = buttonGrid[r][0].owner != null;
            if (cond1 && cond2 && cond3){
                winner = buttonGrid[r][0].owner;
            }
        }
        
        // check each column
        for (int c = 0; c < COLS; c++){
            boolean cond1 = buttonGrid[0][c].owner == buttonGrid[1][c].owner;
            boolean cond2 = buttonGrid[1][c].owner == buttonGrid[2][c].owner;
            boolean cond3 = buttonGrid[0][c].owner != null;
            if (cond1 && cond2 && cond3){
                winner = buttonGrid[0][c].owner;
            }
        }
        //check diagonals
        boolean cond1 = buttonGrid[0][0].owner == buttonGrid[1][1].owner;
        boolean cond2 = buttonGrid[1][1].owner == buttonGrid[2][2].owner;
        boolean cond3 = buttonGrid[0][0].owner != null;
        if (cond1 && cond2 && cond3) {
            winner = buttonGrid[0][0].owner;
        }
        cond1 = buttonGrid[0][2].owner == buttonGrid[1][1].owner;
        cond2 = buttonGrid[1][1].owner == buttonGrid[2][0].owner;
        cond3 = buttonGrid[0][2].owner != null;
        if (cond1 && cond2 && cond3) {
            winner = buttonGrid[0][2].owner;
        } 
        return winner;
    }
    
    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
    }
}
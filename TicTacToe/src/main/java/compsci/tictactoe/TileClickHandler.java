/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package compsci.tictactoe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author aireneahuja
 */
public class TileClickHandler implements ActionListener {
    //Action listener is an interface which means it has abstract methods and 
    //can't be used to make objects
    TicTacToe game;
    
    public TileClickHandler(TicTacToe game) {
        this.game = game;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        Button button = (Button)ae.getSource();
        game.move(button); 
        //game.getCurrentPlayer();
    
    }
    
}

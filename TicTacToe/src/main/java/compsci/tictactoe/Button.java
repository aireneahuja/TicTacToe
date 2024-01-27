package compsci.tictactoe;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JButton;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author aireneahuja
 */
public class Button extends JButton{
    boolean claimed;
    Player owner;
    
    public Button() {
        Dimension dmnsn = new Dimension(100,100);
        this.setPreferredSize(dmnsn);
        Font font = new Font(Font.SERIF, Font.BOLD, 48);
        this.setFont(font);
        this.setBackground(Color.white);
        claimed = false;
    }
    
    public void claim(Player player) {
        if (player == Player.X) {
            this.setText("X");
        } else {
            this.setText("O");
        }
        claimed = true;
        owner = player;
    }
}

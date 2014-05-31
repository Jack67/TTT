/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import GameControl.GameControl;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

/**
 *
 * @author Michael Müller michael.mueller.02
 * @stud.hslu.ch
 */
public class Gui extends JFrame{
    
    private GameBoard gameBoard;
    private Menu menu;
    
    public Gui(GameControl gC){
        super("TicTacToe");
        gameBoard = new GameBoard(gC);
        menu = new Menu();
        setSize(300, 330);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        
        add(menu, BorderLayout.NORTH);
        add(gameBoard, BorderLayout.CENTER);
        
        setVisible(true);
    }
}

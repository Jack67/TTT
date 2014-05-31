/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import GameControl.GameControl;
import GameControl.Marker;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;

/**
 *
 * @author Michael Müller michael.mueller.02
 * @stud.hslu.ch
 */
public class GameBoard extends JPanel implements MouseListener{
    
    GameControl gameCtrl;
    Marker[][] gameBoard;
    
    public GameBoard(GameControl gC){
        gameCtrl = gC;
        gC.getGameBoardObject(this);
        setBackground(Color.WHITE);   
        setFocusable(true);
        addMouseListener(this);
    }
    
    public void updateGameBoard(Marker[][] board){
        gameBoard = board;
        repaint();
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        if(x >= 26 && x <= 101){
            x = 0;
        }
        else if(x >= 107 && x <= 182){
            x = 1;
        }
        else if(x >= 188 && x <= 263){
            x = 2;
        }
        if(y >= 26 && y <= 101){
            y = 0;
        }
        else if(y >= 107 && y <= 182){
            y = 1;
        }
        else if(y >= 188 && y <= 263){
            y = 2;
        }
        if(x <= 2 && y <= 2){
            gameCtrl.setMarker(x, y);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}
    
    @Override
    public void paintComponent(Graphics pg){
        Graphics2D g = (Graphics2D) pg;
        super.paintComponent(g);
        //GameField
        g.setColor(Color.BLACK);
        g.setStroke(new BasicStroke(1));
        g.fillRoundRect(20, 20, 250, 249, 20, 20);
        g.setColor(Color.WHITE);
        g.fillRoundRect(26, 26, 75, 75, 10, 10);
        g.fillRoundRect(26, 107, 75, 75, 10, 10);
        g.fillRoundRect(26, 188, 75, 75, 10, 10);
        g.fillRoundRect(107, 26, 75, 75, 10, 10);
        g.fillRoundRect(107, 107, 75, 75, 10, 10);
        g.fillRoundRect(107, 188, 75, 75, 10, 10);
        g.fillRoundRect(188, 26, 75, 75, 10, 10);
        g.fillRoundRect(188, 107, 75, 75, 10, 10);
        g.fillRoundRect(188, 188, 75, 75, 10, 10);
        //Marker
        for(int y = 0; y <= 2; y++){
            for(int x = 0; x <= 2; x++){
                if(gameBoard[x][y].getPlayer() == Marker.FIRST_PLAYER){ //X
                    g.setColor(Color.BLACK);
                    g.setStroke(new BasicStroke(5));
                    g.drawLine(x * 80 + 26 + x + 10, y * 80 + 26 + y + 10, x * 80 + 26 + x + 10 + 55, y * 80 + 26 + y + 10 + 55);
                    g.drawLine(x * 80 + 26 + x + 10, y * 80 + 26 + y + 10 + 55, x * 80 + 26 + x + 10 + 55, y * 80 + 26 + y + 10);
                }
                else if(gameBoard[x][y].getPlayer() == Marker.SECOND_PLAYER){ //O                                                   //O
                    g.setColor(Color.BLACK);
                    g.setStroke(new BasicStroke(5));
                    g.drawOval(x * 80 + 26 + x + 10, y * 80 + 26 + y + 10, 55, 55);
                }
            }
        }
    }
}

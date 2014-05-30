/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

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
    
    public GameBoard(){
        setBackground(Color.WHITE);
        
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mousePressed(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void paintComponent(Graphics pg){
        Graphics2D g = (Graphics2D) pg;
        super.paintComponent(g);
        //GameField
        g.setColor(Color.BLACK);
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
    }
}

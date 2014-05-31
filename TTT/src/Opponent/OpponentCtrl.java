/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Opponent;

import GameControl.GameControl;
import java.awt.Point;

/**
 *
 * @author Michael Müller michael.mueller.02
 * @stud.hslu.ch
 */
public class OpponentCtrl {
    private boolean wait;
    private TCP tcp;
    private KI ki;
    private GameControl gameCtrl;
    
    public OpponentCtrl(){
        wait = true;
        ki = new KI();
        tcp = new TCP();
    }
    
    public void setGameControl(GameControl gC){
        gameCtrl = gC;
    }
    
    public void makeNextMove(int opponent){
        if(opponent != GameControl.OPP_LOCAL){
            if(opponent == GameControl.OPP_KI){
                Point p = ki.makeNextMove(gameCtrl.getGameBoard());
                gameCtrl.setMarkerByOpponent(p.x, p.y);
            }
            else{
                
            }
        }
    }
    
    public void waitForPlayer(){
        String line;
        tcp.newServer();
        line = tcp.readLn();
        line.compareTo("TTT:Request");
        
    }
    
    public void searchPlayer(){
        tcp.newClient();
    }
}

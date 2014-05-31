/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GameControl;

import Opponent.*;
import View.*;

/**
 *
 * @author Michael Müller michael.mueller.02
 * @stud.hslu.ch
 */
public class GameControl {
    
    Marker[][] gameBoard;
    GameBoard gB;
    
    public GameControl(){
        gameBoard = new Marker[3][3];
        for(int y = 0; y <= 2; y++){
            for(int x = 0; x <= 2; x++){
                gameBoard[x][y] = new Marker(Marker.NONE);
            }
        }
    }
    
    public void getGameBoardObject(GameBoard gB){
        this.gB = gB;
        gB.updateGameBoard(gameBoard);
    }
    
    public void setMarker(int x, int y){
        gameBoard[x][y].setPlayer(Marker.FIRST_PLAYER);
        gB.updateGameBoard(gameBoard);
    }
    
    public static void main(String[] args) {
        GameControl gc = new GameControl();
        Gui g = new Gui(gc);
        OpponentCtrl oc = new OpponentCtrl();
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GameControl;

import Opponent.*;
import View.*;
import java.awt.Point;

/**
 *
 * @author Michael Müller michael.mueller.02
 * @stud.hslu.ch
 */
public class GameControl{
    
    public final static int OPP_KI = 1;
    public final static int OPP_LOCAL = 2;
    public final static int OPP_NET = 3;
    public final static int ME = 1;
    public final static int OPP = 2;
    public final static int PLAYER_1 = 1;
    public final static int PLAYER_2 = 2;
    
    private Marker[][] gameBoard;
    private GameBoard gB;
    private OpponentCtrl oppCtrl;

    private int opponent;
    private int player;
    private int player_1;
    private boolean gameOver;
    
    public GameControl(OpponentCtrl oC){
        oppCtrl = oC;
        opponent = OPP_LOCAL;
        player_1 = ME;
        player = PLAYER_1;
        gameOver = false;
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
    
    public void updateGameBoard(){
        gB.updateGameBoard(gameBoard);
    }
    
    public GameControl getGameControlObject(){
        return this;
    }
    
    public void setOpponent(int opp){
        opponent = opp;
    }
    
    public void setPlayer(int player){
        this.player = player;
    }
    
    public void setPlayer1(int player){
        player_1 = player;
    }
    
    public void setBegin(int begin){
        this.player_1 = begin;
    }
    
    public void setGameBoard(Marker[][] gB){
        gameBoard = gB;
    }
    
    public int getOpponent(){
        return opponent;
    }
    
    public int getPlayer(){
        return player;
    }
    
    public int getPlayer1(){
        return player_1;
    }
    
    public int getBegin(){
        return player_1;
    }
    
    public Marker[][] getGameBoard(){
        return gameBoard;
    }
    
    public void setGameOver(){
        gameOver = true;
    }
    
    public void clearGameOver(){
        gameOver = false;
    }
    
    public boolean getGameOver(){
        return gameOver;
    }
    
    public boolean gameOverCheck(){
        int sum = KI.eval(gameBoard);
        if(sum > 500 || sum < -500){
            return true;
        }
        for(int y = 0; y <= 2; y++){
            for(int x = 0; x <= 2; x++){
                if(gameBoard[x][y].getPlayer() == Marker.NONE){
                    return false;
                }
            }
        }
        return true;
    }
    
    public void startNewGame(){
        for(int y = 0; y <= 2; y++){
            for(int x = 0; x <= 2; x++){
                gameBoard[x][y].setPlayer(Marker.NONE);
            }
        }
        gB.updateGameBoard(gameBoard);
        player = PLAYER_1;
        clearGameOver();
    }
    
    public void setMarkerByView(int x, int y){
        if(!gameOver){
            if(gameBoard[x][y].getPlayer() == Marker.NONE){
                if(player == PLAYER_1){
                    if(player_1 == ME){
                        gameBoard[x][y].setPlayer(Marker.FIRST_PLAYER);
                        oppCtrl.makeNextMove(opponent);
                    }
                    else if(opponent == OPP_LOCAL){
                        gameBoard[x][y].setPlayer(Marker.FIRST_PLAYER);
                    }
                    player = PLAYER_2;
                }
                else{
                    if(player_1 != ME){
                        gameBoard[x][y].setPlayer(Marker.SECOND_PLAYER);
                        oppCtrl.makeNextMove(opponent);
                    }
                    else if(opponent == OPP_LOCAL){
                        gameBoard[x][y].setPlayer(Marker.SECOND_PLAYER);
                    }
                    player = PLAYER_1;
                }
                if(gameOverCheck()){
                    setGameOver();
                }
                gB.updateGameBoard(gameBoard);
            }
        }
    }
    
    public void setMarkerByOpponent(int x, int y){
        if(!gameOver){
            if(gameBoard[x][y].getPlayer() == Marker.NONE){
                if(player == PLAYER_1){
                    gameBoard[x][y].setPlayer(Marker.FIRST_PLAYER);
                    player = PLAYER_2;
                }
                else{
                    gameBoard[x][y].setPlayer(Marker.SECOND_PLAYER);
                    player = PLAYER_1;
                }
                if(gameOverCheck()){
                    setGameOver();
                }
                gB.updateGameBoard(gameBoard);
            }
        }
    }
    
    public static void main(String[] args) {
        OpponentCtrl oc = new OpponentCtrl();
        GameControl gc = new GameControl(oc);
        oc.setGameControl(gc);
        Gui g = new Gui(gc, oc);       
    }
}

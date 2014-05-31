/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GameControl;

import View.GameBoard;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import javax.xml.crypto.Data;

/**
 *
 * @author Michael Müller michael.mueller.02
 * @stud.hslu.ch
 */
public class SaveCtrl implements Serializable{
    
    private Marker[][] gameBoard;
    private GameBoard gB;
    
    private int opponent;
    private int player;
    private int player_1;
    private boolean gameOver;
    
    public SaveCtrl(GameControl gC){ 
        opponent = gC.getOpponent();
        player_1 = gC.getPlayer1();
        player = gC.getPlayer();
        gameBoard = gC.getGameBoard();
        gameOver = gC.getGameOver();
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
    
    public boolean getGameOver(){
        return gameOver;
    }
    
    public Marker[][] getGameBoard(){
        return gameBoard;
    }
    
    public static void save(GameControl gC) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Speicher.txt"))){
            out.writeObject(new SaveCtrl(gC));
            System.out.println("Serialization succeeded");
            System.out.println();
        } catch (Exception e) {
            System.out.println("Serialization failed");
            System.out.println();
        }
    }
    
    public static SaveCtrl load(){
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("Speicher.txt"))){
            SaveCtrl gC = (SaveCtrl) in.readObject();
            System.out.println("Deserialization succeeded");
            System.out.println();
            return gC;
        } 
        catch (Exception e) {
            System.out.println("Deserialization failed");
            System.out.println();
        }
        return null;
    }
}

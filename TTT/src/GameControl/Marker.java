/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GameControl;

import java.io.Serializable;

/**
 *
 * @author Michael Müller michael.mueller.02
 * @stud.hslu.ch
 */
public class Marker implements Serializable{
    
    public final static int NONE = 0;
    public final static int FIRST_PLAYER = 1;
    public final static int SECOND_PLAYER = 2;
    
    private int player;
    
    public Marker(int player){
        player = FIRST_PLAYER;
    }
    
    public int getPlayer(){
        return player;
    }
    
    public void setPlayer(int player){
        this.player = player;
    }
}

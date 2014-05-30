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
    
    public GameControl(){
        
    }
    
    
    public static void main(String[] args) {
        GameControl gc = new GameControl();
        Gui g = new Gui();
        OpponentCtrl oc = new OpponentCtrl();
    }
}

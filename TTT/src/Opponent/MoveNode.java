/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Opponent;

import java.awt.Point;

/**
 *
 * @author Michael Müller michael.mueller.02
 * @stud.hslu.ch
 */
public class MoveNode {
    private Point p;
    MoveNode[] moveRow;
    
    public MoveNode(Point p){
        this.p = p;
        moveRow = new MoveNode[9];
    }
    
    public Point getRow(){
        return p;
    }
    
    public MoveNode getNext(int i){
        return moveRow[i];
    }
}

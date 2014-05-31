/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Opponent;

import GameControl.Marker;
import java.awt.Point;

/**
 *
 * @author Michael Müller michael.mueller.02
 * @stud.hslu.ch
 */
public class KI {
    private final static int ROWS = 3;
    private final static int COLS = 3;
    private final static int neg_inf = Integer.MIN_VALUE;
    private final static int pos_inf = Integer.MAX_VALUE;
    private final static int USER_MUL = -3000;
    private final static int KI_MUL = 1000;
    private int level;
    private Point savedPoint;
    private Marker[][] gameField;
    private MoveNode head;
    
    public KI(){
        
    }
    /*
    public Alpha_Beta_Cut(int level, Disc gameField[][]){
        this.level = level * 2;
        this.gameField = gameField;
        savedRow = 0;
        head = null;
    }
    
    public void updateGameField(Disc gF[][]){
        gameField = gF;
    }
    */
    public Point makeNextMove(Marker[][] gameField){
        savedPoint = null;
        this.gameField = gameField;
        head = new MoveNode(null);
        //max(level, neg_inf, pos_inf, head);
        return savedPoint;
    }
       /* 
    private int max(int depth, int alpha, int beta, MoveNode node) {
        int maxValue;
        int value;
        if (depth == 0 || isGameFieldFull()){
            return eval(gameField);
        }
        maxValue = alpha;
        generateMoves(node);
        for(int i = 0; i < 9; i++) {
            if(node.moveRow[i] != null){
                gameField.(node.moveRow[i].getRow(), gameField);
                value = min(depth - 1, maxValue, beta, node.getNext(i));

                gameField = Disc.removeKIDisc(node.moveRow[i].getRow(), gameField);
                if (value > maxValue) {
                    maxValue = value;
                    if (maxValue >= beta){
                        break;
                    }
                    if (depth == level){
                        savedRow = node.moveRow[i].getRow();
                    }
                }
            }
        }
        return maxValue;
     }

    private int min(int depth, int alpha, int beta, MoveNode node) {
        int minValue;
        int value;
        
        if (depth == 0 || isGameFieldFull()){
            return Eval.eval(gameField);
        }
        minValue = beta;
        generateMoves(node);

        for(int i = 0; i < 7; i++) {
            if(node.moveRow[i] != null){
                gameField = Disc.placeUserDisc(node.moveRow[i].getRow(), gameField);
                value = max(depth - 1, alpha, minValue, node.getNext(i));
                gameField = Disc.removeUserDisc(node.moveRow[i].getRow(), gameField);
                if (value < minValue) {
                    minValue = value;
                    if (minValue <= alpha){
                        break;
                    }
                }
            }
        }
        return minValue;
    }
    
    private void generateMoves(MoveNode node){
        for(int i = 0; i < 7; i++) {
            if(node.moveRow[i] == null){
                if(gameField[i][5] == null){
                    node.moveRow[i] = new MoveNode(i);
                }
            }
            else{
                generateMoves(node.getNext(i));
            }
        }
    }
    
    private boolean isGameFieldFull(){
        for(int i = 0; i < 7; i++){
            if(gameField[i][5] == null){
                return false;
            }
        }
        return true;
    }
    */
    public static int eval(Marker gameField[][]){
        int sum = 0;
                
        for(int i = 0; i < ROWS; i++){
            for(int j = 0; j < COLS; j++){
                sum += getNbrRight(gameField, i, j);
                sum += getNbrDiagRight(gameField, i, j);
                sum += getNbrUp(gameField, i, j);
                sum += getNbrDiagLeft(gameField, i, j);
            }
        }
        return sum;
    }
    
    private static int getNbrRight(Marker gameField[][], int row, int col){
        int sum = 0;
        if(row == 0){
            if(gameField[row][col].getPlayer() == Marker.FIRST_PLAYER){
                do{
                    row++;
                    sum++;
                    if(sum >= 3){
                        sum = KI_MUL;
                    }
                    if(row > 2){
                        break;
                    }
                }
                while(gameField[row][col].getPlayer() == Marker.FIRST_PLAYER);
            }
            else if(gameField[row][col].getPlayer() == Marker.SECOND_PLAYER){
                do{
                    row++;
                    sum--;
                    if(sum <= -3){
                        sum = USER_MUL;
                    }
                    if(row > 2){
                        break;
                    }
                }
                while(gameField[row][col].getPlayer() == Marker.SECOND_PLAYER);
            }
        }
        return sum;
    }
    
    private static int getNbrDiagRight(Marker gameField[][], int row, int col){
        int sum = 0;
        if(row == 0 && col == 2){
            if(gameField[row][col].getPlayer() == Marker.FIRST_PLAYER){
                do{
                    row++;
                    col--;
                    sum++;
                    if(sum >= 3){
                        sum = KI_MUL;
                    }
                    if(row > 2 || col < 0){
                        break;
                    }
                }
                while(gameField[row][col].getPlayer() == Marker.FIRST_PLAYER);
            }
            else if(gameField[row][col].getPlayer() == Marker.SECOND_PLAYER){
                do{
                    row++;
                    col--;
                    sum--;
                    if(sum <= -3){
                        sum = USER_MUL;
                    }
                    if(row > 2 || col < 0){
                        break;
                    }
                }
                while(gameField[row][col].getPlayer() == Marker.SECOND_PLAYER);
            }
        }
        return sum;
    }

    private static int getNbrUp(Marker gameField[][], int row, int col){
        int sum = 0;
        if(col == 2){
            if(gameField[row][col].getPlayer() == Marker.FIRST_PLAYER){
                do{
                    col--;
                    sum++;
                    if(sum >= 3){
                        sum = KI_MUL;
                    }
                    if(col < 0){
                        break;
                    }
                }
                while(gameField[row][col].getPlayer() == Marker.FIRST_PLAYER);
            }
            else if(gameField[row][col].getPlayer() == Marker.SECOND_PLAYER){
                do{
                    col--;
                    sum--;
                    if(sum <= -3){
                        sum = USER_MUL;
                    }
                    if(col < 0){
                        break;
                    }
                }
                while(gameField[row][col].getPlayer() == Marker.SECOND_PLAYER);
            }
        }
        return sum;
    }
    
    private static int getNbrDiagLeft(Marker gameField[][], int row, int col){
        int sum = 0;
        if(row == 2 && col == 2){
            if(gameField[row][col].getPlayer() == Marker.FIRST_PLAYER){
                do{
                    row--;
                    col--;
                    sum++;
                    if(sum >= 3){
                        sum = KI_MUL;
                    }
                    if(col < 0 || row < 0){
                        break;
                    }
                }
                while(gameField[row][col].getPlayer() == Marker.FIRST_PLAYER);
            }
            else if(gameField[row][col].getPlayer() == Marker.SECOND_PLAYER){
                do{
                    row--;
                    col--;
                    sum--;
                    if(sum <= -3){
                        sum = USER_MUL;
                    }
                    if(col < 0 || row < 0){
                        break;
                    }
                }
                while(gameField[row][col].getPlayer() == Marker.SECOND_PLAYER);
            }
        }
        return sum;
    }
}

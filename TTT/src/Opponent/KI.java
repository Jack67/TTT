/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Opponent;

import GameControl.Marker;

/**
 *
 * @author Michael Müller michael.mueller.02
 * @stud.hslu.ch
 */
public class KI {
    private final static int ROWS = 3;
    private final static int COLS = 3;
    
    private final static int USER_MUL = -3000;
    private final static int KI_MUL = 1000;
    
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Pieces;

import model.Piece;
import model.Square;
import model.Game;
import java.awt.Color;

/**
 *
 * @author a19diegogc
 */
public class TPiece extends Piece {
    
    
    public TPiece( Game game) {
        this.game = game;
        squares[0] = new Square(Game.MAX_X / 2, 0, Color.RED, game);
        squares[1] = new Square(Game.MAX_X / 2, Game.SQUARE_SIDE, Color.RED, game);
        squares[2] = new Square(Game.MAX_X / 2, Game.SQUARE_SIDE*2,
                Color.RED, game);
        squares[3] = new Square(Game.MAX_X / 2 + Game.SQUARE_SIDE, Game.SQUARE_SIDE, Color.RED, game);
        
    }
    
    
    
    
    @Override
    public boolean rotate() {
        int pos = 1;
       if (squares[2].getX() - Game.SQUARE_SIDE == squares[1].getX()) {
          pos = 0;
       } else if (squares[0].getY() + Game.SQUARE_SIDE == squares[1].getY()) {
           pos = 1;
       } else if(squares[0].getX() + Game.SQUARE_SIDE == squares[1].getX()&&
               squares[3].getX() - Game.SQUARE_SIDE == squares[1].getX()){
            pos = 2;
        }else if(squares[3].getY() + Game.SQUARE_SIDE == squares[1].getY()){
            pos = 3;
        }        
        switch (pos) {
            case 0:
                if (game.isValidPosition(squares[0].getX() + Game.SQUARE_SIDE, squares[0].getY() - Game.SQUARE_SIDE)
                        && game.isValidPosition(squares[2].getX() - Game.SQUARE_SIDE, squares[2].getY() + Game.SQUARE_SIDE)
                        && game.isValidPosition(squares[3].getX() + Game.SQUARE_SIDE, squares[3].getY() + Game.SQUARE_SIDE )) {
                    
                    squares[0].setX(squares[0].getX() + Game.SQUARE_SIDE);
                    squares[0].setY(squares[0].getY() - Game.SQUARE_SIDE);
                    squares[2].setX(squares[2].getX() - Game.SQUARE_SIDE);
                    squares[2].setY(squares[2].getY() + Game.SQUARE_SIDE);
                    squares[3].setX(squares[3].getX() + Game.SQUARE_SIDE);
                    squares[3].setY(squares[3].getY() + Game.SQUARE_SIDE);
                    return true;
                }
                break;
            case 1:
                if (game.isValidPosition(squares[0].getX() - Game.SQUARE_SIDE, squares[0].getY() + Game.SQUARE_SIDE)) {
                    squares[0].setX(squares[0].getX() - Game.SQUARE_SIDE);
                    squares[0].setY(squares[0].getY() + Game.SQUARE_SIDE);
                    return true;
                }
                break;
            case 2:
                if (game.isValidPosition(squares[3].getX() - Game.SQUARE_SIDE, squares[3].getY() - Game.SQUARE_SIDE)) {
                    squares[3].setX(squares[3].getX() - Game.SQUARE_SIDE);
                    squares[3].setY(squares[3].getY() - Game.SQUARE_SIDE);
                    return true;
                }
                break;
            case 3:
                if (game.isValidPosition(squares[2].getX() + Game.SQUARE_SIDE, squares[2].getY() - Game.SQUARE_SIDE)) {
                    squares[2].setX(squares[2].getX() + Game.SQUARE_SIDE);
                    squares[2].setY(squares[2].getY() - Game.SQUARE_SIDE);
                    return true;
                }
                break;
            
        }

        return false;

    }



    
}

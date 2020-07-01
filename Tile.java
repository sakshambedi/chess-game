/*****************************************************
 **                                                 **
 ** Tile class stores the location of the tile      ** 
 ** and the chessPiece it stores                    **
 **                                                 **
 **                                                 **
 *****************************************************/    

 
// ************* importing libraries ***************** 
import chessPieces.*;
import java.util.ArrayList;
import java.util.Arrays;


public class Tile {
    
    // assigning class variables
    private final int xCoord;
    private final int yCoord;
    private chessPiece piece;
    
    
    // default contructor for Tile class 
    public Tile(final int XCoordinate,final int yCoordinate){
        this.xCoord = XCoordinate;
        this.yCoord = yCoordinate;
    }
    

    /** 
     * Purpose : Method to chess piece at the given tile 
     * 
     * @param name : String name of the tile 
     * @param team : String value of name,represented by the colour
     * 
     **/
    protected void setChessPiece(String name, String team){
        if (name.equals("pawn"))   this.piece = new Pawn(name,team);
        else if(name.equals("rook"))    this.piece = new Rook(name,team);
        else if(name.equals("horse"))   this.piece = new Horse(name,team);
        else if(name.equals("bishop"))  this.piece = new Bishop(name, team);
        else if (name.equals("queen"))  this.piece = new Queen(name,team);
        else this.piece = new King(name,team);
    }


    /**
     * Purpose :  return String x-coordinates and y-coordinates 
     */ 
    protected String TileDetails(){
        return "X-value : " + xCoord + "; Y-value : "+ yCoord;
    }


    /**  
    * Purpose : method to return the name of the piece on the tile
    */
    protected String getPieceName(){
        if(this.piece==null)  return "";
        return this.piece.toStringName();
    }


    /**
    * Purpose : To check if there is a tile on this tile
    * 
    */
    protected boolean isPieceHere(){
        if (this.piece==null) return false;
        return true; 
    }


    /**
     * Purpose : to reset the state of the tile to empty
     * 
     */
    protected void resetTile(){
        piece.removeChessPiece(); 
    }


    /**
     *  Purpose : return chesspiece at the given tile
     *   
     *  @return piece : Chess piece at the given tile 
     */ 
    protected chessPiece getPiece(){
        return piece;
    }

    /**
     * Purpose : To find the color of the chess piece at the given tile 
     * 
     * 
     * @return colorOfPiece : String value of color of the piece at the tile 
     * 
     */
    protected String getPieceColor(){
        return piece.toStringTeamName();
    }



    /**
     * Purpose : To call the right getPossibleMoves method depending upon the
     *           instance of the chessPiece
     * 
     * 
     * @return ArrayList<int[]> : arraylist of possible moves 
     */
    protected ArrayList<int[]> getMoves(){
        int[] psuedoArray = {0,0};
        ArrayList<int[]> psuedoList = new ArrayList<int[]>(
                                        Arrays.asList(psuedoArray));
        if ((this.piece.toStringName()).equals("pawn") )  return calculateMovesForPawn();
        // else if ((this.piece.toStringName()).equals("rook")) return;
        return psuedoList;    
    }   



    private ArrayList<int[]> calculateMovesForPawn(){
        return piece.getPossibleMoves(xCoord, yCoord);
    }

    // private ArrayList<int[]> calculateMovesForRook(){
    //     if()
    //     return piece.getPossibleMoves(xCoord, yCoord);
    // }

}
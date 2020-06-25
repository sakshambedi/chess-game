/**
 * 
 * Tile class stores the location of the tile
 * 
 * 
 */

 
// ************* importing libraries ***************** 
import chessPieces.*;
import java.util.ArrayList;
import java.util.Arrays;


public class Tile {
    
    // assigning variables
    private final int xCoord;
    private final int yCoord;
    private chessPiece piece;
    
    
    // default contructor for Tile class 
    public Tile(final int XCoordinate,final int yCoordinate){
        this.xCoord = XCoordinate;
        this.yCoord = yCoordinate;
        // this.piece = new chessPiece();
        // teamName = null;
        // color =(XCoordinate+yCoordinate)%2; 
    }
    

    /**
     * Purpose : Method to chess piece at the given tile 
     */
    protected void setChessPiece(String name, String team){
        if (name.equals("pawn"))   this.piece = new pawn(name,team);
        else if(name.equals("rook"))    this.piece = new rook(name,team);
        else if(name.equals("horse"))   this.piece = new horse(name,team);
        else if(name.equals("bishop"))  this.piece = new bishop(name, team);
        else if (name.equals("queen"))  this.piece = new queen(name,team);
        else this.piece = new king(name,team);
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
        else return this.piece.toStringName();
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
        if(this.piece == null ) return null;
        else return piece;
    }



    /**
     * Purpose : To call the right getPossibleMoves method depending upon the
     *           instance of the chessPiece
     * 
     * 
     * @return ArrayList<int[]> : arraylist of possible moves 
     */
    protected void getMoves(){
        int[] psuedoArray = {0,0};
        ArrayList<int[]> psuedoList = new ArrayList<int[]>(
                                        Arrays.asList(psuedoArray));

        if (this.piece.toStringName().equals("pawn") ) System.out.println(this.piece.getClass().getName());
        // else if (this.piece instanceof rook) return ((rook)piece).getPossibleMoves(xCoord, yCoord);
        // return psuedoList;    
    }   

}
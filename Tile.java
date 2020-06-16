/**
 * 
 * Tile class stores the location of the tile
 * 
 * 
 */

 
// ************* importing libraries ***************** 
import chessPieces.*;


public class Tile {
    
    // assigning variables
    private int xCoord;
    private int yCoord;
    private chessPiece piece;
    
    
    // default contructor for Tile class 
    public Tile(int XCoordinate,int yCoordinate){
        this.xCoord = XCoordinate;
        this.yCoord = yCoordinate;
        this.piece = new chessPiece();
        // teamName = null;
        // color =(XCoordinate+yCoordinate)%2; 
    }
    

    /**
     * Purpose : Method to chess piece at the given tile 
     */
    public void setChessPiece(String name, String team){
        if (name.equals("pawn"))    piece = new pawn(name,team);
        else if(name.equals("rook"))    piece = new rook(name,team);
        else if(name.equals("horse"))   piece = new horse(name,team);
        else if(name.equals("bishop"))  piece = new bishop(name, team);
        else if (name.equals("queen"))  piece = new queen(name,team);
        else piece = new king(name,team);
    }

    /**
     * Purpose :  return String x-coordinates and y-coordinates 
     */ 
    public String TileDetails(){
        return "X-value : " + xCoord + "; Y-value : "+ yCoord;
    }


    /**  
    * Purpose : method to return the name of the piece on the tile
    */
    public String getPiece(){
        return piece.toStringName();
    }


    /**
     * Purpose : To check if there is a tile on this tile
     * 
    */
    public boolean isPieceHere(){
        if (piece.toStringName()==null) return true;
        return false; 
    }


    /**
     * Purpose : to reset the state of the tile to empty
     * 
     */
    public void resetTile(){
        piece.removeChessPiece(); 
    }
}
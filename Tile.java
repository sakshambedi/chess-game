/**
* Tile class stores the location of the tile
*/

// importing libraries 
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
        // else if(name.equals("rook"))    piece = new ()       
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

}
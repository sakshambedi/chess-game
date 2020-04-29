/*
* tile class stores the location of the tile
*/

// importing libraries 
import chessPieces.*;


public class Tile {
    
    // assigning variables
    private int xCoord;
    private int yCoord;
    // private chessPiece piece;
    
    
    // default contructor for Tile class 
    public Tile(int XCoordinate,int yCoordinate){
        xCoord = XCoordinate;
        yCoord = yCoordinate;
        chessPiece piece = new chessPiece();
        // teamName = null;
        // color =(XCoordinate+yCoordinate)%2; 
    }
    
    // method to set the color of the tile 
    public void setChessPiece(String name, String team){
        if (name.equals("pawn")) {
            chessPiece piece = new chessPiece(name,team);          
        }
    }

    // public method to return details of the tile 
    public String TileDetails(){
        return "X-value : " + xCoord + "; Y-value : "+ yCoord;
    }


    // method to return the name of the piece on the tile
    public String getPiece(){
        return chessPieces.toStringName();
    }

}
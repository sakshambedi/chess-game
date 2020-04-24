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
            chessPiece pawn = new pawn(name,team);
        }
    }
 

    // public method to return details of the tile
    //  instance method  
    public String TileDetails(){
        return "X-value : " + xCoord + "; Y-value : "+ yCoord ;
    }


    // access xCoords  
    public int getXCoords() {return xCoord;}


    // access yCoords
    public int getYCoords() {return yCoord;}


    public String getPiece(){
        return chessPiece.toStringName();
    }

}
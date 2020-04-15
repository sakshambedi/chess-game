/*
tile class stores the location of the tile
*/


public class Tile {
    
    // assigning variables
    private int xCoord;
    private int yCoord;
    private String containsPiece;
    private int color;                 // using int 0/1 for colour ; 0-black 1-white 
     
    // default contructor for Tile class 
    public Tile(int XCoordinate,int yCoordinate){
        xCoord = XCoordinate;
        yCoord = yCoordinate;
        containsPiece= null;
        color =(XCoordinate+yCoordinate)%2; 
    }
    
    // method to set the color of the tile 
    public void setColor(int colorCode){
        color = colorCode;
    }


    // public method to return details of the tile
    //  instance method  
    public String TileDetails(){
        return "X-value : " + xCoord + "; Y-value : "+ yCoord + "; Contains piece : " + containsPiece + "; Color : " + color; 
    }


    // access xCoords  
    public int getXCoords(){
        return xCoord;
    }


    // access yCoords
    public int getYCoords(){
        return yCoord;
    }


    // access String value of piece
    public String getPiece(){
        return containsPiece;
    }


}
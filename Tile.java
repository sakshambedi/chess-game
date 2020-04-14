/*
tile class stores the location of the tile
*/


public class Tile {
    
    // assigning variables
    int xCord;
    int yCord;
    boolean containsPiece;
    int color;                 // using int 0/1 for colour ; 0-black 1-white 
     
    // default contructor for Tile class 
    public Tile(int XCoordinate,int yCoordinate){
        xCord = XCoordinate;
        yCord = yCoordinate;
        containsPiece= false;
        color =(XCoordinate+yCoordinate)%2; 
    }
    
    // method to set the color of the tile 
    public void setColor(int colorCode){
        color = colorCode;
    }

    public String TileDetails(){
        return "X-value : " + xCord + "; Y-value : "+ yCord + "; Contains piece : " + containsPiece + "; Color : " + color; 
    }
}
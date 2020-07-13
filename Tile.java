/*****************************************************
 **                                                 **
 ** Tile class stores the location of the tile      ** 
 ** and the chessPiece it stores                    **
 **                                                 **
 **                                                 **
 *****************************************************/    

 
// ************* importing libraries ***************** 
import chessPieces.*;


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
    * Purpose : To check if there is a tile on this tile.
    *           Return true if there is a tile there ordewise returns false 
    *
    * return boolean 
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
        this.piece=null;
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
        if(this.piece == null) return "";
        return piece.toStringTeamName();
    }



    /** 
     * Purpose : To change the color of piece at the given tile position
     * 
     * @param pieceColor : new color of the chessPiece 
     * 
     * @return void
     * 
      */
      protected void setChessPieceColor(String pieceColor){
            piece.setChessPieceColor(pieceColor);
        }

}
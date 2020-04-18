/*
public class chess piece used mostly as a parent class 
posses  
*/
public class chessPiece {

    // call variables 
    private String pieceName;
    private String teamColor; 

    public chessPiece(){
        
    }

    // contructor for chess Piece 
    public chessPiece(String name,String team){
        this.pieceName = name;
        this.teamColor = team;
    }


    // **********************
    // ** accessor methods ** 
    // **********************

    // name of the chess piece on the tile 
    public String toStringPieceonTile(){
        return pieceName;
    }


    // color of the team 
    public String toStringPieceColor(){
        return teamColor;
    }
}




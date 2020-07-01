package chessPieces;

//**********importing libraries*************** 
import java.util.ArrayList;

public class Pawn extends chessPiece{

    // Class Variables
    ArrayList<int[]> possibleMoves;

    // constructors 
    public Pawn(String name,String teamColor){
        super(name, teamColor);
        possibleMoves = new ArrayList<int[]>(2);
    }


   
}
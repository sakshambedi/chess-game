package chessPieces;

// importing libraries 
import java.util.ArrayList;

public class pawn extends chessPiece{

    protected String name;
    protected String teamColour;
    private ArrayList<int[]> possibleMoves = new ArrayList<int[]>();

    // constructors 
    public pawn(String name,String teamString){
        this.name = name;
        this.teamColour = teamString;
    }

    // method that returns name of the piece 
    public String toStringName(){
        return name;
    } 
    
    
    // method that returs the name of the team
    public String toStringTeamName(){
        return teamColour;
    }

    // method to set chess piece
    public void setChessPiece(String name, String team){
        this.name = name;
        teamColour = team;
    }


    // method to make a arraylist of possible moves
    public ArrayList<int[]> possibleMove(int i,int j){
        int[] tempArray = {i+1,j+1};
        possibleMoves.add(tempArray);
        return possibleMoves;
    }
}
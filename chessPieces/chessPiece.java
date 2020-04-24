package chessPieces;

// ****** Importing libraries ****** 
// import java.util.ArrayList;

public class chessPiece {

    // private ArrayList<int[]> possibleMoves = new ArrayList<int[]>();
    protected String name;
    protected String teamColour;

    // dummy construtor 
    public chessPiece(){
        name ="empty";
        teamColour =null;
    }
                                            
    // Constructor 
    public chessPiece(String name, String teamColor){
        this.name = name;
        this.teamColour = teamColor;
    }


    // method that returns name of the piece 
    public String toStringName(){
        return name;
    }


    // method that returs the name of the team
    public String toStringTeamName(){
        return teamColour;
    }


}
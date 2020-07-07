package chessPieces;


public class Bishop extends chessPiece{

    protected String name;
    protected String teamColour;

    // constructors 
    public Bishop(String name,String teamString){
        super(name,teamString);
    }

    // method that returns name of the piece 
    public String toStringName(){
        return super.toStringName();
    } 
    
    
    // method that returs the name of the team
    public String toStringTeamName(){
        return super.toStringTeamName();
    }
}
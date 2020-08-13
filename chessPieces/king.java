package chessPieces;

public class King extends chessPiece{

    protected String name;
    protected String teamColour;

    // constructors 
    public King(String name,String teamString){
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



    /**
     * Purpose : Method to return an arraylist of unidirection of 
     *           pawns by giving the current position of the piece
     *           depending upon the colours of the chess piece 
     * 
     * @param i : X coordinates 
     * @param j : Y Coordintes 
     */
    /* public ArrayList<int[]> getPossibleMoves(int i,int j){
        int[] tempArray = new int[2];
        
        if (this.teamColour.equals("white"))    tempArray[0] = i+1;
        else   tempArray[0] = i-1;
        
        tempArray[1] = j;
        possibleMoves.add(tempArray);
        return possibleMoves;
    } */
}
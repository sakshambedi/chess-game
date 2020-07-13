/**
 * 
 * Dummy Class for chess Pieces  
 * 
 * 
 * 
*/

package chessPieces;


// ****** Importing libraries ****** 
import java.beans.ConstructorProperties;

public class chessPiece {

    protected String name;
    protected String teamColor;


    // dummy construtor 
    public chessPiece(){
        this.name = null;
        this.teamColor = null;
    }

    // Parameterized constructor
    @ConstructorProperties({"name","teamColor"})
    public chessPiece(String name, String teamColor ){
        this.name = name;
        this.teamColor = teamColor;
    }
         
    

    // setting the value of the chess Piece 
    public void setChessPiece(String name){
        this.name = name;
    }


    public void setChessPieceColor(String teamColor){
        this.teamColor = teamColor;
    }



    // public void removeChessPiece(){
    //     this.name = null;
    //     this.teamColor = null;
        
    // }


    // method that returns name of the piece 
    public String toStringName(){
        return name;
    }


    // method that returs the name of the team
    public String toStringTeamName(){
        return teamColor;
    }

}

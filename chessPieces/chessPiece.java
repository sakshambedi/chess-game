/**
 * 
 * Dummy Class for chess Pieces  
 * 
 * 
 * 
*/


package chessPieces;

import java.beans.ConstructorProperties;
// ****** Importing libraries ****** 
import java.util.ArrayList;
import java.util.Arrays;

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


    public void removeChessPiece(){
        this.name = null;
        this.teamColor = null;
        
    }


    // method that returns name of the piece 
    public String toStringName(){
        return name;
    }


    // method that returs the name of the team
    public String toStringTeamName(){
        return teamColor;
    }



    /**
     * Purpose : Dummy method to return an empty arraylist
     *           Returns null and does nothing
     *           
     *            
     * 
     * @param i : X coordinates 
     * @param j : Y Coordintes 
     */
    public ArrayList<int[]> getPossibleMoves(int i,int j){ return null; }
}
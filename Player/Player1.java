/**
 * Player1 Class 
 * Player class used to return
 ***/

package Player;

public class Player1 extends Player{
    
    //---------- Assigning variables -----------
    String Name;
    String teamName;
    

    // Constructor class 
    public Player1(){
        this.Name = "Player 1";
        this.teamName = "white";
    }


    // constructor with given name for Player 1 class 
    public void setPlayerName(String Name){
        this.Name = Name;
    }


    // method to return weapon 
    public String toStringTeam(){
        return teamName;
    }

    // method to return player name
    public String getPlayerName(){
        return Name;
    }

}
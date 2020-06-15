/*
@
Player Class
Player class would not do much 
mostly used as a dummy class 

Supports subclasses : Player 1 - white team 
                      Player 2 - black team 
@
 */
package Player;

public class Player{

    //---------- Assigning variables -----------
    String Name;
    String teamName;

    // Constructor class 
    public Player(){
        this.Name = null;
        this.teamName = null;
    }

    public void setPlayerName(String name){
        this.Name = name;
    }

    // method to return weapon 
    public String getPlayerName(){
        return null;
    }

    public String toStringTeam(){
        return null;
    }
}
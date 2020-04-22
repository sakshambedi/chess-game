    /*
@
Player1 Class
Player class used to return
@
 */

package Player;

public class Player1 extends Player{
    //---------- Assigning variables -----------
    String teamName;
    String Name = "";

    // Constructor class 
    public Player1(){
        teamName = "white";
        Name = "Player 1";
    }


    // constructor with given name for Player 1 class 
    public Player1(String Name){
        this.Name = Name;
        teamName = "white";
    }


    // method to return weapon 
    public String toStringTeam(){
        return teamName;
    }

    // method to return player name
    public String toStringName(){
        return Name;
    }

}
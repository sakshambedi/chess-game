    /*
@
Player2 Class
Player class used to return X as the weapon
@
 */
package Player;


public class Player2 extends Player{
    //---------- Assigning variables -----------
        String teamName;
        String Name = "";
    
        // Constructor class 
        public Player2(){
            teamName = "black";
            Name = "Player 2";
        }
    
    
        // constructor with given name for Player 2 class 
        public Player2(String Name){
            this.Name = Name;
            teamName = "black";
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
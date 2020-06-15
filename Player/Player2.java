/**
 *  Player2 Class
 *
 * 
 * 
*/
package Player;


public class Player2 extends Player{
    //---------- Assigning variables -----------
        String teamName;
        String Name = "";
    
        // Constructor class 
        public Player2(){
            this.teamName = "black";
            this.Name = "Player 2";
        }
    
    
        /**
         * Method to change player name
          */
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
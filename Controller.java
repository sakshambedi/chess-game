/*************************************************************
 **      public class controller to control the game        **
 **                                                         **
 **   Author : Saksham Bedi                                 **
 **   Github : sakshambedi                                  ** 
 ************************************************************/



// ********* Importing Libraries **************
// import java.util.Arrays;
import java.util.Arrays;
import java.util.Scanner;
import Player.*;


public class Controller extends Throwable{

    static final long serialVersionUID = 3387516923124222343L;
    private static int currentPlayerCount = 0 ;
    private static Player currentPlayer;
    private static Player player1;
    private static Player player2;
    // class objects 
    static Scanner scanInput = new Scanner(System.in);

   
    public Controller(){
        
    }

    
    /**
     *  Purpose : Main Method
     *  
     * @param args : String array of arguments
     *               args[0] is the name of the file
     *   */
    public static void main(String[] args){
        
        /**
         * Initializing everything
         */         
        GameBoard gb = new GameBoard();
        buildDefaultPlayers();
        
        // gb.initiateEachTile();

        if(askForNames()){
            initiateGamePlay();
        }
    }


    /**
     * Purpose : Ask for custom Names 
     * 
    */
    private static boolean askForNames(){
        System.out.print("Do you want to enter the name of the player (y/n) : ");
        String userResponse = scanInput.nextLine(); 

        if(userResponse.equals("yes") || userResponse.equals("y")){
            changePlayerNames();
            return true; 
        } else if(userResponse.equals("no") || userResponse.equals("n"))    return true;
        return askForNames();
    }




    /** 
     * 
     * Purpose : Initiate the game play 
     * 
     */
    private static void initiateGamePlay(){
        try{
            while(currentPlayerCount <= 5){
                int[][] coordinates =  askForInput();
                increasePlayerCount();
                switchPlayer();   
            }
        }catch(Exception exE){
            System.out.println(exE.getMessage());
            exE.printStackTrace();
        }
    }



    /**
     * Purpose : Make default player type objects 
     *    
     */
    private static void buildDefaultPlayers(){     
        player1 = new Player1();
        player2 = new Player2();
        currentPlayer = player1;
    } 



    /**  
     * Purpose : This method asks for player name and
     *
     */
    private static void changePlayerNames(){
       
        // asks for name of the white and the black players and makes player objects
        System.out.print("Enter the name of the player for white pieces : ");
        String playerName = scanInput.nextLine();
        player1.setPlayerName(playerName);

        System.out.print("Enter the name of the playes for black pieces : ");
        playerName = scanInput.nextLine();
        player2.setPlayerName(playerName);
        
    }


    /** 
    * Purpose :  method that asks for user input and then calls method to verify the 
    *            command entered by the user
    */
    public static int[][] askForInput(){
        System.out.print("Enter the command line for " + currentPlayer.getPlayerName() + ": ");
        String cmdEntered = scanInput.nextLine();
        String[] cmdEnteredArray = cmdEntered.split(" ");
        int[][]  arrayOfCoordinates = new int[2][1];

        // System.out.println(Arrays.toString(cmdEnteredArray));
        if(cmdEnteredArray.length==3){
            int[] tempIntArray = returnCoords(cmdEnteredArray[1]);
            System.out.println(Arrays.toString(tempIntArray));
            arrayOfCoordinates[0]  = tempIntArray;
            
            tempIntArray=returnCoords(cmdEnteredArray[2]);
            System.out.println(Arrays.toString(tempIntArray));
            arrayOfCoordinates[1] = tempIntArray;
            if(!thereIsNoNegativeValue(arrayOfCoordinates))    arrayOfCoordinates = askForInput();
        }
        else arrayOfCoordinates = askForInput();
        return arrayOfCoordinates;
    }
         



    /**
     * Purpose :  To check if there is no negative value in the given int array 
     * 
     * @param coordsArray : Array of coordinates
    */
    private static boolean thereIsNoNegativeValue(int[][] coordsArray){
        for(int[] row : coordsArray){
            for (int eachElement : row ){
                if (eachElement == -1)   return false;
            }
        }
        return true;
    }



    /** 
    * Purpose : method to turn chess language commands to eligible array commands 
    *  @param ChessCords : String piece containing a String value and a int value 
    *                      String reps x-axis in alphabets 
    *                      Int reps y-axis 
    */
    private static int[] returnCoords(String chessCoords) { 
        String xCoord = String.valueOf(chessCoords.charAt(0));
        String yCoord = String.valueOf(chessCoords.charAt(1));
        // System.out.println(xCoord + " " +yCoord);
        
        int[] Coords = {returnMapXIndex(xCoord),returnMapYIndex(yCoord)};

        return Coords;
    } 



    /** method to convert the commands to a array 
    * @param xpos : It is the String value of the string part of the position 
    *               tested with all cases and working until it is a string param
    */
    private static int returnMapXIndex(String xpos){
        // initiating variable
        String tempChar = String.valueOf(xpos.charAt(0));     
        
        if(tempChar.equals("a")) return 0;
        else if (tempChar.equals("b")) return 1;
        else if (tempChar.equals("c")) return 2;
        else if (tempChar.equals("d")) return 3;
        else if (tempChar.equals("e")) return 4;
        else if (tempChar.equals("f")) return 5;
        else if (tempChar.equals("g")) return 6;
        else if (tempChar.equals("h")) return 7;
        else    return -1;
    }


    /** method to convert the commands to a array 
    * @param ypos : It is the String value of the string part of the position 
    *               tested with all cases and working until it is a string param
    */
    private static int returnMapYIndex(String ypos){
        // initiating variable
        int tempInt = Integer.valueOf(ypos);

        if(tempInt>0 && tempInt<8) return 7-(tempInt-1);
        else    return -1;
    } 



    /**
     * Purpose : Increament the value of the currentPlayerCount int variable 
     * 
     **/
    private static void increasePlayerCount(){
        currentPlayerCount++;
    }


    /**
     * Purpose : To set the current player to alternative  
     *           only if the right statement is entered 
     *  
     * @param player1 : Player that owns the white pieces 
     * @param player2 : Player that owns the black pieces
     **/
    private static void switchPlayer(){
        if(currentPlayerCount%2==0 )    currentPlayer = player1;
        else    currentPlayer = player2;
    }



    /* method to check the value of y-axis is correct or not 
    *  @param - y-axis int value which  
    *
    */

    // private void makeMove(){

    // }

}

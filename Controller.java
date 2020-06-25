/*************************************************************
 **         Class controller to control the game            **
 **                                                         **
 **   Author : Saksham Bedi                                 **
 **   Github : sakshambedi                                  ** 
 ************************************************************/


// ********* Importing Libraries **************
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;
import Player.*;
import chessPieces.*;


public class Controller{

    static final long serialVersionUID = 3387516923124222343L;
    private static int currentPlayerCount = 0 ;
    private static Player currentPlayer;
    private static Player player1;
    private static Player player2;
    // class objects 
    static Scanner scanInput = new Scanner(System.in);
    static GameBoard gb = new GameBoard();

    /**
     * Purpose : Main Method
     * 
     * @param args : String array of arguments args[0] is the name of the file
     */
    public static void main(String[] args) {

        /**
         * Initializing everything
         */
        // GameBoard gb = new GameBoard();
        gb.printCLIchess();
        player1 = new Player1();
        player2 = new Player2();
        currentPlayer = player1;

        // gb.initiateEachTile();

        if(askForNames()){
            initiateGamePlay();
        }
    }



    /***
     * 
     * @return
     */
    private static void initiateGamePlay() {
        int[][] mapCoords = new int[2][1];
        while(currentPlayerCount <= 5){
            try{
                String[][] arrayOfCommands = askForInput();
                // makeMove(arrayofCommand);
                mapCoords[0] = Stream.of(arrayOfCommands[1]).mapToInt(Integer::parseInt).toArray();
                mapCoords[1] = Stream.of(arrayOfCommands[2]).mapToInt(Integer::parseInt).toArray();
                // for (int[] elements : mapCoords)    System.out.println(Arrays.toString(elements));

    
                if( (gb.getChessPieceName(mapCoords[0][0],mapCoords[0][1]).equals(arrayOfCommands[0][0])) && (!gb.ifChessPieceAt(mapCoords[1][0],mapCoords[1][1]) )){
                    System.out.println("Found the chess piece at : " + Arrays.toString(mapCoords[0])  );
                    makeMove(mapCoords);
                    increasePlayerCount();
                    switchPlayer();
                    // Arrays.deepToString(gb.getTileAt(mapCoords[1][0],mapCoords[1][1]).getMoves().toArray());
    
                }
            }catch(NumberFormatException numException){
                System.out.println("Enter the appropriate command for the game!");
            }        
        }
    }




    /**
     * Purpose : Ask for custom Names 
     *           Only accepts yes/y or No/n 
     *           Asks again for input if any error
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
    public static String[][] askForInput() throws  NumberFormatException{
        System.out.print("Enter the command line for " + currentPlayer.getPlayerName() + ": ");
        String cmdEntered = scanInput.nextLine();
        String[] cmdEnteredArray = cmdEntered.split(" ");
        String[][]  arrayOfCoordinates = new String[3][1];

        // System.out.println(Arrays.toString(cmdEnteredArray));
        if(cmdEnteredArray.length==3){
            arrayOfCoordinates[0][0] = cmdEnteredArray[0];

            String[] tempIntArray = returnCoords(cmdEnteredArray[1]);
            arrayOfCoordinates[1]  = tempIntArray;
            
            tempIntArray = returnCoords(cmdEnteredArray[2]);
            arrayOfCoordinates[2] = tempIntArray;

            // for(String[] element : arrayOfCoordinates)    System.out.println(Arrays.toString(element));
            if(!thereIsNoNegativeValue(arrayOfCoordinates))    arrayOfCoordinates = askForInput();
            
        }
        else arrayOfCoordinates = askForInput();
        return arrayOfCoordinates;
    }
         



    /**
     * Purpose :  To check if there is no negative value in the given int array 
     * 
     * @param coordsArray : Array of coordinates\
     * 
    */
    private static boolean thereIsNoNegativeValue(String[][] coordsArray){
        for(String[] row : coordsArray){
            for (String eachElement :  row){
                if (eachElement.equals("-1"))   return false;
            }
        }
        return true;
    }



    /** 
    * Purpose : method to turn chess language commands to eligible array commands 
    *  @param ChessCords : String piece containing a String value and a int value 
    *                      String reps x-axis in alphabets 
    *                      
    */
    private static String[] returnCoords(String chessCoords) { 
        String xCoord = String.valueOf(chessCoords.charAt(0));
        String yCoord = String.valueOf(chessCoords.charAt(1));
        // System.out.println(xCoord + " " +yCoord);
        
        String[] Coords = {String.valueOf(returnMapXIndex(yCoord)),String.valueOf(returnMapYIndex(xCoord))};

        return Coords;
    } 



    /** method to convert the commands to a array 
    * @param xpos : It is the String value of the string part of the position 
    *               tested with all cases and working until it is a string param
    */
    private static int returnMapYIndex(String ypos){
        // initiating variable
        String tempChar = String.valueOf(ypos.charAt(0));     
        
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
    private static int returnMapXIndex(String xpos){
        // initiating variable
        int tempInt = Integer.valueOf(xpos);

        if(tempInt>0 && tempInt<9) return 8-tempInt;
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



    /**
     *  Purpose : Make a move and  
     *  
     * @param  arrayOfCommands : 2d array of the initital position and final position for the piece   
     * 
     */
    private static void makeMove(int[][] arrayOfCommands){
        int i = arrayOfCommands[1][0];
        int j = arrayOfCommands[1][1];
        if(gb.getTileAt(i,j).getPieceName().equals("pawn"))    ;
        // System.out.println( Arrays.deepToString(gb.getTileAt(i,j).getMoves().toArray()) ) ;
        // else System.out.println("Explicit move request !");
    }

}

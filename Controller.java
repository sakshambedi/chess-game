/*
    public class controller to control the game 


*/
// ********* Importing Libraries **************
// import java.util.Arrays;
import java.util.Arrays;
import java.util.Scanner;
import Player.*;


public class Controller {

    // class objects 
    static Scanner scanInput = new Scanner(System.in);

   
    public Controller(){
        
    }
   
    // main method
    public static void main(String[] args){
        
        // making GameBoard object        
        GameBoard gb = new GameBoard();
        // gb.initiateEachTile();



        // importing gameboard array and storing it 
        // Tile[][] GameArray = gb.getBoard();


        // ask for player Name 
        askForPlayerName();
        // method to ask input]
        try{
            askForInput();
        }catch(extendedException exE){
            System.out.println(exE.getMessage());
            exE.printStackTrace();
        }
         
    }


    /* This method asks for player name and
    *
    */
    private static void askForPlayerName(){
        // assigning variables 
        String tempString;

        //asks if we want to see custom name of the player 
        System.out.print("Do you want to Enter the name of the player(y/n) : ");
        tempString = scanInput.nextLine();
    
        
        // if yes or y is entered 
        if (tempString.equals("yes") || tempString.equals("y")){
            // asks for name of the white and the black players and makes player objects
            System.out.print("Enter the name of the Player 1(white) : ");
            String playerName = scanInput.nextLine();
            Player player1 = new Player1(playerName);

            System.out.print("Enter the name of the Player 2(black) : ");
            playerName = scanInput.nextLine();
            Player player2 = new Player2(playerName);
        }else if (tempString.equals("no") || tempString.equals("n")) {
            // makes 2 player objects with default names 
            Player player1 = new Player1();
            Player player2 = new Player2();
        }else{
            System.out.println("Invalid Resonse");
        }

    }


    /* method that askes for user input and then calls method to verify the 
    ** command entered by the user
    */
    private static void askForInput() throws extendedException{
        System.out.print("Enter the command line : ");
        String cmdEntered = scanInput.nextLine();
        String[] cmdEnteredArray = cmdEntered.split(" ");
        int[]tempIntArray;

        if(cmdEnteredArray.length==3){
            System.out.println(Arrays.toString(tempIntArray=returnCoords(cmdEnteredArray[1])));
            System.out.println(Arrays.toString(tempIntArray=returnCoords(cmdEnteredArray[2])));
        }else throw new SyntaxLengthNotValid("\nInvalid Syntax !\n" + "Make sure the syntax contains the following :\n<piece name> <initial location of piece> <final position of piece>\n");
    }
         



    /** 
    * Purpose : method to turn chess language commands to eligble array commands 
    *  @param ChessCords : String piece containing a String value and a int value 
    *                      String reps x-axis in alphabets 
    *                      Int reps y-axis 
    */
    private static int[] returnCoords(String chessCoords) throws extendedException{ 
        // assigning variables 
        String xCoord = String.valueOf(chessCoords.charAt(0));
        String yCoord = String.valueOf(chessCoords.charAt(1));
        // int[] Coords;
        
        int[] Coords = {returnMapXIndex(xCoord),returnMapYIndex(yCoord)};

        // send this xCoords string to return Map index 
        return Coords;
    } 


    /* method to convert the commands to a array 
    * @param  pos is the String value of the string part of the position 
    * tested with all cases and working until it is a string param
    */
    private static int returnMapXIndex(String xpos)throws XAxisOutOfBoundException{
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
        else throw new XAxisOutOfBoundException("Invalid X-Axis !\nThe X-Axis value only exist between a to h.");
    }


    /* method to convert the commands to a array 
    * @param  pos is the String value of the string part of the position 
    * tested with all cases and working until it is a string param
    */
    private static int returnMapYIndex(String ypos) throws YAxisOutOfBoundException{
        // initiating variable
        int tempInt = Integer.valueOf(ypos.charAt(1));

        if(tempInt>0 || tempInt<8) return tempInt-1;
        else throw new YAxisOutOfBoundException("Invalid Y-Axis !\nThe Y-Axis value only exist between 1 to 8.");
        

    } 


    /* method to check the value of y-axis is correct or not 
    *  @param - y-axis int value which  
    *
    */

    // private void makeMove(){

    // }

}

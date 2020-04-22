/*
    public class controller to control the game 


*/
// ********* Importing Libraries **************
// import java.util.Arrays;
import java.util.Scanner;
import Player.*;


public class Controller {

    // class objects 
    static Scanner scanInput = new Scanner(System.in);

    // main method 
    public static void main(String[] args){
        // making GameBoard object
        GameBoard gb = new GameBoard();

        // importing gameboard array and storing it 
        // Tile[][] GameArray = gb.getBoard();

        // method to ask input
        // askForInput(); 

        // ask for player Name 
        askForPlayerName();


        // Controller control = new Controller();

    }

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
        }else {
            // makes 2 player objects with default names 
            Player player1 = new Player1();
            Player player2 = new Player2();
        }

    }


    //  method that askes for user input and then calls method to verify the 
    // command entered by the user 
    // private static void askForInput(){
    //     System.out.print("Enter the command line : ");
    //     String cmdEntered = scanInput.nextLine();
    //     String[] cmdEnteredArray = cmdEntered.split(" ");

    //     if (cmdEnteredArray.length==3) ;
    //     // else return extendedException.SyntaxLengthNotValid(); 


    /* method to convert the commands to a array 
    * @param  pos is the String value of the string part of the position 
    * tested with all cases and working until it is a string param
    */
    public int returnMapXIndex(String pos){
        // initiating variable
        String tempChar = String.valueOf(pos.charAt(0));     
        
        if(tempChar.equals("a")) return 0;
        else if (tempChar.equals("b")) return 1;
        else if (tempChar.equals("c")) return 2;
        else if (tempChar.equals("d")) return 3;
        else if (tempChar.equals("e")) return 4;
        else if (tempChar.equals("f")) return 5;
        else if (tempChar.equals("g")) return 6;
        else if (tempChar.equals("h")) return 7;
        else return 8;
    }

    // private void makeMove(){

    // }

}
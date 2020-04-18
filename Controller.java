/*
    public class controller to control the game 


*/
// ********* Importing Libraries **************
import java.util.Scanner;


public class Controller {

    // main method 
    public static void main(String[] args){
        // making GameBoard object
        GameBoard gb = new GameBoard();

        // importing gameboard array and storing it 
        Tile[][] GameArray = gb.getBoard();
        Pawn Pawn = new Pawn("pawn", "white");

        Scanner importInput = new Scanner(System.in); 
        int x =0;
        while(x!=5){
            System.out.print("Enter the move to mmake :");
            String enteredMove = importInput.next();

            String[] enteredDataIntoArray = enteredMove.split(" ");

            if((GameArray[Integer.valueOf(enteredDataIntoArray[1])][Integer.valueOf(enteredDataIntoArray[2])]).getPiece().equals("pawn")){
                Pawn.makeMove(enteredDataIntoArray[0],enteredDataIntoArray[1],enteredDataIntoArray[2],enteredDataIntoArray[3]);
            }
        }

    }
}
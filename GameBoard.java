/*
making a basic game board 
using tiles to store each tile
each tile should have the corresponding data : 
    x-axis : a-h;
    y-axis : 1-8; 
    chess piece : what chess piece it holds
    location : 
*/
public class GameBoard{

    // initialising variabls 
    public static Tile[][] gameBoard; 
    
    // create a default table
    public GameBoard(){
        gameBoard = new Tile[8][8];ss
        initiateEachTile();
    }


    // accessor method for GameBoard array 
    public Tile[][] getBoard(){
        return gameBoard;
    }

    // method that initialises each tile with values 
    // 
    private void initiateEachTile(){
        for(int row=0; row< 8; row++){
            for(int column = 0; column <8; column++ ){
                gameBoard[row][column] =  new Tile(row, column);
            }
        }
    }


    // main method for debugging 
    public static void main(String[] args){ 
        GameBoard gb = new GameBoard();
       // gb.initiateEachTile();
       Tile[][] gbarray = gb.getBoard();
       for(int i =0 ; i< gbarray.length; i++){
           for(int j = 0; j<gbarray[i].length; j++){
               System.out.println(gbarray[i][j].TileDetails());
           }
       } 
         
    }
    
    
}
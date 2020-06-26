
/********************************************************
 *                                                      *
 * making a basic game board                            *
 * using tiles to store each tile                       *
 * each tile should have the corresponding data :       * 
 * x-axis : a-h;                                        *
 * y-axis : 1-8;                                        *
 * chess piece : chese pieces at that tile              *
 *                                                      *
 ******************************************************** 
*/


// ---------------- importing libraries ------------
import chessPieces.*;

public class GameBoard{

    // initialising variabls 
    private Tile[][] boardArray; 
    

    /**
     * Purpose : create a 2d array 
     */
    public GameBoard(){ 
        boardArray = new Tile[8][8];
        initiateEachTile(); 
    }


    /**
     * Purpose :  accessor method for boardArray array
     **/ 
    public Tile[][] getBoard() {return boardArray;}


    /**
     * Purpose : method that initialises each tile with values 
     */
    public void initiateEachTile(){
        for(int row=0; row< 8; row++){
            for(int column = 0; column <8; column++ ) boardArray[row][column] =  new Tile(row, column);
        }
        initiateDefaultPosition();
    }



    /**
     * Purpose : load default chess piece at there correct position after each tile has been initiated with default values 
     */
    protected void initiateDefaultPosition(){
        // for white pawn pieces
        // later one for black pieces 
        for (int i=0; i<8; i++){boardArray[1][i].setChessPiece("pawn","black") ; 
                                boardArray[6][i].setChessPiece("pawn","white");}

        //************* placing white pieces first ***************

        // for rook 
        boardArray[7][0].setChessPiece("rook", "white");
        boardArray[7][7].setChessPiece("rook", "white");
    
        // for horse 
        boardArray[7][1].setChessPiece("horse", "white");
        boardArray[7][6].setChessPiece("horse", "white");

        // for bishop
        boardArray[7][2].setChessPiece("bishop", "white");
        boardArray[7][5].setChessPiece("bishop", "white");

        // queen
        boardArray[7][3].setChessPiece("queen", "white");
         
        // king 
        boardArray[7][4].setChessPiece("king", "white");


        // *********** placing black pieces now **************** 
         
        // for rook
        boardArray[0][0].setChessPiece("rook", "black");
        boardArray[0][7].setChessPiece("rook", "black");
        
        // for horses 
        boardArray[0][1].setChessPiece("horse", "black");
        boardArray[0][6].setChessPiece("horse", "black");

        // for bishop 
        boardArray[0][2].setChessPiece("bishop", "black");
        boardArray[0][5].setChessPiece("bishop", "black");

        // queen 
        boardArray[0][4].setChessPiece("queen", "black");
        
        // king 
        boardArray[0][3].setChessPiece("king", "black"); 
    }



    /** 
     * Purpose : To Check if the there is a chessPiece is there on the tile
     *
     * @param i : x axis of 2d Array
     * @param j : y axis of 2d Array
     *  
     */
    public boolean ifChessPieceAt(int i, int j){
        return boardArray[i][j].isPieceHere();
    }



    /**
     * Purpose : print 2d array chess in cli
     **/
    protected void printCLIchess(){
        for(int i = 0 ; i< boardArray.length; i++){ 
            for(int j = 0; j<boardArray[i].length; j++) {
                System.out.printf("[%6s]",boardArray[i][j].getPieceName());
            }
            System.out.println("");
        }
    }



    /** 
     * Purpose : Get the name of the chess piece at the given tile coords 
     * 
     * @param i : Int value of x-axis for 2d array
     * @param j : Int value of y-axis for 2d array 
     * 
     * @return Tile.getPieceName at the given indexes on the boardArray
     **/
    public String getChessPieceName(int i, int j){
        return boardArray[i][j].getPieceName();
    }



    /**
     * Purpose : To return chessPiece from the given tile 
     * 
     * 
     * @param i
     * @param j
     * @return chessPiece at the given indexes in the boardArray
     */
    public chessPiece getChessPieceAt(int i, int j){
        return boardArray[i][j].getPiece();
    }



    /**
     * Purpose : To return the tile at the given indexes 
     * 
     * @param row : row index of the 2d map 
     * @param column : column index of the 2d map
     * 
     * @return Tile : tile the given index in the boardArray 
      */
    protected Tile getTileAt(int row, int column){
        return boardArray[row][column];
    }


    /**  */
    // public void makeMove(int[] arrayOfCommands){

    // }



    // main method for debugging 
    // public static void main(String[] args){ 
    //     boardArray gb = new boardArray();
    //     gb.initiateEachTile();
    // //    Tile[][] gbarray = gb.getBoard();
    // //    for(int i =0 ; i< gbarray.length; i++){
    // //        for(int j = 0; j<gbarray[i].length; j++) System.out.println(gbarray[i][j].TileDetails());
    // //    } 
    //     gb.printCLIchess();     
    // }

}
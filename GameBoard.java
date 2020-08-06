
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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class GameBoard {

    // initialising variabls
    private Tile[][] boardArray;

    /**
     * Purpose : create a 2d array
     */
    public GameBoard() {
        boardArray = new Tile[8][8];
        initiateEachTile();
    }

    /**
     * Purpose : accessor method for boardArray array
     **/
    public Tile[][] getBoard() {
        return boardArray;
    }

    /**
     * Purpose : method that initialises each tile with values
     */
    public void initiateEachTile() {
        for (int row = 0; row < 8; row++) {
            for (int column = 0; column < 8; column++)
                boardArray[row][column] = new Tile(row, column);
        }
        initiateDefaultPosition();
    }

    /**
     * Purpose : Load default chess piece at there correct position after each tile
     * 			 has been initiated with default values
	 * 
	 * 
	 * @return void 
	 * 
     */
    protected void initiateDefaultPosition() {
        // for white pawn pieces
        // later one for black pieces
        for (int i = 0; i < 8; i++) {
            boardArray[1][i].setChessPiece("pawn", "black");
            boardArray[6][i].setChessPiece("pawn", "white");
        }

        // ************* placing white pieces first ***************

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
		
		// debugging
		// initialiseTestCase();
    }


	/**
	 * 
	 * Purpose : Test situations for debugging 
	 * 
	 * @return void 
	 * 
	  */
	//   private void initialiseTestCase(){
	// 	boardArray[4][4].setChessPiece("queen","white");
	// 	boardArray[1][4].setChessPiece("pawn","black");
    //     boardArray[5][4].setChessPiece("pawn","black");	
    //     boardArray[4][1].setChessPiece("pawn","black");	
    //     boardArray[4][6].setChessPiece("pawn","black");
    //     boardArray[2][6].setChessPiece("pawn","black");
    //     boardArray[7][6].setChessPiece("pawn","black");
    //     boardArray[0][0].setChessPiece("pawn","black");
    //     boardArray[5][3].setChessPiece("pawn","black");


	//   }


    /**
     * Purpose : To Check if the there is a chessPiece is there on the tile
     *
     * @param i : x axis of 2d Array
     * @param j : y axis of 2d Array
     * 
     */
    public boolean ifChessPieceAt(int i, int j) {
        return boardArray[i][j].isPieceHere();
    }



    /**
     * Purpose : print 2d array chess in cli
     **/
    protected void printCLIchess() {
        for (int i = 0; i < boardArray.length; i++) {
            for (int j = 0; j < boardArray[i].length; j++) {
                System.out.printf("[%6s]", boardArray[i][j].getPieceName());
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
    public String getChessPieceName(int i, int j) {
        return boardArray[i][j].getPieceName();
    }



    /**
     * Purpose : To return chessPiece from the given tile
     * 
     * 
     * @param i : X coord of the tile in the board array 
     * @param j : y coord of the tile in the board array
     * 
     * @return chessPiece at the given indexes in the boardArray
     * 
     */
    public chessPiece getChessPieceAt(int i, int j) {
        return boardArray[i][j].getPiece();
    }



    /**
     * Purpose : To return the tile at the given indexes
     * 
     * @param row    : row index of the 2d map
     * @param column : column index of the 2d map
     * 
     * @return Tile : tile the given index in the boardArray
     * 
     */
    protected Tile getTileAt(int row, int column) {
        return boardArray[row][column];
    }




    /**
     * Purpose : Method to call the specific method to return an ArrayList of
     * mossible moves
     * 
     * @param i : XCoord for the tile in the map
     * @param j : YCoord for the tile in the map
     * 
     * @return ArrayList of the possible moves.
     *           This returns array {-1,-1} for debugging.
     *           Also causes IndexOutOfBound exception if used to make move.
     * 
     */
    protected ArrayList<int[]> makeMove(int i, int j) {

        // int[] psuedoArray = {-1,-1};
        // ArrayList<int[]> psuedoList = new ArrayList<int[]>(
        //                                 Arrays.asList(psuedoArray));

        chessPiece pieceAtTheTile = boardArray[i][j].getPiece();
        String pieceColor = pieceAtTheTile.toStringTeamName();
        if (pieceAtTheTile instanceof Pawn)
            return calculateMovesForPawn(i, j, pieceColor);
        else if(pieceAtTheTile instanceof Rook)
            return calculateMovesForRook(i, j, pieceColor);
        else if(pieceAtTheTile instanceof Bishop)
            return calculateMovesForBishop(i, j, pieceColor);
        else if(pieceAtTheTile instanceof Queen)
            return calculateMovesForQueen(i, j, pieceColor);
        else if(pieceAtTheTile instanceof Horse)
            return calculateMovesForHorse(i, j, pieceColor);
        else
            return calculateMovesForKing(i, j, pieceColor);
    }



    /**
     * Purpose : Method to return an arraylist possible moves(Straight Moves and diagonal Attack) 
     *          of pawns by giving the current position 
     * 
     * @param i : X coordinates
     * @param j : Y Coordintes
     * 
     * @return possibleMoves : Arraylist of int array containing all the possible
     *         movable blocks for the chessPiece
     */
    private ArrayList<int[]> calculateMovesForPawn(int i, int j, String pawnColor){
        ArrayList<int[]> possibleMoves = new ArrayList<int[]>( );



        int[] moveArray = getPossibleMoveForPawn(i, j, pawnColor);
        if(moveArray[0]!=-1 && moveArray[1]!=-1)  possibleMoves.add(moveArray);

        
        int[][] attackList = getAttackMoveForPawn(i, j, pawnColor);
        
        for (int[] tempArray : attackList)
            if(tempArray[0]!=-1 && tempArray[1]!=-1)
                Collections.addAll(possibleMoves,tempArray);
        return possibleMoves;    
    }


    
    /** 
     * Purpose : To calculate the simple move of moving in uni-directionalw way 
     * 
     * @param i : X Coord location of the chess piece for the 2d Array
     * @param j : Y Coord location of the chess Piece for the 2d array
     * @param pawnColor : Color the pawn to represent the team
     * 
     * @return tempArray : array of the movible location for the pawn depending
     *                     upon the color
     * 
     */
    private int[] getPossibleMoveForPawn(int i , int j, String pawnColor ){
        int[] tempArray =  {-1,-1};
        
        if(pawnColor.equals("white")){
	    // making 2 steps at a time when at the default position
	    if (i==6 && !boardArray[i-2][j].isPieceHere()){
	    	tempArray[0] = i-2;
		tempArray[1] = j;
	    }
            if (!boardArray[i - 1][j].isPieceHere()) {
                tempArray[0] = i - 1;
                tempArray[1] = j;
            }
        }else{
	    if(i==1 && !boardArray[i+2][j].isPieceHere())
		tempArray[0] = i+2;
	   	tempArray[1] = j;
            if(!boardArray[i+1][j].isPieceHere()){   
                tempArray[0] = i + 1;
                tempArray[1] = j;
            }      
        }
        return tempArray;      
    }




     /**
     * Purpose : Method to return a 2d  array of attack mode for the pawn 
     * 
     * @param i :  X coord of the tile of the pawn
     * @param j : Y Coords of the tile of the pawn
     * @param pawnColor : String value of the color of the pawn
     * 
     * @return attackArray : 2dArray of the possible attack list  
     * 
    */
    private int[][] getAttackMoveForPawn(int i, int j, String pawnColor){
		int[][] attackList = {{-1,-1},
							{-1,-1}};

        if (pawnColor.equals("white")) {
            if( (j+1<=7) && (boardArray[i-1][j+1].isPieceHere() &&  !boardArray[i-1][j+1].getPieceColor().equals(pawnColor)) )
                attackList[0][0] = i-1;
                attackList[0][1] = j+1;    
            if((j-1>=0) && (boardArray[i-1][j-1].isPieceHere() &&  !boardArray[i-1][j-1].getPieceColor().equals(pawnColor)) )
                attackList[1][0] = i-1;
                attackList[1][1] = j-1;
        }else{
            if ((j+1<=7) && (boardArray[i+1][j+1].isPieceHere() &&  !boardArray[i+1][j+1].getPieceColor().equals(pawnColor)))
                attackList[0][0] = i+1;
                attackList[0][1] = j+1;
            if ((j-1>=0) && (boardArray[i+1][j-1].isPieceHere() &&  !boardArray[i+1][j-1].getPieceColor().equals(pawnColor)) )
                attackList[1][0] = i+1;
                attackList[1][1] = j-1;
        }
        return attackList;
    }




    /**
     * Purpose : To calculate moves for the rook.
	 * 			 Moves are the array location for possible moveable location for rook
	 * 
	 * @param i : x Coord of the piece 
	 * @param y : y Coord of the piece 
	 * @param rookColor :  Color of the rook at the tile in the boardArray
     * 
     * @return possibleMoves : ArrayList of int[] array 
     * 
      */
    public ArrayList<int[]> calculateMovesForRook(int i,int j,String rookColor){
			
		//assigning variables   
		ArrayList<int[]> possibleMoves = new ArrayList<int[]>(14);
        int[] tempArray = {-1,-1};

            // for going north
        int northIndex = i-1;
		while(northIndex>-1){
            /* need to make a new array every time so that if value of elements change anytime through
            out the loop all other values of the array in arraylist will also change the pointer */
            if(boardArray[northIndex][j].isPieceHere() && boardArray[northIndex][j].getPieceColor().equals(rookColor) )
                break;
            else if(boardArray[northIndex][j].isPieceHere() && !boardArray[northIndex][j].getPieceColor().equals(rookColor)){
                tempArray = new int[2];
                tempArray[0] = northIndex;
                tempArray[1] = j;
                northIndex--;
                possibleMoves.add(tempArray);
                break;
            }else{ 
                tempArray = new int[2];
                tempArray[0] = northIndex;
                tempArray[1] = j;
                northIndex--;
                possibleMoves.add(tempArray);
            }    
        }


            // for going south
        int southIndex = i+1;
        while(southIndex<8){
            /* need to make a new array every time so that if value of elements change anytime through
            out the loop all other values of the array in arraylist will also change the pointer */
            if(boardArray[southIndex][j].isPieceHere() && boardArray[southIndex][j].getPieceColor().equals(rookColor) )
                break;
            else if(boardArray[southIndex][j].isPieceHere() && !boardArray[southIndex][j].getPieceColor().equals(rookColor)){
                tempArray = new int[2];
                tempArray[0] = southIndex;
                tempArray[1] = j;
                southIndex++;
                possibleMoves.add(tempArray);
                break;
            }else{ 
                tempArray = new int[2];
                tempArray[0] = southIndex;
                tempArray[1] = j;
                southIndex++;
                possibleMoves.add(tempArray);
            }
        }


            // for going east
        int eastIndex = j+1;
        while(southIndex<8){
            /* need to make a new array every time so that if value of elements change anytime through
            out the loop all other values of the array in arraylist will also change the pointer */
            if(boardArray[i][eastIndex].isPieceHere() && boardArray[i][eastIndex].getPieceColor().equals(rookColor) )
                break;
            else if(boardArray[i][eastIndex].isPieceHere() && !boardArray[i][eastIndex].getPieceColor().equals(rookColor)){
                tempArray = new int[2];
                tempArray[0] = i;
                tempArray[1] = eastIndex;
                eastIndex++;
                possibleMoves.add(tempArray);
                break;
            }else{ 
                tempArray = new int[2];
                tempArray[0] = i;
                tempArray[1] = eastIndex;
                eastIndex++;
                possibleMoves.add(tempArray);
            }
        }


            // for going west 
        int westIndex = j-1;
        while(westIndex>-1){
            /* need to make a new array every time so that if value of elements change anytime through
            out the loop all other values of the array in arraylist will also change the pointer */
            if(boardArray[i][westIndex].isPieceHere() && boardArray[i][westIndex].getPieceColor().equals(rookColor) )
                break;
            else if(boardArray[i][westIndex].isPieceHere() && !boardArray[i][westIndex].getPieceColor().equals(rookColor)){
                tempArray = new int[2];
                tempArray[0] = i;
                tempArray[1] = westIndex;
                westIndex--;
                possibleMoves.add(tempArray);
                break;
            }else{ 
                tempArray = new int[2];
                tempArray[0] = i;
                tempArray[1] = westIndex;
                westIndex--;
                possibleMoves.add(tempArray);
            }
        }

        // printing the arrayList for debugging 
        // possibleMoves.forEach(printArray -> {
        //     System.out.print(Arrays.toString(printArray)); });
        return possibleMoves; 
    }




    /**
     * Purpose : Calculate the moves for the bishop
     * 
     * 
     * @param i : Xcoord position for the bishop
     * @param j : YCoord position for the bishop 
     * @param rookColor : Color of the bishop
     *
     * @return possibleMoves : ArrayList of arrays containg possible movible
     *                         array position of the bishop
     * 
     */
    protected ArrayList<int[]> calculateMovesForBishop(int i,int j,String rookColor){

        ArrayList<int[]> possibleMoves = new ArrayList<int[]>(14);
        int[] tempArray = {-1,-1};


        //for northeast
        int northIndex = i-1;
        int eastIndex = j+1;
		while(northIndex>-1 && eastIndex<8){
            /* need to make a new array every time so that if value of elements change anytime through
            out the loop all other values of the array in arraylist will also change the pointer */
            if(boardArray[northIndex][eastIndex].isPieceHere() && boardArray[northIndex][eastIndex].getPieceColor().equals(rookColor) )
                break;
            else if(boardArray[northIndex][eastIndex].isPieceHere() && !boardArray[northIndex][eastIndex].getPieceColor().equals(rookColor)){
                tempArray = new int[2];
                tempArray[0] = northIndex;
                tempArray[1] = eastIndex;
                northIndex--;
                eastIndex++;
                possibleMoves.add(tempArray);
                break;
            }else{ 
                tempArray = new int[2];
                tempArray[0] = northIndex;
                tempArray[1] = eastIndex;
                northIndex--;
                eastIndex++;
                possibleMoves.add(tempArray);
            }    
        }



       // for northwest
       northIndex = i-1;
       int westIndex  = j-1; 
       while(northIndex>-1 && westIndex>-1){
        /* need to make a new array every time so that if value of elements change anytime through
        out the loop all other values of the array in arraylist will also change the pointer */
            if(boardArray[northIndex][westIndex].isPieceHere() && boardArray[northIndex][westIndex].getPieceColor().equals(rookColor) )
                break;
            else if(boardArray[northIndex][westIndex].isPieceHere() && !boardArray[northIndex][westIndex].getPieceColor().equals(rookColor)){
                tempArray = new int[2];
                tempArray[0] = northIndex;
                tempArray[1] = westIndex;
                northIndex--;
                westIndex--;
                possibleMoves.add(tempArray);
                break;
            }else{ 
                tempArray = new int[2];
                tempArray[0] = northIndex;
                tempArray[1] = westIndex;
                northIndex--;
                westIndex--;
                possibleMoves.add(tempArray);
            }
        }  
        

        // for south East
        int southIndex = i+1;
        eastIndex  = j+1; 
        while(southIndex<8 && eastIndex<8){
         /* need to make a new array every time so that if value of elements change anytime through
         out the loop all other values of the array in arraylist will also change the pointer */
            if(boardArray[southIndex][eastIndex].isPieceHere() && boardArray[southIndex][eastIndex].getPieceColor().equals(rookColor) )
                break;
            else if(boardArray[southIndex][eastIndex].isPieceHere() && !boardArray[southIndex][eastIndex].getPieceColor().equals(rookColor)){
                tempArray = new int[2];
                tempArray[0] = southIndex;
                tempArray[1] = eastIndex;
                southIndex++;
                eastIndex++;
                possibleMoves.add(tempArray);
                break;
            }else{ 
                tempArray = new int[2];
                tempArray[0] = southIndex;
                tempArray[1] = eastIndex;
                southIndex++;
                eastIndex++;
                possibleMoves.add(tempArray);
            }
        }   
        

        // for south West
        southIndex = i+1;
        westIndex  = j-1; 
        while(southIndex<8 && westIndex>-1){
         /* need to make a new array every time so that if value of elements change anytime through
         out the loop all other values of the array in arraylist will also change the pointer */
            if(boardArray[southIndex][westIndex].isPieceHere() && boardArray[southIndex][westIndex].getPieceColor().equals(rookColor) )
                break;
            else if(boardArray[southIndex][westIndex].isPieceHere() && !boardArray[southIndex][westIndex].getPieceColor().equals(rookColor)){
                tempArray = new int[2];
                tempArray[0] = southIndex;
                tempArray[1] = westIndex;
                southIndex++;
                westIndex--;
                possibleMoves.add(tempArray);
                break;
            }else{ 
                tempArray = new int[2];
                tempArray[0] = southIndex;
                tempArray[1] = westIndex;
                southIndex++;
                westIndex--;
                possibleMoves.add(tempArray);
            } 
        }


        // possibleMoves.forEach(printArray -> {
        //     System.out.print(Arrays.toString(printArray)); });
        return possibleMoves;
    } 



    /**
     * Purpose : Calculate the moves for the bishop
     * @param i : Xcoord for the location of the horse 
     * @param j : YCorrd for the location of the horse 
     * @param horseColor : String value of the color of the horse
     * 
     * @return ArrayList of possible array location for the horse
     *  
     */
    protected ArrayList<int []> calculateMovesForHorse(int i, int j, String horseColor){
        ArrayList <int[]> possibleMoves = new ArrayList<int[]>(8); 
        if(j-2>-1 && i-1>-1 &&(boardArray[i-1][j-2].isPieceHere() || (boardArray[i-1][j-2].isPieceHere() && !boardArray[i-1][j-2].getPieceColor().equals(horseColor) )) ){
            int[] tempArray = {i-1, j-2};
            possibleMoves.add(tempArray);
        }
        if(j-2>-1 && i+1<8 &&(boardArray[i+1][j-2].isPieceHere() || (boardArray[i+1][j-2].isPieceHere() && !boardArray[i+1][j-2].getPieceColor().equals(horseColor) )) ){
            int[] tempArray = {i+1, j-2};
            possibleMoves.add(tempArray);
        }
        if(i-2>-1 && j-1>-1 &&(boardArray[i-2][j-1].isPieceHere() || (boardArray[i-2][j-1].isPieceHere() && !boardArray[i-2][j-1].getPieceColor().equals(horseColor) )) ){
            int[] tempArray = {i-1, j-1};
            possibleMoves.add(tempArray);
        }
        if(i-2>-1 && j+1<8 &&(boardArray[i-2][j+1].isPieceHere() || (boardArray[i-2][j+1].isPieceHere() && !boardArray[i-2][j+1].getPieceColor().equals(horseColor) )) ){
            int[] tempArray = {i-2, j+1};
            possibleMoves.add(tempArray);
        }
        if(j+2<8 && i-1>-1 &&(boardArray[i-1][j+2].isPieceHere() || (boardArray[i-1][j+2].isPieceHere() && !boardArray[i-1][j+2].getPieceColor().equals(horseColor) )) ){
            int[] tempArray = {i-1, j+2};
            possibleMoves.add(tempArray);
        }
        if(j+2<8 && i+1<8 &&(boardArray[i+1][j+2].isPieceHere() || (boardArray[i+1][j+2].isPieceHere() && !boardArray[i+1][j+2].getPieceColor().equals(horseColor) )) ){
            int[] tempArray = {i+1, j+2};
            possibleMoves.add(tempArray);
        }
        if(i+2<8 && j-1>-1 &&(boardArray[i+2][j-1].isPieceHere() || (boardArray[i+2][j-1].isPieceHere() && !boardArray[i+2][j-1].getPieceColor().equals(horseColor) )) ){
            int[] tempArray = {i+2, j-1};
            possibleMoves.add(tempArray);
        }
        if(i+2<8 && j+1<8 &&(boardArray[i+2][j+1].isPieceHere() || (boardArray[i+2][j+1].isPieceHere() && !boardArray[i+2][j+1].getPieceColor().equals(horseColor) )) ){
            int[] tempArray = {i+2, j+1};
            possibleMoves.add(tempArray);
        }
        
        return possibleMoves;
    }



    /**
     * Purpose : Calculate all the possible moves for the queen. 
     *           Basically queen moves the step of bishop and rook all together  
     * 
     * @param i : X coord of the queen 
     * @param j : y coord of the quwwn 
     * @param queenColor : Color of the piece of queen 
     * 
     * 
     * @return ArrayList of int array 
     * 
     */    
    protected ArrayList<int[]> calculateMovesForQueen(int i, int j , String queenColor ){
        ArrayList<int[]> possibleMoves = new ArrayList<int[]>();

        possibleMoves.addAll(calculateMovesForRook(i, j, queenColor));
        possibleMoves.addAll(calculateMovesForBishop(i, j, queenColor));
        return possibleMoves;
    }




    /**
     * Purpose : To calculate moves for the king on the chess Board 
     * 
     * @param i : X coordinate position of the king  
     * @param j : Y Coordinate position of the king 
     * @param kingColor : Color of the piece of the king 
     * 
     * @return Arraylist of int[] returning all the possible positions for the king to move  
     * 
     */
    protected ArrayList<int[]> calculateMovesForKing(int i, int j, String kingColor){
        ArrayList<int[]> possibleMoves = new ArrayList<int[]>();
        
        // adding moves for the N first because we the north
        int northIndex = i-1;
        if(northIndex>-1 && (boardArray[northIndex][j].isPieceHere() || (boardArray[northIndex][j].isPieceHere() && !boardArray[northIndex][j].getPieceColor().equals(kingColor)  ))){
            int[] tempArray = {northIndex,j};
            possibleMoves.add(tempArray);
        }

        int eastIndex = j+1; 
        if((northIndex>-1 && eastIndex<8) && (boardArray[northIndex][eastIndex].isPieceHere() || (boardArray[northIndex][eastIndex].isPieceHere() && !boardArray[northIndex][eastIndex].getPieceColor().equals(kingColor) ))){
            int[] tempArray = {northIndex,eastIndex};
            possibleMoves.add(tempArray);
        }

        int westIndex = j-1;
        if((northIndex>-1 && westIndex>-1) && (boardArray[northIndex][westIndex].isPieceHere() || (boardArray[northIndex][westIndex].isPieceHere() && !boardArray[northIndex][westIndex].getPieceColor().equals(kingColor) ))){
            int[] tempArray = {northIndex,westIndex};
            possibleMoves.add(tempArray);
        }


        // adding moves for south 
        int southIndex = i+1;
        if(southIndex<8 && (boardArray[southIndex][j].isPieceHere() || (boardArray[southIndex][j].isPieceHere() && !boardArray[southIndex][j].getPieceColor().equals(kingColor)  ))){
            int[] tempArray = {southIndex,j};
            possibleMoves.add(tempArray);
        }

        if((southIndex<8 && eastIndex<8) && (boardArray[southIndex][eastIndex].isPieceHere() || (boardArray[southIndex][eastIndex].isPieceHere() && !boardArray[southIndex][eastIndex].getPieceColor().equals(kingColor)  ))){
            int[] tempArray = {southIndex,eastIndex};
            possibleMoves.add(tempArray);
        }

        if((southIndex<8 && westIndex>-1) && (boardArray[southIndex][westIndex].isPieceHere() || (boardArray[southIndex][westIndex].isPieceHere() && !boardArray[southIndex][westIndex].getPieceColor().equals(kingColor)  ))){
            int[] tempArray = {southIndex,westIndex};
            possibleMoves.add(tempArray);
        }
        return possibleMoves;
    }

    /* main method for debugging  */
    /* public static void main(String[] args){ 
        GameBoard gb = new GameBoard();
       Tile[][] gbarray = gb.getBoard();
       for(int i =0 ; i< gbarray.length; i++){
           for(int j = 0; j<gbarray[i].length; j++) System.out.print(gbarray[i][j].TileDetails() + " ");
            System.out.println("");
        } 
        // gb.printCLIchess();     
    } */

}

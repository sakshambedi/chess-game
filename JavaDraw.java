/*
public class used to make basic chess board 
*/

// *********** importing libraries ****************
// import StdDraw;
import java.awt.Color;

public class JavaDraw {


    // class variables 
    private static int canvasLength = 750;
    
    // setting variables for colour theme 
    public static final Color BLACK = new Color(0,0,0); 
    public static final Color WHITE = new Color(255,255,255);
    public static final Color BLUE = new Color(1,166,172);
    
    // method to draw basic chess structure
    public void DrawBasicChess(){
        StdDraw.setCanvasSize(canvasLength, canvasLength);
        // StdDraw.setPenColor(BLACK);
        
        //  calling method to make the chess board on the canvas 
        drawSquares();
    }


    // Method to make the squares of the chess board 
    // set colours of corresponding chess pieces 
    //  white for even 
    // black for odd
    private void drawSquares(){
        // double boxLength = canvasLength/8; 
        StdDraw.setXscale(0,8);
        StdDraw.setYscale(0,8);
        for(int i=0 ; i<8 ; i++){
            for(int j=0; j<8;j++){
                if ((i+j)%2==0) StdDraw.setPenColor(WHITE);
                else StdDraw.setPenColor(BLUE);
                StdDraw.filledSquare(i+0.5, j+0.5, 0.5);
            }

            // calling method for making borders and displaying cooridinates
            makeBorders();
            displayCoordinates();
            StdDraw.show(0);
        }
    }



    // Method to make border lines for border of the chess Board 
    private void makeBorders(){
        StdDraw.setPenColor(BLACK);
        
        // ***** making lines *****
        // making vertical lines  
        StdDraw.line(0,0,8,0);
        StdDraw.line(0,8,8,8);

        // making horizontal lines 
        StdDraw.line(0,0,0,8);
        StdDraw.line(8,0,8,8);
        

        // placing test image 
        // placeTestImage();
    }


    private void displayCoordinates(){
        final String[] letterarray = { "a", "b", "c", "d", "e", "f", "g", "h" };
        final String[] numberarray = { "1", "2", "3", "4", "5", "6", "7", "8" };

        // for vertical letters
        for (int i = 0; i < 8; i++) {
            StdDraw.text(i + 0.5, -0.15, letterarray[i]);
        }

        // for horizontal numbers
        for (int j = 0; j < 8; j++) {
            StdDraw.text(-0.15, j + 0.5, numberarray[j]);
        }

    }

    public static void placePawns(int i,int j) {
        StdDraw.picture(i + 5, j + 0.5, "\\resources\\chess-pieces-images\\pawn-black.png", 0.4, 0.7);
    }

    // test method to place an image on the canvas
    private void placeTestImage() {
        StdDraw.picture(1.5, 0.5, "\\resources\\chess-pieces-images\\pawn-black.png", 0.4, 0.7);
    }

    public static void main(final String[] args) {
        
    }
}
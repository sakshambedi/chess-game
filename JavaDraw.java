/*
public class used to make basic chess board 
*/

// *********** importing libraries ****************
// import StdDraw;
import java.awt.Color;

public class JavaDraw {


    // class variables 
    private static int canvasLength = 750; 
    
    
    // method to draw basic chess structure
    public void DrawBasicChess(){
        StdDraw.setCanvasSize(canvasLength, canvasLength);
        StdDraw.setPenColor(new Color(0,0,0));
        drawSquares();
    }



    public void drawSquares(){
        // double boxLength = canvasLength/8; 
        StdDraw.setXscale(0,8);
        StdDraw.setYscale(0,8);
        for(int i=0 ; i<8 ; i++){
            for(int j=0; j<8;j++){
                if ((i+j)%2==0) StdDraw.setPenColor(new Color(255,255,255));
                else StdDraw.setPenColor(new Color(0,0,0));
                StdDraw.filledSquare(i+0.5, j+0.5, 0.5);
            }
        }
    }


    public static void main(String[] args){
        JavaDraw jd = new JavaDraw();


        // calling the basic draw structure 
        jd.DrawBasicChess();
    }
}
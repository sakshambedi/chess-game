/*
**   This method makes custom Exceptions 
**
*/

public class extendedException extends Exception{

    static final long serialVersionUID = -3387516923124222348L;
    static extendedException exdException = new extendedException();


    // calling the super method 
    // get away with using 
    public extendedException(){
        super();
    }

    // private methid to add ui stars 
    private String UIstars(){
        return "************************************";
    }

    // this is display all the exceptions 
    public static String SyntaxLengthNotValid(){
        return exdException.UIstars() + "\nInvalid Syntax \n" + "Make sure the syntax contains the following <piece name> <initial location of piece> <final position of piece>\n" + exdException.UIstars() ;
    }
    
}
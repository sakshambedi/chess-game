/*
*   This method makes custom Exceptions 
*   This class handles the following exception 
*   1.
*   
*/

public class extendedException extends Exception{

    static final long serialVersionUID = 3387516923124222348L;

    /* UnParamized Cunstructor 
    */
    public extendedException(){
        super();
    }

    /* Parametized constructor 
    * @param - String message 
    */
    public extendedException(String message){
        super(message);
    }   
}


// Exception for Syntax for missing statment
class SyntaxLengthNotValid extends extendedException{
    static final long serialVersionUID = 3387516923124222348L;

    /* UnParamized Cunstructor 
    */
        public SyntaxLengthNotValid(){
        super();
        }
        /* Parametized constructor 
        * @param - String message 
        */
        public SyntaxLengthNotValid(String message){
            super(message);
        }
}

// Exception for y axis
class YAxisOutOfBoundException extends extendedException{
    
    static final long serialVersionUID = 3387516923124222348L;

    /* UnParamized Cunstructor 
    */
    public YAxisOutOfBoundException(){
        super();
    }
    /* Parametized constructor 
    * @param - String message 
    */
    public YAxisOutOfBoundException(String message){
        super(message);
    }
}

// Exception for X axis 
class XAxisOutOfBoundException extends extendedException{
    static final long serialVersionUID = 3387516923124222348L;
    /* UnParamized Cunstructor 
    */
    public XAxisOutOfBoundException(){
        super();
    }
    /* Parametized constructor 
    * @param - String message 
    */
    public XAxisOutOfBoundException(String message){
        super(message);
    }
}
public class Exceptions {

}
class BookNotAvailable extends Exception{
    BookNotAvailable(String msg){
        super(msg);
    }
}
class InvalidReturnException extends RuntimeException{
    InvalidReturnException(String msg){
        super(msg);
    }
}
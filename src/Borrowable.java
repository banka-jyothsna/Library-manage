public interface Borrowable {
     void borrowItem(String userId) throws BookNotAvailable;
    void returnItem(String userId) throws InvalidReturnException;
}

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class LibraryClass extends LibraryItem implements Borrowable{

    public String author;

    LibraryClass(String id, String title, String author) {
        super(id, title);
        this.author=author;
    }


    public static void additem(Map<String,LibraryItem> hm,String bookid,LibraryItem l){
       hm.put(bookid,l);
    }

    @Override
    public void displayinfo() {
        System.out.println("Book ID: " + id);
        System.out.println("Title  : " + title);
        System.out.println("Author : " + author);
        System.out.println("Status : " + (isAvailable ? "Available" : "Borrowed"));
    }


    @Override
    public void borrowItem(String userId) throws BookNotAvailable{
        if (!isAvailable) {
            throw new BookNotAvailable("Book '" + title + "' is already borrowed!");
        }
        isAvailable = false;
        System.out.println(userId + " borrowed the book: " + title);
    }

    @Override
    public void returnItem(String userId) throws InvalidReturnException {
        if (isAvailable) {
            throw new InvalidReturnException("Book '" + title + "' was not borrowed!");
        }
        isAvailable = true;
        System.out.println(userId + " returned the book: " + title);
    }

}


abstract class LibraryItem {
    String id;
    String title;
    boolean isAvailable;
    LibraryItem(String id,String title){
        this.id=id;
        this.title=title;
        this.isAvailable=true;
    }
    public abstract void displayinfo();

}

import java.util.HashMap;
import java.util.Map;

public class Library {
    Map<String, LibraryItem> items = new HashMap<>();

    void addItem(LibraryItem item) {
        items.put(item.id, item);
    }

    LibraryItem findItemById(String id) {
        return items.get(id);
    }

    void displayAllAvailableItems() {
        System.out.println("Available Books....");
        for (LibraryItem item : items.values()) {
            if (item.isAvailable) {
                item.displayinfo();
                System.out.println("........");
            }
        }
    }
    void displayAllItems() {
        System.out.println("\nAll Books in Library....");
        for (LibraryItem item : items.values()) {
            item.displayinfo();
            System.out.println("----------------------");
        }
    }


}

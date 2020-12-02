import org.junit.jupiter.api.Test;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class ContactListTest {

    @Test
    public void addingTaskItemsIncreasesSize() {
        ContactList contacts = new ContactList();
        ContactItem item = new ContactItem("Bob", "Jones","123-456-7890","bobjones@gmail.com");
        contacts.add(item);
        assertEquals(1,contacts.size());
    }

    @Test
    public void editingItemsFailsWithAllBlankValues() {
        ContactList contacts = new ContactList();
        ContactItem item = new ContactItem("Bob", "Jones","123-456-7890","bobjones@gmail.com");
        contacts.add(item);
        assertThrows(ContactItem.EmptyException.class, () -> contacts.edit(new ContactItem("", "","",""), 0));
    }

    @Test
    public void editingItemsFailsWithInvalidIndex() {
        ContactList contacts = new ContactList();
        ContactItem item = new ContactItem("Bob", "Jones","123-456-7890","bobjones@gmail.com");
        contacts.add(item);
        ContactItem item2 = new ContactItem("John", "Hanks","345-333-2345","johnhanks@gmail.com");
        assertThrows(IndexOutOfBoundsException.class, () -> contacts.edit(item2, 1));
    }

    @Test
    public void editingSucceedsWithBlankFirstName() {
        ContactList contacts = new ContactList();
        ContactItem item = new ContactItem("Bob", "Jones","123-456-7890","bobjones@gmail.com");
        contacts.add(item);
        ContactItem item2 = new ContactItem("", "Hanks","345-333-2345","johnhanks@gmail.com");
        contacts.edit(item2, 0);
        assertEquals(contacts.get(0).getFirstName(),item2.getFirstName());
    }

    @Test
    public void editingSucceedsWithBlankLastName() {
        ContactList contacts = new ContactList();
        ContactItem item = new ContactItem("Bob", "Jones","123-456-7890","bobjones@gmail.com");
        contacts.add(item);
        ContactItem item2 = new ContactItem("John", "","345-333-2345","johnhanks@gmail.com");
        contacts.edit(item2, 0);
        assertEquals(contacts.get(0).getLastName(),item2.getLastName());
    }

    @Test
    public void editingSucceedsWithBlankPhone() {
        ContactList contacts = new ContactList();
        ContactItem item = new ContactItem("Bob", "Jones","123-456-7890","bobjones@gmail.com");
        contacts.add(item);
        ContactItem item2 = new ContactItem("John", "Hanks","","johnhanks@gmail.com");
        contacts.edit(item2, 0);
        assertEquals(contacts.get(0).getPhone(),item2.getPhone());
    }

    @Test
    public void editingSucceedsWithNonBlankValues(){
        ContactList contacts = new ContactList();
        ContactItem item = new ContactItem("Bob", "Jones","123-456-7890","bobjones@gmail.com");
        contacts.add(item);
        ContactItem item2 = new ContactItem("John", "Hanks","345-333-2345","johnhanks@gmail.com");
        contacts.edit(item2, 0);
        assertEquals(contacts.get(0),item2);
    }

    @Test
    public void newListIsEmpty(){
        ContactList contacts = new ContactList();
        assertEquals(contacts.size(),0);
    }

    @Test
    public void removingItemsDecreasesSize(){
        ContactList contacts = new ContactList();
        ContactItem item = new ContactItem("Bob", "Jones","123-456-7890","bobjones@gmail.com");
        contacts.add(item);
        ContactItem item2 = new ContactItem("John", "Hanks","345-333-2345","johnhanks@gmail.com");
        contacts.add(item2);
        contacts.remove(0);
        assertEquals(1,contacts.size());
    }

    @Test
    public void removingItemsFailsWithInvalidIndex(){
        ContactList contacts = new ContactList();
        ContactItem item = new ContactItem("Bob", "Jones","123-456-7890","bobjones@gmail.com");
        contacts.add(item);
        ContactItem item2 = new ContactItem("John", "Hanks","345-333-2345","johnhanks@gmail.com");
        contacts.add(item2);
        assertThrows(IndexOutOfBoundsException.class, () -> contacts.remove(3));
    }

    @Test
    public void savedContactListCanBeLoaded(){
        ContactList contacts = new ContactList();
        ContactItem item = new ContactItem("Bob", "Jones","123-456-7890","bobjones@gmail.com");
        contacts.add(item);
        ContactItem item2 = new ContactItem("John", "Hanks","345-333-2345","johnhanks@gmail.com");
        contacts.add(item2);
        contacts.write("file.txt");
        ContactList contacts2 = new ContactList();
        contacts2.open("file.txt",contacts2);

        assertEquals(contacts2.get(0).getFirstName(),contacts.get(0).getFirstName());
        assertEquals(contacts2.get(0).getLastName(),contacts.get(0).getLastName());
        assertEquals(contacts2.get(0).getPhone(),contacts.get(0).getPhone());
        assertEquals(contacts2.get(0).getEmail(),contacts.get(0).getEmail());
    }



}

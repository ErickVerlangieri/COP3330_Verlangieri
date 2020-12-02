import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactItemTest {

    @Test
    public void creationFailsWithAllBlankValues(){
        assertThrows(ContactItem.EmptyException.class, () -> new ContactItem("", "","",""));
    }

    @Test
    public void creationSucceedsWithBlankEmail(){
        assertDoesNotThrow(() -> new ContactItem("Bob", "Jones","123-456-7890",""));
    }

    @Test
    public void creationSucceedsWithBlankFirstName(){
        assertDoesNotThrow(() -> new ContactItem("", "Jones","123-456-7890","jones@gmail.com"));
    }

    @Test
    public void creationSucceedsWithBlankLastName(){
        assertDoesNotThrow(() -> new ContactItem("Bob", "","123-456-7890","jones@gmail.com"));
    }

    @Test
    public void creationSucceedsWithBlankPhone(){
        assertDoesNotThrow(() -> new ContactItem("Bob", "Jones","","jones@gmail.com"));
    }

    @Test
    public void creationSucceedsWithNonBlankValues(){
        assertDoesNotThrow(() -> new ContactItem("Bob", "Jones","123-456-7890","jones@gmail.com"));
    }

    @Test
    public void editingFailsWithAllBlankValues(){
        ContactList contacts = new ContactList();
        ContactItem item = new ContactItem("Bob", "Jones","123-456-7890","jones@gmail.com");
        contacts.add(item);
        assertThrows(ContactItem.EmptyException.class, () -> contacts.edit(new ContactItem("", "","",""), 0));
    }

    @Test
    public void editingSucceedsWithBlankEmail(){
        ContactList contacts = new ContactList();
        ContactItem item = new ContactItem("Bob", "Jones","123-456-7890","jones@gmail.com");
        contacts.add(item);
        assertDoesNotThrow(() -> contacts.edit(new ContactItem("Bob", "Jones","123-456-7890",""), 0));
    }

    @Test
    public void editingSucceedsWithBlankFirstName(){
        ContactList contacts = new ContactList();
        ContactItem item = new ContactItem("Bob", "Jones","123-456-7890","jones@gmail.com");
        contacts.add(item);
        assertDoesNotThrow(() -> contacts.edit(new ContactItem("", "Hanks","333-444-1233","hanks@gmail.com"), 0));
    }

    @Test
    public void editingSucceedsWithBlankLastName(){
        ContactList contacts = new ContactList();
        ContactItem item = new ContactItem("Bob", "Jones","123-456-7890","jones@gmail.com");
        contacts.add(item);
        assertDoesNotThrow(() -> contacts.edit(new ContactItem("John", "","333-444-1233","john@gmail.com"), 0));
    }

    @Test
    public void editingSucceedsWithBlankPhone(){
        ContactList contacts = new ContactList();
        ContactItem item = new ContactItem("Bob", "Jones","123-456-7890","jones@gmail.com");
        contacts.add(item);
        assertDoesNotThrow(() -> contacts.edit(new ContactItem("John", "Hanks","","hanks@gmail.com"), 0));
    }

    @Test
    public void editingSucceedsWithNonBlankValues(){
        ContactList contacts = new ContactList();
        ContactItem item = new ContactItem("Bob", "Jones","123-456-7890","jones@gmail.com");
        contacts.add(item);
        assertDoesNotThrow(() -> contacts.edit(new ContactItem("John", "Hanks","345-333-2345","johnhanks@gmail.com"), 0));
    }

    @Test
    public void testToString(){
        ContactItem item = new ContactItem("Bob", "Jones","123-456-7890","jones@gmail.com");
        assertEquals("Bob",item.getFirstName());
        assertEquals("Jones",item.getLastName());
        assertEquals("123-456-7890",item.getPhone());
        assertEquals("jones@gmail.com",item.getEmail());
    }
}
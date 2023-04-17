import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ContactTest {
    private Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");

    @Test
    public void testGetContactID() {
        assertEquals("1234567890", contact.getContactID());
    }

    @Test
    public void testGetFirstName() {
        assertEquals("John", contact.getFirstName());
    }

    @Test
    public void testGetLastName() {
        assertEquals("Doe", contact.getLastName());
    }

    @Test
    public void testGetPhone() {
        assertEquals("1234567890", contact.getPhone());
    }

    @Test
    public void testGetAddress() {
        assertEquals("123 Main St", contact.getAddress());
    }

    @Test
    public void testSetFirstName() {
        contact.setFirstName("Jane");
        assertEquals("Jane", contact.getFirstName());
    }

    @Test
    public void testSetLastName() {
        contact.setLastName("Smith");
        assertEquals("Smith", contact.getLastName());
    }

    @Test
    public void testSetPhone() {
        contact.setPhone("2345678901");
        assertEquals("2345678901", contact.getPhone());
    }

    @Test
    public void testSetAddress() {
        contact.setAddress("456 Elm St");
        assertEquals("456 Elm St", contact.getAddress());
    }
}

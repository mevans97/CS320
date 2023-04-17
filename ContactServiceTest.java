import static org.junit.jupiter.api.Assertions.*;

public class ContactServiceTest {

	@BeforeEach
	public void setUp() {
        contactService = new ContactService();
        Contact contact1 = new Contact("1234567890", "Michael", "Evans", "1234567890", "123 Main St");
        Contact contact2 = new Contact("2345678901", "Prisila", "Godoi", "2345678901", "456 Elm St");
        contactService.addContact(contact1);
        contactService.addContact(contact2);
	}
	
	@Test
    public void testAddContact() {
        Contact contact = new Contact("3456789012", "Reggie", "Evans", "3456789012", "789 Oak St");
        contactService.addContact(contact);
        assertEquals(contact, contactService.findContact("3456789012"));
    }
    @Test
    public void testFindContact() {
        Contact contact = ContactService.findContact("1234567890");
        assertEquals("Michael", contact.getFirstName());
        assertEquals("Evans", contact.getLastName());
        assertEquals("1234567890", contact.getPhone());
        assertEquals("123 Main St", contact.getAddress());
    }
    @Test
    public void testDeleteContact() {
        contactService.deleteContact("1234567890");
        assertNull(contactService.findContact("1234567890"));
        assertEquals(1, contactService.getContacts().size());
    }
    @Test
    public void testUpdateContact() {
        Contact updatedContact = new Contact("1234567890", "Reggie", "Evans", "1111111111", "321 Maple St");
        contactService.updateContact(updatedContact);
        assertEquals("Reggie", contactService.findContact("1234567890").getFirstName());
        assertEquals("Evans", contactService.findContact("1234567890").getLastName());
        assertEquals("1111111111", contactService.findContact("1234567890").getPhone());
        assertEquals("321 Maple St", contactService.findContact("1234567890").getAddress());
    }

}

public class ContactService {
    private Contact[] contacts;
    private int numContacts;

    public ContactService() {
        contacts = new Contact[100];
        numContacts = 0;
    }

    public void addContact(Contact contact) {
        if (findContact(contact.getContactID()) != null) {
            throw new IllegalArgumentException("Contact with ID " + contact.getContactID() + " already exists.");
        }
        if (numContacts >= contacts.length) {
            throw new IllegalStateException("Contact array is full.");
        }
        contacts[numContacts++] = contact;
    }

    public void deleteContact(String contactID) {
        int index = findContactIndex(contactID);
        if (index < 0) {
            throw new IllegalArgumentException("Contact with ID " + contactID + " does not exist.");
        }
        for (int i = index; i < numContacts - 1; i++) {
            contacts[i] = contacts[i + 1];
        }
        numContacts--;
    }

    public void updateContact(String contactID, String firstName, String lastName, String phone, String address) {
        Contact contact = findContact(contactID);
        if (contact == null) {
            throw new IllegalArgumentException("Contact with ID " + contactID + " does not exist.");
        }
        if (firstName != null) {
            contact.setFirstName(firstName);
        }
        if (lastName != null) {
            contact.setLastName(lastName);
        }
        if (phone != null) {
            contact.setPhone(phone);
        }
        if (address != null) {
            contact.setAddress(address);
        }
    }

    public Contact findContact(String contactID) {
        for (int i = 0; i < numContacts; i++) {
            if (contacts[i].getContactID().equals(contactID)) {
                return contacts[i];
            }
        }
        return null;
    }

    private int findContactIndex(String contactID) {
        for (int i = 0; i < numContacts; i++) {
            if (contacts[i].getContactID().equals(contactID)) {
                return i;
            }
        }
        return -1;
    }
}

package phone;

import java.util.ArrayList;

class MobilePhone {

    private static ArrayList<Contacts> phoneBook = new ArrayList<>();

    void listAllContacts() {
        int index = 0;
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\nContacts list:");
        for (Contacts contact :
                phoneBook) {
            System.out.println("Contact " + (index + 1) + ": " + contact.getContactName() + " (" + contact.getPhoneNumber() + ")");
            index++;
        }
        if (phoneBook.isEmpty()) {
            System.out.println("Contacts list is empty!");
        }
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }

    static Contacts createContact(String name, String phoneNumber) {
        return new Contacts(name, phoneNumber);
    }

    void addContactToList(Contacts contact) {
        phoneBook.add(contact);
    }

    Contacts findContactByName(String name) {
        for (Contacts foundContact : phoneBook) {
            if (foundContact.getContactName().equals(name)) {
                System.out.println("Contact " + foundContact.getContactName() + " (" + foundContact.getPhoneNumber() + ") found!" +
                        " at position " + (phoneBook.indexOf(foundContact) + 1));
                return foundContact;
            }
        }
        System.out.println("Contact " + Main.capitilizeFirstLetter(name) + " not found!");
        return null;
    }

    private Contacts findContactByNameWithoutPrintOut(String name) {
        for (Contacts foundContact : phoneBook) {
            if (foundContact.getContactName().equals(name)) {
                return foundContact;
            }
        }
        return null;
    }

    void removeEntry(String name) {
        Contacts contactToRemove = findContactByNameWithoutPrintOut(name);
        if (contactToRemove != null) {
            phoneBook.remove(contactToRemove);
            System.out.println("Contact removed successfully!\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        } else {
            System.out.println("Contact cannot be found!\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        }
    }

    void updateEntry(String oldName, String newName, String newNumber) {
        Contacts contactToUpdate = findContactByNameWithoutPrintOut(oldName);
        if (contactToUpdate != null) {
            contactToUpdate.setContactName(newName);
            contactToUpdate.setPhoneNumber(newNumber);
        } else {
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        }
    }

    void updateEntry(String oldName, String newName) {
        Contacts contactToUpdate = findContactByNameWithoutPrintOut(oldName);
        if (contactToUpdate != null) {
            contactToUpdate.setContactName(newName);
        } else {
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        }
    }
}

//TODO addContact method - add functionality that checks if contact already exists in phoneBook and the not add it (maybe boolean method)
//TODO updateEntry - add functionality that checks if newName of updating contact exists in list and then not allow to update it

package phone;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static MobilePhone phone = new MobilePhone();


    public static void main(String[] args) {

        boolean isTimeToCloseProgram = false;
        printInstructions();
        while (!isTimeToCloseProgram) {
            try {
                int choice = scanner.nextInt();
                scanner.nextLine();
                userChoice(choice);
                if (choice == 7) {
                    isTimeToCloseProgram = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("ERROR! ONLY INTEGERS ALLOWED!");
                scanner.next();
            }
        }
    }

    private static void userChoice(int choice) {
        switch (choice) {
            case 1:
                printInstructions();
                break;
            case 2:
                printContacts();
                break;
            case 3:
                addContact();
                break;
            case 4:
                updateContact();
                break;
            case 5:
                findContact();
                break;
            case 6:
                removeContact();
                break;
            case 7:
                scanner.close();
                break;

            default:
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n" +
                        "Please give an appropriate number (1-7)" +
                        "\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ ");
        }
    }

    private static void printInstructions() {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\nHere are following instructions You can use: ");
        System.out.println("1 - Print instructions.");
        System.out.println("2 - Print list of contacts.");
        System.out.println("3 - Add new contact.");
        System.out.println("4 - Update existing contact.");
        System.out.println("5 - Find specific contact.");
        System.out.println("6 - Remove contact.");
        System.out.println("7 - Close program.\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }

    private static void printContacts() {
        phone.listAllContacts();
    }

    private static void addContact() {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\nCreating a new contact...\nType a name:");
        String name = scanner.nextLine();
        name = capitilizeFirstLetter(name);
        System.out.println("Type a phone number");
        String number = scanner.nextLine();
        phone.addContactToList(MobilePhone.createContact(name, number));
        System.out.println("Contact created and added successfully!\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }

    private static void updateContact() {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\nType name of contact You want to update");
        String oldName = scanner.nextLine();
        oldName = capitilizeFirstLetter(oldName);
        if (phone.findContactByName(oldName) != null) {
            System.out.println("Type new name:");
            String newName = scanner.nextLine();
            newName = capitilizeFirstLetter(newName);
            System.out.println("Type new number or leave previous:");
            String newNumber = scanner.nextLine();
            if (newNumber.equals("")) {
                phone.updateEntry(oldName, newName);
            } else {
                phone.updateEntry(oldName, newName, newNumber);
            }
            System.out.println("Contact updated successfully!\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        }
    }

    private static void findContact() {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\nType name of contact You want to find");
        String nametoFind = scanner.nextLine();
        nametoFind = capitilizeFirstLetter(nametoFind);
        phone.findContactByName(nametoFind);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }

    private static void removeContact() {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\nType name of contact You want to remove");
        String nameToRemove = scanner.nextLine();
        nameToRemove = capitilizeFirstLetter(nameToRemove);
        phone.removeEntry(nameToRemove);
    }

    static String capitilizeFirstLetter(String input) {
        return input.substring(0, 1).toUpperCase() + input.substring(1);
        //method that returns input String with capital first letter e.g. "Bird" instead of "bird"
    }
}


import java.util.Scanner;

public class ConsoleUI {
    private Scanner input;
    private boolean isValidOption;
    private ContactBook contactBook;

    public ConsoleUI(){
        this.input = new Scanner(System.in);
        this.isValidOption = true;
        this.contactBook = new ContactBook();
    }

    public void start(){
        this.showMainMenu();
    }

    private void showMainMenu(){
        this.clear();

        System.out.println("-- MAIN MENU --");
        System.out.println("\n");
        System.out.println("[1] View contacts");
        System.out.println("[2] Add contact");
        System.out.println("[3] Modify contact");
        System.out.println("[4] Delete contact");
        System.out.println("\n");
        System.out.println("[e] Exit");
        System.out.println("\n");

        this.validateMainMenuOption();
    }

    private void viewContactsMenu(){
        this.clear();

        System.out.println("-- CONTACTS MENU --");
        System.out.println("\n");

        for(int i = 1; i <= this.contactBook.getContacts().size(); i++){
            System.out.println("[" + i + "] " + this.contactBook.getContacts().get(i - 1).getName() + " " + this.contactBook.getContacts().get(i - 1).getLastname() + " " + this.contactBook.getContacts().get(i - 1).getPhoneNumber());
        }

        System.out.println("\n");
        System.out.println("[m] Main menu");
        System.out.println("[e] Exit");
        System.out.println("\n");

        this.validateMenuOption();
    }

    private void addContactMenu(){
        this.clear();

        System.out.println("-- ADD CONTACT MENU --");
        System.out.println("\n");

        System.out.print("Insert name: ");
        String name = this.input.nextLine();

        System.out.print("Insert lastname: ");
        String lastname = this.input.nextLine();

        System.out.print("Insert phone number: ");
        String phoneNumber = this.input.nextLine();

        this.contactBook.addContact(name, lastname, phoneNumber);

        System.out.println("\n");
        System.out.println("The contact was saved.");
        System.out.println("\n");

        System.out.println("[m] Main menu");
        System.out.println("[e] Exit");
        System.out.println("\n");

        this.validateMenuOption();
    }

    private void modifyContactMenu(){
        this.clear();

        System.out.println("-- MODIFY CONTACT MENU --");
        System.out.println("\n");

        for(int i = 1; i <= this.contactBook.getContacts().size(); i++){
            System.out.println("[" + i + "] " + this.contactBook.getContacts().get(i - 1).getName() + " " + this.contactBook.getContacts().get(i - 1).getLastname() + " " + this.contactBook.getContacts().get(i - 1).getPhoneNumber());
        }

        System.out.println("\n");
        System.out.print("Insert the ID of the contact to modify: ");
        int contactID = Integer.parseInt(this.input.nextLine()) - 1;
        System.out.println("\n");

        for(int i = 0; i <= this.contactBook.getContacts().size(); i++){
            if(i == contactID){
                System.out.println(this.contactBook.getContacts().get(i).getName() + " " + this.contactBook.getContacts().get(i).getLastname() + " " + this.contactBook.getContacts().get(i).getPhoneNumber());
            }
        }

        System.out.println("\n");
        System.out.print("Insert new name: ");
        String name = this.input.nextLine();

        System.out.print("Insert new lastname: ");
        String lastname = this.input.nextLine();

        System.out.print("Insert new phone number: ");
        String phoneNumber = this.input.nextLine();

        this.contactBook.modifyContact(contactID, name, lastname, phoneNumber);

        System.out.println("\n");
        System.out.print("The contact was modified.");

        System.out.println("\n");
        System.out.println("[m] Main menu");
        System.out.println("[e] Exit");
        System.out.println("\n");

        this.validateMenuOption();
    }

    private void deleteContactMenu(){
        this.clear();

        System.out.println("-- DELETE CONTACT MENU --");
        System.out.println("\n");

        for(int i = 1; i <= this.contactBook.getContacts().size(); i++){
            System.out.println("[" + i + "] " + this.contactBook.getContacts().get(i - 1).getName() + " " + this.contactBook.getContacts().get(i - 1).getLastname() + " " + this.contactBook.getContacts().get(i - 1).getPhoneNumber());
        }

        System.out.println("\n");
        System.out.print("Insert the ID of the contact to delete: ");

        int contactID = Integer.parseInt(this.input.nextLine()) - 1;

        this.contactBook.deleteContact(contactID);

        System.out.println("\n");
        System.out.print("The contact was deleted.");

        System.out.println("\n");
        System.out.println("[m] Main menu");
        System.out.println("[e] Exit");
        System.out.println("\n");

        this.validateMenuOption();
    }

    private void validateMainMenuOption(){
        if(isValidOption){
            System.out.print("Select an option: ");
        }
        else{
            System.out.print("Select a valid option: ");
            isValidOption = true;
        }

        String option = this.input.nextLine();

        switch (option){
            case "1":
                this.viewContactsMenu();
                break;
            case "2":
                this.addContactMenu();
                break;
            case "3":
                this.modifyContactMenu();
                break;
            case "4":
                this.deleteContactMenu();
                break;
            case "e":
                System.exit(0);
            default:
                isValidOption = false;
                this.validateMainMenuOption();
        }
    }

    private void validateMenuOption(){
        if(isValidOption){
            System.out.print("Select an option: ");
        }
        else{
            System.out.print("Select a valid option: ");
            isValidOption = true;
        }

        String option = this.input.nextLine();

        switch (option){
            case "m":
                this.showMainMenu();
                break;
            case "e":
                System.exit(0);
            default:
                isValidOption = false;
                this.validateMenuOption();
        }
    }

    private void clear(){
        for(int i = 0; i < 1000; i++)
        {
            System.out.println("\b") ;
        }
    }
}

import java.util.Scanner;

public class ContactApp {

    private static Scanner in = new Scanner(System.in);
    private static Scanner in2 = new Scanner(System.in);
    public App m = new App();
    public ContactList contacts = new ContactList();
    private String command;

    void processContactList(){
        while(!askMainMenu().equals("3")){
            if(command.equals("1")){
                contacts = new ContactList();
                System.out.println("new contact list has been created");
                while(!askContactCommands().equals("6")){

                    if(command.equals("1")) {
                        viewList();
                    }
                    else if(command.equals("2")) {
                        ContactItem data = getContactData();
                        storeContactData(data);
                    }
                    else if(command.equals("3")) {
                        viewList();
                        System.out.print("\nWhich contact will you edit? ");
                        int index = in2.nextInt();
                        try{
                            contacts.edit(editContactData(index), index);
                        }
                        catch (IndexOutOfBoundsException e){
                            System.out.println("Out of bounds...");
                        }

                    }
                    else if(command.equals("4")) {
                        viewList();
                        System.out.print("\nWhich contact will you remove? ");
                        int index = in2.nextInt();
                        try{
                            contacts.remove(index);
                        }
                        catch (IndexOutOfBoundsException e){
                            System.out.println("Out of bounds...");
                        }

                    }
                    else if(command.equals("5")) {
                        writeContactItem();
                        System.out.println("contact list has been saved");
                    }
                    else{
                        System.out.println("Not a valid command, try again.");
                    }
                }
                processContactList();

            }
            if(command.equals("2")){
                contacts = new ContactList();
                openContactItem(contacts);
                System.out.println("new contact list has been created");

                while(!askContactCommands().equals("6")){

                    if(command.equals("1")) {
                        viewList();
                    }
                    else if(command.equals("2")) {
                        ContactItem data = getContactData();
                        storeContactData(data);
                    }
                    else if(command.equals("3")) {
                        viewList();
                        System.out.print("\nWhich contact will you edit? ");
                        int index = in2.nextInt();
                        try{
                            contacts.edit(editContactData(index), index);
                        }
                        catch (IndexOutOfBoundsException e){
                            System.out.println("Out of bounds...");
                        }
                    }
                    else if(command.equals("4")) {
                        viewList();
                        System.out.print("\nWhich contact will you remove? ");
                        int index = in2.nextInt();
                        try{
                            contacts.remove(index);
                        }
                        catch (IndexOutOfBoundsException e){
                            System.out.println("Out of bounds...");
                        }
                    }
                    else if(command.equals("5")) {
                        writeContactItem();
                        System.out.println("contact list has been saved");
                    }
                    else{
                        System.out.println("Not a valid command, try again.");
                    }

                }
                processContactList();

            }
            else
                m.processProgram();

        }

    }

    private void writeContactItem(){
        System.out.print("Enter the filename to save as: ");
        contacts.write(in.nextLine());
    }

    private void openContactItem(ContactList data){
        System.out.print("Enter the filename to load: ");
        contacts.open(in.nextLine(), data);
    }

    private void storeContactData(ContactItem data){
        contacts.add(data);
    }

    private void viewList(){
        System.out.println("Current Contacts\n-------------\n");
        contacts.view();
    }

    private ContactItem getContactData(){
        ContactItem data = null;
        while(true){
            try{

                String firstName = getFirstName();
                String lastName = getLastName();
                String phone = getPhone();
                String email = getEmail();

                data = new ContactItem(firstName, lastName, phone, email);
                break;
            }
            catch(ContactItem.EmptyException ex){
                System.out.println("A contact item shall contain at least one of [first name], [last name], [phone number], or [email address]!");
            }
            /*
            catch(ContactItem.InvalidPhoneException ex){
                System.out.println("WARNING: phone must be in (xxx-xxx-xxxx) format!");
            }
            catch(ContactItem.InvalidEmailException ex){
                System.out.println("WARNING: email must be in x@y.z format!");
            }
             */


        }
        return data;
    }

    private ContactItem editContactData(int value){
        ContactItem data = null;
        while(true){
            String firstName = getEditFirstName(value);
            String lastName = getEditLastName(value);
            String phone = getEditPhone(value);
            String email = getEditEmail(value);

            data = new ContactItem(firstName, lastName, phone, email);
            break;
        }
        return data;
    }

    private String getFirstName() {
        System.out.print("First name: ");
        return in.nextLine();
    }

    private String getLastName() {
        System.out.print("Last name: ");
        return in.nextLine();
    }

    private String getPhone() {
        System.out.print("Phone number (xxx-xxx-xxxx): ");
        return in.nextLine();
    }

    private String getEmail() {
        System.out.print("Email address (x@y.z): ");
        return in.nextLine();
    }

    private String getEditFirstName(int index) {
        System.out.print("Enter a new first name for contact " + index + ": ");
        return in.nextLine();
    }

    private String getEditLastName(int index) {
        System.out.print("Enter a new last name for contact " + index + ": ");
        return in.nextLine();
    }

    private String getEditPhone(int index) {
        System.out.print("Enter a new phone number (xxx-xxx-xxxx) for contact " + index + ": ");
        return in.nextLine();
    }

    private String getEditEmail(int index) {
        System.out.print("Enter a new email address (x@y.z) for contact " + index + ": ");
        return in.nextLine();
    }

    private String askContactCommands(){
        System.out.print("\nList Operation Menu\n---------\n\n1) view the list\n2) add an item\n3) edit an item\n4) remove an item\n5) save the current list\n6) quit to the main menu\n\n>");
        command = in.nextLine();
        return command;
    }

    private String askMainMenu(){
        System.out.print("Main Menu\n---------\n\n1) create a new list\n2) load an existing list\n3) quit\n\n>");
        command = in.nextLine();
        return command;
    }
}
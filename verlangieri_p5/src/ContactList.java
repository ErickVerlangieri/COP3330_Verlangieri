import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;
import java.io.File;
import java.util.Scanner;

public class ContactList {

    List<ContactItem> contacts;

    public ContactList(){
        contacts = new ArrayList<>();
    }

    public void add(ContactItem data){
        contacts.add(data);
    }

    public ContactItem get(int index){
        return contacts.get(index);
    }

    public int size(){
        return contacts.size();
    }

    public void view(){
        for(int i = 0; i < contacts.size(); i++){
            System.out.println(i + ") Name: " + contacts.get(i).getFirstName() + " " + contacts.get(i).getLastName() + "\nPhone: " + contacts.get(i).getPhone() + "\nEmail: " + contacts.get(i).getEmail() + "\n");
        }
    }

    public void edit(ContactItem data, int index){
        if(data.getFirstName().equals("") && data.getLastName().equals("") && data.getPhone().equals("") && data.getEmail().equals("")){
            throw new ContactList.EmptyException("A contact item shall contain at least one of [first name], [last name], [phone number], or [email address]!");
        }
        else{
            contacts.set(index, data);
        }
    }

    public void remove(int index){
        contacts.remove(index);
    }

    public void open(String filename, ContactList t){
        try{
            File read = new File(filename);
            Scanner myReader = new Scanner(read);
            ContactItem value = null;
            String firstName, lastName, phone, email;

            while(myReader.hasNextLine()){
                firstName = myReader.nextLine();
                lastName = myReader.nextLine();
                phone = myReader.nextLine();
                email = myReader.nextLine();
                value = new ContactItem(firstName, lastName, phone, email);
                t.add(value);
            }
            myReader.close();

        } catch (FileNotFoundException e) {
            System.out.println("Unable to find the file...");
            System.exit(0);
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

    public void write(String filename){
        try(Formatter output = new Formatter(filename)){
            for(int i = 0; i < contacts.size(); i++){
                output.format(contacts.get(i).getFirstName() + "\n" + contacts.get(i).getLastName() + "\n" + contacts.get(i).getPhone() + "\n" + contacts.get(i).getEmail() + "\n");
            }
        } catch (FileNotFoundException e) {
            System.out.println("Unable to find the file...");
            System.exit(0);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    class EmptyException extends IllegalArgumentException{
        public EmptyException(String msg){
            super(msg);
        }
    }
}
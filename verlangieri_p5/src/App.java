import java.util.Scanner;
public class App {

    private static Scanner in = new Scanner(System.in);
    private String command;

    public void processProgram(){
        while(!askApplication().equals("3")){
            if(command.equals("1")){
                TaskApp t = new TaskApp();
                t.processTaskList();
            }
            else if(command.equals("2")){
                ContactApp c = new ContactApp();
                c.processContactList();
            }
            else{
                System.out.println("Not a valid command, try again!");
            }
        }
        System.exit(0);
    }

    private String askApplication(){
        System.out.print("Select Your Application\n---------\n\n1) task list\n2) contact list\n3) quit\n\n>");
        command = in.nextLine();
        return command;
    }

    public static void main(String[]args){
        App m = new App();
        m.processProgram();
    }

}

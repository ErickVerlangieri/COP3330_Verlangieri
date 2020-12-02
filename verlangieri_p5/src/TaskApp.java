import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Scanner;

public class TaskApp {

    private static Scanner in = new Scanner(System.in);
    private static Scanner in2 = new Scanner(System.in);
    public App m = new App();
    public TaskList tasks = new TaskList();
    private String command;

    void processTaskList(){
        while(!askMainMenu().equals("3")){
            if(command.equals("1")){
                tasks = new TaskList();
                System.out.println("new task list has been created");
                while(!askTaskCommands().equals("8")){

                    if(command.equals("1")) {
                        viewList();
                    }
                    else if(command.equals("2")) {
                        int value = 0;
                        TaskItem data = getTaskData(value);
                        storeTaskData(data);
                    }
                    else if(command.equals("3")) {
                        int value = 0;
                        viewList();
                        System.out.print("\nWhich task will you edit? ");
                        int index = in2.nextInt();
                        try{
                            tasks.edit(editTaskData(index, value), index);
                        }
                        catch (IndexOutOfBoundsException e){
                            System.out.println("Out of bounds...");
                        }

                    }
                    else if(command.equals("4")) {
                        viewList();
                        System.out.print("\nWhich task will you remove? ");
                        int index = in2.nextInt();
                        try{
                            tasks.remove(index);
                        }
                        catch (IndexOutOfBoundsException e){
                            System.out.println("Out of bounds...");
                        }

                    }
                    else if(command.equals("5")) {
                        int value = 1;
                        viewUncompletedList();
                        System.out.print("\nWhich task will you mark as completed? ");
                        int index = in2.nextInt();
                        try{
                            tasks.edit(editMarked(index, value), index);
                        }
                        catch (IndexOutOfBoundsException e){
                            System.out.println("Out of bounds...");
                        }
                    }
                    else if(command.equals("6")) {
                        int value = 0;
                        viewCompletedList();
                        System.out.print("\nWhich task will you unmark as completed? ");
                        int index = in2.nextInt();
                        try{
                            tasks.edit(editMarked(index, value), index);
                        }
                        catch (IndexOutOfBoundsException e){
                            System.out.println("Out of bounds...");
                        }

                    }
                    else if(command.equals("7")) {
                        writeTaskItem();
                        System.out.println("task list has been saved");
                    }
                    else{
                        System.out.println("Not a valid command, try again.");
                    }
                }
                processTaskList();

            }
            if(command.equals("2")){
                tasks = new TaskList();
                openTaskItem(tasks);
                System.out.println("task list has been loaded");

                while(!askTaskCommands().equals("8")){

                    if(command.equals("1")) {
                        viewList();
                    }
                    else if(command.equals("2")) {
                        int value = 0;
                        TaskItem data = getTaskData(value);
                        storeTaskData(data);
                    }
                    else if(command.equals("3")) {
                        int value = 0;
                        viewList();
                        System.out.print("\nWhich task will you edit? ");
                        int index = in2.nextInt();
                        try{
                            tasks.edit(editTaskData(index, value), index);
                        }
                        catch (IndexOutOfBoundsException e){
                            System.out.println("Out of bounds...");
                        }
                    }
                    else if(command.equals("4")) {
                        viewList();
                        System.out.print("\nWhich task will you remove? ");
                        int index = in2.nextInt();
                        try{
                            tasks.remove(index);
                        }
                        catch (IndexOutOfBoundsException e){
                            System.out.println("Out of bounds...");
                        }
                    }
                    else if(command.equals("5")) {
                        int value = 1;
                        viewUncompletedList();
                        System.out.print("\nWhich task will you mark as completed? ");
                        int index = in2.nextInt();
                        try{
                            tasks.edit(editMarked(index, value), index);
                        }
                        catch (IndexOutOfBoundsException e){
                            System.out.println("Out of bounds...");
                        }
                    }
                    else if(command.equals("6")) {
                        int value = 0;
                        viewCompletedList();
                        System.out.print("\nWhich task will you mark as completed? ");
                        int index = in2.nextInt();
                        try{
                            tasks.edit(editMarked(index, value), index);
                        }
                        catch (IndexOutOfBoundsException e){
                            System.out.println("Out of bounds...");
                        }

                    }
                    else if(command.equals("7")) {
                        writeTaskItem();
                        System.out.println("task list has been saved");
                    }
                    else{
                        System.out.println("Not a valid command, try again.");
                    }

                }

            }
            else
                m.processProgram();

        }

    }


    private void writeTaskItem(){
        System.out.print("Enter the filename to save as: ");
        tasks.write(in.nextLine());
    }

    private void openTaskItem(TaskList data){
        System.out.print("Enter the filename to load: ");
        tasks.open(in.nextLine(), data);
    }

    private void storeTaskData(TaskItem data){
        tasks.add(data);
    }

    private void viewList(){
        System.out.println("Current Tasks\n-------------\n");
        tasks.view();
    }

    private void viewCompletedList(){
        System.out.println("Completed Tasks\n-------------\n");
        tasks.completedList();
    }

    private void viewUncompletedList(){
        System.out.println("Uncompleted Tasks\n-------------\n");
        tasks.uncompletedList();
    }


    private TaskItem getTaskData(int value){
        TaskItem data = null;
        while(true){
            try{
                String marked = getMarked(value);
                String title = getTitle();
                String description = getDescription();
                String date = getDate();

                data = new TaskItem(marked, title, description, date);
                break;
            }
            catch(TaskItem.InvalidTitleException ex){
                System.out.println("WARNING: title must be at least 1 character long; task not created");
            }
            catch(TaskItem.InvalidDateException ex){
                System.out.println("WARNING: invalid due date; task not created");
            }
        }
        return data;
    }

    private TaskItem editTaskData(int index, int value){
        TaskItem data = null;
        while(true){
            try{
                String marked = getMarked(value);
                String title = getEditTitle(index);
                String description = getEditDescription(index);
                String date = getEditDate(index);

                data = new TaskItem(marked, title, description, date);
                break;
            }
            catch(TaskItem.InvalidTitleException ex){
                System.out.println("WARNING: title must be at least 1 character long; task not created");
            }
            catch(TaskItem.InvalidDateException ex){
                System.out.println("WARNING: invalid due date; task not created");
            }
        }
        return data;
    }

    private TaskItem editMarked(int index, int value){
        TaskItem data = null;
        while(true){
            try{

                String marked = getMarked(value);
                String title = tasks.get(index).getTitle();
                String description = tasks.get(index).getDescription();
                String date = tasks.get(index).getDate();

                data = new TaskItem(marked, title, description, date);
                break;
            }
            catch(TaskItem.InvalidTitleException ex){
                System.out.println("WARNING: title must be at least 1 character long; task not created");
            }
            catch(TaskItem.InvalidDateException ex){
                System.out.println("WARNING: invalid due date; task not created");
            }
        }
        return data;
    }

    private String getMarked(int value) {
        if(value == 1){
            return "***";
        }
        return "";
    }

    private String getTitle() {
        System.out.print("Task title: ");
        return in.nextLine();
    }

    private String getDescription() {
        System.out.print("Task description: ");
        return in.nextLine();
    }

    private String getDate() {
        System.out.print("Task due date (YYYY-MM-DD): ");
        return in.nextLine();
    }

    private String getEditTitle(int index) {
        System.out.print("Enter a new title for task " + index + ": ");
        return in.nextLine();
    }

    private String getEditDescription(int index) {
        System.out.print("Enter a new description for task " + index + ": ");
        return in.nextLine();
    }

    private String getEditDate(int index) {
        System.out.print("Task due date (YYYY-MM-DD) for task " + index + ": ");
        return in.nextLine();
    }

    private String askMainMenu(){
        System.out.print("Main Menu\n---------\n\n1) create a new list\n2) load an existing list\n3) quit\n\n>");
        command = in.nextLine();
        return command;
    }

    private String askTaskCommands(){
        System.out.print("\nList Operation Menu\n---------\n\n1) view the list\n2) add an item\n3) edit an item\n4) remove an item\n5) mark an item as completed\n6) unmark an item as completed\n7) save the current list\n8) quit to the main menu\n\n>");
        command = in.nextLine();
        return command;
    }
}
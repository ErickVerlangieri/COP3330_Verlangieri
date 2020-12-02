import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;
import java.io.File;
import java.util.Scanner;

public class TaskList {

    List<TaskItem> tasks;

    public TaskList(){
        tasks = new ArrayList<>();
    }

    public void add(TaskItem data){
        tasks.add(data);
    }

    public TaskItem get(int index){
        return tasks.get(index);
    }

    public void view(){
        for(int i = 0; i < tasks.size(); i++){
            if(tasks.get(i).getMarked().equals("***"))
                System.out.println(i + ") " + tasks.get(i).getMarked() + " [" + tasks.get(i).getDate() + "] " + tasks.get(i).getTitle() + ": " + tasks.get(i).getDescription());
            else
                System.out.println(i + ")" + tasks.get(i).getMarked() + " [" + tasks.get(i).getDate() + "] " + tasks.get(i).getTitle() + ": " + tasks.get(i).getDescription());
        }
    }

    public void completedList(){
        for(int i = 0; i < tasks.size(); i++){
            if(tasks.get(i).getMarked().equals("***"))
                System.out.println(i + ") " + tasks.get(i).getMarked() + " [" + tasks.get(i).getDate() + "] " + tasks.get(i).getTitle() + ": " + tasks.get(i).getDescription());
        }
    }

    public void uncompletedList(){
        for(int i = 0; i < tasks.size(); i++){
            if(tasks.get(i).getMarked().equals(""))
                System.out.println(i + ")" + tasks.get(i).getMarked() + " [" + tasks.get(i).getDate() + "] " + tasks.get(i).getTitle() + ": " + tasks.get(i).getDescription());
        }
    }

    public void edit(TaskItem data, int index){
        tasks.set(index, data);
    }

    public void remove(int index){
        tasks.remove(index);
    }

    public int size(){
        return tasks.size();
    }

    public void open(String filename, TaskList t){
        try{
            File read = new File(filename);
            Scanner myReader = new Scanner(read);
            TaskItem value = null;
            String marked, title, description, date;

            while(myReader.hasNextLine()){
                String data = myReader.nextLine();

                if(data.charAt(3) == '*')
                    marked = data.substring(data.indexOf(")") + 2, data.indexOf("[") - 1);
                else
                    marked = data.substring(data.indexOf(")") + 1, data.indexOf(" "));


                date = data.substring(data.indexOf("[") + 1, data.indexOf("]"));
                title = data.substring(data.indexOf("]") + 2, data.indexOf(":"));
                description = data.substring(data.indexOf(":") + 2);
                value = new TaskItem(marked, title, description, date);
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
            for(int i = 0; i < tasks.size(); i++){
                if(tasks.get(i).getMarked() == "***")
                    output.format(i + ") " + tasks.get(i).getMarked() + " [" + tasks.get(i).getDate() + "] " + tasks.get(i).getTitle() + ": " + tasks.get(i).getDescription() + "\n");
                else
                    output.format(i + ")" + tasks.get(i).getMarked() + " [" + tasks.get(i).getDate() + "] " + tasks.get(i).getTitle() + ": " + tasks.get(i).getDescription() + "\n");
            }
        } catch (FileNotFoundException e) {
            System.out.println("Unable to find the file...");
            System.exit(0);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
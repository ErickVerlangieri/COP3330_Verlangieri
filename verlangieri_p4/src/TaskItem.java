public class TaskItem {

    private String marked;
    private String title;
    private String description;
    private String date;

    public TaskItem(String marked, String title, String description, String date){

        this.marked = marked;

        setTitle(title);

        this.description = description;

        setDate(date);

    }

    public void setTitle(String title){

        if(isTitleValid(title)){
            this.title = title;
        }
        else{
            throw new InvalidTitleException("WARNING: title must be at least 1 character long; task not created");
        }

    }

    public void setDate(String date){

        if(isDateValid(date)){
            this.date = date;
        }
        else{
            throw new InvalidDateException("WARNING: invalid due date; task not created");
        }

    }

    private boolean isTitleValid(String title){
        return title.length() > 0;
    }

    private boolean isDateValid(String date){
        return (date.length() == 10 && date.charAt(4) == ('-') && date.charAt(7) == ('-'));
    }

    public String getMarked(){
        return this.marked;
    }

    public String getTitle(){
        return this.title;
    }

    public String getDescription(){
        return this.description;
    }

    public String getDate(){
        return this.date;
    }

    public

    class InvalidTitleException extends IllegalArgumentException{
        public InvalidTitleException(String msg){
            super(msg);
        }
    }

    class InvalidDateException extends IllegalArgumentException{
        public InvalidDateException(String msg){
            super(msg);
        }
    }
}

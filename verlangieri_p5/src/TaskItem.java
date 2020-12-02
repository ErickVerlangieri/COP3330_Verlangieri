public class TaskItem {

    private String marked;
    private String title;
    private String description;
    private String date;

    public TaskItem(String marked, String title, String description, String date){
        verifyIfEmpty(title, description, date);
        setMarked(marked);
        setTitle(title);
        setDescription(description);
        setDate(date);
    }

    private void verifyIfEmpty(String title, String description, String date) {

        if(title == null && description == null && date == null){
            throw new TaskItem.EmptyException("A task list shall contain 1 or more task items!");
        }

    }

    public void setMarked(String marked){
        this.marked = marked;
    }

    public void setTitle(String title){

        if(isTitleValid(title)){
            this.title = title;
        }
        else{
            throw new InvalidTitleException("WARNING: title must be at least 1 character long; task not created");
        }

    }

    public void setDescription(String description){
        this.description = description;
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
        return marked;
    }

    public String getTitle(){
        return title;
    }

    public String getDescription(){
        return description;
    }

    public String getDate(){
        return date;
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

    class EmptyException extends IllegalArgumentException{
        public EmptyException(String msg){
            super(msg);
        }
    }
}

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TaskItemTest {

    @Test
    public void constructorFailsWithInvalidDueDate() {
        assertThrows(TaskItem.InvalidDateException.class, () -> new TaskItem("", "Task1","First Task",""));
    }

    @Test
    public void constructorFailsWithInvalidTitle() {
        assertThrows(TaskItem.InvalidTitleException.class, () -> new TaskItem("", "","First Task","2000-04-04"));
    }

    @Test
    public void constructorSucceedsWithValidDueDate() {
        assertDoesNotThrow(() -> new TaskItem("", "Task1","First Task","2000-04-04"));
    }

    @Test
    public void constructorSucceedsWithValidTitle() {
        assertDoesNotThrow(() -> new TaskItem("", "Task2","First Task","2000-04-04"));
    }

    @Test
    public void editingDueDateFailsWithInvalidDateFormat() {
        TaskItem item = new TaskItem("", "Task1","First Task","2000-04-04");
        assertThrows(TaskItem.InvalidDateException.class, () -> item.setDate(""));
    }

    @Test
    public void editingDueDateFailsWithInvalidYYYMMDD() {
        TaskItem item = new TaskItem("", "Task1","First Task","2000-04-04");
        assertThrows(TaskItem.InvalidDateException.class, () -> item.setDate("20000404"));
    }

    @Test
    public void editingDueDateSucceedsWithExpectedValue() {
        TaskItem item = new TaskItem("", "Task1","First Task","2000-04-04");
        assertDoesNotThrow(() -> item.setDate("2000-04-04"));
    }

    @Test
    public void editingTitleFailsWithEmptyString() {
        TaskItem item = new TaskItem("", "Task1","First Task","2000-04-04");
        assertThrows(TaskItem.InvalidTitleException.class, () -> item.setTitle(""));
    }

    @Test
    public void editingTitleSucceedsWithExpectedValue() {
        TaskItem item = new TaskItem("", "Task1","First Task","2000-04-04");
        assertDoesNotThrow(() -> item.setTitle("Task1"));
    }
}
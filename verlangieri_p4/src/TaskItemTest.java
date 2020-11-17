import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TaskItemTest {

    @Test
    public void creatingTaskItemFailsWithInvalidDueDate() {
        assertThrows(TaskItem.InvalidDateException.class, () -> new TaskItem("", "Task1","First Task",""));
    }

    @Test
    public void creatingTaskItemFailsWithInvalidTitle() {
        assertThrows(TaskItem.InvalidTitleException.class, () -> new TaskItem("", "","First Task","2000-04-04"));
    }

    @Test
    public void creatingTaskItemSucceedsWithValidDueDate() {
        assertDoesNotThrow(() -> new TaskItem("", "Task1","First Task","2000-04-04"));
    }

    @Test
    public void creatingTaskItemSucceedsWithValidTitle() {
        assertDoesNotThrow(() -> new TaskItem("", "Task2","First Task","2000-04-04"));
    }

    @Test
    public void settingTaskItemDueDateFailsWithInvalidDate() {
        TaskItem item = new TaskItem("", "Task1","First Task","2000-04-04");
        assertThrows(TaskItem.InvalidDateException.class, () -> item.setDate(""));
    }

    @Test
    public void settingTaskItemDueDateSucceedsWithValidDate() {
        TaskItem item = new TaskItem("", "Task1","First Task","2000-04-04");
        assertDoesNotThrow(() -> item.setDate("2000-04-04"));
    }

    @Test
    public void settingTaskItemTitleFailsWithInvalidTitle() {
        TaskItem item = new TaskItem("", "Task1","First Task","2000-04-04");
        assertThrows(TaskItem.InvalidTitleException.class, () -> item.setTitle(""));
    }

    @Test
    public void settingTaskItemTitleSucceedsWithValidTitle() {
        TaskItem item = new TaskItem("", "Task1","First Task","2000-04-04");
        assertDoesNotThrow(() -> item.setTitle("Task1"));
    }
}
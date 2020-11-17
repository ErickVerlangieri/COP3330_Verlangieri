import org.junit.jupiter.api.Test;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TaskListTest {

    @Test
    public void addingTaskItemsIncreasesSize() {
        TaskList tasks = new TaskList();
        TaskItem item = new TaskItem("", "Task 1","First Task","2000-04-10");
        tasks.add(item);
        assertEquals(1,tasks.size());
    }

    @Test
    public void completingTaskItemChangesStatus() {
        TaskItem item = new TaskItem("***", "Task 1","First Task","2000-01-01");
        assertEquals("***",item.getMarked());
    }

    @Test
    public void completingTaskItemFailsWithInvalidIndex() {
        TaskList tasks = new TaskList();
        TaskItem item = new TaskItem("***", "Task 1","First Task","2000-01-01");
        tasks.add(item);
        assertThrows(IndexOutOfBoundsException.class, () -> tasks.edit(item, 1));
    }

    @Test
    public void editingTaskItemChangesValues() {
        TaskList tasks = new TaskList();
        TaskItem item = new TaskItem("***", "Task 1","First Task","2000-01-01");
        tasks.add(item);
        TaskItem item2 = new TaskItem("", "Task 2","Second Task","2020-04-10");
        tasks.edit(item2, 0);
        assertEquals(tasks.get(0),item2);
    }

    @Test
    public void editingTaskItemDescriptionChangesValue() {
        TaskList tasks = new TaskList();
        TaskItem item = new TaskItem("***", "Task 1","First Task","2000-01-01");
        tasks.add(item);
        TaskItem item2 = new TaskItem("***", "Task 1","Second Task","2000-01-01");
        tasks.edit(item2, 0);
        assertEquals(tasks.get(0).getDescription(),item2.getDescription());
    }

    @Test
    public void editingTaskItemDescriptionFailsWithInvalidIndex() {
        TaskList tasks = new TaskList();
        TaskItem item = new TaskItem("***", "Task 1","First Task","2000-01-01");
        tasks.add(item);
        TaskItem item2 = new TaskItem("***", "Task 1","Second Task","2000-01-01");
        assertThrows(IndexOutOfBoundsException.class, () -> tasks.edit(item2, 1));
    }

    @Test
    public void editingTaskItemDueDateChangesValue() {
        TaskList tasks = new TaskList();
        TaskItem item = new TaskItem("***", "Task 1","First Task","2000-01-01");
        tasks.add(item);
        TaskItem item2 = new TaskItem("***", "Task 1","First Task","2020-04-10");
        tasks.edit(item2, 0);
        assertEquals(tasks.get(0).getDate(),item2.getDate());
    }

    @Test
    public void editingTaskItemDueDateFailsWithInvalidIndex() {
        TaskList tasks = new TaskList();
        TaskItem item = new TaskItem("***", "Task 1","First Task","2000-01-01");
        tasks.add(item);
        TaskItem item2 = new TaskItem("***", "Task 1","First Task","2020-04-10");
        assertThrows(IndexOutOfBoundsException.class, () -> tasks.edit(item2, 1));
    }

    @Test
    public void editingTaskItemTitleChangesValue() {
        TaskList tasks = new TaskList();
        TaskItem item = new TaskItem("***", "Task 1","First Task","2000-01-01");
        tasks.add(item);
        TaskItem item2 = new TaskItem("***", "Task 2","First Task","2020-04-10");
        tasks.edit(item2, 0);
        assertEquals(tasks.get(0).getTitle(),item2.getTitle());
    }

    @Test
    public void editingTaskItemTitleFailsWithInvalidIndex() {
        TaskList tasks = new TaskList();
        TaskItem item = new TaskItem("***", "Task 1","First Task","2000-01-01");
        tasks.add(item);
        TaskItem item2 = new TaskItem("***", "Task 2","First Task","2000-01-01");
        assertThrows(IndexOutOfBoundsException.class, () -> tasks.edit(item2, 1));
    }

    @Test
    public void gettingTaskItemDescriptionFailsWithInvalidIndex() {
        TaskList tasks = new TaskList();
        TaskItem item = new TaskItem("***", "Task 1","First Task","2000-01-01");
        tasks.add(item);
        assertThrows(IndexOutOfBoundsException.class, () -> tasks.get(1).getDescription());
    }

    @Test
    public void gettingTaskItemDescriptionSucceedsWithValidIndex() {
        TaskList tasks = new TaskList();
        TaskItem item = new TaskItem("***", "Task 1","First Task","2000-01-01");
        tasks.add(item);
        assertEquals(tasks.get(0).getDescription(),item.getDescription());
    }

    @Test
    public void gettingTaskItemDueDateFailsWithInvalidIndex() {
        TaskList tasks = new TaskList();
        TaskItem item = new TaskItem("***", "Task 1","First Task","2000-01-01");
        tasks.add(item);
        assertThrows(IndexOutOfBoundsException.class, () -> tasks.get(1).getDate());
    }

    @Test
    public void gettingTaskItemDueDateSucceedsWithValidIndex() {
        TaskList tasks = new TaskList();
        TaskItem item = new TaskItem("***", "Task 1","First Task","2000-01-01");
        tasks.add(item);
        assertEquals(tasks.get(0).getDate(),item.getDate());
    }

    @Test
    public void gettingTaskItemTitleFailsWithInvalidIndex() {
        TaskList tasks = new TaskList();
        TaskItem item = new TaskItem("***", "Task 1","First Task","2000-01-01");
        tasks.add(item);
        assertThrows(IndexOutOfBoundsException.class, () -> tasks.get(1).getTitle());
    }

    @Test
    public void gettingTaskItemTitleSucceedsWithValidIndex() {
        TaskList tasks = new TaskList();
        TaskItem item = new TaskItem("***", "Task 1","First Task","2000-01-01");
        tasks.add(item);
        assertEquals(tasks.get(0).getTitle(),item.getTitle());
    }

    @Test
    public void newTaskListIsEmpty() {
        TaskList tasks = new TaskList();
        assertEquals(0,tasks.size());
    }

    @Test
    public void removingTaskItemsDecreasesSize() {
        TaskList tasks = new TaskList();
        TaskItem item = new TaskItem("", "Task 1","First Task","2000-04-10");
        tasks.add(item);
        tasks.remove(0);
        assertEquals(0,tasks.size());
    }

    @Test
    public void removingTaskItemsFailsWithInvalidIndex() {
        TaskList tasks = new TaskList();
        TaskItem item = new TaskItem("", "Task 1","First Task","2000-04-10");
        tasks.add(item);
        assertThrows(IndexOutOfBoundsException.class, () -> tasks.remove(1));
    }

    @Test
    public void savedTaskListCanBeLoaded() {
        TaskList tasks = new TaskList();
        TaskItem item = new TaskItem("", "Task 1","First Task","2000-04-10");
        TaskItem item2 = new TaskItem("***", "Task 2","Second Task","2000-04-10");
        String fileName = "open.txt";
        assertDoesNotThrow(() -> tasks.open(fileName, tasks));
    }

    @Test
    public void uncompletingTaskItemChangesStatus() {
        TaskItem item = new TaskItem("", "Task 1","First Task","2000-01-01");
        assertEquals("",item.getMarked());
    }

    @Test
    public void uncompletingTaskItemFailsWithInvalidIndex() {
        TaskList tasks = new TaskList();
        TaskItem item = new TaskItem("", "Task 1","First Task","2000-01-01");
        tasks.add(item);
        assertThrows(IndexOutOfBoundsException.class, () -> tasks.edit(item, 1));
    }
}

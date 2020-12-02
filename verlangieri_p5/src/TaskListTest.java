import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TaskListTest {

    @Test
    public void addingItemsIncreasesSize() {
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
    public void editingItemDescriptionFailsWithInvalidIndex() {
        TaskList tasks = new TaskList();
        TaskItem item = new TaskItem("***", "Task 1","First Task","2000-01-01");
        tasks.add(item);
        TaskItem item2 = new TaskItem("***", "Task 1","Second Task","2000-01-01");
        assertThrows(IndexOutOfBoundsException.class, () -> tasks.edit(item2, 1));
    }

    @Test
    public void editingItemDescriptionSucceedsWithExpectedValue() {
        TaskList tasks = new TaskList();
        TaskItem item = new TaskItem("***", "Task 1","First Task","2000-01-01");
        tasks.add(item);
        TaskItem item2 = new TaskItem("***", "Task 1","Second Task","2000-01-01");
        tasks.edit(item2, 0);
        assertEquals(tasks.get(0).getDescription(),item2.getDescription());
    }

    @Test
    public void editingItemDueDateSucceedsWithExpectedValue() {
        TaskList tasks = new TaskList();
        TaskItem item = new TaskItem("***", "Task 1","First Task","2000-01-01");
        tasks.add(item);
        TaskItem item2 = new TaskItem("***", "Task 1","First Task","2020-04-10");
        tasks.edit(item2, 0);
        assertEquals(tasks.get(0).getDate(),item2.getDate());
    }

    @Test
    public void editingItemTitleFailsWithEmptyString() {
        TaskList tasks = new TaskList();
        TaskItem item = new TaskItem("***", "Task 1","First Task","2000-01-01");
        tasks.add(item);
        assertThrows(TaskItem.InvalidTitleException.class, () -> tasks.edit(new TaskItem("***", "","First Task","2020-04-10"), 0));
    }

    @Test
    public void editingItemTitleFailsWithInvalidIndex() {
        TaskList tasks = new TaskList();
        TaskItem item = new TaskItem("***", "Task 1","First Task","2000-01-01");
        tasks.add(item);
        TaskItem item2 = new TaskItem("***", "Task 2","First Task","2000-01-01");
        assertThrows(IndexOutOfBoundsException.class, () -> tasks.edit(item2, 1));
    }

    @Test
    public void editingItemTitleSucceedsWithExpectedValue() {
        TaskList tasks = new TaskList();
        TaskItem item = new TaskItem("***", "Task 1","First Task","2000-01-01");
        tasks.add(item);
        TaskItem item2 = new TaskItem("***", "Task 2","First Task","2020-04-10");
        tasks.edit(item2, 0);
        assertEquals(tasks.get(0).getTitle(),item2.getTitle());
    }

    @Test
    public void editingTaskItemDueDateFailsWithInvalidDateFormat() {
        TaskList tasks = new TaskList();
        TaskItem item = new TaskItem("***", "Task 1","First Task","2000-01-01");
        tasks.add(item);
        assertThrows(TaskItem.InvalidDateException.class, () -> tasks.edit(new TaskItem("***", "Task 2","First Task","20-2004-10"), 0));
    }

    @Test
    public void editingTaskItemDueDateFailsWithInvalidIndex() {
        TaskList tasks = new TaskList();
        TaskItem item = new TaskItem("***", "Task 1","First Task","2000-01-01");
        tasks.add(item);
        assertThrows(IndexOutOfBoundsException.class, () -> tasks.edit(new TaskItem("***", "Task 2","First Task","2020-04-10"), 4));
    }

    @Test
    public void editingTaskItemDueDateFailsWithInvalidYYYMMDD() {
        TaskList tasks = new TaskList();
        TaskItem item = new TaskItem("***", "Task 1","First Task","2000-01-01");
        tasks.add(item);
        assertThrows(TaskItem.InvalidDateException.class, () -> tasks.edit(new TaskItem("***", "Task 2","First Task","20200410"), 0));
    }

    @Test
    public void gettingItemDescriptionFailsWithInvalidIndex() {
        TaskList tasks = new TaskList();
        TaskItem item = new TaskItem("***", "Task 1","First Task","2000-01-01");
        tasks.add(item);
        assertThrows(IndexOutOfBoundsException.class, () -> tasks.get(1).getDescription());
    }

    @Test
    public void gettingItemDescriptionSucceedsWithValidIndex() {
        TaskList tasks = new TaskList();
        TaskItem item = new TaskItem("***", "Task 1","First Task","2000-01-01");
        tasks.add(item);
        assertEquals(tasks.get(0).getDescription(),item.getDescription());
    }

    @Test
    public void gettingItemDueDateFailsWithInvalidIndex() {
        TaskList tasks = new TaskList();
        TaskItem item = new TaskItem("***", "Task 1","First Task","2000-01-01");
        tasks.add(item);
        assertThrows(IndexOutOfBoundsException.class, () -> tasks.get(1).getDate());
    }

    @Test
    public void gettingItemDueDateSucceedsWithValidIndex() {
        TaskList tasks = new TaskList();
        TaskItem item = new TaskItem("***", "Task 1","First Task","2000-01-01");
        tasks.add(item);
        assertEquals(tasks.get(0).getDate(),item.getDate());
    }

    @Test
    public void gettingItemTitleFailsWithInvalidIndex() {
        TaskList tasks = new TaskList();
        TaskItem item = new TaskItem("***", "Task 1","First Task","2000-01-01");
        tasks.add(item);
        assertThrows(IndexOutOfBoundsException.class, () -> tasks.get(1).getTitle());
    }

    @Test
    public void gettingItemTitleSucceedsWithValidIndex() {
        TaskList tasks = new TaskList();
        TaskItem item = new TaskItem("***", "Task 1","First Task","2000-01-01");
        tasks.add(item);
        assertEquals(tasks.get(0).getTitle(),item.getTitle());
    }

    @Test
    public void newListIsEmpty(){
        TaskList tasks = new TaskList();
        assertEquals(tasks.size(),0);
    }

    @Test
    public void removingItemsDecreasesSize() {
        TaskList tasks = new TaskList();
        TaskItem item = new TaskItem("", "Task 1","First Task","2000-04-10");
        tasks.add(item);
        tasks.remove(0);
        assertEquals(0,tasks.size());
    }

    @Test
    public void removingItemsFailsWithInvalidIndex() {
        TaskList tasks = new TaskList();
        TaskItem item = new TaskItem("", "Task 1","First Task","2000-04-10");
        tasks.add(item);
        assertThrows(IndexOutOfBoundsException.class, () -> tasks.remove(1));
    }

    @Test
    public void savedTaskListCanBeLoaded() {
        TaskList tasks = new TaskList();
        TaskItem item = new TaskItem("***", "Task 1","First Task","2000-01-01");
        tasks.add(item);
        TaskItem item2 = new TaskItem("***", "Task 2","First Task","2020-04-10");
        tasks.add(item2);
        tasks.write("file2.txt");
        TaskList tasks2 = new TaskList();
        tasks2.open("file2.txt",tasks2);

        assertEquals(tasks2.get(0).getMarked(),tasks.get(0).getMarked());
        assertEquals(tasks2.get(0).getTitle(),tasks.get(0).getTitle());
        assertEquals(tasks2.get(0).getDescription(),tasks.get(0).getDescription());
        assertEquals(tasks2.get(0).getDate(),tasks.get(0).getDate());
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
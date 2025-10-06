import org.example.TodoList;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class TodoListTest {
    @Test
    void addAndList() {
        TodoList t = new TodoList();
        t.add(" task1 ");
        assertEquals(1, t.size());
        assertEquals("task1", t.getAll().getFirst());
    }

    @Test
    void remove() {
        TodoList t = new TodoList();
        t.add("a");
        t.add("b");
        assertTrue(t.remove(0));
        assertEquals(1, t.size());
        assertFalse(t.remove(10));
    }

    @Test
    void addEmptyIgnored() {
        TodoList t = new TodoList();
        t.add(" ");
        assertEquals(0, t.size());
    }

    // Новые тесты для clear
    @Test
    void clearAllTasks() {
        TodoList t = new TodoList();
        t.add("task1");
        t.add("task2");
        assertEquals(2, t.size());

        t.clear();
        assertEquals(0, t.size());
        assertTrue(t.getAll().isEmpty());
    }

    // Новые тесты для search
    @Test
    void searchTasks() {
        TodoList t = new TodoList();
        t.add("Buy groceries");
        t.add("Call mom");
        t.add("Buy book");

        List<String> results = t.search("buy");
        assertEquals(2, results.size());
        assertTrue(results.contains("Buy groceries"));
        assertTrue(results.contains("Buy book"));
    }

    @Test
    void searchCaseInsensitive() {
        TodoList t = new TodoList();
        t.add("Buy groceries");
        t.add("Call mom");

        List<String> results = t.search("CALL");
        assertEquals(1, results.size());
        assertTrue(results.contains("Call mom"));
    }

    @Test
    void searchEmptyString() {
        TodoList t = new TodoList();
        t.add("task1");

        List<String> results = t.search("");
        assertTrue(results.isEmpty());

        results = t.search("   ");
        assertTrue(results.isEmpty());
    }

    @Test
    void searchNoResults() {
        TodoList t = new TodoList();
        t.add("task1");
        t.add("task2");

        List<String> results = t.search("xyz");
        assertTrue(results.isEmpty());
    }

    @Test
    void searchNullSafe() {
        TodoList t = new TodoList();
        t.add("task1");

        List<String> results = t.search(null);
        assertTrue(results.isEmpty());
    }
}
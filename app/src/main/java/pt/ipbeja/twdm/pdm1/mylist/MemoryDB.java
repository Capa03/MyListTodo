package pt.ipbeja.twdm.pdm1.mylist;

import java.util.ArrayList;
import java.util.List;

public class MemoryDB {


    private MemoryDB() {

    }


    private static List<TodoList> todo;

    public static List<TodoList> getAllTodo() {

        if (todo == null) {

            todo = new ArrayList<>();
        }
        return todo;
    }

    public static void removeTask(int index) {
        if (index >= 0 && index <= getAllTodo().size() - 1) {
            todo.remove(index);
        } else {
            throw new IndexOutOfBoundsException("Invalid Index");
        }
    }
}

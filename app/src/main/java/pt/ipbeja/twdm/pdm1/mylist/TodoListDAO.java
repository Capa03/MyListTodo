package pt.ipbeja.twdm.pdm1.mylist;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface TodoListDAO {
    @Query("SELECT * FROM TodoList")
    List<TodoList> getAll();

    @Query("SELECT * FROM todolist WHERE id = :todoId")
    TodoList getById(long todoId);
    @Delete
    void delete(TodoList todoList);

    @Update
    void update(TodoList todoList);

    @Insert
    void insert(TodoList todoList);

}

package pt.ipbeja.twdm.pdm1.mylist;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {TodoList.class}, version = 1)
public abstract class AppDataBase extends RoomDatabase {

    public abstract TodoListDAO getTodoListDAO();

    private static AppDataBase INSTANCE;

    public static AppDataBase getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                    AppDataBase.class, "todoListDatabase")
                    .allowMainThreadQueries()
                    .build();
        }
        return INSTANCE;
    }
}

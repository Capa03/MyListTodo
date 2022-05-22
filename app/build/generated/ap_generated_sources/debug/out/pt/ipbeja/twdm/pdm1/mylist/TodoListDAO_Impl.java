package pt.ipbeja.twdm.pdm1.mylist;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class TodoListDAO_Impl implements TodoListDAO {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<TodoList> __insertionAdapterOfTodoList;

  private final EntityDeletionOrUpdateAdapter<TodoList> __deletionAdapterOfTodoList;

  private final EntityDeletionOrUpdateAdapter<TodoList> __updateAdapterOfTodoList;

  public TodoListDAO_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfTodoList = new EntityInsertionAdapter<TodoList>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `TodoList` (`id`,`title`,`description`,`dateData`) VALUES (nullif(?, 0),?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, TodoList value) {
        stmt.bindLong(1, value.getId());
        if (value.getTitle() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getTitle());
        }
        if (value.getDescription() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getDescription());
        }
        if (value.getDateData() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getDateData());
        }
      }
    };
    this.__deletionAdapterOfTodoList = new EntityDeletionOrUpdateAdapter<TodoList>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `TodoList` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, TodoList value) {
        stmt.bindLong(1, value.getId());
      }
    };
    this.__updateAdapterOfTodoList = new EntityDeletionOrUpdateAdapter<TodoList>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `TodoList` SET `id` = ?,`title` = ?,`description` = ?,`dateData` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, TodoList value) {
        stmt.bindLong(1, value.getId());
        if (value.getTitle() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getTitle());
        }
        if (value.getDescription() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getDescription());
        }
        if (value.getDateData() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getDateData());
        }
        stmt.bindLong(5, value.getId());
      }
    };
  }

  @Override
  public void insert(final TodoList todoList) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfTodoList.insert(todoList);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final TodoList todoList) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfTodoList.handle(todoList);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final TodoList todoList) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfTodoList.handle(todoList);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<TodoList> getAll() {
    final String _sql = "SELECT * FROM TodoList";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
      final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
      final int _cursorIndexOfDateData = CursorUtil.getColumnIndexOrThrow(_cursor, "dateData");
      final List<TodoList> _result = new ArrayList<TodoList>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final TodoList _item;
        final long _tmpId;
        _tmpId = _cursor.getLong(_cursorIndexOfId);
        final String _tmpTitle;
        if (_cursor.isNull(_cursorIndexOfTitle)) {
          _tmpTitle = null;
        } else {
          _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
        }
        final String _tmpDescription;
        if (_cursor.isNull(_cursorIndexOfDescription)) {
          _tmpDescription = null;
        } else {
          _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
        }
        final String _tmpDateData;
        if (_cursor.isNull(_cursorIndexOfDateData)) {
          _tmpDateData = null;
        } else {
          _tmpDateData = _cursor.getString(_cursorIndexOfDateData);
        }
        _item = new TodoList(_tmpId,_tmpTitle,_tmpDescription,_tmpDateData);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public TodoList getById(final long todoId) {
    final String _sql = "SELECT * FROM todolist WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, todoId);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
      final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
      final int _cursorIndexOfDateData = CursorUtil.getColumnIndexOrThrow(_cursor, "dateData");
      final TodoList _result;
      if(_cursor.moveToFirst()) {
        final long _tmpId;
        _tmpId = _cursor.getLong(_cursorIndexOfId);
        final String _tmpTitle;
        if (_cursor.isNull(_cursorIndexOfTitle)) {
          _tmpTitle = null;
        } else {
          _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
        }
        final String _tmpDescription;
        if (_cursor.isNull(_cursorIndexOfDescription)) {
          _tmpDescription = null;
        } else {
          _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
        }
        final String _tmpDateData;
        if (_cursor.isNull(_cursorIndexOfDateData)) {
          _tmpDateData = null;
        } else {
          _tmpDateData = _cursor.getString(_cursorIndexOfDateData);
        }
        _result = new TodoList(_tmpId,_tmpTitle,_tmpDescription,_tmpDateData);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}

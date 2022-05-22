package pt.ipbeja.twdm.pdm1.mylist;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class TodoList {
    @PrimaryKey(autoGenerate = true)
    private long id;
    private String title;
    private String description;
    private String dateData;

    public TodoList(long id, String title, String description,String dateData){
        this.id = id;
        this.title = title;
        this.description = description;
        this.dateData = dateData;
    }

    public long getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public String getDescription() {
        return this.description;
    }

    public String getDateData(){
        return this.dateData;
    }
}

package pt.ipbeja.twdm.pdm1.mylist;

public class TodoList {
    private int id;
    private String title;
    private String description;

    public TodoList(int id, String title, String description){
        this.id = id;
        this.title = title;
        this.description = description;
    }

    public int getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public String getDescription() {
        return this.description;
    }
}

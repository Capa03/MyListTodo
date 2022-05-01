package pt.ipbeja.twdm.pdm1.mylist;

public class TodoList {
    private int id;
    private String title;
    private String description;
    private String dateData;

    public TodoList(int id, String title, String description,String dateData){
        this.id = id;
        this.title = title;
        this.description = description;
        this.dateData = dateData;
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

    public String getDateData(){
        return this.dateData;
    }
}

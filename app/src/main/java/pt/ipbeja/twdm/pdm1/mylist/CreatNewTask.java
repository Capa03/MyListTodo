package pt.ipbeja.twdm.pdm1.mylist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class CreatNewTask extends AppCompatActivity {
    public EditText title;
    public EditText description;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creat_new_task);

        this.title = findViewById(R.id.editTextTitle);
        this.description = findViewById(R.id.editTextDescription);
    }


    public void onCreatTask(View view) {
        String dataTitle = title.getText().toString();
        String dataDescription = description.getText().toString();
        MemoryDB.getAllTodo().add(new TodoList(0,dataTitle,dataDescription));

        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}
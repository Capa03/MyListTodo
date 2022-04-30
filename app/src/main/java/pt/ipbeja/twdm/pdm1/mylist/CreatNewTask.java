package pt.ipbeja.twdm.pdm1.mylist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class CreatNewTask extends AppCompatActivity {
    public EditText title;
    public EditText description;
    public static int counter;
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
        counter++;

        if(dataTitle.isEmpty()) {
            Toast.makeText(this,"Title is Empty, Please Insert a Title",Toast.LENGTH_SHORT).show();
            return;
        }
        MemoryDB.getAllTodo().add(new TodoList(counter,dataTitle,dataDescription));

        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}
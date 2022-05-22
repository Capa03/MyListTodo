package pt.ipbeja.twdm.pdm1.mylist;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.time.LocalDate;

@RequiresApi(api = Build.VERSION_CODES.O)
public class CreatNewTask extends AppCompatActivity {
    public EditText title;
    public EditText description;
    public TextView date;
    public LocalDate localDate = LocalDate.now();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creat_new_task);

        viewCache();
    }


    public void onCreatTask(View view) {
        String dataTitle = title.getText().toString();
        String dataDescription = description.getText().toString();
        String dataDate = this.localDate.toString();

        if(dataTitle.isEmpty()) {
            Toast.makeText(this,"Title is Empty, Please Insert a Title",Toast.LENGTH_SHORT).show();
            return;
        }
        TodoList todoList = new TodoList(0,dataTitle,dataDescription,dataDate);

        AppDataBase.getInstance(this).getTodoListDAO().insert(todoList);
        finish();
    }



    private void viewCache(){
        this.title = findViewById(R.id.editTextTitle);
        this.description = findViewById(R.id.editTextDescription);
        this.date = findViewById(R.id.textViewData);
    }
}
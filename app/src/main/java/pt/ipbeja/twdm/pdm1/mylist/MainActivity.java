package pt.ipbeja.twdm.pdm1.mylist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements TodoAdapter.TodoAdapterEventListener {
    private TextView empty;
    private TodoAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.empty = findViewById(R.id.textViewNotingToDo);
        empty();

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        this.adapter = new TodoAdapter(this);
        RecyclerView.LayoutManager layoutmanager = new LinearLayoutManager(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutmanager);

    }

    @Override
    protected void onStart() {
        super.onStart();
        this.adapter.updateList(MemoryDB.getAllTodo());
    }

    private void empty(){
        if(MemoryDB.getAllTodo().isEmpty()){
            this.empty.setVisibility(View.VISIBLE);
        }else{
            this.empty.setVisibility(View.INVISIBLE);
        }
    }


    public void onNewTask(View view) {
        Intent intent = new Intent(this, CreatNewTask.class);
        startActivity(intent);
    }
    @Override
    public void onTodoClicked(int index) {
        MemoryDB.removeTask(index);
        this.adapter.updateList(MemoryDB.getAllTodo());
        empty();
    }
}
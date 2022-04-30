package pt.ipbeja.twdm.pdm1.mylist;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class TodoAdapter extends RecyclerView.Adapter<TodoAdapter.TodoViewHolder> {

    public List<TodoList> todoList;
    private final TodoAdapterEventListener eventListener;
    
    public TodoAdapter(TodoAdapterEventListener eventListener){
        this.eventListener = eventListener;
        this.todoList = new ArrayList<>();
    }

    @NonNull
    @Override
    public TodoAdapter.TodoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_row,parent,false);
        return new TodoViewHolder(layout, parent.getContext());
    }

    @Override
    public void onBindViewHolder(@NonNull TodoAdapter.TodoViewHolder holder, int position) {
        TodoList todoList = this.todoList.get(position);
        holder.setTitle(todoList.getTitle());
        holder.setTextViewDescription(todoList.getDescription());

        holder.rootView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                eventListener.onTodoClicked(holder.getAdapterPosition());
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return this.todoList.size();
    }

    @SuppressLint("NotifyDataSetChanged")
    public void updateList(List<TodoList> allTodoList) {
        this.todoList = allTodoList;
        notifyDataSetChanged();
    }

    public static class TodoViewHolder extends RecyclerView.ViewHolder{
        private TextView textViewTitle;
        private TextView textViewDescription;
        private View rootView;
        private Context context;

        public TodoViewHolder(@NonNull View rootView, Context context) {
            super(rootView);
            this.context = context;
            this.rootView = rootView;
            this.textViewTitle = rootView.findViewById(R.id.textViewTitle);
            this.textViewDescription = rootView.findViewById(R.id.textViewDescription);
        }


        public void setTitle(String title){
            this.textViewTitle.setText(title);
        }

        public void setTextViewDescription(String description){
            this.textViewDescription.setText(description);
        }
    }
    
    public interface TodoAdapterEventListener{
        void onTodoClicked(int index);
    }
}

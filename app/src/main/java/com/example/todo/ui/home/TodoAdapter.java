package com.example.todo.ui.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.todo.R;
import com.example.todo.Task;

import java.util.ArrayList;

public class TodoAdapter extends RecyclerView.Adapter<TodoAdapter.MyViewHolder> {

    Context context;
    ArrayList<Task> taskList;

    //TodoAdapter constructor
    public TodoAdapter(Context context, ArrayList<Task> taskList){
        this.context=context;
        this.taskList=taskList;
    }


    @NonNull
    @Override
    public TodoAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //onCreateViewholder infaltes out layout and gives the look to each of our items

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.todo_item, parent, false);

        return new TodoAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TodoAdapter.MyViewHolder holder, int position) {
        //assigns the values to each off our list items in the Todo_item
        //based on position of reclyer view

        //tells the adaptor to update the data on each of our items, changnithe the values within each of the holders that's passed in
        //in this case we only update the name of the task since checkbox doesn't change
        //add the dude date later when you finshed the recylcer view and it works
        holder.todoText.setText(taskList.get(position).getName());

    }

    @Override
    public int getItemCount() {
        //reclycerView wants to be able to track how many of the todo_itmes are on screen
        return taskList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        //this is similar to the onCreate method used in mainactivity
        //it takes the views rom our todo_item layout xml and stoes it in a local variable
        TextView todoText;
        CheckBox todoCheck;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            todoText = itemView.findViewById(R.id.tvTaskName);
            todoCheck = itemView.findViewById(R.id.cbTaskDone);
        }
    }

    public void updateTasks(ArrayList<Task> updatedTasks) {
        this.taskList = updatedTasks;
        notifyDataSetChanged(); // Notify RecyclerView about dataset change
    }
}

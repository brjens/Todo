package com.example.todo.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.todo.MainActivity;
import com.example.todo.R;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.todo.Task;
import com.example.todo.databinding.FragmentHomeBinding;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    private ArrayList<Task> tasks;

    private RecyclerView recyclerView;

    private TodoAdapter adapter;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        MainActivity mainActivity = (MainActivity) requireActivity();
        tasks = mainActivity.tasks; // Get the tasks from MainActivity
        adapter = new TodoAdapter(requireContext(),tasks);
        //this is the last bit to bind the recylcerview to the homefragment
        //TODO: Connect the arraylst task to the recyclerview
        RecyclerView recyclerView = root.findViewById(R.id.rvTodo);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        recyclerView.setAdapter(adapter);

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public void updateRecyclerView(ArrayList<Task> updatedTasks) {
        if (adapter != null) {
            adapter.updateTasks(updatedTasks);
        }
    }

    public void updateTasks(ArrayList<Task> updatedTasks) {
        this.tasks = updatedTasks;
        if (adapter != null) {
            adapter.updateTasks(tasks); // Update tasks in adapter
        }
    }
}

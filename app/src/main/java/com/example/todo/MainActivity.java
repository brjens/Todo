package com.example.todo;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.widget.DatePicker;
import android.widget.EditText;

import com.example.todo.ui.home.HomeFragment;
import com.google.android.material.navigation.NavigationView;

import androidx.appcompat.app.AlertDialog;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import com.example.todo.databinding.ActivityMainBinding;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;
    public List<Task> tasks = new ArrayList<>();

    private String m_Text;

    private boolean showDialog = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ArrayList<Task> tasks = new ArrayList<>();

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.appBarMain.toolbar);
        binding.appBarMain.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // setting up the variable to retrieve the user input
                View dialogView = LayoutInflater.from(MainActivity.this).inflate(R.layout.dialog_add_task, null);
                EditText taskNameEditTask = dialogView.findViewById(R.id.taskNameEditText);
                DatePicker taskDueDate = dialogView.findViewById(R.id.taskDueDatePicker);

                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Add Task")
                        .setView(R.layout.dialog_add_task) // Inflate your custom layout here
                        .setMessage("Enter task name and due date:")
                        .setPositiveButton("Add", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                //Log.d("UserInput", "Value from EditText: " + userTextInput); // Logging the user input

                                String userTextInput = taskNameEditTask.getText().toString();
                                int year = taskDueDate.getYear();
                                int month = taskDueDate.getMonth();
                                int day = taskDueDate.getDayOfMonth();
                                LocalDate inputDate = LocalDate.of(year, month, day);

                                Log.d("UserInput", "Value from EditText: " + userTextInput); // Logging the user input

                                addTask(new Task(userTextInput,inputDate));

                            }
                        })
                        .setNegativeButton("Cancel", null)
                        .show();

            }

        });

        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    public void addTask(Task task) {
        tasks.add(task);
        notifyHomeFragment();
    }

    private void notifyHomeFragment() {
        HomeFragment homeFragment = (HomeFragment) getSupportFragmentManager().findFragmentByTag("homeFragmentTag");
        if (homeFragment != null) {
            homeFragment.updateRecyclerView(); // Method to update RecyclerView in HomeFragment
        }
    }


    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}
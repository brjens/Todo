import org.junit.Test;
import static org.junit.Assert.*;

import android.util.Log;

import com.example.todo.Task;

import java.util.ArrayList;

public class TaskTest {
    @Test
    public void testSetCompleted(){
        Task task = new Task();
        task.setCompleted(true);
        assertEquals(true,task.getCompleted());
    }

    @Test
    public void testSetName(){
        Task task = new Task();
        task.setName("Hello World");
        assertEquals("Hello World", task.getName());
    }
    @Test
    public void testToString(){
        Task task = new Task();
        task.setCompleted(true);
        task.setName("hello world");


    }

   @Test
   public void testArrayList(){

      ArrayList<Task> tasks = getTasksWithRandomNames();
      String[] names = getRandomNames();
      String currentName;
       for (int i=0; i<5; i++){
           currentName = (tasks.get(i)).getName();
           assertEquals( currentName, names[i]);
       }
   }

   @Test
   public  void testArrayListChangeName(){

        ArrayList<Task> tasks = new ArrayList<>();
        tasks = getTasksWithRandomNames();
        String test = "Hello world";
       //should change Charlie to hello world
        tasks.get(3).setName(test);
        assertEquals( tasks.get(3).getName(), "Hello world");
   }
   public String[] getRandomNames(){
        String[] names = {"Alie","bob","Charlie","David","Eva"};
        return names;
   }

   //helper, to populate Arraylist w/ random names
   public  ArrayList<Task> getTasksWithRandomNames(){
       ArrayList<Task> tasks = new ArrayList<>();
       Task task;
       String[] names = getRandomNames();
       for (int i=0; i<5; i++){
            task = new Task(names[i]);
           tasks.add(task);
       }
       return tasks;
   }
}

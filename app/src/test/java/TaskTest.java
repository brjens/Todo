import org.junit.Test;
import static org.junit.Assert.*;

import android.util.Log;

import com.example.todo.Task;

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

}

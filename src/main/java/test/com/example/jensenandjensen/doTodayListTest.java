package test.com.example.jensenandjensen; 

import com.example.jensenandjensen.doTodayList;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TableView;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

public class doTodayListTest { 

@Before
public void initToolkit() throws Exception {

} 

@After
public void after() throws Exception { 
} 

@Test
public void testAddToDoList() throws Exception { 
String exp="test";

    ListView<String>list_area=new ListView<>();
    list_area.getItems().add("test");
    list_area.getSelectionModel().select(0);
    doTodayList instance=new doTodayList();
    instance.list_area=new ListView<>();
    System.out.println("testing ..."+exp);
        String actual=instance.taskToDo();
        assertEquals(exp,actual);
}

@Test
public void testInsertNewTask() throws Exception { 
 }


@Test
public void testClearToDoList() throws Exception { 

} 

@Test
public void testTaskToDo() throws Exception {

 }

@Test
public void testBackToMainPage() throws Exception { 

} 


} 

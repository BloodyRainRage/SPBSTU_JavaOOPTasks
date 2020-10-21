import Tasks.*;

import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Task> tasks = new LinkedList<>();
//        tasks.add(new Task1()); //done
//        tasks.add(new Task2()); //done
//        tasks.add(new Task3()); //done
//        tasks.add(new Task4()); //done
//        tasks.add(new Task5());
//        tasks.add(new Task6());
//        tasks.add(new Task7()); //done
        tasks.add(new Task8());


        for (Task task: tasks) {
            task.execute();
        }

    }

}

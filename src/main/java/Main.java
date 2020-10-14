import Tasks.*;

import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Task> tasks = new LinkedList<>();
        tasks.add(new Task1());
        tasks.add(new Task2());
        tasks.add(new Task3());
        tasks.add(new Task4());
        tasks.add(new Task7());


        for (Task task: tasks) {
            task.execute();
        }

    }

}

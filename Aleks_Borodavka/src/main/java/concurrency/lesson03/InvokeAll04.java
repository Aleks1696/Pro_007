package concurrency.lesson03;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class InvokeAll04 {

    public static void main(String[] args) {
        List<Callable<Integer>> tasks = new ArrayList<>();
        tasks.add(() -> {
            TimeUnit.MILLISECONDS.sleep(2500);
            System.out.println("Task 1 - Executed");
            return 100;
        });
        tasks.add(() -> {
            TimeUnit.MILLISECONDS.sleep(1250);
            System.out.println("Task 2 - Executed");
            return 200;
        });
        tasks.add(() -> {
            TimeUnit.MILLISECONDS.sleep(1750);
            System.out.println("Task 3 - Executed");
            return 300;
        });
        ScheduledExecutorService es = Executors.newScheduledThreadPool(2);
        try {
            /* invokeAll - позволяет передать список задач на выполнение
             * классу исполнителю*/
            List<Future<Integer>> results = es.invokeAll(tasks);
            while (results.size() > 0) {
                System.out.println("In process " + results.size() + " tasks");
                for (int i = 0; i < results.size(); i++) {
                    if (results.get(i).isDone()) {
                        System.out.println(results.get(i).get());
                        results.remove(i--);
                    }
                }
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        es.shutdown();
    }
}

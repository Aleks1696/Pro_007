package concurrency.lesson03;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class InvokeAll04 {

    public static void main(String[] args) {
        List<Callable<Integer>> tasks = new ArrayList<>();
        tasks.add(() -> {
            TimeUnit.MILLISECONDS.sleep(2500);
            System.out.println("Задание 1 - выполнено.");
            return 100;
        });
        tasks.add(() -> {
            TimeUnit.MILLISECONDS.sleep(1250);
            System.out.println("Задание 2 - выполнено.");
            return 200;
        });
        tasks.add(() -> {
            TimeUnit.MILLISECONDS.sleep(1750);
            System.out.println("Задание 3 - выполнено.");
            return 300;
        });

        ScheduledExecutorService es =
                Executors.newScheduledThreadPool(2);
        try {
            /* Позволяет передать список задач на выполнение
             *  классу исполнителю*/
            List<Future<Integer>> results = es.invokeAll(tasks);
            while (results.size() > 0) {
                System.out.println(
                        "В обработке " + results.size() + " задач.");
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

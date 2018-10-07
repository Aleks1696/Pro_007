package concurrency.lesson04;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledEx06 {

    public static void main(String[] args) {
        System.out.println("Старт метода main()");
        ScheduledExecutorService es =
                Executors.newScheduledThreadPool(1);
        es.scheduleAtFixedRate(() -> {
            try {
                System.out.println("Старт фоновой задачи");
                TimeUnit.SECONDS.sleep(1);
                System.out.println("Что-то делаем...");
                TimeUnit.SECONDS.sleep(1);
                System.out.println("Что-то делаем...");
                TimeUnit.SECONDS.sleep(1);
                System.out.println("Завершение задачи...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, 1, 10, TimeUnit.SECONDS);
        System.out.println("Завершение метода main()");
    }

}

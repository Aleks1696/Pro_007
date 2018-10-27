package concurrency.lesson04;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledEx06 {

    public static void main(String[] args) {
        System.out.println("Main starts");
        ScheduledExecutorService es = Executors.newScheduledThreadPool(1);
        es.scheduleAtFixedRate(() -> {
            try {
                System.out.println("Background task starts");
                TimeUnit.SECONDS.sleep(1);
                System.out.println("Do something");
                TimeUnit.SECONDS.sleep(1);
                System.out.println("Do something");
                TimeUnit.SECONDS.sleep(1);
                System.out.println("Task end");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, 1, 10, TimeUnit.SECONDS);
        System.out.println("Main ended");
    }
}

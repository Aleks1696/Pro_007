package concurrency.lesson04;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class ScheduledEx05 {

    public static void main(String[] args) {
        System.out.println("Main start");
        ScheduledExecutorService es = Executors.newScheduledThreadPool(1);
        /* schedule() - позволяет установить отложенную к выполнению задачу
        * 1-й параметр - задача для отложенного запуска
        * 2-й параметр - время задержки
        * 3-й параметр - еденица измерения
        * ScheduledFuture - класс который позволяет контролировать отложенную задачу*/
        ScheduledFuture sf = es.schedule(() -> {
            System.out.println("Scheduled task!");
        }, 5, TimeUnit.SECONDS);

        while(!sf.isDone()){
            System.out.println("seconds to start: " + sf.getDelay(TimeUnit.MILLISECONDS));
            try {
                TimeUnit.MILLISECONDS.sleep(750);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Main ended");
    }
}

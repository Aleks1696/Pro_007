package concurrency.lesson04;

import java.util.concurrent.*;

public class ScheduledEx05 {
    public static void main(String[] args) {
        System.out.println("Старт метода main");

        ScheduledExecutorService es =
                Executors.newScheduledThreadPool(1);
        // schedule() - позволяет установить отложенную к выполнению задачу
        // 1 й параметр - Задача для отложенного запуска
        // 2 й параметр - Время задержки до запуска
        // 3 й параметр - Еденицы измерения


        // ScheduledFuture - класс который позволяет контролировать отложенную задачу
        ScheduledFuture sf = es.schedule(() -> {
            System.out.println("Отложенная задача");
        },5, TimeUnit.SECONDS);

        while (!sf.isDone()){
            System.out.println("До запуска осталось " + sf.getDelay(TimeUnit.MILLISECONDS));
            try{
                TimeUnit.MILLISECONDS.sleep(750);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        System.out.println("Завершение метода main");
    }
}

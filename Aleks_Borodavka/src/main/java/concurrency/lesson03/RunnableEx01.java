package concurrency.lesson03;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/* Concurrency API - библиотека с набором инструментов
 * для работы с потоками */
public class RunnableEx01 {

    /* Runnable - интерфейс для описания действий (задачи) которые
    необходимо выполнить в отделеьном потоке */
    public static void main(String[] args) {
        Runnable task01 = () -> {
            try {
                TimeUnit.SECONDS.sleep(2);
                System.out.println("Task 1 - Executed");

                /* InterruptException - генерируется в случае
                если во время режима сна досрочно прервать выполнение этого потока */
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        };
        /* ExecutorService - является интерфейсом класса исполнителя для запуска фоновых задач
        *
        * Executor - вспомогательный класс(фабрика), который позволяет нам создать
        * необходимый сервис для запуска задач
        *
        * newSingleThreadExecutor() - создает сервис исполнитель
        * с одним активным процесом. В одном процессе выполняется
        * одна задача, все остальные находятся в режиме ожидания*/
        ExecutorService es = Executors.newSingleThreadExecutor();

        es.execute(task01);
        es.execute(() -> {
            try {
                TimeUnit.SECONDS.sleep(10);
                System.out.println("Task 2 - Executed");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        /* shutdown - досрочная остановка работы сервиса исполнителя
         *  */
//        es.shutdown;
        if (!es.isTerminated()){
            System.out.println("Preparation for closing down executor");
            System.out.println("Waiting 3 sec.");
            try {
                /* awaitTermination - дает таймаут на завершение всех процессов
                 * которые находятся к классе исполнителе */
                es.awaitTermination(5, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            /* отсанавливает работу потока */
            es.shutdown();
        }
    }
}

package concurrency.lesson03;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class RunnableEx01 {

    /* Runnable - интерфейс для описания действий (задач) которые необходимо выполнить в отдельном потоке*/
    public static void main(String[] args) {
        Runnable task01 = () -> {
            try {
                TimeUnit.SECONDS.sleep(2);
                System.out.println("Задача 1 выполнена");
                // interrupt exeption - генерируется во время режима сна, если во время сна(досрочно) прервать работу потока
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        };
            //Executor service - интерфейс - является интерфейсом класса исполнителя для запуска фоновых задач
            //Executors - вспомогательный класс(фабрика), который позволяет нам создать необходимый сервис для запуска задач
            // newSingleThreadExecutor() - создает сервис-исполнитель с одним активным процессом. В одном процессе может выполняться одна задача. Все остальные находятся в режиме ожидания

        ExecutorService es = Executors.newSingleThreadExecutor();

        es.execute(task01);
        es.execute(()-> {
            try {
                TimeUnit.MILLISECONDS.sleep(4500);
                System.out.println("Задача 2 выполнена");
            }catch (InterruptedException e){
                e.printStackTrace();
            }

        });
        //shutdown - досрочная остановка работы сервиса исполнителя
//        es.shutdown();
        if(!es.isTerminated()) {
            System.out.println("Подготовка к завершению работы исполнителя");
            System.out.println("Ожидание 3 секунды до завершения работы");
            try {
                //awaitTermination дает таймаут на завершение всех процессов которые находятся в классе исполнителе
                es.awaitTermination(3, TimeUnit.SECONDS);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            //
            es.shutdown();
        }
    }
}

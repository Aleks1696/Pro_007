package concurrency.lesson03;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/* Concurrency API - библиотека с набором
*  интрументов для работы с потоками*/
public class RunnableEx01 {

    /* Runnable - интерфейс для описания действий(задачи)
    * которые необходимо выполнить в отельном потоке*/
    public static void main(String[] args) {
        Runnable task01 = () -> {
            try {
                TimeUnit.SECONDS.sleep(2);
                System.out.println("Задача 1 - Выполнена.");
                /*InterruptedException - генерируется в случае
                * если во время режима сна, досрочно прервать работу
                * потока*/
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        /* ExecutorService - является интерфейсом класса исполнителя
        *                    для запуска фоновых задач
        *  Executors       - вспомогательный класс(фабрика), который
        *                    позволяет нам создать необходимый сервис
        *                    для запуска задач
        *  newSingleThreadExecutor() - создает сервис-исполнитель
        *                    с одним активным процессом.
        *                    В одном процессе выполняется одна задача,
        *                    все остальные находятся в режиме ожидания*/
        ExecutorService es = Executors.newSingleThreadExecutor();

        es.execute(task01);
        es.execute(() -> {
            try {
                TimeUnit.MILLISECONDS.sleep(1500);
                System.out.println("Задача 2 - Выполнена.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        /* shutdown - досрочная остановка работы сервиса исполнителя*/
//        es.shutdown();
        if (!es.isTerminated()) {
            System.out.println("Подготовка к завершению работы исполнителя");
            System.out.println("Ожидание 3 сек.");
            try {
                /*awaitTermination - дает таймаут на завершение всех
                *                    процессов которые находятся
                *                    в классе исполнителе*/
                es.awaitTermination(5, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            /*Останавливает работу потока*/
            es.shutdownNow();
        }
    }
}

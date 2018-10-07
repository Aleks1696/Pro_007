package concurrency.lesson03;

import java.util.concurrent.*;

public class CallableEx03 {

    public static void main(String[] args) {
        ExecutorService es = Executors.newSingleThreadExecutor();

        Future<String> result = es.submit(() -> {
            System.out.println("Запуск задачи...");
            TimeUnit.SECONDS.sleep(3);
            return "Результат выполнения задачи";
        });

        try {
            TimeUnit.MILLISECONDS.sleep(500);
            System.out.println("Ожидание выполения...");
            while (!result.isDone()) {
                System.out.println("Ждем 1 сек.");
                TimeUnit.SECONDS.sleep(1);
            }
            System.out.println("Получаем результат...");
            System.out.println(result.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        es.shutdown();
    }
}

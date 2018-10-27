package concurrency.lesson03;

import java.util.concurrent.*;

public class CallableEx02 {

    /* Callable - появился начиная с JDK 1.5 в составе concurrency API
     * который помогает вернуть результат выполненой работы из потока */
    public static void main(String[] args) {
        Callable<String> task = () -> {
            System.out.println("Do something");
            TimeUnit.SECONDS.sleep(2);
            return "Result of execution...";
        };

        /* newFixedThreadPool - создает процес с двумя активными потоками*/
        ExecutorService es = Executors.newFixedThreadPool(2);

        /*submit - позволяет запустить Callable задачу в отдельном потоке*/
//        es.submit(task);

        /* Future - класс который позволяет контролировать работу потока и получить
        * результат выполнения после завершения задачи*/
        Future<String> taskResult = es.submit(task);

        try {
            System.out.println("Waiting for result...");
            System.out.println("Is task completed? - " + taskResult.isDone());
            if (!taskResult.isDone()){
                String result = taskResult.get(3, TimeUnit.SECONDS);
                System.out.println("Result: --->>>" + result);
            }
            System.out.println("Is task completed? - " + taskResult.isDone());
        } catch (InterruptedException e){
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }

        es.shutdown();
    }
}

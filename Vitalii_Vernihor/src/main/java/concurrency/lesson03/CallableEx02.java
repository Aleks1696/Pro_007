package concurrency.lesson03;

import java.util.concurrent.*;

public class CallableEx02 {

    //Callable - появился с JDK 1.5 в составе Concurrency API, который помогает вернуть результат выполненной работы из потока
    public static void main(String[] args) {
        Callable<String> task = () -> {
            System.out.println("Выполняем что-то...");
            TimeUnit.SECONDS.sleep(2);
            return "Результат выполнения задачи...";
        };
        // newFixedThreadPool - создает процесс с 2 активными потоками
        ExecutorService es = Executors.newFixedThreadPool(2);
        // submit позволяет запустить Callable задачу в отдельном потоке
        // Future - класс, который позволяет контролировать работу потока и получить результат выполнения после завершения задачи
        Future<String> taskResult = es.submit(task);

        try {


            System.out.println("Ожидание результата работы");
            System.out.println("Задача завершена? - " + taskResult.isDone());
            if (!taskResult.isDone()){
                String result = taskResult.get(3,TimeUnit.SECONDS);
                System.out.println("Результат: --->>>" +result);
            }
            System.out.println("Задача завершена? - " + taskResult.isDone());
        }catch (InterruptedException | ExecutionException | TimeoutException e){
            e.printStackTrace();
        }
    }
}

package concurrency.lesson03;

import java.util.concurrent.*;

public class CollableEx03 {

    public static void main(String[] args) {
        ExecutorService es = Executors.newSingleThreadExecutor();

        Future<String> result = es.submit(() -> {
            System.out.println("Start task...");
            TimeUnit.SECONDS.sleep(3);
            return "Result of operation execution";
        });

        try {
            TimeUnit.MILLISECONDS.sleep(500);
            System.out.println("Waiting for execution...");
            while(!result.isDone()){
                System.out.println("Wait 1 sec.");
                TimeUnit.SECONDS.sleep(1);
            }
            System.out.println("Getting results...");
            System.out.println(result.get());
        } catch (InterruptedException e){
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        es.shutdown();
    }
}

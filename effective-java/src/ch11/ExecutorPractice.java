package ch11;

import javax.management.RuntimeErrorException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.*;


public class ExecutorPractice {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 1번
//        ExecutorService exec = Executors.newSingleThreadExecutor();
//        System.out.println("실행자 서비스 시작 : " + LocalTime.now());
//        ComputeThread computeThread = new ComputeThread();
//        exec.submit(computeThread).get();
//        System.out.println("실행자 서비스 종료 : "  + LocalTime.now());

        // 2번
//        ExecutorService exec = Executors.newFixedThreadPool(5);
//        List<Task> list = new ArrayList<>();
//        list.add(new Task());
//        list.add(new Task());
//        List<Future<String>> futures = exec.invokeAll(list);
//        for (Future<String> future : futures) {
//            System.out.println(future.get());
//        }

        // 4번
//        ExecutorService exec = Executors.newFixedThreadPool(3);
//        ExecutorCompletionService<String> executorCompletionService = new ExecutorCompletionService<>(exec);
//
//        List<Future<String>> futures = new ArrayList<>();
//        futures.add(executorCompletionService.submit(() -> "mango"));
//        futures.add(executorCompletionService.submit(() -> "vanille"));
//        futures.add(executorCompletionService.submit(() -> "apple"));
//
//        for (int i = 0; i < 3; i++) {
//            try {
//                String result = executorCompletionService.take().get();
//                System.out.println(result);
//            } catch (InterruptedException e) {
//                //
//            } catch (ExecutionException e) {
//                //
//            }
//        }


        // 5번
        ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(2);

        executor.scheduleAtFixedRate(() -> {
            System.out.println(DateTimeFormatter.ofPattern("HH:mm:ss")
                    .format(LocalDateTime.now()));
        }, 0, 1, TimeUnit.SECONDS);

    }

    static class Task implements Callable<String> {
        @Override
        public String call() {
            return Thread.currentThread().getName();
        }
    }

}

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {

        //Задача 1
        
        ThreadSafeList<Integer> threadSafeList = new ThreadSafeList<>();

        ExecutorService executor = Executors.newFixedThreadPool(1000);
        for (int i = 0; i < 1000; i++) {
            final int value = i;
            executor.submit(() -> {
                threadSafeList.add(value);
                threadSafeList.get(value % 100);
                threadSafeList.remove(value % 100);
            });
        }
        executor.shutdown();
        try {
            executor.awaitTermination(1, TimeUnit.HOURS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Final size: " + threadSafeList.size());


        //Задача 2

        PetrolStation station = new PetrolStation(1000.0);

        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                try {
                    station.doRefuel(50.0);
                    System.out.println("Заправка завершена. Остаток: " + station.getAvailableFuel());
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } catch (IllegalStateException e) {
                    System.err.println(e.getMessage());
                }
            }).start();
        }

    }
}

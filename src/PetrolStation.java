import java.util.Random;
import java.util.concurrent.Semaphore;

public class PetrolStation {

    private double availableFuel;
    private final Semaphore semaphore = new Semaphore(3);
    private final Random random = new Random();

    public PetrolStation(double initialFuel) {
        this.availableFuel = initialFuel;
    }

    public void doRefuel(double requestedFuel) throws InterruptedException {
        semaphore.acquire();
        try {
            synchronized (this) {
                if (requestedFuel > availableFuel) {
                    throw new IllegalStateException("Недостаточно топлива. Доступно: " + availableFuel);
                }
                availableFuel -= requestedFuel;
            }

            int delaySeconds = 3 + random.nextInt(8);
            Thread.sleep(delaySeconds * 1000L);

        } finally {
            semaphore.release();
        }
    }

    public synchronized double getAvailableFuel() {
        return availableFuel;
    }
}

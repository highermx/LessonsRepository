public class Car {
    public void start() {
        startElectricity();
        startCommand();
        startFuelSystem();
    }

    private void startElectricity(){
        System.out.println("Электричество запущено");
    }

    private void startCommand(){
        System.out.println("Запуск управления");
    }

    private void startFuelSystem(){
        System.out.println("Начало подачи топлива");
    }
}

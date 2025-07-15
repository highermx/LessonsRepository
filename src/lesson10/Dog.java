package lesson10;

public class Dog extends AnimalCanSwim {

    private static int counter;

    public Dog(String name) {
        super(name);
        this.counter = ++counter;
    }

    public void run (int length) {
        if (length > 500) {
            System.out.println("Собака " + getName() + " устал(а)и не может бежать");
            return;
        }
        System.out.println("Собака "  + getName() + " пробежал(а) " + length + " метров.");
    }

    public void swim (int length) {
        if (length > 10) {
            System.out.println("Собака " + getName() + " устал(а) и не может плыть дальше");
            return;
        }
        System.out.println("Собака "  + getName() + " проплыл(а) " + length + " метров.");

    }

    public void animalCounter() {
        System.out.println("Созданно собак: " + counter);
    }




}

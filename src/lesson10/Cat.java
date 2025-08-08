package lesson10;

public class Cat extends Animal {

    private static int counter;

    public Cat(String name) {
        super(name);
        this.counter = ++counter;
    }

    public void run (int length) {
        if (length > 200) {
            System.out.println("Кошка " + getName() + " устал(а) и не может бежать.");
            return;
        }
        System.out.println("Кошка " + getName() + " пробежал(а) " + length + " метров." );
    }

    public void animalCounter() {
        System.out.println("Созданно кошек " + counter);
    }
}

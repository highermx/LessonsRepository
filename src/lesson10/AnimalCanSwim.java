package lesson10;

public abstract class AnimalCanSwim extends Animal {

    public AnimalCanSwim(String name) {
        super(name);
    }

    public abstract void run(int length);

    public abstract void swim(int length);

    public abstract void animalCounter();

}

package lesson10;

public abstract class Animal {

    private String name;
    private static int totalAnimals;


    public Animal(String name) {
        this.name = name;
        totalAnimals++;

    }

    public String getName() {
        return name;
    }





    public abstract void run(int length);

    public abstract void animalCounter();

    public static int totalAnimalsCounter(){
        return totalAnimals;
    }



}




import lesson10.Animal;
import lesson10.AnimalCanSwim;
import lesson10.Cat;
import lesson10.Dog;

import static lesson10.Animal.totalAnimalsCounter;



public class Main {
    public static void main(String[] args) {
        Employee employee1 = new Employee("John", "Java developer", "johnjava@gmail.com", 795195475, 31);
        System.out.println(employee1);

        Car car = new Car();
        car.start();

        
        



        AnimalCanSwim dog = new Dog("Rex");
        System.out.println("Cобаку зовут: " + dog.getName());
        dog.run(426);
        dog.swim(6);

        AnimalCanSwim dog1 = new Dog("Tom");
        System.out.println("Cобаку зовут: " + dog1.getName());
        dog1.run(363);
        dog1.swim(10);

        Animal cat = new Cat("Richard");
        System.out.println("Кота зовут: " + cat.getName());
        cat.run(125);

        Animal cat1 = new Cat("Lusya");
        System.out.println("Кота зовут: " + cat1.getName());
        cat1.run(215);

        dog.animalCounter();
        cat.animalCounter();
        System.out.println("Всего животных: " + Animal.totalAnimalsCounter());






    }

     }

}

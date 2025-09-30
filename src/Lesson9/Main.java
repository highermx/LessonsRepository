package Lesson9;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Employee[] workers = new Employee[]{
                new Employee("Henry", "backend developer","henrydev@gmail.com", 815376, 11000, 41),
                new Employee("John", "frontend developer","johndev@gmail.com", 841993, 9000, 34),
                new Employee("Garry", "backend developer","garrydev@gmail.com", 813377, 6000, 45),
                new Employee("Petter", "frontend developer","petterydev@gmail.com", 892413, 7000, 26),
                new Employee("Marry", "HR manager","marryhr@gmail.com", 825375, 6000, 40),
        };

        System.out.println(Arrays.toString(workers));

        for(Employee oldworkers: workers) {
            if (oldworkers.getYear() > 40) {
                System.out.println("Работнику с именем " + oldworkers.getName() + " больше 40 лет");
            }
        }





    }
}

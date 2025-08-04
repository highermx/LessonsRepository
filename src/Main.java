import iprody.coffeeshot.CoffeeOrderBoard;

public class Main {
    public static void main(String[] args) {
        CoffeeOrderBoard board = new CoffeeOrderBoard();

        board.add("Alina");
        board.add("Boris");
        board.add("Anna");

        System.out.println("Текущая очередь:");
        board.draw();

        System.out.println("\nВыдан заказ: " + board.deliver());
        System.out.println("\nОчередь после выдачи:");
        board.draw();

        System.out.println("\nВыдан заказ №3: " + board.deliver(3));
        System.out.println("\nФинальная очередь:");
        board.draw();

    }
}

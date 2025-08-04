package iprody.coffeeshot;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.TreeSet;

public class CoffeeOrderBoard {
    private final TreeSet<Order> orders = new TreeSet<>();
    private int lastOrderNumber = 0;

    public void add(String customerName) {
        lastOrderNumber++;
        orders.add(new Order(lastOrderNumber, customerName));
    }

    public Order deliver() {
        if (orders.isEmpty()) {
            throw new NoSuchElementException("Нет активных заказов");
        }
        return orders.pollFirst();
    }

    public Order deliver(int orderNumber) {
        Iterator<Order> iterator = orders.iterator();
        while (iterator.hasNext()) {
            Order order = iterator.next();
            if (order.getOrderNumber() == orderNumber) {
                iterator.remove();
                return order;
            }
        }
        throw new NoSuchElementException("Заказ №" + orderNumber + " не найден");
    }

    public void draw() {
        System.out.println("Num | Order | Name");
        int position = 1;
        for (Order order : orders) {
            System.out.printf("%-4d| %-7d| %s%n",
                    position++,
                    order.getOrderNumber(),
                    order.getCustomerName());
        }
    }
}

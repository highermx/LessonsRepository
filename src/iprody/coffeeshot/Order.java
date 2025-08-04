package iprody.coffeeshot;

public class Order implements Comparable<Order> {
    private final int orderNumber;
    private final String customerName;

    public Order(int orderNumber, String customerName) {
        if (customerName == null || customerName.isEmpty()) {
            throw new IllegalArgumentException("Имя клиента не может быть пустым");
        }
        this.orderNumber = orderNumber;
        this.customerName = customerName;
    }

    @Override
    public int compareTo(Order other) {
        return Integer.compare(this.orderNumber, other.orderNumber);
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    @Override
    public String toString() {
        return String.format("№%d | %s", orderNumber, customerName);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return orderNumber == order.orderNumber;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(orderNumber);
    }
}

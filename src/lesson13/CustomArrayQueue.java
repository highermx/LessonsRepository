package lesson13;

public class CustomArrayQueue {
    private int head = 0;
    private int tail = 0;
    private int size = 0;
    private int capacity;
    private int[] storage;

    // Инициализация очереди
    public int[] init(int capacity) {
        this.capacity = capacity;
        this.storage = new int[capacity];
        return storage;
    }

    // Добавление элемента
    public void add(int[] queue, int value) {
        if (size == capacity) {
            throw new IllegalStateException("Очередь переполнена");
        }

        storage[tail] = value;
        tail = (tail + 1) % capacity;
        size++;
        System.arraycopy(storage, 0, queue, 0, capacity);
    }

    // Извлечение элемента
    public int poll(int[] queue) {
        if (size == 0) {
            throw new IllegalStateException("Очередь пуста");
        }

        int value = storage[head];
        head = (head + 1) % capacity;
        size--;
        System.arraycopy(storage, 0, queue, 0, capacity);
        return value;
    }
}

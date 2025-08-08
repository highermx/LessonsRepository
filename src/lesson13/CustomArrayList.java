package lesson13;

public class CustomArrayList {
    private Integer[] data;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;

    public CustomArrayList() {
        this(DEFAULT_CAPACITY);
    }

    public CustomArrayList(int initialCapacity) {
        if (initialCapacity > 0) {
            this.data = new Integer[initialCapacity];
        } else {
            throw new IllegalArgumentException("Некорректная емкость: " + initialCapacity);
        }
    }

    public void add(int value) {
        ensureCapacity(size + 1);
        data[size++] = value;
    }

    public int get(int index) {
        checkIndex(index);
        return data[index];
    }

    public int size() {
        return size;
    }

    private void ensureCapacity(int minCapacity) {
        if (minCapacity > data.length) {
            int newCapacity = data.length + (data.length >> 1);
            if (newCapacity < minCapacity) {
                newCapacity = minCapacity;
            }
            Integer[] newData = new Integer[newCapacity];
            System.arraycopy(data, 0, newData, 0, size);
            data = newData;
        }
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Индекс: " + index + ", Размер: " + size);
        }
    }
}





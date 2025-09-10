
import java.util.ArrayList;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.List;

public class ThreadSafeList<T> {
    private final List<T> list = new ArrayList<>();
    private final ReadWriteLock lock = new ReentrantReadWriteLock();


public void add(T element) {
    lock.writeLock().lock();
    try {
        list.add(element);
    } finally {
        lock.writeLock().unlock();
    }
}

public boolean remove(T element) {
    lock.writeLock().lock();
    try {
        return list.remove(element);
    } finally {
        lock.writeLock().unlock();
    }
}


public T get(int index) {
    lock.readLock().lock();
    try {
        if (index < 0 || index >= list.size()) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }
        return list.get(index);
    } finally {
        lock.readLock().unlock();
    }
}

    public int size() {
        lock.readLock().lock();
        try {
            return list.size();
        } finally {
            lock.readLock().unlock();
        }
    }
}



import java.util.ArrayList;
import java.util.List;
public class Box <T extends Fruit> {

    private final List<T> fruits = new ArrayList<>();
    private final Class<T> fruitType;

    public Box(Class<T> fruitType) {
        this.fruitType = fruitType;
    }

    public void add(T fruit) {
        if (!fruit.getClass().equals(fruitType)) {
            throw new IllegalArgumentException("В коробке может находится только один тип фруктов");
        }
        fruits.add(fruit);
    }

    public float getWeight() {
        float totalWeight = 0.0f;
        for (T fruit : fruits) {
            totalWeight += fruit.getWeight();
        }
        return totalWeight;
    }

    public boolean compare(Box<?> otherBox) {
        return Math.abs(this.getWeight() - otherBox.getWeight()) < 0.0001f;
    }

    public void transfer(Box<T> destinationBox) {
        if (destinationBox.fruitType != this.fruitType) {
            throw new IllegalArgumentException("Можно пересыпать только в коробку того же типа");
        }
        destinationBox.fruits.addAll(this.fruits);
        this.fruits.clear();
    }
}

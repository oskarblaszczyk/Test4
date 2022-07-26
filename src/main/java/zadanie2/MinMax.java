package zadanie2;

public class MinMax <T extends Comparable<T>>{
    private final T max;
    private final T min;

    public MinMax(T min, T max) {
        this.min = min;
        this.max = max;
    }

    public T getMax() {
        return max;
    }

    public T getMin() {
        return min;
    }


}

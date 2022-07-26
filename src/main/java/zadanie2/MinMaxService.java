package zadanie2;

import java.util.*;

public class MinMaxService {

    public static <T extends Comparable<T>> MinMax<T> getMinAndMax(List<T> elements) {
        T max = Optional.ofNullable(elements)
                .orElse(Collections.emptyList())
                .stream()
                .filter(Objects::nonNull)
                .max(Comparable::compareTo)
                .orElse(null);

        T min = Optional.ofNullable(elements)
                .orElse(Collections.emptyList())
                .stream()
                .filter(Objects::nonNull)
                .min(Comparable::compareTo)
                .orElse(null);

        return new MinMax<T>(min, max);
    }

}

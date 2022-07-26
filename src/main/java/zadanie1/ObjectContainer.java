package zadanie1;

import exceptions.ObjectAddConditionFalse;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;

public class ObjectContainer<T> {
    private final Node<T> first = new Node<>(null);
    private final Predicate<T> addCondition;

    public ObjectContainer(Predicate<T> addCondition) {
        this.addCondition = addCondition;
    }

    public boolean add(T t) {
        if (t == null) {
            throw new NullPointerException("Object can't be a null");
        }
        if (!addCondition.test(t)) {
            throw new ObjectAddConditionFalse("Add condition isn't true");
        }

        if (first.getNext() == null) {
            first.setNext(new Node<>(t));
            return true;
        } else {
            Node<T> last = first.getNext();
            while (last.getNext() != null) {
                last = last.getNext();
            }
            last.setNext(new Node<>(t));
            return true;
        }
    }

    public List<T> getWithFilter(Predicate<T> getCondition) {
        Node<T> last = first.getNext();
        List<T> result = new ArrayList<>();
        while (last != null) {
            if (getCondition.test(last.getT())) {
                result.add(last.getT());
            }
            last = last.getNext();
        }
        return result;
    }


    public void removeIf(Predicate<T> rmvCondition) {
        Node<T> last = first;
        while (last.getNext() != null) {
            if (rmvCondition.test(last.getNext().getT())) {
                last.setNext(last.getNext().getNext());
            }
            last = last.getNext();
        }
    }


    public void storeToFile(String file, Predicate<T> filter, Function<T, String> pattern) throws IOException {
        PrintWriter pw = new PrintWriter(file);
        Optional.ofNullable(getWithFilter(filter))
                .orElse(Collections.emptyList())
                .stream()
                .map(pattern)
                .forEach(pw::println);
        pw.close();
    }

    private static final class Node<T> {
        private final T t;
        private Node<T> next;

        public Node(T t) {
            this.t = t;
        }

        public T getT() {
            return t;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> n) {
            next = n;
        }

    }

}
package chapter9;

import java.util.EmptyStackException;
import my.util.DLinkedList;

public class DLinkedListStack<T> implements Stack<T> {

    private final DLinkedList<T> list;

    public DLinkedListStack() {
        list = new DLinkedList<>();
    }

    @Override
    public void push(T item) {
        // TODO (use tail as the top)
        list.add(item);
    }

    @Override
    public T pop() throws Exception {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return list.removeLast().getData();
    }

    @Override
    public T top() throws Exception {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return list.get(list.size() - 1).getData();
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }
}

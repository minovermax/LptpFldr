package com.company;

public class ArrayStack<T> implements Stack<T> {
    public static final int INITIAL_SIZE = 10;
    T[] stack = (T[]) new Object[INITIAL_SIZE];
    int top = 0;    // remember that top should always be empty, the top most element is stack[top - 1]

    @Override
    public void push(T element) {
        if (top == stack.length) {
            expandArray();
        }

        stack[top] = element;
        ++top;
    }

    private void expandArray() {
        T[] newArray = (T[]) new Object[stack.length *2];

        for (int i = 0; i < stack.length; ++i) {
            newArray[i] = stack[i];
        }

        stack = newArray;
    }

    @Override
    public T pop() {
        if(!isEmpty()) {
            T poppedElement = stack[top - 1];
            stack[top - 1] = null;
            --top;

            return poppedElement;
        }

        return null;
    }

    @Override
    public T peek() {
        if(!isEmpty()) {
            return stack[top - 1];
        }

        return null;
    }

    @Override
    public boolean isEmpty() {
        return top == 0;
    }

    @Override
    public int size() {
        return top;
    }
}

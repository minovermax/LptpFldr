package com.company;

public class LinearNode<E> {

    E data;
    LinearNode<E> next;

    // Constructor
    public LinearNode(E d)
    {
        data = d;
        next = null;
    }

    public LinearNode() {

    }

    public void setElem(E elem) {
        data = elem;
    }

    public void setNext(LinearNode<E> node) {
        next = node;
    }

    public LinearNode<E> getNext() {
        return next;
    }

    public E getElem() {
        return data;
    }
}

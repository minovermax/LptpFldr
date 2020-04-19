package com.company;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

class LinkedList<E> {
    private int size = 0;
    private LinearNode<E> first;
    private LinearNode<E> last;



    public void add(E elem) {
        LinearNode<E> newNode = new LinearNode<>();
        newNode.setElem(elem);
        last.setNext(newNode);
        last = newNode;
        ++size;
    }



    public void add(E elem, int index) {
        if((index < 0 ) || (index >= size)){
            return;
        }
        LinearNode<E> newNode = new LinearNode<>();
        newNode.setElem(elem);
        newNode.setNext(first);

        if(index == 0){
            first = newNode;
            ++size;
            return;
        }

        LinearNode<E> prev = first;
        int counter  = 0;
        LinearNode<E> current = first;

        while(counter < index){
            prev = current;
            current = current.getNext();
            counter = counter + 1;
        }

        newNode.setNext(current);
        prev.setNext(newNode);
        ++size;
    }

    public E remove(int index) {
        LinearNode<E> prev = first;
        int counter  = 0;
        LinearNode<E> current = first;

        while(counter < index){
            prev = current;
            current = current.getNext();
            ++counter;
        }
        prev.setNext(current.getNext());
        current.setNext(null);
        E element = current.getElem();
        current = null;

        --size;
        return element;
    }

    public E peek(int index) {
        int counter  = 0;
        LinearNode<E> current = first;

        while(counter < index){
            current = current.getNext();
            ++counter;
        }

        return current.getElem();
    }

    public E replace(int index, E elem) {
        int counter  = 0;
        LinearNode<E> current = first;

        while(counter < index){
            current = current.getNext();
            ++counter;
        }

        current.setElem(elem);
        return elem;
    }

    public int size() {
        return size;
    }

}